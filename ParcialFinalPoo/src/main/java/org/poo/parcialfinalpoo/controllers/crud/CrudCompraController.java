package org.poo.parcialfinalpoo.controllers.crud;

import javafx.collections.FXCollections;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.poo.parcialfinalpoo.controllers.crud.CrudAbstractController;
import org.poo.parcialfinalpoo.model.QueryCompra;
import org.poo.parcialfinalpoo.model.QueryTarjeta;
import org.poo.parcialfinalpoo.model.Tarjeta;
import org.poo.parcialfinalpoo.model.Transaccion;

import java.sql.SQLException;
import java.util.Arrays;

public class CrudCompraController extends CrudAbstractController {
    private Label lblTotal;
    private Label lblFecha;
    private Label lblDescripcion;
    private Label lblTarjeta;
    private TextField txtTotal;
    private DatePicker txtFecha;
    private TextField txtDescripcion;
    private ComboBox<Integer> txtTarjeta;

    @Override
    protected void asignarIdsComboBox() {
        try {
            cbIds.setItems(FXCollections.observableArrayList(QueryCompra.getIds()));
        } catch (SQLException e) {
            alerta("Error de inicialización");
        }
    }

    @Override
    protected void enBuscar() {
        try {
            actual = cbIds.getValue();
            Transaccion transaccion = QueryCompra.select(actual);
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
            QueryCompra.insertar(Double.parseDouble(txtTotal.getText()), txtFecha.getValue(), txtDescripcion.getText(), txtTarjeta.getValue());
        } catch (SQLException e){
            alerta(e.getMessage());
        }
    }

    @Override
    protected void enEliminar() {
        try {
            QueryCompra.eliminar(actual);
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
            QueryCompra.actualizar(Double.parseDouble(txtTotal.getText()), txtFecha.getValue(), txtDescripcion.getText(), txtTarjeta.getValue());
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
            txtTarjeta = new ComboBox<>();
            txtTarjeta.setItems(FXCollections.observableArrayList(QueryTarjeta.getIds()));
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
