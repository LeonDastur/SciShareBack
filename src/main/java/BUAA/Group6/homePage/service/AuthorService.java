package BUAA.Group6.homePage.service;

import BUAA.Group6.homePage.model.Author;

import java.util.List;

public interface AuthorService {
    List<Author> getAllAuthor();
    void insetAuthor(Author author);
    void updateAuthorInfo(String id, String institution, String degree,
                          String websiteUrl, String email, String phone);
    void updateIntroduction(String id, String intro, List<String> skills);
}
