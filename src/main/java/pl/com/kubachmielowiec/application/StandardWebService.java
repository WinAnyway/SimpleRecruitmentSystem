package pl.com.kubachmielowiec.application;

import pl.com.kubachmielowiec.model.JobApplication;

import java.util.List;

public class StandardWebService implements WebService{

    private JobApplicationRepository repository;

    public StandardWebService(JobApplicationRepository repository) {
        this.repository = repository;
    }

    @Override
    public Long calculateTotalSubmissions() {
        return repository.calculateTotalSubmissions();
    }

    @Override
    public Long calculateSubmissionsOf(String positionName) {
        return repository.calculateSubmissionsOf(positionName);
    }

    @Override
    public boolean checkIfPersonSubmittedForPosition(String email, String positionName) {
        return repository.checkIfExist(positionName, email);
    }

    @Override
    public List<JobApplication> getApplicationsOf(String email) {
        return repository.getApplicationsOf(email);
    }
}
