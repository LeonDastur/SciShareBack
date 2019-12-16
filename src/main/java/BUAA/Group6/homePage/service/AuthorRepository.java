package BUAA.Group6.homePage.service;

import BUAA.Group6.homePage.model.Author;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AuthorRepository extends MongoRepository<Author, String> {
    Author getById(String id);
    Author getByName(String name);

}
