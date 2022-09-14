package com.example.blogdesktop.controller;

import com.example.blogdesktop.Main;
import com.example.blogdesktop.model.UserModel;
import com.example.blogdesktop.service.ConnectionService;
import com.example.blogdesktop.singleton.MyGson;
import com.example.blogdesktop.views.ViewLoader;
import com.google.gson.Gson;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import net.synedra.validatorfx.Check;
import net.synedra.validatorfx.Validator;

import java.net.URL;
import java.util.ResourceBundle;

public class HomePageController implements Initializable {
    public JFXButton buttonRegister;
    public JFXButton buttonLogin;
    public Label labelLogo;
    public JFXTextField textFieldUsername;
    public JFXPasswordField passwordField;
    public AnchorPane root;

    private final Validator validatorUsername = new Validator();
    private final Validator validatorPassword = new Validator();
    private final Check checkUsername = new Check();
    private final Check checkPassword = new Check();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        checkUsername.dependsOn("username",textFieldUsername.textProperty()).withMethod(c->{
            String username = c.get("username");
            if (username.equals("")) {
                c.error("Username is required");
            }
        }).immediate();
        checkPassword.dependsOn("password",passwordField.textProperty()).withMethod(c->{
            String password = c.get("password");
            if (password.equals("")) {
                c.error("Password is required");
          } //else if (password.length() < 8) {
//                c.error("Password should be minimum 8 letters");
//            }
        }).immediate();
        validatorUsername.add(checkUsername);
        validatorPassword.add(checkPassword);
    }

    public void registerButtonClicked(MouseEvent mouseEvent) {
        Main.scene.setRoot(ViewLoader.loadView("register.fxml"));
    }

    public void loginButtonClicked(MouseEvent mouseEvent) {
        if (validatorUsername.containsErrors()) {
            checkUsername.decorates(textFieldUsername);
            validatorUsername.add(checkUsername);
            validatorUsername.validate();
            Main.shake(textFieldUsername);
            return;
        }
        if (validatorPassword.containsErrors()) {
            checkPassword.decorates(passwordField);
            validatorPassword.add(checkPassword);
            validatorPassword.validate();
            Main.shake(passwordField);
            return;
        }
        UserModel userModel = new UserModel(
                textFieldUsername.getText(),
                passwordField.getText()
        );
        Gson gson = MyGson.getInstance().getGson();
        ConnectionService.postConnection("/auth/login", gson.toJson(userModel));
        ViewLoader.loadView("dashboard.fxml");
    }
}
