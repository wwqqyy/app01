package com.briup.apps.app02.web.controller;


import com.briup.apps.app02.bean.Course;
import com.briup.apps.app02.service.ICourseService;
import com.briup.apps.app02.utils.Message;
import com.briup.apps.app02.utils.MessageUtil;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {
@Autowired
    private ICourseService courseService;

    @ApiOperation("find all info")
    @GetMapping("findAll")
    public Message findAll(){
        List<Course> list=courseService.findAll();
        return MessageUtil.success("success",list);
    }

    @ApiOperation("find info by id")
    @GetMapping("findById")
    public Message findById(@ApiParam(value="primarykey",required = true) @RequestParam(value = "id") long id){
        Course course=courseService.findById(id);
        return MessageUtil.success("success",course);
    }

    @ApiOperation("save or update info")
    @GetMapping("saveorupdate")
    public Message saveOrUpdate(Course course){
        try{
            courseService.saveOrUpdate(course);
            return MessageUtil.success("success");
        }
        catch (Exception e){
            e.printStackTrace();
            return MessageUtil.error(e.getMessage());
        }
    }

    @ApiOperation("instinct find")
    @GetMapping("query")
    public Message query(Course course){
        List<Course> list=courseService.query(course);
        System.out.println();
        return MessageUtil.success("success",list);
    }

    @ApiOperation("delete info by id")
    @GetMapping("deleteById")
    public Message deleteById(@ApiParam(value="primarykey",required = true) @RequestParam(value = "id") long id){
        try{
            courseService.deleteById(id);
            return MessageUtil.success("success");
        }
        catch (Exception e) {
            e.printStackTrace();
            return MessageUtil.error(e.getMessage());
        }
    }
    }

