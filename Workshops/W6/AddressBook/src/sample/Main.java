package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.RandomAccessFile;
import java.util.Random;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Hello World");
        primaryStage.show();
    }

    public void SaveAddress(Address a) {
        File f = new File("address.dat");
        if (f.createNewFile()) {

        } else {

        }
            f.createNewFile();
        try {
            RandomAccessFile raf = new RandomAccessFile("address.dat", "rw");
        }

    }
    public static void main(String[] args) {
        launch(args);
    }
}
