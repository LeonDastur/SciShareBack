package BUAA.Group6.homePage.repo;

import BUAA.Group6.homePage.model.Expert;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ExpertRepository extends MongoRepository<Expert, String> {
    Expert getExpertById(String id);
    Expert getExpertByUsername(String username);
}
