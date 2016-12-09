package main.exeptions;


public class IpAddressFormatException extends Exception {

    public IpAddressFormatException(String message) {
        super("Неправильный формат IP адреса: " + message);
    }
}
