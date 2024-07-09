package org.poo.parcialfinalpoo.documentViews;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class documentC_App extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/poo/parcialfinalpoo/documentosC.fxml")); //00054123 Se carga el archivo fxml
        Scene scene = new Scene(fxmlLoader.load(), 700, 500); //00054123 Se genera una nueva escena para mostrar con el fxml cargado
        stage.setTitle("Reporte tipo C"); //00054123 Se le pone el titulo al stage
        stage.setScene(scene);//00054123 Se coloca la escena en el stage
        stage.show();//00054123 se meustra el neuvo stage
    }
}
