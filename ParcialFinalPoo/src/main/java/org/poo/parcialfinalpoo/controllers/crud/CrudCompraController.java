package org.poo.parcialfinalpoo.controllers.crud;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.poo.parcialfinalpoo.modelBase.query.QueryCliente;
import org.poo.parcialfinalpoo.modelBase.query.QueryCompra;
import org.poo.parcialfinalpoo.modelBase.query.QueryTarjeta;
import org.poo.parcialfinalpoo.modelBase.tipos.Transaccion;

import java.sql.SQLException;

public class CrudCompraController extends CrudAbstractController { // 00016823 COntroller para cualquier acción del crud (Escena) en la tabla Transaccion
    private Label lblTotal; // 00016823 Label en el que se mostrará el total de alguna transacción
    private Label lblFecha; // 00016823 Label en el que se mostrará la fecha de alguna transacción
    private Label lblDescripcion; // 00016823 Label en el que se mostrará la descripción de alguna transacción
    private Label lblTarjeta; // 00016823 Label en el que se mostrará el número de alguna tarjeta
    private TextField txtTotal; // 00016823 Text field en el que se digitará el valor de una transacción
    private DatePicker txtFecha; // 00016823 Date picker para poder elegir una fecha de manera sencilla
    private TextField txtDescripcion; // 00016823 Text field en el que se digitará una descripción para alguna transacción
    private ComboBox<Integer> txtTarjeta; // 00016823 Combo box en el que se mostrarán las tarjetas existentes en el sistema

    @FXML
    protected void initialize(){query = new QueryCompra();} // 00016823 Se inicializa query con una nueva query compra

    @Override
    protected void asignarIdsComboBox() { // 00016823 Asigna las ids existentes de transacciones al combo box
        try { // 00016823 Todos los métodos de query pueden lanzar una excepción, así que es necesario un bloque try catch
            cbIds.setItems(FXCollections.observableArrayList(query.getIds())); // 00016823 Se le asignan los ids encontrados en la tabla a cbIds
        } catch (SQLException e) { // 00016823 Se encarga del caso donde ocurre alguna excepción
            alerta("Error de inicialización");  // 00016823 Muestra una alerta que comunica ha ocurrido un error
        }
    }

    @Override
    protected void enBuscar() { // 00016823 Especifica el procedimiento a realizar cuando se presione el botón Buscar
        try { // 00016823 Todos los métodos de query pueden lanzar una excepción, así que es necesario un bloque try catch
            actual = cbIds.getValue(); // 00016823 Se guarda el valor del id del cliente seleccionado
            Transaccion transaccion = (Transaccion) query.select(actual); // 00016823 Construye una transaccion nueva con los valores encontrados en la base de datos con el id actual
            if (txtDescripcion == null){  // 00016823 Comprueba si los text fields son nulos
                lblTotal.setText(String.valueOf(transaccion.getTotal()));  // 00016823 Asigna el total encontrado a su label correspondiente
                lblDescripcion.setText(transaccion.getDescripcion()); // 00016823 Asigna la descripción encontrada a su label correspondiente
                lblFecha.setText(transaccion.getFecha().toString()); // 00016823 Asigna la fecha encontrada a su label correspondiente
                lblTarjeta.setText(String.valueOf(transaccion.getId_tarjeta())); // 00016823 Asigna el número de tarjeta encontrado a su label correspondiente
            } else{ // 00016823 En caso de que los text fields no sean nulos
                txtTotal.setText(String.valueOf(transaccion.getTotal())); // 00016823 Se asigna el total encontrado a su text field correspondiente
                txtDescripcion.setText(transaccion.getDescripcion()); // 00016823 Se asigna la descripción encontrada a su text field correspondiente
            }
        } catch (Exception e){ // 00016823 Se encarga del caso donde ocurre alguna excepción
            alerta("Transacción no encontrada"); // 00016823 Muestra una alerta que comunica ha ocurrido un error
        }
    }

    @Override
    protected void enInsertar() { // 00016823 Especifica el procedimiento a realizar cuando se presione el botón insertar
        try { // 00016823 Se parsea a double el texto del text field de total para comprobar si lanza una excepción, comprobando así si es un valor double válido
            Double.parseDouble(txtTotal.getText()); // 00016823 Se parsea a double el valor del txtTotal
        } catch (NumberFormatException e){ // 00016823 En caso de no ser un double y por lo tanto recibir una excepción se evita el procedimiento
            alerta("Ingrese valores validos"); // 00016823 Muestra una alerta solicitando datos válidos
            return; // 00016823 Evita que el método siga
        }
        try { // 00016823 Todos los métodos de query deben estar en un bloque try catch a causa de un posible SQLException
            query.insertar(new Transaccion(0,Double.parseDouble(txtTotal.getText()), txtFecha.getValue(), txtDescripcion.getText(), txtTarjeta.getValue())); // 00016823 Se envían los nuevos valores a asignar al id actual en la bd
            informacion("Insertado correctamente"); // 00016823 Se comunica que se ha actualizado exitosamente
        } catch (SQLException e){ // 00016823 En caso de recibir una SQLException se maneja
            alerta(e.getMessage()); // 00016823 Muestra una alerta comunicando un error
        }
    }

    @Override
    protected void enEliminar() {  // 00016823 Especifica el procedimiento a realizar cuando se presione el botón Eliminar
        try { // 00016823 Todos los métodos de query deben estar en un bloque try catch a causa de un posible SQLException
            query.eliminar(actual); // 00016823 Se intenta eliminar el registro de transacción con el id actual
            txtTotal.setText(""); // 00016823 Se vacía el txtTotal para evitar ingresar 2 veces el mismo valor
            txtDescripcion.setText(""); // 00016823 Se vacía el txtDescripción para evitar ingresar 2 veces el mismo valor
            informacion("Eliminado correctamente"); // 00016823 Se muestra una alerta comunicando que se ha realizado correctamente
        } catch (SQLException e){ // 00016823 En caso de haber una excepción de maneja
            alerta(e.getMessage()); // 00016823 Se muestra una alerta comunicando un error
        }

    }

    @Override
    protected void enActualizar() {  // 00016823 Especifica el procedimiento a realizar cuando se presione el botón actualizar
        try { // 00016823 Se parsea a double el texto del text field de total para comprobar si lanza una excepción, comprobando así si es un valor double válido
            Double.parseDouble(txtTotal.getText()); // 00016823 Se parsea a double el valor del txtTotal
        } catch (NumberFormatException e){ // 00016823 En caso de no ser un double y por lo tanto recibir una excepción se evita el procedimiento
            alerta("Ingrese valores validos"); // 00016823 Muestra una alerta solicitando datos válidos
            return; // 00016823 Evita que el método siga
        }
        try { // 00016823 Todos los métodos de query deben estar en un bloque try catch a causa de un posible SQLException
            query.actualizar(new Transaccion(actual,Double.parseDouble(txtTotal.getText()), txtFecha.getValue(), txtDescripcion.getText(), txtTarjeta.getValue())); // 00016823 Se envían los datos a actualizar a través de un objeto transacción
            informacion("Actualizado correctamente"); // 00016823 Muestra una alerta comunicando que se ha realizado exitosamente
        } catch (SQLException e){ // 00016823 En caso de haber una excepción se maneja
            alerta(e.getMessage()); // 00016823 Se muestra una alerta comunicando un error
        }
    }

    @Override
    public void ponerLabels() { // 00016823 Pone en el grid pane los labels para mostrar los diferentes campos de algún elemento seleccionado
        lblTotal = new Label(); // 00016823 Inicializa el label total
        lblTarjeta = new Label(); // 00016823 Inicializa el label tarjeta
        lblDescripcion = new Label(); // 00016823 Inicializa el label descripción
        lblFecha = new Label(); // 00016823 Inicializa el label fecha
        gridDatos.add(lblTotal, 1, 0); // 00016823 Pone el label total en la posición 1,0 del grid
        gridDatos.add(lblFecha, 1, 1); // 00016823 Pone el label fecha en la posición 1,1 del grid
        gridDatos.add(lblDescripcion, 1, 2); // 00016823 Pone el label descripción en la posición 1,2 del grid
        gridDatos.add(lblTarjeta, 1, 3); // 00016823 Pone el label tarjeta en la posición 1,3 del grid
    }

    @Override
    public void ponerTextFields() { // 00016823 Pone en el grid pane los text fields (directos o "decorados" como el datepicker y combo box) para insertar datos
        txtTotal = new TextField(); // 00016823 Inicializa el text field total
        try { // 00016823 Todos los métodos de query deben estar en un bloque try catch a causa de un posible SQLException
            QueryTarjeta queryTarjeta = new QueryTarjeta(); // 00016823 Se crea una nueva query tarjeta ya que no estamos en CrudTarjetaController y nuestra query es de transacción
            txtTarjeta = new ComboBox<>(); // 00016823 Se inicializa el combo box de tarjeta
            txtTarjeta.setItems(FXCollections.observableArrayList(queryTarjeta.getIds())); // 00016823 Se asignan los ids de las tarjetas al combo box
        } catch (SQLException e){ // 00016823 En caso de haber una excepción de maneja
            alerta(e.getMessage()); // 00016823 Se muestra una alerta comunicando un error
        }
        txtDescripcion = new TextField(); // 00016823 Inicializa el text field descripción
        txtFecha = new DatePicker(); // 00016823 Inicializa el date picker fecha
        gridDatos.add(txtTotal, 1, 0); // 00016823 Pone el text field total en la posición 1,0 del grid
        gridDatos.add(txtFecha, 1, 1); // 00016823 Pone el date picker fecha en la posición 1,1 del grid
        gridDatos.add(txtDescripcion, 1, 2); // 00016823 Pone el text field descripción en la posición 1,2 del grid
        gridDatos.add(txtTarjeta, 1, 3); // 00016823 Pone el combo box tarjeta en la posición 1,3 del grid
    }
}
