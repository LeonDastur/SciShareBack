package BUAA.Group6.homePage.service;

import BUAA.Group6.homePage.model.Expert;
import BUAA.Group6.homePage.model.ExpertInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.List;

@Service
@Primary
public class ExpertServiceImpl implements ExpertService {
    @Autowired
    private MongoTemplate mongoTemplate;
    @Override
    public List<Expert> getAllExperts() {
        return mongoTemplate.findAll(Expert.class);
    }

    @Override
    public void insertExpert(Expert expert) {
        mongoTemplate.insert(expert);
    }

    @Override
    public void updateExpertIntro(String id, String intro, List<String> skills) {
        Query query = new Query();
        query.addCriteria(Criteria.where("Id").is(id));
        Update update = new Update();
        update.set("introduction", intro);
        update.set("skills", skills);
        mongoTemplate.findAndModify(query, update, Expert.class);
    }


    @Override
    public void updateExpertInfo(String id, ExpertInfo expertInfo) {
        Query query = new Query();
        query.addCriteria(Criteria.where("Id").is(id));
        Update update = new Update();
        update.set("institution", expertInfo.getInstitution());
        update.set("degree", expertInfo.getDegree());
        update.set("webSiteUrl", expertInfo.getWebSiteUrl());
        update.set("phone", expertInfo.getPhone());
        update.set("email", expertInfo.getEmail());
        mongoTemplate.findAndModify(query, update, Expert.class);
    }
}
