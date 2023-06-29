package blck.radiostation.exception;

/**
 * Invalid Transaction Exception.
 *
 * @author Livio Agolini
 */
public class InvalidEntityException extends RuntimeException {

    public InvalidEntityException(String entity, String message) {
        super("Invalid %s: %s".formatted(entity, message));
    }
}
