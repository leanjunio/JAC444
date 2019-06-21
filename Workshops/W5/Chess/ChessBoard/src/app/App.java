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

		// Rectangle[] tiles = new Rectangle[64];
		Rectangle[] tileRow = new Rectangle[8];

		// Create a Rectangle and fill it with the correct Color
		// for (int i = 0; i < 64; i++) {
		// tiles[i] = new Rectangle(100, 100);
		// if (i % 2 == 0) {
		// tiles[i].setFill(Color.WHITE);
		// } else {
		// tiles[i].setFill(Color.BLACK);
		// }
		// }

		// fills the tileRow with colors (8 rectangles)
		boolean reverse = false;

		// try {
		// for (int i = 0; i < 64; i++) {
		// boolean flippable = i % 8 == 0 && i != 0;
		// if (flippable) {
		// for (int x = i; x < i + 8; x++) {
		// Rectangle temp = new Rectangle(100, 100);
		// temp = tiles[x];
		// tiles[x] = tiles[x+1];
		// tiles[x+1] = temp;
		// }
		// i += 8;
		// }
		// }
		// } catch (Exception e) {
		// System.err.println(e.getLocalizedMessage());
		// }

		GridPane gridpane = new GridPane();

		try {
			int row = 1;
			for (int i = 0; i < 64; i++) {
				
				// Creates new Rectangles
				if (reverse) {
					for (int x = 0; x < 8; x++) {
						tileRow[x] = new Rectangle(100, 100);
						if (x % 2 == 0) {
							tileRow[x].setFill(Color.WHITE);
						} else {
							tileRow[x].setFill(Color.BLACK);
						}
					}
					reverse = false;
				} else {
					for (int x = 0; x < 8; x++) {
						tileRow[x] = new Rectangle(100, 100);
						if (x % 2 == 0) {
							tileRow[x].setFill(Color.BLACK);
						} else {
							tileRow[x].setFill(Color.WHITE);
						}
					}
				}
				
				// adds the tileRow into the gridPane
				for (int x = 0; x < 8; x++) {
					gridpane.add(tileRow[x], x, row - 1, row, row);
				}
				i += 8;
				row++;
				reverse = true;
			}
		} catch (Exception e) {
			System.err.println(e.getLocalizedMessage());
		}

		// gridpane.add(tiles[0], 0, 0, 1, 1);
		// gridpane.add(tiles[1], 1, 0, 1, 1);
		// gridpane.add(tiles[2], 2, 0, 1, 1);
		// gridpane.add(tiles[3], 3, 0, 1, 1);
		// gridpane.add(tiles[4], 4, 0, 1, 1);
		// gridpane.add(tiles[5], 5, 0, 1, 1);
		// gridpane.add(tiles[6], 6, 0, 1, 1);
		// gridpane.add(tiles[7], 7, 0, 1, 1);

		// gridpane.add(tiles[8], 0, 1, 2, 2);
		// gridpane.add(tiles[9], 1, 1, 2, 2);
		// gridpane.add(tiles[10], 2, 1, 2, 2);
		// gridpane.add(tiles[11], 3, 1, 2, 2);
		// gridpane.add(tiles[12], 4, 1, 2, 2);
		// gridpane.add(tiles[13], 5, 1, 2, 2);
		// gridpane.add(tiles[14], 6, 1, 2, 2);
		// gridpane.add(tiles[15], 7, 1, 2, 2);

		// gridpane.add(tiles[16], 0, 1, 3, 3);
		// gridpane.add(tiles[17], 1, 1, 3, 3);
		// gridpane.add(tiles[18], 2, 1, 3, 3);
		// gridpane.add(tiles[19], 3, 1, 3, 3);
		// gridpane.add(tiles[20], 4, 1, 3, 3);
		// gridpane.add(tiles[21], 5, 1, 3, 3);
		// gridpane.add(tiles[22], 6, 1, 3, 3);
		// gridpane.add(tiles[23], 7, 1, 3, 3);

		// Create a scene and place it in the stage
		Scene scene = new Scene(gridpane, 800, 800);
		primaryStage.setTitle("Chess board");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}