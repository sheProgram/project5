package ADTPackage;
/**
 * A class that defines an error message if a queue is empty.
 */
public class EmptyQueueException extends RuntimeException {
    public EmptyQueueException(String message) {
        super(message);
    }
}
