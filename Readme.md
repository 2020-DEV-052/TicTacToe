# Tic-Tac-Toe for Android
This is the implementation of the Tic-Tac-Toe game for Android devices
## Prerequisites
- Latest version of Android Studio is recommended to build the code
- Latest Android Build Tools
## Getting started
This application uses the Gradle build system
1. Fetch the source code by cloning or downloading this repository:
 ```  git clone https://github.com/2020-DEV-052/TicTacToe.git ```
2.  Open Android Studio and import the project using *File &rarr; New &rarr; Import Project*
3.  After successful import, run the app in an emulator or on a device
## Game Rules
- X always goes first
- Players cannot play on a played position
- Players alternate placing Xs and Os on the board until either:
	- One player has three in a row, horizontally, vertically or diagonally
	- All nine squares are filled.
- If a player is able to draw three Xs or three Os in a row, that player wins
- If all nine squares are filled and neither player has three in a row, the game is a draw
## Technical Details
- The application is written in Kotlin programming language
- Model-View-ViewModel (**MVVM**)  pattern is used to enable true separation between the `view` and `model`. Using this pattern makes testing more accessible and helps in test driven development.
-   The following [Android Jetpack]([https://developer.android.com/jetpack](https://developer.android.com/jetpack)) components have been used to make the app robust, testable and maintainable:
	- **LiveData**: It is used to observe the value of the 'winner' when the game ends and update the UI
	- **DataBinding**: It is used to update the text of each cell with either 'X' or 'O'  in the grid layout after each move of the user without having to explicitly write code for it in the activity
	-  **ViewModel**: It is used to manage and store UI related data by supporting databinding. It also segregates the logic completely from the UI and makes unit testing of the logic possible
-   **Test Driven Development (TDD)** approach has been followed throughout the project at three different levels:
	- **Model**: Junit tests have been written for the `Grid` Model class
	- **ViewModel**: Junit tests have been written for the `GameGridViewModel` class
	- **User Interface**: Espresso tests have been written for the `GameGridActivity` UI class to test the user interface