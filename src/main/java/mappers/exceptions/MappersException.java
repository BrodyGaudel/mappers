package mappers.exceptions;

/**
 * The {@code MappersException} class is a custom runtime exception specific to the Mappers utility class.
 * It is thrown to indicate errors during the mapping process, such as issues with creating DTOs or entities.
 *
 * @author BRODY GAUDEL MOUNANGA BOUKA
 */
public class MappersException extends RuntimeException {

    /**
     * Constructs a new runtime exception with the specified detail message.
     * The cause is not initialized, and may subsequently be initialized by a
     * call to {@link #initCause}.
     *
     * @param message the detail message. The detail message is saved for
     *                later retrieval by the {@link #getMessage()} method.
     */
    public MappersException(String message) {
        super(message);
    }
}

