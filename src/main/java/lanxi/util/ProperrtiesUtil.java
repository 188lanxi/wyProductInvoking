package lanxi.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * Created by wuxiaobo on 2018/6/19 0019.
 */
public class ProperrtiesUtil {
    private static Properties properties;
    private static String path="";

    /**
     * 初始化配置文件
     */
    static {
        try {
            File[] files=null;
            String classPath=ProperrtiesUtil.class.getClassLoader().getResource("").toURI().getPath();
            files = ReadFileUtil.getFilesOppositeClassPath("/properties", ".properties");
            for (File each:files)
                loadProperties(each);
        }catch (Exception e){
            throw new RuntimeException("初始化配置文件时发生异常",e);
        }
    }
    public static void reload(){
        init();
        System.out.println("重新加载配置文件完成!");
    }
    public static void init(){
        try {
            File[] files = null;
            String classPath = ProperrtiesUtil.class.getClassLoader().getResource("").toURI().getPath();
            System.out.println("路径：" + classPath);
            files = ReadFileUtil.getFilesOppositeClassPath("/properties", ".properties");
            System.out.println(files);
            for (File each : files)
                loadProperties(each);
        } catch (Exception e) {
            throw new RuntimeException("初始化配置文件设置异常", e);
        }

    }
    /**
     * 从默认的路径加载配置文件 默认路径为 classpath/properties/
     *
     * @return
     */
    public static Properties load() {
        try {
            properties = properties == null ? new Properties() : properties;
            String path = ProperrtiesUtil.class.getClassLoader().getResource("/").getPath();
            return load(path);
        } catch (Exception e) {
            throw new RuntimeException("加载配置文件异常", e);
        }
    }
    /**
     * 从指定路径加载配置文件 指定路径为文件,则加载文件 指定路径为目录,加载下所有peroperties文件
     *
     * @param path
     * @return
     */
    public static Properties load(String path) {
        try {
            properties = properties == null ? new Properties() : properties;
            File file = new File(path);
            if (file.isDirectory()) {
                File[] files = file.listFiles();
                for (File each : files) {
                    if (!each.getName().endsWith(".properties"))
                        continue;
                    FileInputStream fin = new FileInputStream(each);
                    InputStreamReader reader = new InputStreamReader(fin, "utf-8");
                    properties.load(reader);
                }
                return properties;
            } else {
                FileInputStream fin = new FileInputStream(file);
                InputStreamReader reader = new InputStreamReader(fin, "utf-8");
                properties.load(reader);
                return properties;
            }
        } catch (Exception e) {
            throw new RuntimeException("加载配置文件异常", e);
        }
    }
    /**
     * 加载配置文件
     * @param file
     * @return
     */
    public static Properties loadProperties(File file){
        try {
            if (!file.getName().endsWith(".properties"))
                return properties;
            properties = properties == null ? new Properties() : properties;
            FileInputStream fin=new FileInputStream(file);
            InputStreamReader reader=new InputStreamReader(fin,"utf-8");
            properties.load(reader);
            return properties;
        }catch (Exception e){
            throw new RuntimeException("加载配置文件异常",e);
        }
    }

    /**
     * 获取配置文件参数
     * @param key
     * @return
     */
    public static String get(String key){
        return null == properties ? load().getProperty(key) : properties.getProperty(key);
    }

    public static void main(String[] args) {
        String s = get("1");
        System.err.println(s);
    }
}
