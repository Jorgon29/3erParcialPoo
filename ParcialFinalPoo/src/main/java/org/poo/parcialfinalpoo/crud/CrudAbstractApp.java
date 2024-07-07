package org.poo.parcialfinalpoo.crud;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;
import org.poo.parcialfinalpoo.controllers.crud.CrudClienteController;

public abstract class CrudAbstractApp extends Application {
    protected FXMLLoader loader;
    protected Parent root;
    public abstract void start(Stage stage) throws Exception;

    public abstract void ponerBotonActualizar();
    public abstract void ponerBotonEliminar();
    public abstract void ponerLabels();
    public abstract void ponerTextFields();
    public abstract void ponerBuscador();
    public abstract void ponerBotonInsertar();
    public abstract void cambiarTitulo(String titulo);
}
