package pl.com.kubachmielowiec.application;

public class SimpleLoginProcess implements LoginProcess{

    @Override
    public void validate(String userName, String password) {
        if (!(userName.equals("admin") && password.equals("admin123")))
            throw new InvalidLoginDataException("Wrong username or password");
    }
}
