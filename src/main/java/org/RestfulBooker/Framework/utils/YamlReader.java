package org.RestfulBooker.Framework.utils;

import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Map;

public class YamlReader {

    public YamlReader() {
    }

    public static String readKey(String key, String filePath) throws FileNotFoundException {
        String filePath2 = System.getProperty("user.dir")+"/src/main/resources/"+filePath;
        InputStream inputStream = new FileInputStream(new File(filePath2));

        Yaml yaml = new Yaml();
        Map<String, Object> data = yaml.load(inputStream);
        return (String) data.get(key);
    }
// To check the key
//    public static void main(String[] args) throws FileNotFoundException {
//        System.out.println(YamlReader.readKey("url","data.yaml"));
//    }
}


