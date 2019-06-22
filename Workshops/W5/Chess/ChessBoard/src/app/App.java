package app;

import java.util.Arrays;
import java.util.Collections;

import javafx.application.Application;
import javafx.scene.shape.Rectangle;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class App extends Application {

	public static void main(String[] args) throws Exception {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		Rectangle[][] board = new Rectangle[8][8];
		GridPane gridpane = new GridPane();

		for (int row = 0; row < 8; row++) {
			for (int col = 0; col < 8; col++) {
				if (row % 2 == 0) {
					if (col % 2 == 0) {
						board[row][col] = CreateRectangle(Color.WHITE);
					} else {
						board[row][col] = CreateRectangle(Color.BLACK);
					}
				}
				if (row % 2 != 0) {
					if (col % 2 == 0) {
						board[row][col] = CreateRectangle(Color.BLACK);
					} else {
						board[row][col] = CreateRectangle(Color.WHITE);
					}
				}
			}
		}

		for (int row = 0; row < 8; row++) {
			for (int col = 0; col < 8; col++) {
				gridpane.add(board[row][col], col, row);
			}
		}
		
		// Create a scene and place it in the stage
		Scene scene = new Scene(gridpane, 800, 800);
		primaryStage.setTitle("Chess board");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public Rectangle CreateRectangle(Color c) {
		Rectangle r = new Rectangle(100, 100, c);
		return r;
	}
}