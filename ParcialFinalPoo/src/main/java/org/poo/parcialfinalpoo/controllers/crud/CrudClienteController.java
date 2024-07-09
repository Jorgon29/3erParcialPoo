package org.poo.parcialfinalpoo.controllers.crud;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.poo.parcialfinalpoo.modelBase.tipos.Cliente;
import org.poo.parcialfinalpoo.modelBase.query.QueryCliente;

import java.sql.SQLException;
import java.util.ArrayList;

public class CrudClienteController extends CrudAbstractController{
    protected TextField txtNombre; // 00016823 Es el text field en el que se podrá digitar un nombre para asignar
    protected TextField txtDireccion; // 00016823 Es el text field en el que se podrá digitar una dirección para asignar
    protected TextField txtTelefono; // 00016823 Es el text field en el que se podrá digitar un teléfono para asignar
    protected Label lblNombre; // 00016823 Es el label en el que se mostrará el nombre del cliente seleccionado
    protected Label lblDireccion; // 00016823 Es el label en el que se mostrará la dirección del cliente seleccionado
    protected Label lblTelefono; // 00016823 Es el label en el que se mostrará el teléfono del cliente seleccionado

    @FXML protected void initialize(){query = new QueryCliente();} // 00016823 Se inicializa query con un nuevo QueryCliente

    protected void enBuscar(){ // 00016823 Especifica el procedimiento a realizar cuando se presione el botón Buscar
        try { // 00016823 Todos los métodos de query pueden lanzar una excepción, así que es necesario un bloque try catch
            Cliente cliente = (Cliente) query.select(cbIds.getValue()); // 00016823 Se instancia un nuevo cliente con los valores obtenidos de la base con del id seleccionado
            if (txtNombre == null){ // 00016823 Comprueba si los text field son nulos
                lblNombre.setText(cliente.getNombre()); // 00016823 Le asigna el nombre obtenido de la bd al label correspondiende
                lblDireccion.setText(cliente.getDireccion()); // 00016823 Le asigna la dirección obtenido de la bd al label correspondiente
                lblTelefono.setText(cliente.getTelefono()); // 00016823 Le asigna el teléfono obtenido de la bd al label correspodiente
            } else{ // 00016823 En caso de que los text field no sean nulos se les asigna valores a estos
                txtNombre.setText(cliente.getNombre()); // 00016823 Le asigna el nombre obtenido de la bd al text field correspondiende
                txtDireccion.setText(cliente.getDireccion()); // 00016823 Le asigna la dirección obtenido de la bd al text field correspondiente
                txtTelefono.setText(cliente.getTelefono()); // 00016823 Le asigna el teléfono obtenido de la bd al text field correspodiente
            }
            actual = cbIds.getValue(); // 00016823 Se guarda el valor del id del cliente seleccionado
        } catch (Exception e){ // 00016823 Se encarga del caso donde ocurre alguna excepción
            alerta("Cliente no encontrado"); // 00016823 Muestra una alerta diciendo Cliente no encontrado
        }
    }
    protected void enActualizar(){ // 00016823 Especifica el procedimiento a realizar cuando se presione el botón actualizar
        try {
            query.actualizar(new Cliente(actual, txtNombre.getText(), txtTelefono.getText(), txtDireccion.getText()));
            informacion("Actualizado correctamente");
        } catch (Exception e){
            alerta("Error en actualización");
        }
    }
    protected void enEliminar(){ // 00016823 Especifica el procedimiento a realizar cuando se presione el botón eliminar
        try { // 00016823 Es necesario el bloque try catch dado que se usa un método de query
            query.eliminar(actual); // 00016823 Se intenta eliminar de la base de datos el registro con el id actual
            asignarIdsComboBox(); // 00016823 Se vuelven a asignar los ids del combo box puesto que ahora hay uno menos
            lblTelefono.setText(""); // 00016823 Se deja vacío el label de teléfono
            lblNombre.setText(""); // 00016823 Se deja vacío el label de nombre
            lblDireccion.setText(""); // 00016823 Se deja vacío el label de Dirección
            informacion("Eliminado correctamente"); // 00016823 Se muestra una alerta diciendo que se ha eliminado correctamente
        } catch (SQLException e){ // 00016823 En caso de de haber una excepción se recibe
            alerta("Error en eliminación"); // 00016823 Se muestra una alerta comunicando que hubo un error
        }
    }


    public void ponerLabels(){ // 00016823 Pone en el grid pane los labels para mostrar los diferentes campos de algún elemento seleccionado
        lblDireccion = new Label(); // 00016823 Se inicializa el label de dirección
        lblNombre = new Label(); // 00016823 Se inicializa el label de nombre
        lblTelefono = new Label(); // 00016823 Se inicializa el label de teléfono
        gridDatos.add(lblNombre, 1, 0); // 00016823 Se coloca el label de nombre en la posición 1, 0 del grid pane
        gridDatos.add(lblDireccion, 1, 1); // 00016823 Se coloca el label de dirección en la posición 1, 1 del grid pane
        gridDatos.add(lblTelefono, 1, 2); // 00016823 Se coloca el label de teléfono en la posición 1, 2 del grid pane
    }

    public void ponerTextFields(){
        txtNombre = new TextField();
        txtDireccion = new TextField();
        txtTelefono = new TextField();
        gridDatos.add(txtNombre, 1, 0);
        gridDatos.add(txtDireccion, 1, 1);
        gridDatos.add(txtTelefono, 1, 2);

    }

    protected void asignarIdsComboBox(){
        ArrayList<Integer> ids = null;
        try {
            ids = query.getIds();
        } catch (SQLException e) {
            alerta("Error al obtener ids");
        }
        cbIds.setItems(FXCollections.observableArrayList(ids));
    }

    protected void enInsertar(){ // 00016823 Especifica el procedimiento a realizar cuando se presione el botón Insertar
        try {
            query.insertar(new Cliente(0,txtNombre.getText(), txtTelefono.getText(), txtDireccion.getText()));
            txtTelefono.setText("");
            txtNombre.setText("");
            txtDireccion.setText("");
            informacion("Insertado correctamente");
        } catch (SQLException e){
            alerta(e.getMessage());
        }
    }



}
