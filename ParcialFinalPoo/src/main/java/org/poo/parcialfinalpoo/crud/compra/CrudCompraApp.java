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
    public void ponerBotonActualizar() {((CrudCompraController) loader.getController()).ponerBotonActualizar();} // 00016823 Se castea al controllador y se usa su atributo para poner el botón actualizar

    @Override
    public void ponerBotonEliminar() {
        ((CrudCompraController) loader.getController()).ponerBotonEliminar();}// 00016823 Se castea al controllador y se usa su atributo para poner el botón eliminar

    @Override
    public void ponerLabels() {
        ((CrudCompraController) loader.getController()).ponerLabels();
    } // 00016823 Se castea al controllador y se usa su atributo para poner el labels

    @Override
    public void ponerTextFields() {
        ((CrudCompraController) loader.getController()).ponerTextFields();
    }// 00016823 Se castea al controllador y se usa su atributo para poner el text fields

    @Override
    public void ponerBuscador() {
        ((CrudCompraController) loader.getController()).ponerBuscador();
    }// 00016823 Se castea al controllador y se usa su atributo para poner el buscador

    @Override
    public void ponerBotonInsertar() {
        ((CrudCompraController) loader.getController()).ponerBotonInsertar();
    }// 00016823 Se castea al controllador y se usa su atributo para poner el botón insertar

    @Override
    public void cambiarTitulo(String titulo) {
        ((CrudCompraController) loader.getController()).getLblTitulo().setText(titulo);
    }// 00016823 Se castea al controllador y se usa su atributo para poner un nuevo texto al label de título

    public CrudCompraApp(){
        loader = new FXMLLoader(getClass().getResource("/org/poo/parcialfinalpoo/crud/crud-compra.fxml")); // 00016823 Se carga el fxml de crud compra y lo guarda en loader
        try {
            root = loader.load(); // 00016823 Guarda el parent
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
