package org.poo.parcialfinalpoo.controllers.crud;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.poo.parcialfinalpoo.modelBase.query.QueryCliente;
import org.poo.parcialfinalpoo.modelBase.query.QueryFacilitador;
import org.poo.parcialfinalpoo.modelBase.query.QueryTarjeta;
import org.poo.parcialfinalpoo.modelBase.tipos.Cliente;
import org.poo.parcialfinalpoo.modelBase.tipos.Facilitador;
import org.poo.parcialfinalpoo.modelBase.tipos.Tarjeta;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

public class CrudTarjetaController extends CrudAbstractController {
    protected Label lblNumero;
    protected Label lblFechaExp;
    protected Label lblTipo;
    protected Label lblNombreCliente;
    protected Label lblFacilitador;
    protected TextField txtNumero;
    protected DatePicker txtFechaExp;
    protected ComboBox<String> txtTipo;
    protected ComboBox<Cliente> txtCliente;
    protected ComboBox<Facilitador> txtFacilitador;

    @FXML
    protected void initialize(){
        System.out.println("Entrado a initialize");
        query = new QueryTarjeta();
    }

    protected void enBuscar(){
        try {
            actual = cbIds.getValue();
            Tarjeta tarjeta = (Tarjeta) query.select(actual);
            if (txtNumero == null){
                lblNumero.setText(tarjeta.getNumero());
                lblTipo.setText(tarjeta.getTipo());
                lblNombreCliente.setText(tarjeta.getCliente());
                lblFechaExp.setText(tarjeta.getFecha_exp().toString());
                lblFacilitador.setText(tarjeta.getFacilitador());
            } else{
                txtNumero.setText(tarjeta.getNumero());
                txtFechaExp = new DatePicker(tarjeta.getFecha_exp());
                txtTipo.getEditor().setText(tarjeta.getTipo());
                txtCliente.getEditor().setText(tarjeta.getCliente());
                txtFacilitador.getEditor().setText(tarjeta.getFacilitador());
            }
        } catch (Exception e){
            alerta("Tarjeta no encontrada");
        }
    }
    protected void enActualizar(){
        try {
            query.actualizar(new Tarjeta(actual,txtTipo.getValue(), txtNumero.getText(), txtFechaExp.getValue(), txtCliente.getValue().getNombre() ,txtCliente.getValue().getId(), txtFacilitador.getValue().getNombre(),txtFacilitador.getValue().getId()));
            informacion("Actualizado correctamente");
        } catch (Exception e){
            alerta("Error en actualización");
        }
    }
    protected void enEliminar(){
        try {
            query.eliminar(actual);
            asignarIdsComboBox();
            informacion("Eliminado correctamente");
        } catch (SQLException e){
            alerta("Error SQL en eliminación");
        } catch (Exception e){
            alerta("Error en eliminación");
        }
    }


    public void ponerLabels(){
        lblFacilitador = new Label();
        lblNombreCliente = new Label();
        lblNumero = new Label();
        lblTipo = new Label();
        lblFechaExp = new Label();
        gridDatos.add(lblNumero, 1, 0);
        gridDatos.add(lblFechaExp, 1, 1);
        gridDatos.add(lblTipo, 1, 2);
        gridDatos.add(lblNombreCliente, 1, 3);
        gridDatos.add(lblFacilitador, 1, 4);
    }

    public void ponerTextFields(){
        txtFacilitador = new ComboBox<>();
        txtCliente = new ComboBox<>();
        txtTipo = new ComboBox<>();
        try {
            QueryFacilitador queryFacilitador = new QueryFacilitador();
            QueryCliente queryCliente = new QueryCliente();
            txtFacilitador.setItems(FXCollections.observableArrayList(queryFacilitador.select()));
            txtCliente.setItems(FXCollections.observableArrayList(queryCliente.select()));
        } catch (SQLException e){
            alerta("Error poniendo editables");
        }
        txtNumero = new TextField();
        txtTipo.setItems(FXCollections.observableArrayList(Arrays.asList("Credito", "Debito")));
        txtFechaExp = new DatePicker();
        gridDatos.add(txtNumero, 1, 0);
        gridDatos.add(txtFechaExp, 1, 1);
        gridDatos.add(txtTipo, 1, 2);
        gridDatos.add(txtCliente, 1, 3);
        gridDatos.add(txtFacilitador, 1, 4);
    }


    protected void asignarIdsComboBox(){
        ArrayList<Integer> ids = null;
        try {
            ids = query.getIds();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        cbIds.setItems(FXCollections.observableArrayList(ids));
    }


    protected void enInsertar(){
        try {
            query.insertar(new Tarjeta(actual,txtTipo.getValue(), txtNumero.getText(), txtFechaExp.getValue(), txtCliente.getValue().getNombre() ,txtCliente.getValue().getId(), txtFacilitador.getValue().getNombre(),txtFacilitador.getValue().getId()));
            informacion("Insertado correctamente");
            txtNumero.setText("");

        } catch (SQLException e){
            alerta("Error SQL en inserción");
        } catch (Exception e){
            alerta("Error en inserción");
        }
    }


}
