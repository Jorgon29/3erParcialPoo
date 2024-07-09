package org.poo.parcialfinalpoo.documentViews;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class documentD_App extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/poo/parcialfinalpoo/documentosD.fxml")); //00054123 Carga el archivo fxml para mostrar
        Scene scene = new Scene(fxmlLoader.load(), 700, 500); //00054123 Inicia una scena donde se va a mostrar todo con el fxml cargado
        stage.setTitle("Reporte tipo D"); //00054123 Se coloca el titulo de la ventana
        stage.setScene(scene); //00054123 se coloca la escena en el stage
        stage.show(); //00054123 Se muestra el stage
    }

}
