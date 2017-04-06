package pl.com.kubachmielowiec.infrastructure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.com.kubachmielowiec.application.ApplyingProcess;
import pl.com.kubachmielowiec.application.JobApplicationRepository;
import pl.com.kubachmielowiec.application.StandardApplyingProcess;

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
}
