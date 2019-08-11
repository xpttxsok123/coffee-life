package com.coffee.life.ucenter.dao;

import com.coffee.life.ucenter.entity.XcCompanyUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by jay.
 */
public interface XcCompanyUserRepository extends JpaRepository<XcCompanyUser,String> {
    //根据用户id查询该用户所属的公司id
    XcCompanyUser findByUserId(String userId);
}
