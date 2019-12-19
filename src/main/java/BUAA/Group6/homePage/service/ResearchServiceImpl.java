package BUAA.Group6.homePage.service;

import BUAA.Group6.homePage.model.Research;
import BUAA.Group6.homePage.repo.ResearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

@Service
@Primary
public class ResearchServiceImpl implements ResearchService {
    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public void insertResearch(Research research) {
        mongoTemplate.insert(research, "research");
    }
}
