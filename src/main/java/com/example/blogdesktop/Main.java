package com.example.blogdesktop;

import animatefx.animation.Bounce;
import animatefx.animation.FadeIn;
import animatefx.animation.Shake;
import com.example.blogdesktop.model.PostModel;
import com.example.blogdesktop.model.UserModel;
import com.example.blogdesktop.views.ViewLoader;
import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import lk.vivoxalabs.customstage.CustomStage;
import lk.vivoxalabs.customstage.CustomStageBuilder;
import org.kordamp.bootstrapfx.BootstrapFX;
import org.kordamp.ikonli.javafx.FontIcon;
import org.kordamp.ikonli.javafx.IkonResolver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main extends Application {

    public static Stage primaryStage;
    public static Scene scene = new Scene(ViewLoader.loadView("homepage.fxml"));;
    public static final String BASE_PATH_FILES = "C:/Users/Abdurasul/IdeaProjects/blog-desktop/src/main/resources/com/example/blogdesktop";
    public static String token = "";
    public static final String BASE_URL = "http://localhost:8082/api";
    public static UserModel currentUser;
    public static List<PostModel> usersPosts = new ArrayList<>();
    public static Integer currentPostIndex = 0;

    @Override
    public void start(Stage stage) throws IOException {
        primaryStage = stage;
        scene.getStylesheets().add(BootstrapFX.bootstrapFXStylesheet());
        primaryStage.setTitle("Home page");
        primaryStage.setScene(scene);
//        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    public static void shake(Node target) {
        new Shake(target).setCycleCount(5).setSpeed(30).play();
    }
}