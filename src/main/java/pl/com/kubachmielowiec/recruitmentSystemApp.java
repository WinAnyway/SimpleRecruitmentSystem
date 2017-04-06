package pl.com.kubachmielowiec;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.net.UnknownHostException;

//java -cp lib/hsqldb.jar org.hsqldb.server.Server --database.0 file:D:/recruitmentSystemResources/recruitmentSystem --dbname.0 recruitmentSystem

@SpringBootApplication
public class recruitmentSystemApp {

    public static void main(String[] args) throws UnknownHostException {
        ConfigurableApplicationContext ctx = SpringApplication.run(recruitmentSystemApp.class);
    }

}
