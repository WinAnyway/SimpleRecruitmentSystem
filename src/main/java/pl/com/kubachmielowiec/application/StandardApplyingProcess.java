package pl.com.kubachmielowiec.application;

import org.springframework.transaction.annotation.Transactional;
import pl.com.kubachmielowiec.model.JobApplication;

public class StandardApplyingProcess implements ApplyingProcess{

    private JobApplicationRepository jobApplicationRepository;

    public StandardApplyingProcess(JobApplicationRepository jobApplicationRepository) {
        this.jobApplicationRepository = jobApplicationRepository;
    }

    @Override
    @Transactional
    public void apply(JobApplication jobApplication) {
        validateApplication(jobApplication.getJobPosition().getPositionName(), jobApplication.getEmail());
        jobApplicationRepository.put(jobApplication);
    }

    private void validateApplication(String positionName, String email) {
        if(jobApplicationRepository.checkIfExist(positionName, email))
            throw new AlreadyAppliedException("You have already applied for this position");
    }

    @Override
    public void chooseJobPosition() {

    }
}
