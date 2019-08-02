package com.coffee.life.manage.course.dao;

import com.coffee.life.framework.domain.course.CoursePic;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by jay.
 */
public interface CoursePicRepository extends JpaRepository<CoursePic,String> {
    //当返回值大于0，表示删除成功的记录数
    long deleteByCourseid(String courseId);
}
