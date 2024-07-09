package org.poo.parcialfinalpoo.crud.Facilitador;

import javafx.fxml.FXMLLoader;
import org.poo.parcialfinalpoo.controllers.crud.CrudFacilitadorController;
import org.poo.parcialfinalpoo.crud.CrudAbstractApp;

import java.io.IOException;

public class CrudFacilitadorApp extends CrudAbstractApp {
    @Override
    public void ponerBotonActualizar() {
        ((CrudFacilitadorController) loader.getController()).ponerBotonActualizar();
    }

    @Override
    public void ponerBotonEliminar() {
        ((CrudFacilitadorController) loader.getController()).ponerBotonEliminar();
    }

    @Override
    public void ponerLabels() {
        ((CrudFacilitadorController) loader.getController()).ponerLabels();
    }

    @Override
    public void ponerTextFields() {
        ((CrudFacilitadorController) loader.getController()).ponerTextFields();
    }

    @Override
    public void ponerBuscador() {
        ((CrudFacilitadorController) loader.getController()).ponerBuscador();
    }

    @Override
    public void ponerBotonInsertar() {
        ((CrudFacilitadorController) loader.getController()).ponerBotonInsertar();
    }

    @Override
    public void cambiarTitulo(String titulo) {
        ((CrudFacilitadorController) loader.getController()).getLblTitulo().setText(titulo);
    }

    public CrudFacilitadorApp(){
        loader = new FXMLLoader(getClass().getResource("/org/poo/parcialfinalpoo/crud/crud-facilitador.fxml"));
        try {
            root = loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
