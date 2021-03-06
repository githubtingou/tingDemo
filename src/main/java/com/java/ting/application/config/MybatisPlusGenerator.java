package com.java.ting.application.config;

import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.java.ting.application.config.generator.GeneratorDo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * <p>
 * mysql mybatis-plus代码生成器演示例子
 * </p>
 *
 * @author Tingou
 * @since 2018-09-12
 */
public class MybatisPlusGenerator {

    @Value("${spring.datasource.url}")
    public static String DRIVER;
    @Value("${spring.datasource.url}")
    public static String URL;
    @Value("${spring.datasource.username}")
    public static String USERNAME;
    @Value("${spring.datasource.password}")
    public static String PASSWORD;


    /**
     * 自动代码生成
     * @param generatorDo
     */
    public static void generator(GeneratorDo generatorDo) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();
        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        // 设置文件生成路径
        gc.setOutputDir(projectPath + generatorDo.getPath());
        // 作者
        gc.setAuthor(generatorDo.getAuthor());
        // 文件是否覆盖
        gc.setFileOverride(true);
        gc.setOpen(false);
        // 是否生成基本的resultMap
        gc.setBaseResultMap(true);
        // 是否生成基本的SQL片段
        gc.setBaseColumnList(true);
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl(URL);
        // dsc.setSchemaName("public");
        dsc.setDriverName(DRIVER);
        dsc.setUsername(USERNAME);
        dsc.setPassword(PASSWORD);
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
        // 模块名
        pc.setModuleName(generatorDo.getModelName());
        pc.setParent("com.baomidou.mybatisplus.samples.generator");
        mpg.setPackageInfo(pc);

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义XML文件
        focList.add(new FileOutConfig("/templates/mapper.xml.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输入文件名称
                return projectPath + "/mybatis-plus-sample-generator/src/main/resources/mapper/" + pc.getModuleName()
                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);
        mpg.setTemplate(new TemplateConfig().setXml(null));

        // 自定义前端页面
        // focList.add(new FileOutConfig("/templatesMybatis/list.html.vm") {
        //      @Override
        //      public String outputFile(TableInfo tableInfo) {
        //          // 自定义输入文件名称
        //          return "E://test//html//" + tableInfo.getEntityName() + "ListIndex.html";
        //      }
        // });
        // cfg.setFileOutConfigList(focList);
        // mpg.setCfg(cfg);


        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        // 全局大写命名数据源为Oracle加上
        // strategy.setCapitalMode(true);
        // 表名生成策略
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        // 自定义实体类父类
        strategy.setSuperEntityClass("com.baomidou.mybatisplus.samples.generator.common.BaseEntity");
        // 实体类是否使用Lombok
        strategy.setEntityLombokModel(true);
        // 自定义Controller类父类
        strategy.setSuperControllerClass("com.baomidou.mybatisplus.samples.generator.common.BaseController");
        strategy.setInclude(generatorDo.getTableName());
        strategy.setSuperEntityColumns("id");
        strategy.setControllerMappingHyphenStyle(true);
        // 表前缀
        strategy.setTablePrefix(pc.getModuleName() + "_");
        mpg.setStrategy(strategy);
        // 选择 freemarker 引擎需要指定如下加，注意 pom 依赖必须有！
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }

}
