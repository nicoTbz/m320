package Project.logic;

/**
 * The {@code InvalidTaskException} class represents a custom exception that is thrown 
 * when an invalid task is encountered.
 * This exception extends {@link Exception} and allows for a custom error message to be provided.
 */
public class InvalidTaskException extends Exception {

    /**
     * Constructs a new {@code InvalidTaskException} with the specified detail message.
     *
     * @param message A {@code String} containing the error message to describe the exception.
     */
    public InvalidTaskException(String message) {
        super(message);
    }
}
