package BUAA.Group6.homePage.model;
import java.io.Serializable;
import java.util.List;

public class HomePage implements Serializable{

    private String realName;

    private String expertID;

    private int follows;

    private int fans;

    private String introduction;

    private String pictureUrl;

    private List<String> skills;

    private List<Paper> researchList;

    private String institution;

    private String degree;

    private String webSiteUrl;

    private String phone;

    private String email;

    public HomePage(Author author, List<Paper> paperList) {
        this.realName = author.getName();
        this.expertID = author.getId();
        this.follows = author.getFollows();
        this.fans = author.getFans();
        this.introduction = author.getIntroduction();
        this.pictureUrl = author.getPictureUrl();
        this.skills = author.getSkills();
        this.researchList = paperList;
        this.institution = author.getInstitution();
        this.degree = author.getDegree();
        this.webSiteUrl = author.getWebSiteUrl();
        this.email = author.getEmail();
        this.phone = author.getPhone();
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getExpertID() {
        return expertID;
    }

    public void setExpertID(String expertId) {
        this.expertID = expertId;
    }

    public String getUsername() {
        return realName;
    }

    public void setUsername(String username) {
        this.realName = username;
    }

    public List<Paper> getResearchList() {
        return researchList;
    }

    public void setResearchList(List<Paper> researchList) {
        this.researchList = researchList;
    }

    public int getFollows() {
        return follows;
    }

    public void setFollows(int follows) {
        this.follows = follows;
    }

    public int getFans() {
        return fans;
    }

    public void setFans(int fans) {
        this.fans = fans;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getWebSiteUrl() {
        return webSiteUrl;
    }

    public void setWebSiteUrl(String webSiteUrl) {
        this.webSiteUrl = webSiteUrl;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
