/*
 * Kurt Kangas
 * CIS 2212 Java Software Development I
 * JavaFX Christmas Hangman Game (Disappearing Snowman) - Simple hangman game using JavaFX
 */

import java.util.ArrayList;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class DisappearingSnowman extends Application {

	protected int Difficulty = 1;
	protected int Win = 0;
	protected int Loss = 0;
	protected double Counter = 0;
	protected Group root = new Group();
	protected String word = new String("");  // A word for label.
	protected Label WordLabel = new Label();
	protected String wordString = new String(); // Word
	protected TextField Guess = new TextField();
	protected ArrayList<String> WordListGlobal = new ArrayList<>();

	Stage window;
	Scene scene1, scene2;

	public static void main(String[] args) {
		launch(args);	
	}

	@Override
	public void start(Stage primaryStage) {	
		window = primaryStage;
		window.setTitle("DisappearingSnowman");

		// TODO START OF SCENE 1
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10, 10, 10, 10));
		grid.setVgap(100);
		grid.setHgap(50);

		Wordbank wb = new Wordbank(this.WordListGlobal);
		wb.setWordList(this.WordListGlobal);

		// Difficulty Selection
		Label difficultyLabel = new Label("Select a difficulty...");
		GridPane.setConstraints(difficultyLabel, 0, 0);

		// Difficulty Buttons
		Button easyButton = new Button("Easy");
		easyButton.setOnAction(e -> {
			int sizeMin = 1;
			int sizeMax = 3;
			this.wordString = wb.getRandomWord(this.WordListGlobal, sizeMin, sizeMax);
			this.Difficulty = wb.getSize();
			HideAllWord();
		});
		Button moderateButton = new Button("Moderate");
		moderateButton.setOnAction(e -> {
			int sizeMin = 4;
			int sizeMax = 7;
			this.wordString = wb.getRandomWord(this.WordListGlobal, sizeMin, sizeMax);
			this.Difficulty = wb.getSize();
			HideAllWord();
		});
		Button difficultButton = new Button("Difficult");
		difficultButton.setOnAction(e -> {
			int sizeMin = 8;
			int sizeMax = 11;
			this.wordString = wb.getRandomWord(this.WordListGlobal, sizeMin, sizeMax);
			this.Difficulty = wb.getSize();
			HideAllWord();
		});
		HBox difficultyHBox = new HBox(easyButton, moderateButton, difficultButton);
		difficultyHBox.setSpacing(10);
		GridPane.setConstraints(difficultyHBox, 1, 0);

		// Play Again / Quit Buttons
		Button playagainButton = new Button("Play again");
		playagainButton.setOnAction(e -> {
			this.Counter = 0;
			ReloadGroup();
			HideAllWord();
			int sizeMin = 1;
			int sizeMax = 10;
			this.wordString = wb.getRandomWord(this.WordListGlobal, sizeMin, sizeMax);
		});
		Button quitButton = new Button("Quit");
		quitButton.setOnAction(e -> {
			System.exit(0);
		});
		HBox playHBox = new HBox(playagainButton, quitButton);
		playHBox.setSpacing(30);
		GridPane.setConstraints(playHBox, 2, 0);

		// Missing Word label p1
		Label promptLabel = new Label("The missing word --> ");
		GridPane.setConstraints(promptLabel, 0, 1);

		// Missing Word label p2
		GridPane.setConstraints(this.WordLabel, 1, 1);

		// Guess label
		Label guessLabel = new Label("Type in a letter you think is in the word!");
		GridPane.setConstraints(guessLabel, 0, 2);

		// Guess TextField
		GridPane.setConstraints(this.Guess, 1, 2);

		// Guess button
		Button guessButton = new Button("Guess!");
		GridPane.setConstraints(guessButton, 2, 2);
		guessButton.setOnAction(e -> {
			String guessString = this.Guess.getText();
			char LetterGuessed = guessString.charAt(0);
			//System.out.println("This is the letter guessed: " + LetterGuessed);
			System.out.println("This is the word: " + this.wordString);
			boolean check = checkLetter(LetterGuessed);
			if (check == false) {
				this.Counter += 1;
			}else {
				//Delete or do something with.
			}
			ReloadGroup();
			window.setScene(scene2);
		});

		grid.getChildren().addAll(difficultyLabel, difficultyHBox, playHBox,  promptLabel, this.WordLabel, guessLabel, this.Guess, guessButton);
		//** END OF SCENE 1

		ReloadGroup();

		scene1 = new Scene(grid, 700, 700);
		scene2 = new Scene(this.root, 600, 600);

		window.setScene(scene1);
		window.show();
	}
	public void HideAllWord() {
		String tempWord = new String(this.word);
		for (int i = 0; i < tempWord.length(); i++) {
			this.word = "";
		}
		String Word = "";
		for (int i = 0; i < this.wordString.length(); i++) {
			//this.word += "-";
			Word += "-";
		}
		this.WordLabel.setText(Word);
	}

	public void ReplaceAllWord(char LetterFound) {

		String placeHolderWord = "";	

		for (int i = 0; i < this.wordString.length(); i++) {
			if (this.wordString.charAt(i) == 'a') {
				placeHolderWord += 'a';
			} else {
				placeHolderWord += '-';
			}
		}
		this.WordLabel.setText(placeHolderWord);	
	}

	public boolean checkLetter(char LetterGuessed) {	
		boolean check = false;		
		String result = "";
		String word = this.WordLabel.getText();


		for (int i = 0; i < this.wordString.length(); i++) {
			if (this.wordString.charAt(i) == LetterGuessed ) {
				result += LetterGuessed;
				check = true;
			}else if (this.wordString.charAt(i) != LetterGuessed && word.charAt(i) != '-') {
				char c = this.wordString.charAt(i);
				result += c;
			}else {
				result += "-";
			}
		}
		this.WordLabel.setText(result);
		return check;
	}

	public void ReloadGroup(){
		//** SCENE 2
		double Height = 600;
		double Width = 600;

		// Background of Scene
		Group backgroundGroup = new Group();
		Rectangle rectangle = new Rectangle();
		rectangle.setHeight(800);
		rectangle.setWidth(800);
		rectangle.setX(0);
		rectangle.setY(0);
		rectangle.setFill(Color.AQUA);
		Button btnBack = new Button("Guess Again");
		btnBack.setOnAction(e -> {
			window.setScene(scene1);
		});
		backgroundGroup.getChildren().add(rectangle);
		backgroundGroup.getChildren().add(btnBack);


		// Snowman
		Snowman s = new Snowman();
		Group leftarmGroup = s.LeftArm(Height, Width);
		Group rightarmGroup = s.RightArm(Height, Width);
		Group bottomGroup = s.Bottom(Height, Width);
		Group middleGroup = s.Middle(Height, Width);
		Group headGroup = s.Head(Height, Width);
		Group buttonsGroup = s.Buttons(Height, Width);
		Group hatGroup = s.Hat(Height, Width);

		//Group root = new Group();
		this.root.getChildren().add(backgroundGroup);
		this.root.getChildren().add(leftarmGroup);
		this.root.getChildren().add(rightarmGroup);
		this.root.getChildren().add(bottomGroup);
		this.root.getChildren().add(middleGroup);
		this.root.getChildren().add(buttonsGroup);
		this.root.getChildren().add(headGroup);
		this.root.getChildren().add(hatGroup);

		//** ADD ALL TO ROOT -- Comment out as you do.
		if (this.Counter >= 1) {
			this.root.getChildren().remove(hatGroup);
		}
		if (this.Counter >= 2) {
			this.root.getChildren().remove(buttonsGroup);
		}
		if (this.Counter >= 3) {
			this.root.getChildren().remove(leftarmGroup);
		}
		if (this.Counter >= 4) {
			this.root.getChildren().remove(rightarmGroup);
		}
		if (this.Counter >= 5) {
			this.root.getChildren().remove(bottomGroup);
		}
		if (this.Counter >= 6) {
			this.root.getChildren().remove(middleGroup);
		}
		if (this.Counter >= 7) {
			this.Loss = 1;
			if (this.Loss == 1) {
				this.WordLabel.setText("You lost");
				window.setScene(scene1);
			}
		}

	}

}

