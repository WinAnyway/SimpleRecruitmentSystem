package pl.com.kubachmielowiec.application;

import pl.com.kubachmielowiec.model.JobApplication;

import java.util.List;

public interface WebService {

    Long calculateTotalSubmissions();

    Long calculateSubmissionsOf(String positionName);

    boolean checkIfPersonSubmittedForPosition(String email, String positionName);

    List<JobApplication> getApplicationsOf(String email);
}
