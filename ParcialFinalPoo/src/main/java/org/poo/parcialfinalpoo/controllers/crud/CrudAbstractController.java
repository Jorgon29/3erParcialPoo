package org.poo.parcialfinalpoo.controllers.crud;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import org.poo.parcialfinalpoo.BcnApp;

public abstract class CrudAbstractController {
    @FXML protected HBox hbArriba;
    @FXML protected HBox hbAbajo;
    @FXML protected ComboBox<Integer> cbIds;
    @FXML protected Label lblTitulo;
    @FXML protected GridPane gridDatos;
    protected int actual;
    protected abstract void asignarIdsComboBox();
    protected abstract void enBuscar();
    protected abstract void enInsertar();
    protected abstract void enEliminar();
    protected abstract void enActualizar();
    public abstract void ponerLabels();
    public abstract void ponerTextFields();

    public void ponerBotonInsertar(){
        Button button = new Button();
        button.setText("Insertar");
        button.setOnAction(actionEvent -> {
            enInsertar();
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
    public void ponerBotonActualizar(){
        Button button = new Button();
        button.setText("Actualizar");
        button.setOnAction(actionEvent -> {
            enActualizar();
        });
        hbAbajo.getChildren().add(button);
    }

    @FXML
    public void enRegresar(){
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

    public Label getLblTitulo(){
        return lblTitulo;
    }
    protected void alerta(String mensaje){
        Alert a = new Alert(Alert.AlertType.ERROR);
        a.setContentText(mensaje);
        a.setTitle("Error");
        a.showAndWait();
    }

}
