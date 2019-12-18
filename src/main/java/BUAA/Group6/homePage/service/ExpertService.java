package BUAA.Group6.homePage.service;

import BUAA.Group6.homePage.model.Expert;

import java.util.List;

public interface ExpertService {
    List<Expert> getAllExperts();
    void insertExpert(Expert expert);
    void updateExpertIntro(String id, String intro, List<String> skills);
}
