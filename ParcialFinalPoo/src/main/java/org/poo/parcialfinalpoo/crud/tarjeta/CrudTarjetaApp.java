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

    @Override
    public void ponerBotonActualizar() {
        ((CrudTarjetaController) loader.getController()).ponerBotonActualizar();
    } // 00016823 Se castea al controllador y se usa su atributo para poner el botón actualizar

    @Override
    public void ponerBotonEliminar() {
        ((CrudTarjetaController) loader.getController()).ponerBotonEliminar();
    } // 00016823 Se castea al controllador y se usa su atributo para poner el botón eliminar

    @Override
    public void ponerLabels() {
        ((CrudTarjetaController) loader.getController()).ponerLabels();
    } // 00016823 Se castea al controllador y se usa su atributo para poner labels

    @Override
    public void ponerTextFields() {
        ((CrudTarjetaController) loader.getController()).ponerTextFields();
    } // 00016823 Se castea al controllador y se usa su atributo para poner el text fields

    @Override
    public void ponerBuscador() {
        ((CrudTarjetaController) loader.getController()).ponerBuscador();
    }// 00016823 Se castea al controllador y se usa su atributo para poner el buscador

    @Override
    public void ponerBotonInsertar() {
        ((CrudTarjetaController) loader.getController()).ponerBotonInsertar();
    }// 00016823 Se castea al controllador y se usa su atributo para poner el botón insertar

    public void cambiarTitulo(String titulo){
        ((CrudTarjetaController) loader.getController()).getLblTitulo().setText(titulo); // 00016823 Se castea al controllador y se usa su atributo para poner un nuevo texto al label de título
    }
    public CrudTarjetaApp(){
        loader = new FXMLLoader(getClass().getResource("/org/poo/parcialfinalpoo/crud/crud-tarjeta.fxml")); // 00016823 Se carga el fxml de crud tarjeta y lo guarda en loader
        try {
            root = loader.load(); // 00016823 Guarda el parent
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
