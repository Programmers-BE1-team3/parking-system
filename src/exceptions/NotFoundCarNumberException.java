package exceptions;

public class NotFoundCarNumberException extends Exception {
    public NotFoundCarNumberException(String carNum) {
        super("Car number " + carNum + " not found");
    }
}
