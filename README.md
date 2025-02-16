MCQ-Based Quiz App (Android - Java)

Objective

Create a fully functional MCQ-based Quiz App in Android (Java) that demonstrates the use of:

Splash Screen with Animations

Activities & Navigation

Explicit & Implicit Intents

Features

1. Splash Screen with Animations

Appears when the app is launched.

Includes animations such as fading, scaling, or translating the logo.

Automatically navigates to the Main Quiz Screen after 2-3 seconds.

2. Quiz Interface

MainActivity (Start Screen)

Displays a text field for entering the user’s name.

"Start Quiz" button navigates to QuizActivity (Explicit Intent).

QuizActivity (MCQ Screen)

Displays one MCQ at a time with four answer options.

Includes "Previous" and "Next" buttons:

Next Button: Moves to the next question.

Previous Button: Moves to the previous question (disabled on the first question).

Implements score tracking.

After the last question, displays the final score.

3. Explicit Intent

Navigate from MainActivity to QuizActivity (Explicit Intent).

Pass the user’s name to QuizActivity using an Intent Extra.

4. Implicit Intent

After the quiz ends, navigate to ResultActivity (Explicit Intent).

"Share Score" button uses an Implicit Intent to share the result via WhatsApp, Gmail, etc.

Design

Splash Screen: App logo and animated transition.

Start Screen: User name input and "Start Quiz" button.

Quiz Screens: Displays questions, options, and navigation buttons.

Result Screen: Shows the final score and includes a "Share Score" button.

Additional Instructions

Consistency: Maintain design consistency across all screens (colors, fonts, spacing).

Usability: Ensure interactive elements (buttons, forms) are user-friendly and clearly labeled.

Testing: Test the navigation flow between screens to ensure it functions smoothly.

Assets: Use the provided logo and background in the app design.

Project Structure

/app/src/main/java/com/example/quizapp
│
├── MainActivity.java
├── QuizActivity.java
├── ResultActivity.java
├── SplashActivity.java

How to Run the App

Clone the repository.

Open the project in Android Studio.

Sync the Gradle files.

Run the app on an emulator or physical device.

Happy Coding! 🚀

