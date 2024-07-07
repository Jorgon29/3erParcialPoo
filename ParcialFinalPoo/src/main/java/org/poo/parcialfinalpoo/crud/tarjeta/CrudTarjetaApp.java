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

    }

    @Override
    public void ponerBotonEliminar() {

    }

    @Override
    public void ponerLabels() {

    }

    @Override
    public void ponerTextFields() {

    }

    @Override
    public void ponerBuscador() {

    }

    @Override
    public void ponerBotonInsertar() {

    }

    public void cambiarTitulo(String titulo){
        ((CrudClienteController) loader.getController()).getLblTitulo().setText(titulo);
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
