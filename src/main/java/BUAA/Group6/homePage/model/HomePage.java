package BUAA.Group6.homePage.model;
import java.io.Serializable;
import java.util.List;

public class HomePage implements Serializable {
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

    public String getExpertName() {
        return expertName;
    }

    public int getFollows() {
        return follows;
    }

    public int getFans() {
        return fans;
    }

    public String getIntroduction() {
        return introduction;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public List<String> getSkills() {
        return skills;
    }

    public List<Research> getResearchList() {
        return researchList;
    }

    public String getInstitution() {
        return institution;
    }

    public String getDegree() {
        return degree;
    }

    public String getWebSiteUrl() {
        return webSiteUrl;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }
}
