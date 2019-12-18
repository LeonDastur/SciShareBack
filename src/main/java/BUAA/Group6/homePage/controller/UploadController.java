package BUAA.Group6.homePage.controller;

import BUAA.Group6.homePage.Result.Result;
import BUAA.Group6.homePage.Result.ResultCode;
import BUAA.Group6.homePage.Result.ResultFactory;
import BUAA.Group6.homePage.utils.FileUploadUtil;
import BUAA.Group6.homePage.utils.FilenameUtil;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

@RestController
@CrossOrigin
public class UploadController {

    @RequestMapping(value = "uploadPictures", method = RequestMethod.POST)
    public Result uploadPictures(@RequestParam(value = "file") MultipartFile file,
                                 HttpServletRequest request) {
        String localPath = "E:/upload/";
        //获取文件名
        String fileName = file.getOriginalFilename();

        fileName = FilenameUtil.getFileName(fileName);
        File dest = new File(localPath + fileName);
        if(FileUploadUtil.upload(file, localPath, fileName)) {
            // 将上传的文件写入服务器
            // 获取当前项目运行的完整url
            String requestURL = request.getRequestURL().toString();
            //获取当前项目的请求路径url
            String requestURI = request.getRequestURI();
            String url = requestURL.substring(0, requestURL.length() -
                    requestURI.length() + 1);
            url += ("file:/"+localPath+fileName);
            return ResultFactory.buildResult(ResultCode.SUCCESS, "图片上传成功", url);
        }

        return ResultFactory.buildFailResult("上传失败");
    }


}
