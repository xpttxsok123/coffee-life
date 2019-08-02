package com.coffee.life.manage.course.dao;

import com.github.pagehelper.Page;
import com.coffee.life.framework.domain.course.CourseBase;
import com.coffee.life.framework.domain.course.ext.CourseInfo;
import com.coffee.life.framework.domain.course.request.CourseListRequest;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by jay.
 */
@Mapper
public interface CourseMapper {
   CourseBase findCourseBaseById(String id);
   Page<CourseBase> findCourseList();
   //我的课程查询列表
   Page<CourseInfo> findCourseListPage(CourseListRequest courseListRequest);
}
