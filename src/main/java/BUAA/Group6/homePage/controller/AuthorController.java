package BUAA.Group6.homePage.controller;

import BUAA.Group6.homePage.model.Author;
import BUAA.Group6.homePage.repo.AuthorRepository;
import BUAA.Group6.homePage.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@CrossOrigin
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
