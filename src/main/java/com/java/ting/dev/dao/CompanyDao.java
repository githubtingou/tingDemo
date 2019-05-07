package com.java.ting.dev.dao;


import com.java.ting.dev.entity.Company;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CompanyDao {
    /**
     * 插入
     * @param  company
     * @return
     */
    int insert(Company company);

    /**
     * 删除
     * @param id
     * @return
     */
    void deleteById(@Param(value = "id") String id);

    /**
     * 获取总数
     * @return
     */
    int count();

    /**
     * 批量插入
     * @param companyList
     * @return
     */
    void insertCompany(List<Company> companyList);

    /**
     * 删除所有
     */
    void deleteAll();
}
