/**
 * Created by Маргарита on 27.11.2016.
 */
public class WrongBarCodeException extends Exception {
    public WrongBarCodeException() {
        super();
    }

    public WrongBarCodeException(String message) {
        super(message);
    }

    public WrongBarCodeException(String message, Throwable cause) {
        super(message, cause);
    }

    public WrongBarCodeException(Throwable cause) {
        super(cause);
    }
}
