package app;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.control.TextField;

public class App extends Application {
	public static void main(String[] args) throws Exception {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		// First Name
		Label fNameLabel = new Label("First Name: ");
		TextField fNameTF = new TextField();
		fNameTF.setMinWidth(470);
		HBox fName = new HBox(5, fNameLabel, fNameTF);

		// Last Name
		Label lNameLabel = new Label("Last Name: ");
		TextField lNameTF = new TextField();
		lNameTF.setMinWidth(470);
		HBox lName = new HBox(5, lNameLabel, lNameTF);

		// City
		Label cityLabel = new Label("City: ");
		Label provLabel = new Label("Province: ");
		Label postalCodeLabel = new Label("Postal Code: ");
		TextField cityTF = new TextField();
		TextField postalTF = new TextField();
		ComboBox province = new ComboBox();

		String[] provinces = { "ON", "BC", "QC", "AB", "MB", "SK", "NS", "NB", "NL", "PE", "NT", "YT", "NU"};

		for (String p : provinces) {
			province.getItems().add(p);
		}
		
		HBox location = new HBox(5, cityLabel, cityTF, provLabel, province, postalCodeLabel, postalTF);

		Button[] buttons = new Button[6];
		String[] buttonStrings = {"Add", "First", "Next", "Previous", "Last", "Update"};

		for (int i = 0; i < buttonStrings.length; i++) {
			buttons[i] = new Button(buttonStrings[i]);
			buttons[i].setMinWidth(89);
		}

		HBox buttonHB = new HBox(1, buttons[0], buttons[1], buttons[2], buttons[3], buttons[4], buttons[5]);

		GridPane grid = new GridPane();
		grid.setPadding(new Insets(25, 25, 25, 25));
		grid.setVgap(10);
		grid.setHgap(5);

		grid.add(lName, 0, 1);
		grid.add(fName, 0, 2);
		grid.add(location, 0, 3);
		grid.add(buttonHB, 0, 4);
		Scene scene = new Scene(grid, 600, 200);
		primaryStage.setTitle("Address Book");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}