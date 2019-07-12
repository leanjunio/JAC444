package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Controller {
    @FXML
    private AnchorPane ap;
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
    private Label messageLabel;

    @FXML
    protected void handleSubmitButtonAction(ActionEvent event) throws IOException {
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

    public  void handleExitButtonAction() {
        Stage stage = (Stage)ap.getScene().getWindow();
        stage.close();
    }
    private void lookup(Query q) throws IOException {
        String fileName = "src/babynamesranking" + q.getYear() + ".txt";
        try {
            readFile(q, fileName);
        } catch(IOException i) {
            i.printStackTrace();
        }
    }

    private void readFile(Query q, String filename) throws IOException  {
        try {
            int i = 0;
            boolean found = false;
            File file = new File(filename);
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = "";
            while ((line = br.readLine()) != null && !found) {
                i++;
                found = lineProcessor(line, q);
            }
            showResult(q);
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    private void showResult(Query q) {
        if (q.getRank() != 0) {
            System.out.println(q.toString());
            messageLabel.setText(q.toString());
            messageLabel.setVisible(true);
        } else {
            alertHandler("The name " + q.getName() + " is not found in any of the files.");
        }
    }

    private boolean lineProcessor(String s, Query q) {
        boolean nameFound = false;
        String str[] = s.split("\\s+");

        int r = 0;

        String rank = str[0];
        String mName = str[1];
        String mNum = str[2];
        String fName = str[3];
        String fNum = str[4];

        String name = (q.getGender() == 'M') ? mName : fName;

        if (q.getName().equals(name)) {
            q.setRank(Integer.parseInt(rank));
        }

        if (q.getRank() != 0) {
            nameFound = true;
        }

        return nameFound;
    }

    private void alertHandler(String s) {
        Alert a = new Alert(Alert.AlertType.ERROR);
        a.getDialogPane().setMinWidth(550);
        a.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
        a.setContentText(s);
        a.showAndWait();
    }

    public void initialize() {
    }
}

