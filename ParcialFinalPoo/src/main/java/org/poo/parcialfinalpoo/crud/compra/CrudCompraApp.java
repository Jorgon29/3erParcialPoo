package org.poo.parcialfinalpoo.crud.compra;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.poo.parcialfinalpoo.controllers.crud.CrudCompraController;
import org.poo.parcialfinalpoo.controllers.crud.CrudTarjetaController;
import org.poo.parcialfinalpoo.crud.CrudAbstractApp;

import java.io.IOException;

public class CrudCompraApp extends CrudAbstractApp {

    @Override
    public void ponerBotonActualizar() {
        ((CrudCompraController) loader.getController()).ponerBotonActualizar();
    }

    @Override
    public void ponerBotonEliminar() {
        ((CrudCompraController) loader.getController()).ponerBotonEliminar();
    }

    @Override
    public void ponerLabels() {
        ((CrudCompraController) loader.getController()).ponerLabels();
    }

    @Override
    public void ponerTextFields() {
        ((CrudCompraController) loader.getController()).ponerTextFields();
    }

    @Override
    public void ponerBuscador() {
        ((CrudCompraController) loader.getController()).ponerBuscador();
    }

    @Override
    public void ponerBotonInsertar() {
        ((CrudCompraController) loader.getController()).ponerBotonInsertar();
    }

    @Override
    public void cambiarTitulo(String titulo) {
        ((CrudCompraController) loader.getController()).getLblTitulo().setText(titulo);
    }

    public CrudCompraApp(){
        loader = new FXMLLoader(getClass().getResource("/org/poo/parcialfinalpoo/crud/crud-compra.fxml"));
        try {
            root = loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
