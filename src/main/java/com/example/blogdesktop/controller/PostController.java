package com.example.blogdesktop.controller;

import com.example.blogdesktop.Main;
import com.example.blogdesktop.model.PostModel;
import com.example.blogdesktop.service.ConnectionService;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import lombok.SneakyThrows;
import org.controlsfx.control.InfoOverlay;

import java.io.FileInputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import static com.example.blogdesktop.controller.DashboardController.postModels;
import static com.example.blogdesktop.controller.DashboardController.currentIndex;

public class PostController implements Initializable {

    public InfoOverlay infoOverlay;
    public ImageView imageView;

    public static List<ImageView> imageViewList = new ArrayList<>();

    @SneakyThrows
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        PostModel postModel = postModels.get(currentIndex);
        currentIndex++;
        ImageView imageView1 = new ImageView(new Image(ConnectionService.getConnection("/attachment/post?postId="+ postModel.getId())));
        imageViewList.add(imageView1);
        infoOverlay.setContent(imageView1);
        infoOverlay.setText(postModel.getText());
    }
}
