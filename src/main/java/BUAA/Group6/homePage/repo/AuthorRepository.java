package BUAA.Group6.homePage.repo;

import BUAA.Group6.homePage.model.Author;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AuthorRepository extends MongoRepository<Author, String> {
    Author getById(String id);
    Author getByName(String name);

}
