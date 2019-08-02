package com.coffee.life.manage.course.dao;

import com.coffee.life.framework.domain.course.TeachplanMediaPub;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by jay.
 */
public interface TeachplanMediaPubRepository extends JpaRepository<TeachplanMediaPub,String> {
    //根据课程id删除记录
    long deleteByCourseId(String courseId);
}
