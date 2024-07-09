package org.poo.parcialfinalpoo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class BcnApp extends Application {
    private static Stage appStage;
    @Override
    public void start(Stage stage) throws IOException {
        appStage = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("menu-principal.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 500);
        stage.setTitle("BCN");
        stage.setScene(scene);
        stage.show();
    }

    public static Stage getAppStage() {
        return appStage;
    }

    public static void main(String[] args) {
        launch();
    }

}