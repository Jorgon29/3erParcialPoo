package org.poo.parcialfinalpoo.controllers.crud;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.poo.parcialfinalpoo.modelBase.tipos.Cliente;
import org.poo.parcialfinalpoo.modelBase.query.QueryCliente;

import java.sql.SQLException;
import java.util.ArrayList;

public class CrudClienteController extends CrudAbstractController{
    protected TextField txtNombre;
    protected TextField txtDireccion;
    protected TextField txtTelefono;
    protected Label lblNombre;
    protected Label lblDireccion;
    protected Label lblTelefono;

    @FXML protected void initialize(){
        query = new QueryCliente();
    }

    protected void enBuscar(){
        try {

            Cliente cliente = (Cliente) query.select(cbIds.getValue());
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
            alerta("Cliente no encontrado");
        }
    }
    protected void enActualizar(){
        try {
            query.actualizar(new Cliente(actual, txtNombre.getText(), txtTelefono.getText(), txtDireccion.getText()));
            informacion("Actualizado correctamente");
        } catch (Exception e){
            alerta("Error en actualización");
        }
    }
    protected void enEliminar(){
        try {
            query.eliminar(actual);
            asignarIdsComboBox();
            lblTelefono.setText("");
            lblNombre.setText("");
            lblDireccion.setText("");
            informacion("Eliminado correctamente");
        } catch (SQLException e){
            alerta("Error en eliminación");
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
        ArrayList<Integer> ids = null;
        try {
            ids = query.getIds();
        } catch (SQLException e) {
            alerta("Error al obtener ids");
        }
        cbIds.setItems(FXCollections.observableArrayList(ids));
    }

    protected void enInsertar(){
        try {
            query.insertar(new Cliente(0,txtNombre.getText(), txtTelefono.getText(), txtDireccion.getText()));
            txtTelefono.setText("");
            txtNombre.setText("");
            txtDireccion.setText("");
            informacion("Insertado correctamente");
        } catch (SQLException e){
            alerta(e.getMessage());
        }
    }



}
