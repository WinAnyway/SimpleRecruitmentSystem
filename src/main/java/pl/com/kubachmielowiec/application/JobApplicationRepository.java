package pl.com.kubachmielowiec.application;

import pl.com.kubachmielowiec.model.JobApplication;

public interface JobApplicationRepository {

    void put(JobApplication jobApplication);

    boolean checkIfExist(String positionName, String email);
}
