package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Controller {
    @FXML
    private Button btnSubmit;
    @FXML
    private TextField sum;
    @FXML
    private TextField difference;
    @FXML
    private TextField product;
    @FXML
    private TextField quotient;
    @FXML
    private Label generatedLabel;
    @FXML
    private Label additionLabel;
    @FXML
    private Label subtractionLabel;
    @FXML
    private Label multiplicationLabel;
    @FXML
    private Label divisionLabel;
    @FXML
    private Label correctLabel;
    @FXML
    private Label wrongLabel;

    private Quiz q = new Quiz();

    @FXML
    protected void handleSubmitButtonAction(ActionEvent e) throws IOException {
        getInputs(q);
        q.checkForCorrectAnswers();
        showResults(q);
    }

    private void clearTextInputs() {
        sum.setText("");
        difference.setText("");
        product.setText("");
        quotient.setText("");
    }

    private void updateLabels(Quiz q) {
        generatedLabel.setText("Two randomly generated numbers are: " + q.getA() + " and " + q.getB());
        additionLabel.setText("What is addition of: " + q.getA() + " and " + q.getB());
        subtractionLabel.setText("What is subtraction of: " + q.getA() + " and " + q.getB());
        multiplicationLabel.setText("What is multiplication of: " + q.getA() + " and " + q.getB());
        divisionLabel.setText("What is division of: " + q.getA() + " and " + q.getB());
    }

    private void showResults(Quiz q) {
        correctLabel.setText("Number of correct answers: " + q.noCorrectAnswers);
        wrongLabel.setText("Number of wrong answers: " + (q.userAnswers.size() - q.noCorrectAnswers));
        correctLabel.setVisible(true);
        wrongLabel.setVisible(true);
    }

    private void clearResults() {
        q = new Quiz();
        correctLabel.setVisible(false);
        wrongLabel.setVisible(false);
    }

    private void generateNumbers(Quiz q) {
        Random r = new Random();

        q.a = r.nextInt(10) + 1;
        q.b = r.nextInt(10) + 1;

        System.out.println("Generated numbers: " + q.a + " and " + q.b);

        q.generateCorrectAnswers();
    }

    private void getInputs(Quiz q) {
        List<Number> answers = new ArrayList<Number>();
        try {
            answers.add(Integer.parseInt(sum.getText()));
            answers.add(Integer.parseInt(difference.getText()));
            answers.add(Integer.parseInt(product.getText()));
            answers.add(Double.parseDouble(quotient.getText()));

            q.setUserAnswers(answers);
        } catch(IllegalArgumentException e) {
            alertHandler(e.getLocalizedMessage());
        } finally {
            clearTextInputs();
        }
    }

    private void alertHandler(String s) {
        Alert a = new Alert(Alert.AlertType.ERROR);
        a.getDialogPane().setMinWidth(550);
        a.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
        a.setContentText(s);
        a.showAndWait();
    }

    public void initialize() {
        clearResults();
        generateNumbers(q);
        updateLabels(q);
    }
}
