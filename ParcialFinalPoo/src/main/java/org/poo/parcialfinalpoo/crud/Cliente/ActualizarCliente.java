package org.poo.parcialfinalpoo.crud.Cliente;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ActualizarCliente extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/poo/parcialfinalpoo/crud/actualizar-cliente.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 500);
        stage.setTitle("BCN");
        stage.setScene(scene);
        stage.show();
    }
}
