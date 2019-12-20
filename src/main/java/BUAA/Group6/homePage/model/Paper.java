package BUAA.Group6.homePage.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Document(collection = "magpapers")
public class Paper {

    @Id
    private String _id;

    @Field(value = "id")
    private String id;

    private String title;

    @Field(value = "authors")
    private List<SimpleAuthor> authors;

    @Field(value = "venue")
    private Venue venue;

    private int year;

    private int n_citations;

    private String page_start;

    private String page_end;

    private String doc_type; //pdf doc ppt

    private String publisher;

    private String volume;

    private String issue;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<SimpleAuthor> getAuthors() {
        return authors;
    }

    public void setAuthors(List<SimpleAuthor> authors) {
        this.authors = authors;
    }

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getN_citations() {
        return n_citations;
    }

    public void setN_citations(int n_citations) {
        this.n_citations = n_citations;
    }

    public String getPage_start() {
        return page_start;
    }

    public void setPage_start(String page_start) {
        this.page_start = page_start;
    }

    public String getPage_end() {
        return page_end;
    }

    public void setPage_end(String page_end) {
        this.page_end = page_end;
    }

    public String getDoc_type() {
        return doc_type;
    }

    public void setDoc_type(String doc_type) {
        this.doc_type = doc_type;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }
}
