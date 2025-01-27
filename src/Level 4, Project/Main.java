package Project;

import Project.ui.Menu;

/**
 * The {@code Main} class serves as the entry point for the application.
 * It initializes the {@link Menu} and starts the application.
 */
public class Main {

    /**
     * The main method is the entry point of the application.
     * It creates an instance of the {@link Menu} class and calls its {@code start} method to run the application.
     *
     * @param args Command-line arguments passed to the application.
     */
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.start();
    }
}
