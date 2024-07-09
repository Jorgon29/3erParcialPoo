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
    private Label lblNombre;
    private TextField txtNombre;

    @FXML protected void initialize(){
        query = new QueryFacilitador();
    }

    @Override
    protected void asignarIdsComboBox() {
        try {
            cbIds.setItems(FXCollections.observableArrayList(query.getIds()));
        } catch (SQLException e) {
            alerta(e.getMessage());
        }
    }

    @Override
    protected void enBuscar() {
        try {
            actual = cbIds.getValue();
            Facilitador facilitador = (Facilitador) query.select(actual);
            if (lblNombre == null){
                txtNombre.setText(facilitador.getNombre());
            } else {
                lblNombre.setText(facilitador.getNombre());
            }
        } catch (Exception e){
            alerta(e.getMessage());
        }
    }

    @Override
    protected void enInsertar() {
        try {
            query.insertar(new Facilitador(actual, txtNombre.getText()));
            informacion("Insertado correctamente");
        } catch (Exception e){
            alerta(e.getMessage());
        }
    }

    @Override
    protected void enEliminar() {
        try {
            query.eliminar(actual);
            lblNombre.setText("");
            informacion("Eliminado correctamente");
            asignarIdsComboBox();
        } catch (Exception e){
            alerta(e.getMessage());
        }
    }

    @Override
    protected void enActualizar() {
        try {
            query.actualizar(new Facilitador(actual, txtNombre.getText()));
            informacion("Actualizado correctamente");
        } catch (Exception e){
            alerta(e.getMessage());
        }
    }

    @Override
    public void ponerLabels() {
        lblNombre = new Label();
        gridDatos.add(lblNombre, 1, 0);
    }

    @Override
    public void ponerTextFields() {
        txtNombre = new TextField();
        gridDatos.add(txtNombre, 1, 0);
    }
}
