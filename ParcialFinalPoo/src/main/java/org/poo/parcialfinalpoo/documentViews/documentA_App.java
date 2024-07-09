package org.poo.parcialfinalpoo.documentViews;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class documentA_App extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/poo/parcialfinalpoo/documentosA.fxml")); //00054123 Se carga el fxml para mostrar
        Scene scene = new Scene(fxmlLoader.load(), 700, 500);//00054123 Se crea una nueva escena para mostrar en el stage
        stage.setTitle("Documento tipo A"); //00054123 Se le pone un titulo al stage
        stage.setScene(scene); //00054123 Se pone la nueva escena en el stage
        stage.show(); //00054123 Se muestra el stage con la escena que se puso
    }
}

