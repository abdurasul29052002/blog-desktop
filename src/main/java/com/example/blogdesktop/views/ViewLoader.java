package com.example.blogdesktop.views;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import lombok.SneakyThrows;

public class ViewLoader {
    @SneakyThrows
    public static Parent loadView(String viewName){
        FXMLLoader fxmlLoader = new FXMLLoader(ViewLoader.class.getResource(viewName));
        return fxmlLoader.load();
    }
}
