package com.coffee.life.ucenter.dao;

import com.coffee.life.ucenter.entity.XcMenu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by jay.
 */
@Mapper
public interface XcMenuMapper {
    //根据用户id查询用户的权限
    public List<XcMenu> selectPermissionByUserId(String userid);
}
