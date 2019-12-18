package BUAA.Group6.homePage.controller;


import BUAA.Group6.homePage.Result.Result;
import BUAA.Group6.homePage.Result.ResultFactory;
import BUAA.Group6.homePage.model.*;
import BUAA.Group6.homePage.repo.ExpertRepository;
import BUAA.Group6.homePage.repo.ResearchRepository;
import BUAA.Group6.homePage.service.ExpertService;
import javafx.util.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin

@RequestMapping("/home")
public class HomePageController {

    @Autowired
    ExpertRepository expertRepo;

    @Autowired
    ResearchRepository researchRepo;

    @Autowired
    ExpertService expertService;

    @RequestMapping(value = "/loadHomePage", method = RequestMethod.GET)
    public Result getHomePageItem(@RequestParam String expertName) {
        Expert expert = expertRepo.getExpertByUsername(expertName);
        if(expert == null) {
            return ResultFactory.buildFailResult("专家不存在");
        }
        String id = expert.getId();
        List<Research> researchList = researchRepo.getResearchesByExpertId(id);
        return ResultFactory.buildSuccessResult(new HomePage(expert, researchList));
    }

    @RequestMapping(value = "/updateIntro")
    public Result updateIntro(@RequestParam String expertName, @RequestParam String intro,
                              @RequestParam List<String> skills) {
        Expert expert = expertRepo.getExpertByUsername(expertName);
        if(expert == null)
            return ResultFactory.buildFailResult("用户不存在");

        expertService.updateExpertIntro(expert.getId(), intro, skills);
        return ResultFactory.buildSuccessResult("用户介绍修改成功");
    }



}
