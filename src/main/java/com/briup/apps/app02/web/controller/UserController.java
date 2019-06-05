package com.briup.apps.app02.web.controller;


import com.briup.apps.app02.bean.User;
import com.briup.apps.app02.service.IUserService;
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
@RequestMapping("/user")
public class UserController {
@Autowired

private IUserService userService;

    @ApiOperation("find all info")
    @GetMapping("findAll")
    public Message findAll(){
        List<User> list=userService.findAll();
    return MessageUtil.success("success",list);
}

    @ApiOperation("find info by id")
    @GetMapping("findById")
    public Message findById(@ApiParam(value="primarykey",required = true) @RequestParam(value = "id") long id){
        User user=userService.findById(id);
        return MessageUtil.success("success",user);
    }

    @ApiOperation("save or update info")
    @GetMapping("saveOrUpdate")
    public Message saveOrUpdate (User user){
        try{
            userService.saveOrUpdate(user);
        return MessageUtil.success("success");}
        catch (Exception e){
            e.printStackTrace();
            return MessageUtil.error(e.getMessage());
        }
    }

    @ApiOperation("instinct find")
    @GetMapping("query")
    public Message query(User user){
        List<User> list=userService.query(user);

        return MessageUtil.success("success",list);
    }

    @ApiOperation("delete info by id")
    @GetMapping("deleteById")
    public Message deleteById(@ApiParam(value="primarykey",required = true) @RequestParam(value = "id") long id){
       try{
           userService.deleteById(id);
           return MessageUtil.success("success");
    }
       catch (Exception e) {
       e.printStackTrace();
       return MessageUtil.error(e.getMessage());
       }
    }
}
