package pl.com.kubachmielowiec.infrastructure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.com.kubachmielowiec.application.*;

@Configuration
public class Config {

    @Bean
    public ApplyingProcess applyingProcess(JobApplicationRepository jobApplicationRepository) {
        return new StandardApplyingProcess(jobApplicationRepository);
    }

    @Bean
    public JobApplicationRepository jobApplicationRepository() {
        return new JPAJobApplicationRepository();
    }

    @Bean
    public LoginProcess loginProcess() {
        return new SimpleLoginProcess();
    }

    @Bean
    public WebService webService(JobApplicationRepository jobApplicationRepository) {
        return new StandardWebService(jobApplicationRepository);
    }
}
