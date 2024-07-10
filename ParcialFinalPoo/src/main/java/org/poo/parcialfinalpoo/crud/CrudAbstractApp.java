package org.poo.parcialfinalpoo.crud;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.poo.parcialfinalpoo.controllers.crud.CrudClienteController;

public abstract class CrudAbstractApp extends Application { // 00016823 Clase base para todas las escenas de acciones crud
    protected FXMLLoader loader; // 00016823 Almacena el loader con el fin de poder usar métodos del controller
    protected Parent root; // 00016823 Permite almacenar correctamente el FXMLLoader
    public void start(Stage stage) throws Exception { // 00016823 Método por el que inician las apps crud
        Scene scene = new Scene(root, 700, 500); // 00016823 Se crea una escena tomando el parent almacenado
        stage.setTitle("BCN"); // 00016823 Se establece el título en BCN
        stage.setScene(scene); // 00016823 Pone la escena en el stage recibido
        stage.show(); // 00016823 Permite mostrar la scene antes puesta
    }

    public abstract void ponerBotonActualizar(); // 00016823 Espera se llame al método del controller para poner el botón actualizar
    public abstract void ponerBotonEliminar(); // 00016823 Espera se llame al método del controller para poner el botón eliminar
    public abstract void ponerLabels(); // 00016823 Espera se llame al método del controller para poner los campos no editables
    public abstract void ponerTextFields(); // 00016823 Espera se llame al método del controller para poner los campos editables
    public abstract void ponerBuscador(); // 00016823 Espera se llame al método del controller para poner el buscador
    public abstract void ponerBotonInsertar(); // 00016823 Espera se llame al método del controller para poner el botón insertar
    public abstract void cambiarTitulo(String titulo); // 00016823 Espera se llame al método del controller para cambiar el texto del label del título
}
