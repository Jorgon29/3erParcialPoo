package org.poo.parcialfinalpoo.crud.compra.builders;

import org.poo.parcialfinalpoo.crud.BuilderCrud;
import org.poo.parcialfinalpoo.crud.Cliente.CrudClienteApp;
import org.poo.parcialfinalpoo.crud.compra.CrudCompraApp;

public class ActualizarCompraBuilder implements BuilderCrud<CrudCompraApp> {
    private CrudCompraApp app; // 00016823 app de resultado
    @Override
    public void reiniciar() { // 00016823 se le asigna una nueva app al resultado
        app = new CrudCompraApp(); // 00016823 se le asigna una nueva app al resultado
        app.cambiarTitulo("Actualizar compra");// 00016823 llama a la función del controller para cambiar título
    }

    @Override
    public void ponerBotonEliminar() {} // 00016823 Es parte de la interfaz, pero no se necesita

    @Override
    public void ponerBotonActualizar() {app.ponerBotonActualizar();} // 00016823 Se llama al método del controller para poner el botón actualizar

    @Override
    public void ponerTextFields() {app.ponerTextFields();} // 00016823 Se llama al método del controller para poner los campos editables

    @Override
    public void ponerLabels() {} // 00016823 Es parte de la interfaz, pero no se necesita

    @Override
    public void ponerBuscador() {app.ponerBuscador();} // 00016823 Se llama al método del controller para poner el buscador

    @Override
    public void ponerBotonInsertar() {} // 00016823 Es parte de la interfaz, pero no se necesita

    @Override
    public CrudCompraApp getResultado() {return app;} // 00016823 Se obtiene el resultado
}
