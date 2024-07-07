package org.poo.parcialfinalpoo.crud.Cliente;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.poo.parcialfinalpoo.Controllers.Crud.CrudClienteController;

import java.io.IOException;

public class CrudClienteApp extends Application {
    private FXMLLoader loader;
    private Parent root;
    @Override
    public void start(Stage stage) throws Exception {
        Scene scene = new Scene(root, 700, 500);
        stage.setTitle("BCN");
        stage.setScene(scene);
        stage.show();
    }
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
