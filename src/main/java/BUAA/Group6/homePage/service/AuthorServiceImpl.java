package BUAA.Group6.homePage.service;

import BUAA.Group6.homePage.model.Author;
import BUAA.Group6.homePage.repo.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Primary
public class AuthorServiceImpl implements AuthorService{
    @Autowired
    MongoTemplate mongoTemplate;
    @Autowired
    AuthorRepository authorRepository;

    @Override
    public List<Author> getAllAuthor() {
        return mongoTemplate.findAll(Author.class);
    }

    @Override
    public void insetAuthor(Author author) {
        mongoTemplate.insert(author, "magauthors");
    }

    @Override
    public void updateAuthorInfo(String id, String institution, String degree,
                                 String websiteUrl, String email, String phone) {

        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(id));
        Update update = new Update();
        update.set("institution", institution);
        update.set("degree", degree);
        update.set("websiteUrl", websiteUrl);
        update.set("email", email);
        update.set("phone", phone);
        mongoTemplate.findAndModify(query, update, Author.class, "magauthors");
    }

    @Override
    public void updateIntroduction(String id, String intro, List<String> skills) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(id));
        Update update = new Update();
        update.set("introduction", intro);
        update.set("skills", skills);
        mongoTemplate.findAndModify(query, update, Author.class, "magauthors");
    }
}
