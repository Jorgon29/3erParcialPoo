package org.poo.parcialfinalpoo.controllers.crud;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.poo.parcialfinalpoo.controllers.crud.CrudAbstractController;
import org.poo.parcialfinalpoo.modelBase.query.QueryFacilitador;
import org.poo.parcialfinalpoo.modelBase.tipos.Facilitador;

import java.sql.SQLException;

public class CrudFacilitadorController extends CrudAbstractController {
    private Label lblNombre; // 00016823 En este label se pone el nombre del facilitador seleccionado
    private TextField txtNombre; // 00016823 En este text field se puede digitar el nombre del facilitador a ingresar/actualizar

    @FXML protected void initialize(){ // 00016823 Esta función se ejecuta al iniciar la application
        query = new QueryFacilitador(); // 00016823 Se asigna a query un nuevo QueryFacilitador que permite ejecutar queries en la tabla facilitador
    }

    @Override
    protected void asignarIdsComboBox() { // 00016823 Se asignan las ids de los registros de facilitadores al comboBox del buscador
        try { // 00016823 Se necesita un bloque try catch ya que todos los métodos de queries pueden lanzar una SQLexception
            cbIds.setItems(FXCollections.observableArrayList(query.getIds())); // 00016823 Se asigna el observable array de todos los ids existentes en la base de datos al combo box del buscador
        } catch (SQLException e) { // 00016823 Se agarra la sql exception posiblemente lanzada por getIds
            alerta(e.getMessage()); // 00016823 Muestra una alerta con el mensaje de la excepción
        }
    }

    @Override
    protected void enBuscar() { // 00016823 Este método se ejecuta al presionar buscar, y dependiendo de los widgets presentes se asignan valores a unos u otros
        try { // 00016823 Se necesita un bloque try catch ya que todos los métodos de queries pueden lanzar una SQLexception
            actual = cbIds.getValue(); // 00016823 Se toma el valor actual del combo box del buscador y se guarda para evitar problemas (Si entre presionar buscar y la siguiente accion se cambia el combo box)
            Facilitador facilitador = (Facilitador) query.select(actual); // 00016823 Se construye un objeto facilitador tomando los datos en la tabla de la tabla con el id actual
            if (lblNombre == null){ // 00016823 Se comprueba si los labels no están puestos
                txtNombre.setText(facilitador.getNombre()); // 00016823 Se asigna el valor del nombre obtenido de la bd al text field editable
            } else { // 00016823 En este caso los labels sí están puestos
                lblNombre.setText(facilitador.getNombre()); // 00016823 Se le asigna el valor del nombre obtenido de la bd al label no editable
            }
        } catch (Exception e){ // 00016823 En caso de cualquier opción (Pueden haber diferentes tipos), se recibe
            alerta(e.getMessage()); // 00016823 Muestra una alerta con el mensaje de la excepción
        }
    }

    @Override
    protected void enInsertar() { // 00016823 Este método es ejecutado al intentar insertar un nuevo registro
        try { // 00016823 Se necesita un bloque try catch ya que todos los métodos de queries pueden lanzar una SQLexception
            query.insertar(new Facilitador(actual, txtNombre.getText())); // 00016823 Se inserta un registro nuevo a la tabla de la bd con el nombre ingresado, se manda el id actual ya que el constructor lo necesita
            informacion("Insertado correctamente"); // 00016823 Se muestra una alerta diciendo que ha sido exitoso el método
        } catch (Exception e){ // 00016823 En caso de cualquier opción (Pueden haber diferentes tipos), se recibe
            alerta(e.getMessage()); // 00016823 Muestra una alerta con el mensaje de la excepción
        }
    }

    @Override
    protected void enEliminar() { // 00016823 Este método es ejecutado al intentar eliminar un facilitador
        try { // 00016823 Se necesita un bloque try catch ya que todos los métodos de queries pueden lanzar una SQLexception
            query.eliminar(actual); // 00016823 Se intenta eliminar el registro de la base de datos que tenga el id actual
            lblNombre.setText(""); // 00016823 Se quita el texto del label que tenía el nombre
            informacion("Eliminado correctamente (Se han eliminado también todas las tarjetas y sus transacciones) "); // 00016823 Se comunican los procedimientos realizados exitosamente
            asignarIdsComboBox(); // 00016823 Se vuelven a asignar los ids al combo box ya que se ha eliminado uno
        } catch (Exception e){ // 00016823 En caso de cualquier opción (Pueden haber diferentes tipos), se recibe
            alerta(e.getMessage()); // 00016823 Muestra una alerta con el mensaje de la excepción
        }
    }

    @Override
    protected void enActualizar() { // 00016823 Este método es ejecutado al intentar actualizar un registro ya existente
        try { // 00016823 Se necesita un bloque try catch ya que todos los métodos de queries pueden lanzar una SQLexception
            query.actualizar(new Facilitador(actual, txtNombre.getText())); // 00016823 Se envía un objeto facilitador con los datos a actualizar
            informacion("Actualizado correctamente"); // 00016823 Muestra una alerta transmitiendo que se ha realizado exitosamente la actualización
        } catch (Exception e){ // 00016823 En caso de cualquier opción (Pueden haber diferentes tipos), se recibe
            alerta(e.getMessage()); // 00016823 Muestra una alerta con el mensaje de la excepción
        }
    }

    @Override
    public void ponerLabels() { // 00016823 Se inicializa y pone el label para el nombre del facilitador
        lblNombre = new Label(); // 00016823 Se inicializa el label
        gridDatos.add(lblNombre, 1, 0);  // 00016823 Se coloca el label en la 2da columna y 1ra fila del grid
    }

    @Override
    public void ponerTextFields() { // 00016823 Se inicializa y pone el text field para el nombre del facilitador
        txtNombre = new TextField(); // 00016823 Se inicializa el text field
        gridDatos.add(txtNombre, 1, 0); // 00016823 Se coloca el text field en la 2da columna y 1ra fila del grid
    }
}
