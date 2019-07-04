package org.example.learnlib;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
// public class App extends Application {
    public class App {

    // @Override
    // public void start(Stage stage) {
    //     var javaVersion = SystemInfo.javaVersion();
    //     var javafxVersion = SystemInfo.javafxVersion();

    //     var label = new Label("Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");
    //     var scene = new Scene(new StackPane(label), 640, 480);
    //     stage.setScene(scene);
    //     stage.show();
    // }

    public static void main(String[] args) {

        try {
            // Creates 10 objects of Accounts and initialize them to 100 balance
            Account accounts[] = new Account[10];

            FileOutputStream file = new FileOutputStream("account.dat");
            ObjectOutputStream out = new ObjectOutputStream(file);
            
            for (Account a : accounts) {
                a = new Account(0, 100.00);
                
            }
            out.close();
        } catch (Exception e) {
            //TODO: handle exception
        }
        // launch();
    }

}