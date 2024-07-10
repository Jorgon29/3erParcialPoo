package org.poo.parcialfinalpoo.controllers.crud;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.poo.parcialfinalpoo.modelBase.tipos.Cliente;
import org.poo.parcialfinalpoo.modelBase.query.QueryCliente;

import java.sql.SQLException;
import java.util.ArrayList;

public class CrudClienteController extends CrudAbstractController{ // 00016823 COntroller para cualquier acción del crud (Escena) en la tabla Cliente
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
        try { // 00016823 Todos los métodos de query deben estar en un bloque try catch a causa de un posible SQLException
            query.actualizar(new Cliente(actual, txtNombre.getText(), txtTelefono.getText(), txtDireccion.getText())); // 00016823 Se intenta actualizar un registro con los valores introducidos
            informacion("Actualizado correctamente"); // 00016823 Se muestra una alerta que comunica que se ha realizado la operación correctamente
        } catch (Exception e){ // 00016823 En caso de que ocurra alguna excepción se recibe y se trata
            alerta("Error en actualización"); // 00016823 Muestra una alerta comunicando que ha ocurrido un error
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

    public void ponerTextFields(){ // 00016823 Pone en el grid pane los text field para ingresar los diferentes campos de algún elemento
        txtNombre = new TextField(); // 00016823 Se inicializa el text field de dirección
        txtDireccion = new TextField(); // 00016823 Se inicializa el text field de nombre
        txtTelefono = new TextField(); // 00016823 Se inicializa el text field de teléfono
        gridDatos.add(txtNombre, 1, 0); // 00016823 Se coloca el text field de nombre en la posición 1, 0 del grid pane
        gridDatos.add(txtDireccion, 1, 1); // 00016823 Se coloca el text field de dirección en la posición 1, 1 del grid pane
        gridDatos.add(txtTelefono, 1, 2); // 00016823 Se coloca el text field de teléfono en la posición 1, 2 del grid pane

    }

    protected void asignarIdsComboBox(){ // 00016823 Asigna los ids de los clientes existentes a cbIds
        ArrayList<Integer> ids = null; // 00016823 Se crea un nuevo array list para almacenar los ids
        try { // 00016823 Todos los métodos de query deben estar en un bloque try catch a causa de un posible SQLException
            ids = query.getIds(); // 00016823 Se asignan los ids de la base de datos al array antes declarado
        } catch (SQLException e) { // 00016823 En caso de ocurrir alguna SQLException se toma
            alerta("Error al obtener ids"); // 00016823 Muestra una alerta comunicando que ha ocurrido un error
            return; // 00016823 Retorna evitando que el método siga
        }
        cbIds.setItems(FXCollections.observableArrayList(ids)); // 00016823 Se le asigna el arraylist antes declarado e inicializado al combo box
    }

    protected void enInsertar(){ // 00016823 Especifica el procedimiento a realizar cuando se presione el botón Insertar
        try { // 00016823 Todos los métodos de query deben estar en un bloque try catch a causa de un posible SQLException
            query.insertar(new Cliente(0,txtNombre.getText(), txtTelefono.getText(), txtDireccion.getText())); // 00016823 Se intenta insertar un nuevo registro con los valores introducidos
            txtTelefono.setText(""); // 00016823 Se deja vacío el text field de teléfono con el fin de evitar ingresar lo mismo 2 veces
            txtNombre.setText(""); // 00016823 Se deja vacío el text field de nombre con el fin de evitar ingresar lo mismo 2 veces
            txtDireccion.setText(""); // 00016823 Se deja vacío el text field de dirección con el fin de evitar ingresar lo mismo 2 veces
            informacion("Insertado correctamente");
        } catch (SQLException e){ // 00016823 En caso de ocurrir alguna SQLException se toma
            alerta(e.getMessage());// 00016823 Muestra una alerta comunicando que ha ocurrido un error
        }
    }



}
