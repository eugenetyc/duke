package duke;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.util.Scanner;

/**
 * Controller for duke.MainWindow. Provides the layout for the other controls.
 */
public class MainWindow extends AnchorPane {

    // GUI Controls
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private VBox dialogContainer;
    @FXML
    private TextField userInput;
    @FXML
    private Button sendButton;

    // Supporting Images for Duke and User display photos
    private Image userImage = new Image(this.getClass().getResourceAsStream("/images/DaUser.png"));
    private Image dukeImage = new Image(this.getClass().getResourceAsStream("/images/DaDuke.png"));

    /**
     * Initialises the Main Window for the Application, prompting user to use Duke.
     */
    @FXML
    public void initialize() {

        // set size constraints
        scrollPane.vvalueProperty().bind(dialogContainer.heightProperty());

        // set visual cues for users to begin using program
        dialogContainer.getChildren().addAll(
                DialogBox.getDukeDialog(Ui.welcome(), dukeImage)
        );

    }

    // We can use this Duke to perform as a chatbot.
    private Duke duke;

    /**
     * Sets the Duke of choice to be the Duke chatbot handling the user inputs.
     *
     * @param d Duke chosen to handle user inputs.
     */
    public void setDuke(Duke d) {
        duke = d;
    }

    /**
     * Creates two dialog boxes, one echoing user input and the other containing Duke's reply and then appends them to
     * the dialog container. Clears the user input after processing.
     */
    @FXML
    private void handleUserInput() {

        // User and Duke query and response come as a pair.
        String userText = getUserResponse(userInput.getText());
        String dukeText = getDukeResponse(userInput.getText());

        // Adding both into a container (VBox) which presents visually their messages.
        dialogContainer.getChildren().addAll(
                DialogBox.getUserDialog(userText, userImage),
                DialogBox.getDukeDialog(dukeText, dukeImage)
        );

        // Clear the user input.
        userInput.clear();
    }

    /**
     * Provides user input with user as the author.
     *
     * @param input input entered by the user.
     * @return String to represent input entered by the user.
     */
    private String getUserResponse(String input) {
        return "You: " + input;
    }

    /**
     * Generates a response for Duke to process the user input.
     *
     * @param input user input entered for Duke to respond to.
     * @return Duke's response after processing the user input.
     */
    private String getDukeResponse(String input) {
        String result = (input.equals("bye")) ? Ui.goodbye() : duke.run(input);
        return "Duke: " + result;
    }

}