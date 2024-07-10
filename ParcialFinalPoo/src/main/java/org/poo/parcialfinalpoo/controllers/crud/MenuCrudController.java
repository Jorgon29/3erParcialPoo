package org.poo.parcialfinalpoo.controllers.crud;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.poo.parcialfinalpoo.BcnApp;
import org.poo.parcialfinalpoo.controllers.crud.menuStrategies.MenuCrudStrategy;

import java.io.IOException;

public class MenuCrudController { // 00016823 Controller de la scene donde se elige acción del crud (Insertar, Actualizar, Eliminar, Ver)
    private MenuCrudStrategy strategy; // 00016823 Dependiendo del elemento (tabla) a modificar o utilizar se asigna una strategy diferente
    @FXML
    protected Button btnInsertar; // 00016823 Botón que lleva a la escena de inserción
    @FXML
    protected Button btnEliminar; // 00016823 Botón que lleva a la escena de eliminación
    @FXML
    protected Button btnVer;// 00016823 Botón que lleva a la escena de visualización
    @FXML
    protected Button btnActualizar;// 00016823 Botón que lleva a la escena de actualización
    @FXML
    protected Label lblTipo; // 00016823 Label que muestra el nombre del tipo de registro a operar
    @FXML
    protected Button btnRegresar; // 00016823 Botón que lleva a la escena de menú principal

    public void setStrategy(MenuCrudStrategy strategy){this.strategy = strategy;}  // 00016823 Asigna la strategy a utilizar para determinar el tipo de registro

    @FXML
    public void enInsertar(){
        strategy.enInsertar();
    } // 00016823 Llama al insertar de la strategy

    @FXML
    public void enEliminar(){
        strategy.enEliminar();
    } // 00016823 Llama al eliminar de la strategy
    @FXML
    public void enActualizar(){
        strategy.enActualizar();
    } // 00016823 Llama al actualizar de la strategy
    @FXML
    public void enVer(){
        strategy.enVer();
    }// 00016823 Llama al visualizar de la strategy

    public Label getLblTipo(){
        return lblTipo;
    } // 00016823 Obtiene el label de título para poderlo modificar fuera
    @FXML
    public void enRegresar(){ // 00016823 Muestra de nuevo el menú principal
        try { // 00016823 Es necesario que el start de las javafx application esté dentro de un bloque try catch
            (new BcnApp()).start(((Stage) btnActualizar.getScene().getWindow())); // 00016823 Se inicia una nueva BcnApp en la misma escena actual
        } catch (IOException e) { // 00016823 En caso de haber una excepción se procede al catch
            throw new RuntimeException(e); // 00016823 Se lanza una nueva excepción
        }
    }


}
