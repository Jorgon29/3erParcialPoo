package org.poo.parcialfinalpoo.Controllers.Crud;

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

public class CrudClienteController {
    @FXML protected ComboBox<Integer> cbIds;
    protected TextField txtNombre;
    protected TextField txtDireccion;
    protected TextField txtTelefono;
    protected Label lblNombre;
    protected Label lblDireccion;
    protected Label lblTelefono;
    @FXML protected GridPane gridDatos;
    @FXML protected HBox hbAbajo;
    @FXML protected HBox hbArriba;
    @FXML protected Label lblTitulo;
    private int actual;
    @FXML public void enRegresar(){
        BcnApp app = new BcnApp();
        try {
            if (BcnApp.getAppStage() != null){
                app.start(BcnApp.getAppStage());
            } else {
                app.start(new Stage());
            }

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private void enBuscar(){
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
    private void enActualizar(){
        try {
            QueryCliente.actualizar(new Cliente(actual, txtNombre.getText(), txtTelefono.getText(), txtDireccion.getText()));
        } catch (Exception e){
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Error en la actualizacion");
            a.setTitle("Error");
            a.showAndWait();
        }
    }
    private void enEliminar(){
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

    public void ponerBotonActualizar(){
        Button button = new Button();
        button.setText("Actualizar");
        button.setOnAction(actionEvent -> {
            enActualizar();
        });
        hbAbajo.getChildren().add(button);
    }
    public void ponerBotonEliminar(){
        Button button = new Button();
        button.setText("Eliminar");
        button.setOnAction(actionEvent -> {
            enEliminar();
        });
        hbAbajo.getChildren().add(button);
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

    public void ponerBuscador(){
        cbIds = new ComboBox<>();
        asignarIdsComboBox();
        hbArriba.getChildren().add(cbIds);
        Button button = new Button("Buscar");
        button.setOnAction(actionEvent -> {
            enBuscar();
        });
        hbArriba.getChildren().add(button);
    }

    private void asignarIdsComboBox(){
        ArrayList<Integer> ids = QueryCliente.getIds();
        cbIds.setItems(FXCollections.observableArrayList(ids));
    }

    public Label getLblTitulo(){
        return lblTitulo;
    }

    private void enInsertar(){
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

    public void ponerBotonInsertar(){
        Button button = new Button();
        button.setText("Insertar");
        button.setOnAction(actionEvent -> {
            enInsertar();
        });
        hbAbajo.getChildren().add(button);
    }

}
