package pl.com.kubachmielowiec.infrastructure;

import pl.com.kubachmielowiec.application.JobApplicationRepository;
import pl.com.kubachmielowiec.model.JobApplication;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public class JPAJobApplicationRepository implements JobApplicationRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void put(JobApplication jobApplication) {
        entityManager.persist(jobApplication);
    }

    @Override
    public boolean checkIfExist(String positionName, String email) {
        Query query = entityManager.createQuery("SELECT count(j) FROM JobApplication j WHERE j.jobPosition.positionName = :name AND j.email = :email");
        query.setParameter("name", positionName);
        query.setParameter("email", email);
        return (Long) query.getSingleResult() != 0L;
    }

    @Override
    public Long calculateTotalSubmissions() {
        Query query = entityManager.createQuery("SELECT COUNT(j) FROM JobApplication j");
        return (Long) query.getSingleResult();
    }

    @Override
    public Long calculateSubmissionsOf(String positionName) {
        Query query = entityManager.createQuery("SELECT COUNT(j) FROM JobApplication j WHERE j.jobPosition.positionName = :name");
        query.setParameter("name", positionName);
        return (Long) query.getSingleResult();
    }

    @Override
    public List<JobApplication> getApplicationsOf(String email) {
        Query query = entityManager.createQuery("SELECT j FROM JobApplication j WHERE j.email = :email");
        query.setParameter("email", email);
        return null;
    }
}
