package pl.com.kubachmielowiec.application;

import pl.com.kubachmielowiec.model.JobApplication;

public interface ApplyingProcess {

    void apply(JobApplication jobApplication);

    void chooseJobPosition();
}
