package com.example.blogdesktop.controller;

import com.example.blogdesktop.Main;
import com.example.blogdesktop.model.UserModel;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import net.synedra.validatorfx.Check;
import net.synedra.validatorfx.Validator;

import java.net.URL;
import java.util.ResourceBundle;

public class RegisterPageController implements Initializable {
    public JFXTextField textFieldFullName;
    public JFXTextField textFieldUsername;
    public JFXPasswordField passwordField;
    public JFXPasswordField passwordFieldCheck;
    public JFXButton buttonRegister;

    private final Validator validatorFullName = new Validator();
    private final Check checkFullName = new Check();
    private final Validator validatorPassword = new Validator();
    private final Check checkPassword = new Check();
    private final Validator validatorPasswordCheck = new Validator();
    private final Check checkPasswordCheck = new Check();
    private final Validator validatorUsername = new Validator();
    private final Check checkUsername = new Check();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        checkFullName.dependsOn("fullName", textFieldFullName.textProperty())
                .withMethod(c->{
                    String fullName = c.get("fullName");
                    if (fullName.equals("")){
                        c.error("Full name is required");
                    }
                }).immediate();
        checkUsername.dependsOn("username", textFieldUsername.textProperty())
                .withMethod(c->{
                    String username = c.get("username");
                    if (username.equals("")){
                        c.error("Username is required");
                    }
                }).immediate();
        checker(checkPassword, passwordField, passwordFieldCheck);
        checker(checkPasswordCheck, passwordFieldCheck, passwordField);
        validatorFullName.add(checkFullName);
        validatorUsername.add(checkUsername);
        validatorPassword.add(checkPassword);
        validatorPasswordCheck.add(checkPasswordCheck);
    }

    private void checker(Check checkPasswordCheck, JFXPasswordField passwordField, JFXPasswordField passwordFieldCheck) {
        checkPasswordCheck.dependsOn("password", passwordField.textProperty())
                .withMethod(c->{
                    String password = c.get("password");
                    if (password.equals("")){
                        c.error("Password is required");
                    }else if (!password.equals(passwordFieldCheck.getText())){
                        c.error("Passwords don't match");
                    }else if (password.length()<8){
                        c.error("Password should be minimum 8 letters");
                    }
                }).immediate();
    }

    public void buttonRegisterOnClick(MouseEvent mouseEvent) {
        if (validatorFullName.containsErrors()){
            checkFullName.decorates(textFieldFullName);
            validatorFullName.validate();
            Main.shake(textFieldFullName);
            return;
        }
        if (validatorUsername.containsErrors()){
            checkUsername.decorates(textFieldUsername);
            validatorUsername.validate();
            Main.shake(textFieldUsername);
            return;
        }
        if (validatorPassword.containsErrors() || validatorPasswordCheck.containsErrors()){
            checkPassword.decorates(passwordField);
            checkPasswordCheck.decorates(passwordFieldCheck);
            validatorPassword.validate();
            validatorPasswordCheck.validate();
            Main.shake(passwordField);
            Main.shake(passwordFieldCheck);
            return;
        }
        UserModel userModel = new UserModel(
                textFieldFullName.getText(),
                textFieldUsername.getText(),
                passwordField.getText()
        );

    }
}
