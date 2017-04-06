package pl.com.kubachmielowiec.application;

public class InvalidLoginDataException extends RuntimeException {
    public InvalidLoginDataException(String s) {
        super(s);
    }
}
