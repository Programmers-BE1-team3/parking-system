package exceptions;

public class NoExistParkingSlotException extends Exception {
    public NoExistParkingSlotException(int parkingSlotId) {
        super("Parking slot with id " + parkingSlotId + " can not be used");
    }
}
