package com.briup.apps.app02.service;

import com.briup.apps.app02.bean.Course;
import java.util.List;

public interface ICourseService {

    List<Course> findAll();
    List<Course> query(Course course);
    Course findById(long id);
    void deleteById(long id) throws Exception;
    void saveOrUpdate(Course course) throws Exception;
}
