module org.poo.parcialfinalpoo {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires java.sql;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;

    opens org.poo.parcialfinalpoo to javafx.fxml;
    exports org.poo.parcialfinalpoo;
    exports org.poo.parcialfinalpoo.crud;
    exports org.poo.parcialfinalpoo.Controllers.Crud.MenuStrategies;
    exports org.poo.parcialfinalpoo.Controllers;
    exports org.poo.parcialfinalpoo.Controllers.Crud;
    exports org.poo.parcialfinalpoo.Controllers.Crud.Actualizar;

    opens org.poo.parcialfinalpoo.Controllers.Crud.Actualizar;

    opens org.poo.parcialfinalpoo.crud to javafx.fxml;
    opens org.poo.parcialfinalpoo.Controllers.Crud.MenuStrategies;
    opens org.poo.parcialfinalpoo.Controllers;
    opens org.poo.parcialfinalpoo.Controllers.Crud;
}