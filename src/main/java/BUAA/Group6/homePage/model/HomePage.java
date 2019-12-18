package BUAA.Group6.homePage.model;

import java.util.List;

public class HomePage {
    String expertName;

    int follows;

    int fans;

    String introduction;

    String pictureUrl;

    List<String> skills;

    List<Research> researchList;

    private String institution;

    private String degree;

    private String webSiteUrl;

    private String phone;

    private String email;

    public HomePage(Expert expert, List<Research> researchList) {
        this.expertName = expert.getUsername();
        this.pictureUrl = expert.getPictureUrl();
        this.follows = expert.getFollows();
        this.fans = expert.getFans();
        this.introduction = expert.getIntroduction();
        this.skills = expert.getSkills();
        this.researchList = researchList;
        this.institution = expert.getInstitution();
        this.degree = expert.getDegree();
        this.webSiteUrl = expert.getWebSiteUrl();
        this.phone = expert.getPhone();
        this.email = expert.getEmail();
    }
}
