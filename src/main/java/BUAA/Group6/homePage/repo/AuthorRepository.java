package BUAA.Group6.homePage.repo;

import BUAA.Group6.homePage.model.Author;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AuthorRepository extends MongoRepository<Author, String> {
    Author getAuthorById(String id);
    Author getByNormalizedName(String normalized_name);
    Author getAuthorByName(String name);
    Author getAuthorByUsername(String username);

}
