package org.poo.parcialfinalpoo.crud.tarjeta;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.poo.parcialfinalpoo.controllers.crud.CrudClienteController;
import org.poo.parcialfinalpoo.controllers.crud.CrudTarjetaController;
import org.poo.parcialfinalpoo.crud.CrudAbstractApp;

import java.io.IOException;

public class CrudTarjetaApp extends CrudAbstractApp {
    private FXMLLoader loader;
    private Parent root;
    @Override
    public void start(Stage stage) throws Exception {
        Scene scene = new Scene(root, 700, 500);
        stage.setTitle("BCN");
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void ponerBotonActualizar() {
        ((CrudTarjetaController) loader.getController()).ponerBotonActualizar();
    }

    @Override
    public void ponerBotonEliminar() {
        ((CrudTarjetaController) loader.getController()).ponerBotonEliminar();
    }

    @Override
    public void ponerLabels() {
        ((CrudTarjetaController) loader.getController()).ponerLabels();
    }

    @Override
    public void ponerTextFields() {
        ((CrudTarjetaController) loader.getController()).ponerTextFields();
    }

    @Override
    public void ponerBuscador() {
        ((CrudTarjetaController) loader.getController()).ponerBuscador();
    }

    @Override
    public void ponerBotonInsertar() {
        ((CrudTarjetaController) loader.getController()).ponerBotonInsertar();
    }

    public void cambiarTitulo(String titulo){
        ((CrudTarjetaController) loader.getController()).getLblTitulo().setText(titulo);
    }
    public CrudTarjetaApp(){
        loader = new FXMLLoader(getClass().getResource("/org/poo/parcialfinalpoo/crud/crud-tarjeta.fxml"));
        try {
            root = loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
