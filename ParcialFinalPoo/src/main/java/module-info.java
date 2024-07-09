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

    exports org.poo.parcialfinalpoo.documentsControllers;
    opens org.poo.parcialfinalpoo.documentsControllers to javafx.fxml;

    requires kotlin.stdlib;

    opens org.poo.parcialfinalpoo to javafx.fxml;
    exports org.poo.parcialfinalpoo;
    exports org.poo.parcialfinalpoo.crud;
    exports org.poo.parcialfinalpoo.controllers.crud.menuStrategies;
    exports org.poo.parcialfinalpoo.controllers;
    exports org.poo.parcialfinalpoo.controllers.crud;

    exports org.poo.parcialfinalpoo.crud.Cliente;
    opens org.poo.parcialfinalpoo.crud.Cliente to javafx.graphics;

    opens org.poo.parcialfinalpoo.controllers.crud.menuStrategies;
    opens org.poo.parcialfinalpoo.controllers;
    opens org.poo.parcialfinalpoo.controllers.crud;
    opens org.poo.parcialfinalpoo.crud to javafx.fxml, javafx.graphics;
    exports org.poo.parcialfinalpoo.modelBase.tipos;
    exports org.poo.parcialfinalpoo.modelBase.query;
}