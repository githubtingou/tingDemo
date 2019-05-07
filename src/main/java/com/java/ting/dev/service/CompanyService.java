package com.java.ting.dev.service;

import com.java.ting.application.utils.UUIDUtil;
import com.java.ting.dev.dao.CompanyDao;
import com.java.ting.dev.entity.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

/**
 * 公司Service
 *
 * @author TingOu
 */
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class CompanyService {
    @Autowired
    private CompanyDao dao;



    /**
     * 插入数据
     */
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public void insert(Company company) {
        if (company.getId() == null) {
            company.setId(UUID.randomUUID().toString().replaceAll("-", ""));
        }
        dao.insert(company);
    }

    /**
     * 获取总数
     */
    public int count() {
        return dao.count();
    }

    /**
     * 循环插入所有数据
     */
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public void insertAll(List<Company> companyList) {
        for (int i = 0; i < companyList.size(); i++) {
            if (companyList.get(i).getId() == null) {
                companyList.get(i).setId(UUIDUtil.getUUID());
            }

        }
        dao.insertCompany(companyList);
    }

    /**
     * 删除所有
     */
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public void deleteAll() {
        dao.deleteAll();
    }
}
