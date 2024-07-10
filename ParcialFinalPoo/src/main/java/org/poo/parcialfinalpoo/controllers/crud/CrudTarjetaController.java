package org.poo.parcialfinalpoo.controllers.crud;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.poo.parcialfinalpoo.modelBase.query.QueryCliente;
import org.poo.parcialfinalpoo.modelBase.query.QueryFacilitador;
import org.poo.parcialfinalpoo.modelBase.query.QueryTarjeta;
import org.poo.parcialfinalpoo.modelBase.tipos.Cliente;
import org.poo.parcialfinalpoo.modelBase.tipos.Facilitador;
import org.poo.parcialfinalpoo.modelBase.tipos.Tarjeta;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

public class CrudTarjetaController extends CrudAbstractController { // 00016823 COntroller para cualquier acción del crud (Escena) en la tabla Tarjeta
    protected Label lblNumero; // 00016823 Label en el que se mostrará el número de alguna tarjeta
    protected Label lblFechaExp; // 00016823 Label en el que se mostrará la fecha de expiración de alguna tarjeta
    protected Label lblTipo; // 00016823 Laben en el que se mostrará el tipo de alguna tarjeta
    protected Label lblNombreCliente; // 00016823 Label en el que se mostrará el nombre del cliente de alguna tarjeta
    protected Label lblFacilitador; // 00016823 Label en el que se mostrará el nombre del facilitador de alguna tarjeta
    protected TextField txtNumero; // 00016823 Text field en el que se podrá digitar un número de tarjeta
    protected DatePicker txtFechaExp;// 00016823 Date picker en el que se podrá elegir una fecha de expiración para una tarjeta
    protected ComboBox<String> txtTipo; // 00016823 Combo box en el que se podrá elegir entre crédito y débito para alguna tarjeta
    protected ComboBox<Cliente> txtCliente; // 00016823 Combo box en el que se podrá elegir algún cliente al que asignarle una tarjeta
    protected ComboBox<Facilitador> txtFacilitador; // 00016823 Combo box en el que se podrá elegir algún facilitador que asignarle a una tarjeta

    @FXML
    protected void initialize(){query = new QueryTarjeta();} // 00016823 Se inicializa query con una nueva Query Tarjeta

    protected void enBuscar(){ // 00016823 Especifica el procedimiento a realizar cuando se presione el botón Buscar
        try { // 00016823 Se necesita un bloque try catch ya que todos los métodos de queries pueden lanzar una SQLexception
            actual = cbIds.getValue(); // 00016823 Se asigna el valor del id seleccionado al actual
            Tarjeta tarjeta = (Tarjeta) query.select(actual); // 00016823 Se construye un objeto tarjeta con los valores obtenidos en la base de datos identificados con el id actual
            if (txtNumero == null){ // 00016823 Se comprueba si los text fields son nulos
                lblNumero.setText(tarjeta.getNumero()); // 00016823 Se asigna el número de tarjeta a su label correspondiente
                lblTipo.setText(tarjeta.getTipo()); // 00016823 Se asigna el tipo de tarjeta su label correspondiente
                lblNombreCliente.setText(tarjeta.getCliente()); // 00016823 Se asigna el nombre del cliente a su label correspondiente
                lblFechaExp.setText(tarjeta.getFecha_exp().toString()); // 00016823 Se asigna la fecha de expiración a su label correspondiente
                lblFacilitador.setText(tarjeta.getFacilitador()); // 00016823 Se asigna nombre del facilitador a su label correspondiente
            } else{ // 00016823 En caso de que los text fields no sean nulos
                txtNumero.setText(tarjeta.getNumero()); // 00016823 Se le asigna el número de tarjeta al text field correspondiente
            }
        } catch (Exception e){ // 00016823 En caso de de haber una excepción se recibe
            alerta("Tarjeta no encontrada"); // 00016823 Se muestra una alerta comunicando sobre un error
        }
    }
    protected void enActualizar(){ // 00016823 Especifica el procedimiento a realizar cuando se presione el botón actualizar
        try { // 00016823 Se necesita un bloque try catch ya que todos los métodos de queries pueden lanzar una SQLexception
            query.actualizar(new Tarjeta(actual,txtTipo.getValue(), txtNumero.getText(), txtFechaExp.getValue(), txtCliente.getValue().getNombre() ,txtCliente.getValue().getId(), txtFacilitador.getValue().getNombre(),txtFacilitador.getValue().getId())); // 00016823 Se envían los valores a actualizar al registro con el id actual
            informacion("Actualizado correctamente"); // 00016823 Se muestra una alerta comunicando que se ha realizado exitosamente
        } catch (Exception e){ // 00016823 En caso de de haber una excepción se recibe
            alerta("Error en actualización"); // 00016823 Se muestra una alerta comunicando sobre un error
        }
    }

    protected void enEliminar(){ // 00016823 Especifica el procedimiento a realizar cuando se presione el botón Eliminar
        try { // 00016823 Se necesita un bloque try catch ya que todos los métodos de queries pueden lanzar una SQLexception
            query.eliminar(actual); // 00016823 Se intenta eliminar el registro con el id actual
            asignarIdsComboBox(); // 00016823 Se asignan nuevamente los ids a cbIds ya que ahora hay uno menos
            informacion("Eliminado correctamente"); // 00016823 Se muestra una alerta comunicando que se realizó correctamente
        } catch (Exception e){ // 00016823 En caso de de haber una excepción se recibe
            alerta("Error en eliminación"); // 00016823 Se muestra una alerta comunicando sobre un error
        }
    }


    public void ponerLabels(){ // 00016823 Pone en el grid pane los labels para mostrar los diferentes campos de algún elemento seleccionado
        lblFacilitador = new Label(); // 00016823 Se inicializa el label facilitador
        lblNombreCliente = new Label();// 00016823 Se inicializa el label nombre cliente
        lblNumero = new Label();// 00016823 Se inicializa el label número
        lblTipo = new Label();// 00016823 Se inicializa el label tipo
        lblFechaExp = new Label();// 00016823 Se inicializa el label fecha_exp
        gridDatos.add(lblNumero, 1, 0);// 00016823 Se pone el label número en la posición 1,0 del grid
        gridDatos.add(lblFechaExp, 1, 1);// 00016823 Se pone el label fecha_exp en la posición 1,1 del grid
        gridDatos.add(lblTipo, 1, 2);// 00016823 Se pone el label tipo en la posición 1,2 del grid
        gridDatos.add(lblNombreCliente, 1, 3);// 00016823 Se pone el label nombre cliente en la posición 1,3 del grid
        gridDatos.add(lblFacilitador, 1, 4);// 00016823 Se pone el label facilitador en la posición 1,4 del grid
    }

    public void ponerTextFields(){ // 00016823 Pone en el grid pane los text fields (directos o "decorados" como el datepicker y combo box) para insertar datos
        txtFacilitador = new ComboBox<>(); // 00016823 se inicializa el combo box facilitador
        txtCliente = new ComboBox<>(); // 00016823 se inicializa el combo box cliente
        txtTipo = new ComboBox<>(); // 00016823 se inicializa el combo box tipo
        try { // 00016823 Se necesita un bloque try catch ya que todos los métodos de queries pueden lanzar una SQLexception
            QueryFacilitador queryFacilitador = new QueryFacilitador(); // 00016823 Dado que no estamos en CrudFacilitadorController, debemos crear un nuevo queryFacilitador
            QueryCliente queryCliente = new QueryCliente(); // 00016823 Dado que no estamos en CrudClienteController, debemos crear un nuevo queryCliente
            txtFacilitador.setItems(FXCollections.observableArrayList(queryFacilitador.select())); // 00016823 Se le asignan los facilitadores presentes en la bd al txtFacilitador
            txtCliente.setItems(FXCollections.observableArrayList(queryCliente.select())); // 00016823 Se le asignan los clientes presentes en la bd al txtCliente
        } catch (SQLException e){ // 00016823 En caso de de haber una excepción se recibe
            alerta("Error poniendo editables"); // 00016823 Se muestra una alerta comunicando sobre un error
        }
        txtNumero = new TextField(); // 00016823 Se inicializa el text fiel número
        txtTipo.setItems(FXCollections.observableArrayList(Arrays.asList("Credito", "Debito"))); // 00016823 Se le asigan "Credito" y "Debito" a txtTipo como posibles opciones
        txtFechaExp = new DatePicker(); // 00016823 Se inicializa el date picker fechaExp
        gridDatos.add(txtNumero, 1, 0); // 00016823 Se pone txtNumero en la posición 1,0 del grid
        gridDatos.add(txtFechaExp, 1, 1); // 00016823 Se pone txtFechaExp en la posición 1,1 del grid
        gridDatos.add(txtTipo, 1, 2);// 00016823 Se pone txtTipo en la posición 1,2 del grid
        gridDatos.add(txtCliente, 1, 3);// 00016823 Se pone txtCliente en la posición 1,3 del grid
        gridDatos.add(txtFacilitador, 1, 4);// 00016823 Se pone txtFacilitador en la posición 1,4 del grid
    }


    protected void asignarIdsComboBox(){ // 00016823 Asigna los ids de la tabla correspondiente a cbIds
        ArrayList<Integer> ids = null; // 00016823 Se inicializa el array de ids como nulo
        try { // 00016823 Se necesita un bloque try catch ya que todos los métodos de queries pueden lanzar una SQLexception
            ids = query.getIds(); // 00016823 Se asigna al array el resultado de la query de seleccionar todos los ids de la tabla Tarjeta
        } catch (SQLException e) { // 00016823 En caso de de haber una excepción se recibe
            throw new RuntimeException(e);// 00016823 Se lanza una excepción
        }
        cbIds.setItems(FXCollections.observableArrayList(ids));// 00016823 Se le asignan los ids encontrados al combo box de ids
    }


    protected void enInsertar(){ // 00016823 Especifica el procedimiento a realizar cuando se presione el botón insertar
        try { // 00016823 Se necesita un bloque try catch ya que todos los métodos de queries pueden lanzar una SQLexception
            query.insertar(new Tarjeta(actual,txtTipo.getValue(), txtNumero.getText(), txtFechaExp.getValue(), txtCliente.getValue().getNombre() ,txtCliente.getValue().getId(), txtFacilitador.getValue().getNombre(),txtFacilitador.getValue().getId())); // 00016823 Se pasan los valores a insertar mediante un objeto tarjeta a la query y se intentan insertar
            informacion("Insertado correctamente"); // 00016823 Muestra una alerta comunicando que se realizó con éxito
            txtNumero.setText(""); // 00016823 Se vacía el texto de txtNumero para evitar introducirlo más de una vez
        } catch (Exception e){ // 00016823 En caso de de haber una excepción se recibe
            alerta("Error en inserción"); // 00016823 Se muestra una alerta comunicando sobre un error
        }
    }


}
