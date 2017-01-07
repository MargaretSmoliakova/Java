/**
 * Created by Маргарита on 27.11.2016.
 */
public class WrongCurrencyNoteNumber extends Exception {
    public WrongCurrencyNoteNumber() {
        super();
    }

    public WrongCurrencyNoteNumber(String message) {
        super(message);
    }

    public WrongCurrencyNoteNumber(String message, Throwable cause) {
        super(message, cause);
    }

    public WrongCurrencyNoteNumber(Throwable cause) {
        super(cause);
    }
}
