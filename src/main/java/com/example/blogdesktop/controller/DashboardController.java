package com.example.blogdesktop.controller;

import com.example.blogdesktop.Main;
import com.example.blogdesktop.model.PostModel;
import com.example.blogdesktop.model.UserModel;
import com.example.blogdesktop.service.ConnectionService;
import com.example.blogdesktop.singleton.MyGson;
import com.example.blogdesktop.views.ViewLoader;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXScrollPane;
import com.jfoenix.controls.JFXToggleNode;
import javafx.fxml.Initializable;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class DashboardController implements Initializable {


    public ToggleGroup hello;
    public VBox postRoot;
    public JFXToggleNode buttonHome;
    public JFXToggleNode buttonGroup;
    public JFXToggleNode buttonProfile;
    public JFXToggleNode buttonNotification;
    public JFXToggleNode buttonChat;
    public Gson gson = MyGson.getInstance().getGson();
    public static List<PostModel> postModels = new ArrayList<>();
    public static int currentIndex = 0;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        InputStream userInputStream = ConnectionService.getConnection("/user");
        Main.currentUser = gson.fromJson(new InputStreamReader(userInputStream), UserModel.class);
        InputStream postInputStream = ConnectionService.getConnection("/post");
        PostModel[] postModels = gson.fromJson(new InputStreamReader(postInputStream), PostModel[].class);
        Main.usersPosts.addAll(Arrays.asList(postModels));
        buttonHome.setSelected(true);
        for (PostModel postModel : postModels) {
            postRoot.getChildren().add(ViewLoader.loadView("post.fxml"));
        }
    }

    public void buttonHomeOnClick(MouseEvent mouseEvent) {
        System.out.println("Home clicked");
    }

    public void buttonGroupOnClick(MouseEvent mouseEvent) {
        System.out.println("Group clicked");
    }

    public void buttonProfileOnClick(MouseEvent mouseEvent) {
        System.out.println("Profile clicked");
    }

    public void buttonNotificationOnClick(MouseEvent mouseEvent) {
        System.out.println("Notification clicked");
    }

    public void buttonChatOnClick(MouseEvent mouseEvent) {
        System.out.println("Chat clicked");
    }
}
