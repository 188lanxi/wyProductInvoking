package lanxi.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wuxiaobo on 2018/6/19 0019.
 */
public class ReadFileUtil {
    private static String testPath="../../src/main/resources/";

    /**
     * 获取指定目录下的文件或目录(可指定文件后缀名)
     * @param dirPath 文件路径
     * @param fileFormat 文件后缀名
     * @return
     */
    public static File[] getFiles(String dirPath,String fileFormat){
        if (dirPath==null||dirPath.isEmpty())
            return null;
        File file=new File(dirPath);
        if (!file.isDirectory())
            return null;
        File[] files=null;
        if (file.isDirectory()){
            files=file.listFiles();
            if (null==fileFormat)
                return files;
            else{
                List<File> list=new ArrayList<>();
                for (File each:files)
                    if (each.getName().endsWith(fileFormat))
                        list.add(each);
                return list.toArray(new File[list.size()]);
            }
        }
        return files;
    }
    /**
     * 相对与classpath获取文件 ..表示上一级目录
     *
     * @param path
     * @return File
     */
    public static File getFileOppositeClassPath(String path) {
        try {
            String classPath = ReadFileUtil.class.getClassLoader().getResource("").toURI().getPath();
            System.out.println(classPath);
            File file = new File(classPath);
            if (path == null ||path.isEmpty())
                return file;
            if (path.startsWith("/"))
                path = path.substring(1);
            if(classPath.contains("test-classes")){
                System.out.println("调用测试路径");
                path=testPath+path;
            }
            String[] strs = path.split("/");
            for (String each : strs) {
                if ("..".equals(each))
                    file = file.getParentFile();
                else if (file.isDirectory()) {
                    file = new File(file.getAbsolutePath() + "/" + each);
                } else
                    throw new RuntimeException("路径"+file.getAbsolutePath()+"是一个文件而非目录或路径不存在,无法进入下一级");
            }
            return file;
        } catch (Exception e) {
            throw new RuntimeException("相对classPath获取文件异常", e);
        }
    }
    /**
     * 获取相对于classpath下的目录中的文件(可以指定后缀名)
     * @param path
     * @param format
     * @return File[]
     */
    public static File[] getFilesOppositeClassPath(String path, String format) {
        try {
            return getFiles(getFileOppositeClassPath(path).getAbsolutePath(), format);
        } catch (Exception e) {
            throw new RuntimeException("获取相对于classpath目录下指定文件列表异常", e);
        }
    }
}
