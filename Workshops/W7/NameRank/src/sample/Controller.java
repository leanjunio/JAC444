package sample;

import javafx.beans.Observable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class Controller {
    @FXML
    private TextField yearField;
    @FXML
    private TextField genderField;
    @FXML
    private TextField nameField;
    @FXML
    private Button submitButton;
    @FXML
    private Button exitButton;

    @FXML
    protected void handleSubmitButtonAction(ActionEvent event) {
        Validator v = null;
        boolean validFields = false;

        String year ="", gender="", name="";
        try {
            year = yearField.getText();
            gender = genderField.getText();
            name = nameField.getText();
            v = new Validator(year, gender, name);
            validFields = v.isValid();
        } catch(NullPointerException e) {
            e.getStackTrace();
            alertHandler("One or more fields were empty. Please fill them out.");
        } catch(IllegalArgumentException i) {
            i.getStackTrace();
            alertHandler(i.getLocalizedMessage());
        } finally {
            yearField.setText("");
            genderField.setText("");
            nameField.setText("");
        }
        System.out.println("Reached!");
        if (validFields) {
            System.out.println("Fields are all valid");
            Query q = new Query(Integer.parseInt(year), gender.charAt(0), name, 0);
            lookup(q);
        } else {
            System.out.println("The Fields are not valid!");
        }
    }

    public void lookup(Query q) {
        StringBuilder fileName = new StringBuilder("babynamesranking").append(q.getYear()).append(".txt");



    }

    public void readFile(Query q, FileReader file) {
        Scanner sc = new Scanner(file);
    }

    public void alertHandler(String s) {
        Alert a = new Alert(Alert.AlertType.ERROR);
        a.getDialogPane().setMinWidth(550);
        a.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
        a.setContentText(s);
        a.showAndWait();
    }

    public static boolean isNumeric(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch(NumberFormatException e) {
            return false;
        }
    }

    public void initialize() {
//        genderField.textProperty().addListener((observableValue, s, t1) -> {
//            if (t1.matches("[mfMF]")) {
//                genderField.setText(t1);
//            } else {
//                genderField.setText(s);
//            }
//        });
    }
}

