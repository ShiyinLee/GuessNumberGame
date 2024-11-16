# Guess Number Game

## Description
The Guess Number Game is a JavaFX-based application where users attempt to guess a randomly generated number. 
Players can customize the number of digits (1 to 10) and receive feedback for each guess using symbols:
- `+`: Correct digit and correct position.
- `*`: Correct digit but incorrect position.
- `-`: Digit not in the number.

The game tracks the number of attempts and provides an intuitive GUI with customizable background color.

## Features
- **Customizable digit length**: Play with numbers from 1 to 10 digits.
- **Feedback system**:
  - `+`: Correct digit and position.
  - `*`: Correct digit, wrong position.
  - `-`: Digit not present.
- **Attempt counter**: Tracks the number of guesses made.
- **Clean GUI**: Modern interface with a customizable background color.
- **Random secret number generation**: Ensures unique and unpredictable gameplay.

## How to Play
1. Enter the number of digits you want to guess (1 to 10).
2. Start the game, and a secret number will be generated.
3. Enter your guess in the input field and press **Submit**.
4. Receive feedback:
   - `+`: Correct digit and position.
   - `*`: Correct digit, wrong position.
   - `-`: Digit not in the number.
5. Keep guessing until you receive only `+` symbols, indicating you've won.
6. The attempt counter displays how many tries you've made.

## Project Structure
src/
├── controllers/
│   ├── HelloController.java    # Main game logic and controller for the UI
│
├── views/
│   ├── play-game.fxml          # Layout file for the JavaFX GUI
│
├── HelloApplication.java                  # Entry point for the application
│
resources/
├── styles.css                 # CSS file for customizing the UI
│
README.md                      # This file

## Screenshots
![img.png](img.png)
![img_1.png](img_1.png)
![img_2.png](img_2.png)
![img_3.png](img_3.png)
![img_4.png](img_4.png)
