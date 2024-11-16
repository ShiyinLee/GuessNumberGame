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
//    private StringBuilder currentGuess;

    @FXML
    public void initialize(){
        generateSeretNumber();
//        currentGuess = new StringBuilder("______");
        statusLabel.setText("Guess the 6-digit number!");
    }

    private void generateSeretNumber(){
        Random random = new Random();
        secretNumber = String.format("%06d", random.nextInt(1_000_000));
        /*System.out.println("Secret Number: "+secretNumber);*/
    }

    @FXML
    public void handleSubmit(){
        String input = digitInput.getText();
        if(input.length()!=6 || !input.matches("\\d{6}")){
            resultLabel.setText("Enter a valid 6-digit number");
            return;
        }

//        char guessedDigit = input.charAt(0);
//        int position=currentGuess.indexOf("_");
        StringBuilder feedback=new StringBuilder();
        boolean[] matchedInSecret = new boolean[6];

        for(int i=0;i<6;i++){
            if(input.charAt(i)==secretNumber.charAt(i)){
                feedback.append("+");
                matchedInSecret[i]=true;
            }else{
                feedback.append("_");
            }
        }

        for(int i=0; i<6; i++){
            if(feedback.charAt(i)!='+'){
                boolean found=false;
                for(int j=0;j<6;j++){
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
        if(feedback.toString().equals("++++++")){
            statusLabel.setText("Congratulations! You guessed the number: "+secretNumber);
            digitInput.setDisable(true);
        }else{
            statusLabel.setText("Try again!");
        }

        digitInput.clear();
    }

}