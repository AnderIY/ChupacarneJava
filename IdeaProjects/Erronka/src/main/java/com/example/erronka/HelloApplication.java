package com.example.erronka;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        BorderPane root = fxmlLoader.load();
        Scene scene = new Scene(root, 500, 335);

        stage.setTitle("Saioa Hasi");
        stage.setScene(scene);

        stage.initStyle(StageStyle.UNDECORATED);
        CustomTitleBar customTitleBar = new CustomTitleBar(stage, root);
        root.setTop(customTitleBar.getTitleBar());
        stage.getIcons().add(new Image(HelloApplication.class.getResource("/img/Elchupacarne.jpg").toExternalForm()));

        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}