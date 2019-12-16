package BUAA.Group6.homePage.utils;



public class FilenameUtil {

    /**
     * 获取文件后缀
     * @param filename
     * @return
     */

    public static String getSuffix(String filename) {
        return filename.substring(filename.lastIndexOf("."));
    }

    /**
     * 生成新的文件名
     * @param originalFileName 源文件名
     * @return
     */

    public static String getFileName(String originalFileName) {
        return UUIDUtils.getUUID() + FilenameUtil.getSuffix(originalFileName);
    }
}

