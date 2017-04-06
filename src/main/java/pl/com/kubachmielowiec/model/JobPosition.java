package pl.com.kubachmielowiec.model;

import javax.persistence.Embeddable;

@Embeddable
public class JobPosition {

    private String positionName;

    public JobPosition(String jobPosition) {
        this.positionName = jobPosition;
    }

    JobPosition(){}

    public String getPositionName() {
        return positionName;
    }
}
