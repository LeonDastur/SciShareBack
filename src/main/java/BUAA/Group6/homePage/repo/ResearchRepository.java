package BUAA.Group6.homePage.repo;

import BUAA.Group6.homePage.model.Research;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ResearchRepository extends MongoRepository<Research, String> {
    List<Research> getResearchesByExpertId(String id);
}
