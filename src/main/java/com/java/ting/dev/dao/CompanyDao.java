package com.java.ting.dev.dao;


import com.java.ting.dev.entity.Company;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CompanyDao {
    // 插入
    int insert(Company company);

    // 删除
    void delete(Company company);

    // 获取总数
    int count();

    // 批量插入
    void insertAll(List<Company> companyList);

    // 删除所有
    void deleteAll();
}
