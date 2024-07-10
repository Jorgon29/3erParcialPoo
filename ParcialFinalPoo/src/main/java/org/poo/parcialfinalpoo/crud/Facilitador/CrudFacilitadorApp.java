package org.poo.parcialfinalpoo.crud.Facilitador;

import javafx.fxml.FXMLLoader;
import org.poo.parcialfinalpoo.controllers.crud.CrudFacilitadorController;
import org.poo.parcialfinalpoo.crud.CrudAbstractApp;

import java.io.IOException;

public class CrudFacilitadorApp extends CrudAbstractApp { // 00016823 App para crud del facilitador
    @Override
    public void ponerBotonActualizar() {((CrudFacilitadorController) loader.getController()).ponerBotonActualizar();} // 00016823 Se castea al controllador y se usa su atributo para poner el botón actualizar

    @Override
    public void ponerBotonEliminar() {((CrudFacilitadorController) loader.getController()).ponerBotonEliminar();} // 00016823 Se castea al controllador y se usa su atributo para poner el botón eliminar

    @Override
    public void ponerLabels() {((CrudFacilitadorController) loader.getController()).ponerLabels();}// 00016823 Se castea al controllador y se usa su atributo para poner labels

    @Override
    public void ponerTextFields() {((CrudFacilitadorController) loader.getController()).ponerTextFields();}// 00016823 Se castea al controllador y se usa su atributo para poner el text fields

    @Override
    public void ponerBuscador() {((CrudFacilitadorController) loader.getController()).ponerBuscador();}// 00016823 Se castea al controllador y se usa su atributo para poner el buscador

    @Override
    public void ponerBotonInsertar() {((CrudFacilitadorController) loader.getController()).ponerBotonInsertar();}// 00016823 Se castea al controllador y se usa su atributo para poner el botón insertar

    @Override
    public void cambiarTitulo(String titulo) {((CrudFacilitadorController) loader.getController()).getLblTitulo().setText(titulo);}// 00016823 Se castea al controllador y se usa su atributo para poner un nuevo texto al label de título

    public CrudFacilitadorApp(){
        loader = new FXMLLoader(getClass().getResource("/org/poo/parcialfinalpoo/crud/crud-facilitador.fxml"));// 00016823 Se carga el fxml de crud facilitador y lo guarda en loader
        try {
            root = loader.load(); // 00016823 Guarda el parent
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
