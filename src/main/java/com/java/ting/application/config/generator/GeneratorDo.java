package com.java.ting.application.config.generator;

/**
 * 代码生成类
 *
 * @author TongOu
 * @since 2019-04-29
 */
public class GeneratorDo {

    /**
     * 模块名
     **/
    private String modelName;
    /**
     * 作者
     **/
    private String author;
    /**
     * 路径
     **/
    private String path;
    /**
     * 表名
     **/
    private String tableName;

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }
}
