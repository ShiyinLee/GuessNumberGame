package org.example.demo3;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;

import java.util.Random;

public class HelloController {
    @FXML
    private TextField digitInput;
    @FXML
    private Label resultLabel;
    @FXML
    private Label statusLabel;

    private String secretNumber;
    private StringBuilder currentGuess;

    @FXML
    public void initialize(){
        generateSeretNumber();
        currentGuess = new StringBuilder("______");
        statusLabel.setText("Guess a digit for position 1!");
    }

    private void generateSeretNumber(){
        Random random = new Random();
        secretNumber = String.format("%06d", random.nextInt(1_000_000));
        /*System.out.println("Secret Number: "+secretNumber);*/
    }

    @FXML
    public void handleSubmit(){
        String input = digitInput.getText();
        if(input.length()!=1 || !Character.isDigit(input.charAt(0))){
            resultLabel.setText("Enter a single digit (0-9)!");
            return;
        }

        char guessedDigit = input.charAt(0);
        int position=currentGuess.indexOf("_");

    }

}