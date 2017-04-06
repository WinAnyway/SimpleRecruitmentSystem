package pl.com.kubachmielowiec.infrastructure;

import pl.com.kubachmielowiec.application.JobApplicationRepository;
import pl.com.kubachmielowiec.model.JobApplication;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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
        return (Long)query.getSingleResult() != 0L;
    }
}
