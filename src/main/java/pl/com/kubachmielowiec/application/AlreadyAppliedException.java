package pl.com.kubachmielowiec.application;

public class AlreadyAppliedException extends RuntimeException {

    public AlreadyAppliedException(String s) {
        super(s);
    }
}
