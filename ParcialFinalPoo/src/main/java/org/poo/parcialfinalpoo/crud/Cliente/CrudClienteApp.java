package org.poo.parcialfinalpoo.crud.Cliente;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.poo.parcialfinalpoo.controllers.crud.CrudClienteController;
import org.poo.parcialfinalpoo.crud.CrudAbstractApp;

import java.io.IOException;

public class CrudClienteApp extends CrudAbstractApp { // 00016823 App para crud del cliente
    public void cambiarTitulo(String titulo){((CrudClienteController) loader.getController()).getLblTitulo().setText(titulo);} // 00016823 Se castea al controllador y se usa su atributo para poner un nuevo texto al label de título
    public CrudClienteApp(){
        loader = new FXMLLoader(getClass().getResource("/org/poo/parcialfinalpoo/crud/crud-cliente.fxml")); // 00016823 Se carga el fxml de crud cliente y lo guarda en loader
        try {
            root = loader.load(); // 00016823 Guarda el parent
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void ponerBotonActualizar(){((CrudClienteController) loader.getController()).ponerBotonActualizar();} // 00016823 Se castea al controllador y se usa su atributo para poner el botón actualizar
    public void ponerBotonEliminar(){((CrudClienteController) loader.getController()).ponerBotonEliminar();} // 00016823 Se castea al controllador y se usa su atributo para poner el botón eliminar
    public void ponerLabels(){((CrudClienteController) loader.getController()).ponerLabels();} // 00016823 Se castea al controllador y se usa su atributo para poner el labels
    public void ponerTextFields(){((CrudClienteController) loader.getController()).ponerTextFields();} // 00016823 Se castea al controllador y se usa su atributo para poner el text fields
    public void ponerBuscador(){((CrudClienteController) loader.getController()).ponerBuscador();} // 00016823 Se castea al controllador y se usa su atributo para poner el buscador
    public void ponerBotonInsertar(){((CrudClienteController) loader.getController()).ponerBotonInsertar();} // 00016823 Se castea al controllador y se usa su atributo para poner el botón insertar

}
