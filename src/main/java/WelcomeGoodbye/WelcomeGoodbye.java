package WelcomeGoodbye;

public class WelcomeGoodbye {

    /**
     * Utilised in printing
     */
    private final String horizontalLine = "____________________________________________________________";

    /**
     * Welcomes the user with a message
     */
    public void welcome() {
        printLine();
        print("Hello, Driver.Duke here! :D \n"
                + "I'm feeling good and ready to go! "
                + "What can I do for you?");
        printLine();
    }

    /**
     * Says goodbye to the user
     */
    public void goodbye() {
        printLine();
        print("====> Alright byeee thanks for coming and see ya soon! <==== \n:D :D :D :D :D");
        printLine();
    }

    /**
     * Prints a horizontal formatting line
     */
    private void printLine() {
        print(horizontalLine);
    }

    /**
     * Prints a given String
     *
     * @param s String to be printed
     */
    private void print(String s) {
        System.out.println(s);
    }

}