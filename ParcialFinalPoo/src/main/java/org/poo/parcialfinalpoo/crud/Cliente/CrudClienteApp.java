package org.poo.parcialfinalpoo.crud.Cliente;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.poo.parcialfinalpoo.controllers.crud.CrudClienteController;
import org.poo.parcialfinalpoo.crud.CrudAbstractApp;

import java.io.IOException;

public class CrudClienteApp extends CrudAbstractApp {
    public void cambiarTitulo(String titulo){
        ((CrudClienteController) loader.getController()).getLblTitulo().setText(titulo);
    }
    public CrudClienteApp(){
        loader = new FXMLLoader(getClass().getResource("/org/poo/parcialfinalpoo/crud/crud-cliente.fxml"));
        try {
            root = loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void ponerBotonActualizar(){
        ((CrudClienteController) loader.getController()).ponerBotonActualizar();
    }
    public void ponerBotonEliminar(){
        ((CrudClienteController) loader.getController()).ponerBotonEliminar();
    }
    public void ponerLabels(){
        ((CrudClienteController) loader.getController()).ponerLabels();
    }
    public void ponerTextFields(){
        ((CrudClienteController) loader.getController()).ponerTextFields();
    }
    public void ponerBuscador(){
        ((CrudClienteController) loader.getController()).ponerBuscador();
    }
    public void ponerBotonInsertar(){
        ((CrudClienteController) loader.getController()).ponerBotonInsertar();
    }

}
