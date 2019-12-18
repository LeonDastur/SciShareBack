package BUAA.Group6.homePage.repo;

import BUAA.Group6.homePage.model.Paper;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PaperRepository extends MongoRepository<Paper, String> {
    List<Paper> getPapersByTitleLike(String title);
    List<Paper> getPapersByAuthorsContains(Object obj);
    Paper getPaperById(String id);
}
