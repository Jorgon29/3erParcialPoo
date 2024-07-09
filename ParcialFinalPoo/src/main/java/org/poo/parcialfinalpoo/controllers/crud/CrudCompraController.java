package org.poo.parcialfinalpoo.controllers.crud;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.poo.parcialfinalpoo.modelBase.query.QueryCliente;
import org.poo.parcialfinalpoo.modelBase.query.QueryCompra;
import org.poo.parcialfinalpoo.modelBase.query.QueryTarjeta;
import org.poo.parcialfinalpoo.modelBase.tipos.Transaccion;

import java.sql.SQLException;

public class CrudCompraController extends CrudAbstractController {
    private Label lblTotal;
    private Label lblFecha;
    private Label lblDescripcion;
    private Label lblTarjeta;
    private TextField txtTotal;
    private DatePicker txtFecha;
    private TextField txtDescripcion;
    private ComboBox<Integer> txtTarjeta;

    @FXML
    protected void initialize(){
        query = new QueryCompra();
    }

    @Override
    protected void asignarIdsComboBox() {
        try {
            cbIds.setItems(FXCollections.observableArrayList(query.getIds()));
        } catch (SQLException e) {
            alerta("Error de inicialización");
        }
    }

    @Override
    protected void enBuscar() {
        try {
            actual = cbIds.getValue();
            Transaccion transaccion = (Transaccion) query.select(actual);
            if (txtDescripcion == null){
                lblTotal.setText(String.valueOf(transaccion.getTotal()));
                lblDescripcion.setText(transaccion.getDescripcion());
                lblFecha.setText(transaccion.getFecha().toString());
                lblTarjeta.setText(String.valueOf(transaccion.getId_tarjeta()));
            } else{
                txtTotal.setText(String.valueOf(transaccion.getTotal()));
                txtDescripcion.setText(transaccion.getDescripcion());
            }
        } catch (Exception e){
            alerta("Transacción no encontrada");
        }
    }

    @Override
    protected void enInsertar() {
        try {
            Double.parseDouble(txtTotal.getText());
        } catch (NumberFormatException e){
            alerta("Ingrese valores validos");
            return;
        }
        try {
            query.insertar(new Transaccion(0,Double.parseDouble(txtTotal.getText()), txtFecha.getValue(), txtDescripcion.getText(), txtTarjeta.getValue()));
            informacion("Insertado correctamente");
        } catch (SQLException e){
            alerta(e.getMessage());
        }
    }

    @Override
    protected void enEliminar() {
        try {
            query.eliminar(actual);
            txtTotal.setText("");
            txtDescripcion.setText("");
            informacion("Eliminado correctamente");
        } catch (SQLException e){
            alerta(e.getMessage());
        }

    }

    @Override
    protected void enActualizar() {
        try {
            Double.parseDouble(txtTotal.getText());
        } catch (NumberFormatException e){
            alerta("Ingrese valores validos");
            return;
        }
        try {
            query.actualizar(new Transaccion(actual,Double.parseDouble(txtTotal.getText()), txtFecha.getValue(), txtDescripcion.getText(), txtTarjeta.getValue()));
            informacion("Actualizado correctamente");
        } catch (SQLException e){
            alerta(e.getMessage());
        }
    }

    @Override
    public void ponerLabels() {
        lblTotal = new Label();
        lblTarjeta = new Label();
        lblDescripcion = new Label();
        lblFecha = new Label();
        gridDatos.add(lblTotal, 1, 0);
        gridDatos.add(lblFecha, 1, 1);
        gridDatos.add(lblDescripcion, 1, 2);
        gridDatos.add(lblTarjeta, 1, 3);
    }

    @Override
    public void ponerTextFields() {
        txtTotal = new TextField();
        try {
            QueryTarjeta queryTarjeta = new QueryTarjeta();
            txtTarjeta = new ComboBox<>();
            txtTarjeta.setItems(FXCollections.observableArrayList(queryTarjeta.getIds()));
        } catch (SQLException e){
            alerta(e.getMessage());
        }
        txtDescripcion = new TextField();
        txtFecha = new DatePicker();
        gridDatos.add(txtTotal, 1, 0);
        gridDatos.add(txtFecha, 1, 1);
        gridDatos.add(txtDescripcion, 1, 2);
        gridDatos.add(txtTarjeta, 1, 3);
    }
}
