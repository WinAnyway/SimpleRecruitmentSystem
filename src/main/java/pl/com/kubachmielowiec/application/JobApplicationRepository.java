package pl.com.kubachmielowiec.application;

import pl.com.kubachmielowiec.model.JobApplication;

import java.util.List;

public interface JobApplicationRepository {

    void put(JobApplication jobApplication);

    boolean checkIfExist(String positionName, String email);

    Long calculateTotalSubmissions();

    Long calculateSubmissionsOf(String positionName);

    List<JobApplication> getApplicationsOf(String email);
}
