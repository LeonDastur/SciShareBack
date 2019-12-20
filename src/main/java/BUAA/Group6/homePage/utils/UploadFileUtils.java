package BUAA.Group6.homePage.utils;

import org.springframework.stereotype.Component;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

/**
 * 文件操作工具类
 */

@Component
public class UploadFileUtils {

    /**
     * 写入文件
     */
    public static void write(String target, InputStream src) throws IOException {
        OutputStream os = new FileOutputStream(target);
        byte[] buf = new byte[1024];
        int len;
        while (-1 != (len = src.read(buf))) {
            os.write(buf,0,len);
        }
        os.flush();
        os.close();
    }


    /**
     * 产生随机的文件名
     */
    public static String generateFileName(String oldName) {
        String suffix = oldName.substring(oldName.lastIndexOf("."));
        return UUID.randomUUID().toString()+suffix;
    }
}
