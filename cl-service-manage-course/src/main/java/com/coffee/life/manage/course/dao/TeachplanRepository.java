package com.coffee.life.manage.course.dao;

import com.coffee.life.framework.domain.course.Teachplan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by jay.
 */
public interface TeachplanRepository extends JpaRepository<Teachplan,String> {

    //根据课程id和parentid查询teachplan，SELECT * FROM teachplan a WHERE a.courseid ='4028e581617f945f01617f9dabc40000' AND a.parentid='0'
    public List<Teachplan> findByCourseidAndParentid(String courseId,String parentId);
}
