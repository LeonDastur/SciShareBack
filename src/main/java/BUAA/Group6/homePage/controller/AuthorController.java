package BUAA.Group6.homePage.controller;

import BUAA.Group6.homePage.model.Author;
import BUAA.Group6.homePage.service.AuthorRepository;
import BUAA.Group6.homePage.service.AuthorService;
import BUAA.Group6.homePage.service.AuthorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class AuthorController {
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    AuthorRepository authorRepository;
    @Autowired
    AuthorService authorService;

    @RequestMapping(value = "getAuthorByName", method = RequestMethod.GET)
    public Author getByName(@RequestParam String name){
        return authorRepository.getByName(name);
    }

    @RequestMapping(value = "getAllAuthor", method = RequestMethod.GET)
    public List<Author> allAuthor(){
        return authorService.getAllAuthor();
    }
}
