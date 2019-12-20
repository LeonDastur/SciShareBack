package BUAA.Group6.homePage.service;

import BUAA.Group6.homePage.model.Paper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Primary
public class PaperServiceImpl implements PaperService {
    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public List<Paper> getAllPapers() {
        return mongoTemplate.findAll(Paper.class);
    }


}
