package org.poo.parcialfinalpoo.crud.tarjeta.builders;

import org.poo.parcialfinalpoo.crud.BuilderCrud;
import org.poo.parcialfinalpoo.crud.tarjeta.CrudTarjetaApp;

public class EliminarTarjetaBuilder implements BuilderCrud<CrudTarjetaApp> {
private CrudTarjetaApp app; // 00016823 app de resultado

    @Override
    public void reiniciar() {
app = new CrudTarjetaApp(); // 00016823 se le asigna una nueva app al resultado
app.cambiarTitulo("Eliminar tarjeta (Elimina compras asociadas)");// 00016823 llama a la función del controller para cambiar título
    }

    @Override
    public void ponerBotonEliminar() {app.ponerBotonEliminar();} // 00016823 Se llama al método del controller para poner el botón eliminar

    @Override
    public void ponerBotonActualizar() {} // 00016823 Es parte de la interfaz, pero no se necesita

    @Override
    public void ponerTextFields() {} // 00016823 Es parte de la interfaz, pero no se necesita

    @Override
    public void ponerLabels() {app.ponerLabels();} // 00016823 Se llama al método del constructor para poner labels

    @Override
    public void ponerBuscador() {app.ponerBuscador();} // 00016823 Se llama al método del controller para poner el buscador

    @Override
    public void ponerBotonInsertar() {} // 00016823 Es parte de la interfaz, pero no se necesita

    @Override
    public CrudTarjetaApp getResultado() {
        return app;
    }
}
