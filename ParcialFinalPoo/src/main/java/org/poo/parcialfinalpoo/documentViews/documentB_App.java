package org.poo.parcialfinalpoo.documentViews;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class documentB_App extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/poo/parcialfinalpoo/documentosB.fxml")); //00054123 Se carga el archivo fxml que se va a mostrar
        Scene scene = new Scene(fxmlLoader.load(), 700, 500); //00054123 se genera una nueva escena con el fxml que se cargo
        stage.setTitle("Reporte tipo B"); //00054123 Se le pone el titulo al stage
        stage.setScene(scene); //00054123 Se coloca la escena en el stage
        stage.show(); //00054123 Se muestra el stage con la escena ya cargada
    }
}
