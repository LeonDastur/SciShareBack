package BUAA.Group6.homePage.controller;


import BUAA.Group6.homePage.Result.Result;
import BUAA.Group6.homePage.Result.ResultFactory;
import BUAA.Group6.homePage.model.*;
import BUAA.Group6.homePage.repo.AuthorRepository;
import BUAA.Group6.homePage.repo.PaperRepository;
import BUAA.Group6.homePage.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class HomePageController {

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    PaperRepository paperRepository;

    @Autowired
    AuthorService authorService;

    @RequestMapping(value = "loadHomePage", method = RequestMethod.GET)
    public Result loadHomePage(@RequestParam String id) {

        Author author = authorRepository.getAuthorById(id);
        if(author == null) {
            return ResultFactory.buildFailResult("专家不存在");
        }
        List<Paper> papers = new ArrayList<>();
        List<Pub> pubs = author.getPubs();
        for (Pub pub:pubs) {
            System.out.println(pub.getI());
            Paper paper = paperRepository.getPaperById(pub.getI());
            papers.add(paper);
        }

        HomePage homePage = new HomePage(author, papers);
        return ResultFactory.buildSuccessResult(homePage);
    }

    @RequestMapping(value = "updateInfo", method = RequestMethod.GET)
    public Result updateExpertInfo(@RequestParam String expertId, @RequestParam String institution,
                                   @RequestParam String degree, @RequestParam String websiteUrl,
                                   @RequestParam String email, @RequestParam String phone ) {
        Author author = authorRepository.getAuthorById(expertId);
        if(author == null)
            return ResultFactory.buildFailResult("专家不存在");
        authorService.updateAuthorInfo(expertId, institution, degree, websiteUrl, email, phone);
        return ResultFactory.buildSuccessResult("用户信息修改成功");
    }

    @RequestMapping(value = "updateIntroduction", method = RequestMethod.GET)
    public Result updateIntroduction(@RequestParam String expertId,
                                     @RequestParam String introduction,
                                     @RequestBody List<String> skills) {
        Author author = authorRepository.getAuthorById(expertId);
        if(author == null) {
            return ResultFactory.buildFailResult("专家不存在");
        }
        authorService.updateIntroduction(expertId, introduction, skills);
        return ResultFactory.buildSuccessResult("用户信息修改成功");
    }


    @RequestMapping(value = "getAuthor", method = RequestMethod.GET)
    public Result getAuthor(@RequestParam String id) {
        Author author = authorRepository.getAuthorById(id);
        if(author == null) {
            return ResultFactory.buildFailResult("未找到作者");
        }
        else
            return ResultFactory.buildSuccessResult(author);
    }

    @RequestMapping(value = "getPaper", method = RequestMethod.GET)
    public Result getPaper(@RequestParam String id) {
        Paper paper = paperRepository.getPaperById(id);
        if(paper == null) {
            return ResultFactory.buildFailResult("未找到作者");
        }
        else
            return ResultFactory.buildSuccessResult(paper);
    }
}
