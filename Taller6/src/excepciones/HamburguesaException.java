package excepciones;

public class HamburguesaException extends Exception{
	public HamburguesaException() {
        super();
    }

    public HamburguesaException(String message) {
        super(message);
    }

    public HamburguesaException(String message, Throwable cause) {
        super(message, cause);
    }

    public HamburguesaException	(Throwable cause) {
        super(cause);
    }
}
