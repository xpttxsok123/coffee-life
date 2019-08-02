package com.coffee.life.framework.domain.portalview;

import com.coffee.life.framework.domain.course.CourseMarket;
import com.coffee.life.framework.domain.course.CoursePic;
import com.coffee.life.framework.domain.course.ext.TeachplanNode;
import com.coffee.life.framework.domain.course.CourseBase;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data
@ToString
@Document(collection = "pre_view_course")
public class PreViewCourse implements Serializable{

    @Id
    private String id;
    private CourseBase courseBase;
    private CourseMarket courseMarket;
    private CoursePic coursePic;
    private TeachplanNode teachplan;

}
