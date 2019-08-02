package com.coffee.life.framework.domain.course.ext;

import com.coffee.life.framework.domain.course.CourseBase;
import com.coffee.life.framework.domain.course.CourseMarket;
import com.coffee.life.framework.domain.course.CoursePic;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author jay
 * @version 1.0
 **/
@Data
@NoArgsConstructor
@ToString
public class CourseView implements java.io.Serializable {
    private CourseBase courseBase;
    private CoursePic coursePic;
    private CourseMarket courseMarket;
    private TeachplanNode teachplanNode;
}
