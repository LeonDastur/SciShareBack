
package BUAA.Group6.homePage.controller;


import BUAA.Group6.homePage.Result.Result;
import BUAA.Group6.homePage.Result.ResultFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@RestController
@CrossOrigin
public class PicUploadController {

    private static final Logger logger = LoggerFactory.getLogger(PicUploadController.class);



    @Value("${file.uploadFolder}")
    private String uploadFolder;
    private String staticAccessPath = "/static/upload/img/";

    @ResponseBody
    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    public Result uploadPictures(@RequestParam(value = "file") MultipartFile files[],
                                 HttpServletRequest request) {
        List<String> imgUrls = new ArrayList<>();
        String  baseUrl = request.getScheme() + "://" + request.getServerName() + ":" +
                request.getServerPort() + request.getContextPath(); //网页访问路径前缀
        File uploadDirectory = new File(uploadFolder); //存储目录
        if (uploadDirectory.exists()) {
            if (!uploadDirectory.isDirectory()) {
                uploadDirectory.delete();
            }
        } else {
            uploadDirectory.mkdirs();
        }
        //这里可以支持多文件上传
        if (files != null && files.length >= 1) {
            for (MultipartFile file : files) {
                String oldFileName = file.getOriginalFilename();
                System.out.println(oldFileName);
                //判断是否有文件且是否为图片文件
                if (oldFileName != null && !"".equalsIgnoreCase(oldFileName.trim()) && isImageFile(oldFileName)) {
                    //生成新的文件名
                    String newFileName = UUID.randomUUID().toString() + getFileType(oldFileName);
                    try {
                        file.transferTo(new File(uploadDirectory, newFileName));
                        String url = baseUrl + staticAccessPath + newFileName; //图片url
                        imgUrls.add(url);
                    } catch (IOException e) {
                        e.printStackTrace();
                        return ResultFactory.buildFailResult("图片上传失败");

                    }
                }
            }
        } else {
            return ResultFactory.buildFailResult("上传图片失败");
        }
        return ResultFactory.buildSuccessResult(imgUrls);
    }

    /**
     * 判断是否为图片
     * @param fileName
     * @return
     */
    private Boolean isImageFile(String fileName) {
        String[] img_type = new String[]{".jpg", ".jpeg", ".png", ".gif", ".bmp"};
        if (fileName == null) {
            return false;
        }
        fileName = fileName.toLowerCase();
        for (String type : img_type) {
            if (fileName.endsWith(type)) {
                return true;
            }
        }
        return false;
    }
    /**
     * 获取文件后缀名
     * @param fileName
     * @return
     */
    private String getFileType(String fileName) {
        if (fileName != null && fileName.contains(".")) {
            return fileName.substring(fileName.lastIndexOf("."));
        }
        return "";
    }
}
