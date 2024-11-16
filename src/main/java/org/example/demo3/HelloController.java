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
    private TextField digitCountInput;
    @FXML
    private Label resultLabel;
    @FXML
    private Label statusLabel;
    @FXML
    private Label attemptLabel;
    @FXML
    private Button startButton;

    private String secretNumber;
    private int digitCount;
    private int attempts;

    @FXML
    public void initialize(){
        resetGame();
    }

    private void resetGame(){
        secretNumber="";
        digitCount=0;
        attempts=0;
        digitInput.setDisable(true);
        digitInput.clear();
        resultLabel.setText("");
        statusLabel.setText("Set the number of digits and click Start!");
        attemptLabel.setText("Attempts: 0");
    }

    private void generateSeretNumber(){
        Random random = new Random();
        StringBuilder secret = new StringBuilder();
        for(int i=0; i<digitCount; i++){
            secret.append(random.nextInt(10));
        }
        secretNumber=secret.toString();
//        secretNumber = String.format("%06d", random.nextInt(1_000_000));
        /*System.out.println("Secret Number: "+secretNumber);*/
    }

    @FXML
    public void handleStart() {
        String input = digitCountInput.getText();
        if (!input.matches("\\d+") || Integer.parseInt(input) < 1 || Integer.parseInt(input) > 10) {
            resultLabel.setText("Enter a valid digit count (1-10)!");
            return;
        }

//        char guessedDigit = input.charAt(0);
//        int position=currentGuess.indexOf("_");
        digitCount = Integer.parseInt(input);
        generateSeretNumber();
        digitInput.setDisable(false);
        statusLabel.setText("Guess the " + digitCount + "-digit number!");
        attempts = 0;
        attemptLabel.setText("Attempts: 0");
    }
    @FXML
    public void handleSubmit(){
        String input = digitInput.getText();
        if(input.length()!=digitCount||!input.matches("\\d{"+digitCount+"}")){
            resultLabel.setText("Enter a valid"+digitCount+"-digit number");
            return;
        }
        attempts++;
        attemptLabel.setText("Attempts: "+attempts);

        StringBuilder feedback = new StringBuilder();
        boolean[] matchedInSecret = new boolean[digitCount];

        for(int i=0; i<digitCount; i++){
            if(input.charAt(i)==secretNumber.charAt(i)){
                feedback.append("+");
                matchedInSecret[i]=true;
            }else{
                feedback.append("_");
            }
        }

        for(int i=0; i<digitCount;i++){
            if(feedback.charAt(i)!='+'){
                boolean found = false;
                for(int j=0;j<digitCount;j++){
                    if(!matchedInSecret[j]&&input.charAt(i)==secretNumber.charAt(j)){
                        feedback.setCharAt(i,'*');
                        matchedInSecret[j]=true;
                        found=true;
                        break;
                    }
                }
                if(!found){
                    feedback.setCharAt(i,'-');
                }
            }
        }
        resultLabel.setText("Feedback: "+feedback);
        if(feedback.toString().equals("+".repeat(digitCount))){
            statusLabel.setText("Congratulations! You guessed the number in "+attempts+" attempts!");
            digitInput.setDisable(true);
        }else{
            statusLabel.setText("Try again!");
        }
        digitInput.clear();
    }



}