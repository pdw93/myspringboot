package com.ssnail.myspringboot.freemarker;

import freemarker.cache.FileTemplateLoader;
import freemarker.cache.TemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author pengdengwang
 * @since 2020/4/27
 */
public class FreeMarkerTest {



    @Test
    public void fileTemplateLoader() throws Exception {
        // freemarker配置类
        Configuration cfg = new Configuration();

        // 模版加载器
        TemplateLoader loader = new FileTemplateLoader(new File("templates"));
        cfg.setTemplateLoader(loader);

        // 获取模版
        Template template = cfg.getTemplate("testFreeMarker.ftl");

        // 构造数据模型
        Map<String, Object> dataModel = new HashMap<>();
        dataModel.put("templateName", "testFreeMarker.ftl");
        dataModel.put("ifFlag",1);
        List<String> names = new ArrayList<>();
        names.add("zhangsan");
        names.add("lisi");
        names.add("wangwu");
        dataModel.put("names", names);

        // 文件输出
        // 1 文件输出
        FileWriter writer = new FileWriter(new File("/Users/souche/Desktop/ssh/freemarker/testFreeMarker.txt"));
        template.process(dataModel, writer);
    }
}
