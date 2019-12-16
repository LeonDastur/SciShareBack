package BUAA.Group6.homePage.service;

import BUAA.Group6.homePage.model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class AuthorServiceImpl implements AuthorService{
    @Autowired
    MongoTemplate mongoTemplate;


    @Override
    public List<Author> getAllAuthor() {
        return mongoTemplate.findAll(Author.class);
    }
}
