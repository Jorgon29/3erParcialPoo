package org.poo.parcialfinalpoo.controllers.crud;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import org.poo.parcialfinalpoo.BcnApp;
import org.poo.parcialfinalpoo.model.Cliente;
import org.poo.parcialfinalpoo.model.QueryCliente;

import java.sql.SQLException;
import java.util.ArrayList;

public class CrudClienteController extends CrudAbstractController{
    protected TextField txtNombre;
    protected TextField txtDireccion;
    protected TextField txtTelefono;
    protected Label lblNombre;
    protected Label lblDireccion;
    protected Label lblTelefono;

    protected void enBuscar(){
        try {

            Cliente cliente = QueryCliente.select(cbIds.getValue());
            if (txtNombre == null){
                lblNombre.setText(cliente.getNombre());
                lblDireccion.setText(cliente.getDireccion());
                lblTelefono.setText(cliente.getTelefono());
            } else{
                txtNombre.setText(cliente.getNombre());
                txtDireccion.setText(cliente.getDireccion());
                txtTelefono.setText(cliente.getTelefono());
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
            QueryCliente.actualizar(new Cliente(actual, txtNombre.getText(), txtTelefono.getText(), txtDireccion.getText()));
        } catch (Exception e){
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Error en la actualizacion");
            a.setTitle("Error");
            a.showAndWait();
        }
    }
    protected void enEliminar(){
        try {
            QueryCliente.eliminar(actual);
            asignarIdsComboBox();
            lblTelefono.setText("");
            lblNombre.setText("");
            lblDireccion.setText("");
        } catch (SQLException e){
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Error en la eliminación");
            a.setTitle("Error");
            a.showAndWait();
        }
    }




    public void ponerLabels(){
        lblDireccion = new Label();
        lblNombre = new Label();
        lblTelefono = new Label();
        gridDatos.add(lblNombre, 1, 0);
        gridDatos.add(lblDireccion, 1, 1);
        gridDatos.add(lblTelefono, 1, 2);
    }

    public void ponerTextFields(){
        txtNombre = new TextField();
        txtDireccion = new TextField();
        txtTelefono = new TextField();
        gridDatos.add(txtNombre, 1, 0);
        gridDatos.add(txtDireccion, 1, 1);
        gridDatos.add(txtTelefono, 1, 2);

    }

    protected void asignarIdsComboBox(){
        ArrayList<Integer> ids = QueryCliente.getIds();
        cbIds.setItems(FXCollections.observableArrayList(ids));
    }

    protected void enInsertar(){
        try {
            QueryCliente.insertar(txtNombre.getText(), txtDireccion.getText(), txtTelefono.getText());
            txtTelefono.setText("");
            txtNombre.setText("");
            txtDireccion.setText("");
        } catch (SQLException e){
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Error en la inserción");
            a.setTitle("Error");
            a.showAndWait();
        }
    }



}
