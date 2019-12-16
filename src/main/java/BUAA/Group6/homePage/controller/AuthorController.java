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


    //这几个接口现在可能响应会很慢，因为数据库的索引正在建立中
    @RequestMapping(value = "getAuthorByName", method = RequestMethod.GET)
    public Author getByName(@RequestParam String name){
        return authorRepository.getByNormalizedName(name);
    }

    @RequestMapping(value = "getAuthorById", method = RequestMethod.GET)
    public Author getById(@RequestParam String id){
        return authorRepository.getById(id);
    }

    @RequestMapping(value = "getAllAuthor", method = RequestMethod.GET)//暂时不要使用这个接口，因为数据过大，耗时很长
    public List<Author> allAuthor(){
        return authorService.getAllAuthor();
    }
}
