package org.poo.parcialfinalpoo.controllers.crud;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import org.poo.parcialfinalpoo.BcnApp;
import org.poo.parcialfinalpoo.modelBase.query.Queryable;

public abstract class CrudAbstractController { // 00016823 Clase base para todos los controllers de las escenas CRUD
    @FXML protected HBox hbArriba; // 00016823 hbox donde va el label del título y el buscador
    @FXML protected HBox hbAbajo; // 00016823 hbox donde va el botón regresar y el posible botón de acción (Eliminar, Actualizar o Insertar)
    @FXML protected ComboBox<Integer> cbIds; // 00016823 Combobox donde se puede elegir uno entre los ids existentes en la bd, para el elemento que sea
    @FXML protected Label lblTitulo; // 00016823 Label donde se describe la acción realizable en alguna escena
    @FXML protected GridPane gridDatos; // 00016823 GridPane donde se muestran los cambos (Editables o no) de todos los datos que almacena un registro en la bd
    protected int actual; // 00016823 Guarda el id del elemento actual
    protected abstract void asignarIdsComboBox(); // 00016823 Asigna los ids de la tabla correspondiente a cbIds
    protected abstract void enBuscar(); // 00016823 Especifica el procedimiento a realizar cuando se presione el botón Buscar
    protected abstract void enInsertar(); // 00016823 Especifica el procedimiento a realizar cuando se presione el botón insertar
    protected abstract void enEliminar();  // 00016823 Especifica el procedimiento a realizar cuando se presione el botón Eliminar
    protected abstract void enActualizar();  // 00016823 Especifica el procedimiento a realizar cuando se presione el botón actualizar
    public abstract void ponerLabels(); // 00016823 Pone en el grid pane los labels para mostrar los diferentes campos de algún elemento seleccionado
    public abstract void ponerTextFields(); // 00016823 Pone en el grid pane los text fields (directos o "decorados" como el datepicker y combo box) para insertar datos
    protected Queryable query; // 00016823 Es el que provee de los métodos necesarios para usar la tabla necesaria

    public void ponerBotonInsertar(){ // 00016823 Coloca el boton insertar en hbabajo
        Button button = new Button(); // 00016823 Se instancia un nuevo botón
        button.setText("Insertar"); // 00016823 Se especifica el texto que mostrará el botón
        button.setOnAction(actionEvent -> {enInsertar();}); // 00016823 Se especifica la acción que ocurre cuando se presiona el botón
        hbAbajo.getChildren().add(button); // 00016823 Se coloca el botón en hbabajo
    }

    public void ponerBotonEliminar(){ // 00016823 Coloca el boton eliminar en hbabajo
        Button button = new Button(); // 00016823 Se instancia un nuevo botón
        button.setText("Eliminar"); // 00016823 Se especifica el texto que mostrará el botón
        button.setOnAction(actionEvent -> {enEliminar();}); // 00016823 Se especifica la acción que ocurre cuando se presiona el botón
        hbAbajo.getChildren().add(button); // 00016823 Se coloca el botón en hbabajo
    }
    public void ponerBotonActualizar(){ // 00016823 Coloca el boton actualizar en hbabajo
        Button button = new Button(); // 00016823 Se instancia un nuevo botón
        button.setText("Actualizar"); // 00016823 Se especifica el texto que mostrará el botón
        button.setOnAction(actionEvent -> {enActualizar();}); // 00016823 Se especifica la acción que ocurre cuando se presiona el botón
        hbAbajo.getChildren().add(button); // 00016823 Se coloca el botón en hbabajo
    }

    @FXML
    public void enRegresar(){ // 00016823 Muestra de nuevo la escena del menú principal
        BcnApp app = new BcnApp(); // 00016823 Se instancia una nueva BcnApp
        try { // 00016823 Siempre se debe colocar en un try catch el start de una java fx application
            if (BcnApp.getAppStage() != null){ // 00016823 Se comprueba que la stage guardada no sea nula
                app.start(BcnApp.getAppStage());// 00016823 Se inicia la nueva BcnApp en la stage del sistema
            } else { // 00016823 En caso de que la stage del sistema sea nula por algún motivo se crea una nueva stage
                app.start(new Stage()); // 00016823 Se inicia la app en una nueva stage
            }

        } catch (Exception e){ // 00016823 En caso de lanzarse una excepción se interrumpe
            e.printStackTrace(); // 00016823 Muestra la cadena de llamados hasta el momento en el que se lanza la excepción
        }
    }

    public void ponerBuscador(){ // 00016823 Pone tanto el combo box como el botón responsables de permitir elegir un registro existente
        cbIds = new ComboBox<>(); // 00016823 Se inicializa el combo box
        asignarIdsComboBox(); // 00016823 Se asignan los ids de los registros existentes de la tabla pertinente
        hbArriba.getChildren().add(cbIds); // 00016823 Se agrega el combo box a la hbox de arriba
        Button button = new Button("Buscar"); // 00016823 Se instancia un nuevo botón con el texto Buscar
        button.setOnAction(actionEvent -> {enBuscar();}); // 00016823 Se especifica la acción a realizar cuando se presione el botón
        hbArriba.getChildren().add(button);// 00016823 Se agrega el botón buscar al hbox de arriba
    }

    public Label getLblTitulo(){return lblTitulo;} // 00016823 Regresa el label del título para poder ser editado su texto en otro lugar
    protected void alerta(String mensaje){ // 00016823 Se muestra un pop up de error con el mensaje recibido
        Alert a = new Alert(Alert.AlertType.ERROR); // 00016823 Se inicializa una nueva alerta del tipo ERROR
        a.setContentText(mensaje); // 00016823 Se le asigna el mensaje recibido a la alerta
        a.setTitle("Error"); // 00016823 Se establece el título de la alerta como Error
        a.showAndWait(); // 00016823 Se muestra la alerta y se espera a la siguiente acción
    }
    protected void informacion(String mensaje){ // 00016823 Se muestra un pop up de información con el mensaje recibido
        Alert a = new Alert(Alert.AlertType.INFORMATION); // 00016823 Se inicializa una nueva alerta del tipo INFORMATION
        a.setContentText(mensaje); // 00016823 Se le asigna el mensaje recibido a la alerta
        a.setTitle("Información"); // 00016823 Se establece el título de la alerta como Información
        a.showAndWait(); // 00016823 Se muestra la alerta y se espera a la siguiente acción
    }

}
