package org.poo.parcialfinalpoo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class BcnApp extends Application {// 00016823 Clase donde empieza el funcionamiento del programa. Carga el menú principal
    private static Stage appStage;// 00016823 guarda la stage para futuro uso en otras apps
    @Override
    public void start(Stage stage) throws IOException { // 00016823 método que carga el menú principal
        appStage = stage;// 00016823 guarda el stage para usarlo después
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("menu-principal.fxml")); // 00016823 carga el fxml del menú principal
        Scene scene = new Scene(fxmlLoader.load(), 700, 500); // 00016823 crea la escena
        stage.setTitle("BCN");// 00016823 establece el título de la ventana
        stage.setScene(scene);// 00016823 asigna la escena al stage
        stage.show(); // 00016823 llamada a show para poder mostrar la escena
        // 00016823 Si alguien lee esto, no alcancé a comentar TODAS las líneas (algunas del patrón builder), pero la gran mayoría sí están comentadas, consideración
    }

    public static Stage getAppStage() {
        return appStage;
    }  // 00016823 Así se obtiene la stage almacenada

    public static void main(String[] args) {
        launch();
    }  // 00016823 Método main, da inicio al programa

}