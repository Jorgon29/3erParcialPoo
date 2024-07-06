package org.poo.parcialfinalpoo.Controllers.Crud.Actualizar;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import org.poo.parcialfinalpoo.model.Cliente;
import org.poo.parcialfinalpoo.model.QueryCliente;

import java.util.ArrayList;

public class ActualizarClienteController {
    @FXML protected ComboBox<Integer> cbIds;
    @FXML protected TextField txtNombre;
    @FXML protected TextField txtDireccion;
    @FXML protected TextField txtTelefono;
    private int actual;
    @FXML public void initialize(){
        ArrayList<Integer> ids = QueryCliente.getIds();
        cbIds.setItems(FXCollections.observableArrayList(ids));
    }

    @FXML public void enBuscar(){
        try {
            Cliente cliente = QueryCliente.select(cbIds.getValue());
            txtNombre.setText(cliente.getNombre());
            txtDireccion.setText(cliente.getDireccion());
            txtTelefono.setText(cliente.getTelefono());
            actual = cbIds.getValue();
        } catch (Exception e){
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Cliente no encontrado");
            a.setTitle("Error");
            a.showAndWait();
        }
    }
    @FXML public void enActualizar(){
        try {
            QueryCliente.actualizar(new Cliente(actual, txtNombre.getText(), txtTelefono.getText(), txtDireccion.getText()));
        } catch (Exception e){
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Error en la actualizacion");
            a.setTitle("Error");
            a.showAndWait();
        }
    }
}
