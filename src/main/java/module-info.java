module com.example.blogdesktop {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires com.google.gson;
    requires lombok;
    requires com.jfoenix;
    requires net.synedra.validatorfx;
    requires AnimateFX;
    requires CustomStage;

    opens com.example.blogdesktop to javafx.fxml;
    opens com.example.blogdesktop.controller to javafx.fxml;
    opens com.example.blogdesktop.model to com.google.gson;

    exports com.example.blogdesktop to javafx.fxml, javafx.graphics;
    exports com.example.blogdesktop.controller to javafx.fxml;
    exports com.example.blogdesktop.model to javafx.fxml;
    exports com.example.blogdesktop.model.enums to com.google.gson;
}