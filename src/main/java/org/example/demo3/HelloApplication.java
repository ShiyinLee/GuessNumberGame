package org.example.demo3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        // Main Menu Layout
        BorderPane mainMenu = new BorderPane();

        // Welcome Text
        Text welcomeText = new Text("Welcome to NumGuessr");
        BorderPane.setAlignment(welcomeText, javafx.geometry.Pos.TOP_CENTER);
        mainMenu.setTop(welcomeText);

        // Buttons
        Button btnPlayGame = new Button("Play Game");
        Button btnHowToPlay = new Button("How To Play?");
        Button btnExitGame = new Button("Exit Game");

        // Button Container (Bottom)
        HBox buttonContainer = new HBox(20, btnPlayGame, btnHowToPlay, btnExitGame);
        buttonContainer.setAlignment(javafx.geometry.Pos.CENTER);
        mainMenu.setBottom(buttonContainer);

        Scene mainScene = new Scene(mainMenu, 640, 480);

        // Load the Game Screen (hello-view.fxml)
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("play-game.fxml"));
        Parent gameScreen = fxmlLoader.load(); // Load the game scene from FXML
        Scene gameScene = new Scene(gameScreen, 640, 480);

        // "How to Play" Screen Layout
        VBox howToPlayLayout = new VBox(10);
        howToPlayLayout.setAlignment(javafx.geometry.Pos.CENTER);
        Text instructions = new Text("This game is about guessing a randomly generated number.\n" +
                "\n" +
                "1) Pick how many digits you want the number to be.\n" +
                "2) Try to guess the number by entering the correct amount of digits.\n" +
                "3) Meanings of the symbols:\n" +
                "        +: This digit is included in the number and is at the correct place!\n" +
                "        *: This digit is included in the number but is not in this place!\n" +
                "        -: This digit is not included in the number!\n" +
                "4)Have fun! ");
        Button btnBack = new Button("Back to Main Menu");
        howToPlayLayout.getChildren().addAll(instructions, btnBack);

        Scene howToPlayScene = new Scene(howToPlayLayout, 640, 480);

        // Button Actions
        btnPlayGame.setOnAction(e -> primaryStage.setScene(gameScene));
        btnHowToPlay.setOnAction(e -> primaryStage.setScene(howToPlayScene));
        btnBack.setOnAction(e -> primaryStage.setScene(mainScene));
        btnExitGame.setOnAction(e -> primaryStage.close());

        primaryStage.setScene(mainScene);
        primaryStage.setTitle("Guess the Number Game");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}