package BUAA.Group6.homePage.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "researches")
public class Research {

    @Id
    private String expertId;

    private String title;

    private String date;

    private String venue;

    private List<String> expertsName;

    public String getExpertId() {
        return expertId;
    }

    public void setExpertId(String expertId) {
        expertId = expertId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public List<String> getExpertsName() {
        return expertsName;
    }

    public void setExpertsName(List<String> expertsName) {
        this.expertsName = expertsName;
    }
}
