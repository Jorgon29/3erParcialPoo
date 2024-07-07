package org.poo.parcialfinalpoo.controllers.crud;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import org.poo.parcialfinalpoo.BcnApp;
import org.poo.parcialfinalpoo.model.*;

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

    protected void enBuscar(){
        try {
            actual = cbIds.getValue();
            Tarjeta tarjeta = QueryTarjeta.select(actual);
            if (txtNumero == null){
                lblNumero.setText(tarjeta.getNumero());
                lblTipo.setText(tarjeta.getTipo());
                lblNombreCliente.setText(tarjeta.getCliente());
                lblFechaExp.setText(tarjeta.getFecha_exp().toString());
                lblFacilitador.setText(tarjeta.getFacilitador());
            } else{
                txtNumero.setText(tarjeta.getNumero());
                txtFechaExp.
            }
            actual = cbIds.getValue();
        } catch (Exception e){
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Cliente no encontrado");
            a.setTitle("Error");
            a.showAndWait();
        }
    }
    protected void enActualizar(){
        try {

        } catch (Exception e){
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Error en la actualizacion");
            a.setTitle("Error");
            a.showAndWait();
        }
    }
    protected void enEliminar(){
        try {
            QueryTarjeta.eliminar(actual);
            asignarIdsComboBox();
        } catch (SQLException e){
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Error en la eliminación");
            a.setTitle("Error");
            a.showAndWait();
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
            txtFacilitador.setItems(FXCollections.observableArrayList(QueryFacilitador.select()));
            txtCliente.setItems(FXCollections.observableArrayList(QueryCliente.select()));
        } catch (SQLException e){
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("SQL exception");
            a.setTitle("Error");
            a.showAndWait();
            System.exit(3);
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
            ids = QueryTarjeta.getIds();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        cbIds.setItems(FXCollections.observableArrayList(ids));
    }


    protected void enInsertar(){
        try {

        } catch (SQLException e){
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Error en la inserción");
            a.setTitle("Error");
            a.showAndWait();
        }
    }


}
