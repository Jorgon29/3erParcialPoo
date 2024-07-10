package org.poo.parcialfinalpoo.crud.Facilitador.builders;

import org.poo.parcialfinalpoo.crud.BuilderCrud;
import org.poo.parcialfinalpoo.crud.Facilitador.CrudFacilitadorApp;

public class InsertarFacilitadorBuilder implements BuilderCrud<CrudFacilitadorApp> {

    private CrudFacilitadorApp app; // 00016823 app de resultado
    @Override
    public void reiniciar() { // 00016823 se le asigna una nueva app al resultado
        app = new CrudFacilitadorApp(); // 00016823 se le asigna una nueva app al resultado
        app.cambiarTitulo("Insertar facilitador");// 00016823 llama a la función del controller para cambiar título
    }

    @Override
    public void ponerBotonEliminar() {} // 00016823 Es parte de la interfaz, pero no se necesita

    @Override
    public void ponerBotonActualizar() {} // 00016823 Es parte de la interfaz, pero no se necesita

    @Override
    public void ponerTextFields() {app.ponerTextFields();} // 00016823 Se llama al método del controller para poner los campos editables

    @Override
    public void ponerLabels() {} // 00016823 Es parte de la interfaz, pero no se necesita

    @Override
    public void ponerBuscador() {} // 00016823 Es parte de la interfaz, pero no se necesita

    @Override
    public void ponerBotonInsertar() {
        app.ponerBotonInsertar();
    }

    @Override
    public CrudFacilitadorApp getResultado() {return app;} // 00016823 Se obtiene el resultado
}
