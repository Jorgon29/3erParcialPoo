package org.poo.parcialfinalpoo.crud;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.poo.parcialfinalpoo.controllers.crud.MenuCrudController;
import org.poo.parcialfinalpoo.controllers.crud.menuStrategies.MenuCrudStrategy;

public class CrudApp extends Application { // 00016823 muestra un menú con las 4 opciones del CRUD
    @Override
    public void start(Stage stage) throws Exception { // 00016823 Lanza la aplicación en la stage proveída
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("menu-crud.fxml")); // 00016823 carga el fxml del menu crud
        Scene scene = new Scene(fxmlLoader.load(), 700, 500); // 00016823 Crea la scena a mostrar
        stage.setTitle("BCN"); // 00016823 Pone BCN en el título del stage
        stage.setScene(scene); // 00016823 Pone la escena en el stage
        stage.show(); // 00016823 Permite mostrar la escena
    }
    public void start(Stage stage, MenuCrudStrategy strategy) throws Exception { // 00016823 Similar al método inmediatamente arriba, pero recibe una strategy crud
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("menu-crud.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 500); // 00016823 Crea la scena a mostrar
        stage.setTitle("BCN"); // 00016823 Pone BCN en el título del stage
        stage.setScene(scene); // 00016823 Pone la escena en el stage
        ((MenuCrudController) fxmlLoader.getController()).setStrategy(strategy); // 00016823 Pone la strategy en la app para que funcione como se espera
        ((MenuCrudController) fxmlLoader.getController()).getLblTipo().setText(strategy.getNombre()); // 00016823 Pone el título dependiendo de la strategy recibida
        stage.show(); // 00016823 Permite mostrar la escena
    }
}
