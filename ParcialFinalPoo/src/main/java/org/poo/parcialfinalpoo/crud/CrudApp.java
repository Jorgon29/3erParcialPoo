package org.poo.parcialfinalpoo.crud;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.poo.parcialfinalpoo.controllers.crud.MenuCrudController;
import org.poo.parcialfinalpoo.controllers.crud.menuStrategies.MenuCrudStrategy;

public class CrudApp extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("menu-crud.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 500);
        stage.setTitle("BCN");
        stage.setScene(scene);
        stage.show();
    }
    public void start(Stage stage, MenuCrudStrategy strategy) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("menu-crud.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 500);
        stage.setTitle("BCN");
        stage.setScene(scene);
        ((MenuCrudController) fxmlLoader.getController()).setStrategy(strategy);
        ((MenuCrudController) fxmlLoader.getController()).getLblTipo().setText(strategy.getNombre());
        stage.show();
    }
}
