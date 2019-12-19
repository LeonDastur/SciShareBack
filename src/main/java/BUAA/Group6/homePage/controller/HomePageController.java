package BUAA.Group6.homePage.controller;


import BUAA.Group6.homePage.Result.Result;
import BUAA.Group6.homePage.Result.ResultFactory;
import BUAA.Group6.homePage.model.*;
import BUAA.Group6.homePage.repo.AuthorRepository;
import BUAA.Group6.homePage.repo.ExpertRepository;
import BUAA.Group6.homePage.repo.ResearchRepository;
import BUAA.Group6.homePage.service.ExpertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("/home")
public class HomePageController {

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    ExpertRepository expertRepo;

    @Autowired
    ResearchRepository researchRepo;

    @Autowired
    ExpertService expertService;

    @RequestMapping(value = "/loadHomePage", method = RequestMethod.GET)
    public Result loadHomePage(@RequestParam String expertName) {

        Expert expert = expertRepo.getExpertByUsername(expertName);
        if(expert == null) {
            return ResultFactory.buildFailResult("专家不存在");
        }
        String id = expert.getId();
        List<Research> researchList = researchRepo.getResearchesByExpertId(id);
        HomePage homePage = new HomePage(expert, researchList);
        return ResultFactory.buildSuccessResult(homePage);
    }

    @RequestMapping(value = "/updateIntro", method = RequestMethod.POST)
    public Result updateIntro(@RequestParam String expertName, @RequestParam String intro,
                              @RequestParam List<String> skills) {
        Expert expert = expertRepo.getExpertByUsername(expertName);
        if(expert == null)
            return ResultFactory.buildFailResult("专家不存在");

        expertService.updateExpertIntro(expert.getId(), intro, skills);
        return ResultFactory.buildSuccessResult("专家介绍修改成功");
    }

    @RequestMapping(value = "/updateExpertInfo", method = RequestMethod.POST)
    public Result updateExpertInfo(@RequestBody ExpertInfo expertInfo) {
        Expert expert = expertRepo.getExpertByUsername(expertInfo.getUserName());
        if(expert == null)
            return ResultFactory.buildFailResult("专家不存在");
        expertService.updateExpertInfo(expert.getId(), expertInfo);
        return ResultFactory.buildSuccessResult("专家信息修改成功");
    }



//    @RequestMapping(value = "/saveExpert", method = RequestMethod.GET)
//    Result saveExpert() {
//        Expert e = new Expert();
//        e.setRealName("Barbara Pratscher");
//        e.setId("100000977");
//        e.setUsername("huyikun");
//        e.setDegree("本科");
//        e.setFans(10);
//        e.setFollows(50);
//        e.setInstitution("北航");
//        expertRepo.save(e);
//        return ResultFactory.buildSuccessResult(e);
//    }








}
