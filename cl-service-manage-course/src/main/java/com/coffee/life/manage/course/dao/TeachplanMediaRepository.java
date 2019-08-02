package com.coffee.life.manage.course.dao;

import com.coffee.life.framework.domain.course.TeachplanMedia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by jay.
 */
public interface TeachplanMediaRepository extends JpaRepository<TeachplanMedia,String> {
    //根据课程id查询列表
    List<TeachplanMedia> findByCourseId(String courseId);
}
