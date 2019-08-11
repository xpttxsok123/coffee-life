package com.coffee.life.ucenter.dao;

import com.coffee.life.ucenter.entity.XcUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by jay.
 */
public interface XcUserRepository extends JpaRepository<XcUser,String> {
    //根据账号查询用户信息
    XcUser findByUsername(String username);
}
