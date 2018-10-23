package com.edu.zucc.ygg.movie.controller;

import com.edu.zucc.ygg.movie.constant.ApplicationConstant;
import com.edu.zucc.ygg.movie.dto.ResultDto;
import com.edu.zucc.ygg.movie.dto.UserDto;
import com.edu.zucc.ygg.movie.service.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/user/register",method = RequestMethod.POST)
    @ApiOperation(value = "用户注册")
    public ResultDto registerUser(@RequestBody UserDto userDto){
        return userService.registerUser(userDto);
    }

    @RequestMapping(value = "/user/updateUserInfo",method = RequestMethod.POST)
    @ApiOperation(value = "用户详细信息更新")
    @ApiImplicitParams({@ApiImplicitParam(name = ApplicationConstant.AUTHORIZATION, required = true, paramType = ApplicationConstant.HTTP_HEADER)})
    @RequiresRoles("user")
    public ResultDto updateUserInfo(@RequestBody UserDto userDto){
        return userService.updateUserInfo(userDto);
    }

    @RequestMapping(value = "/admin/register",method = RequestMethod.POST)
    @ApiOperation(value = "管理员注册")
    @ApiImplicitParams({@ApiImplicitParam(name = ApplicationConstant.AUTHORIZATION, required = true, paramType = ApplicationConstant.HTTP_HEADER)})
    @RequiresRoles("admin")
    @RequiresPermissions("root")
    public ResultDto registerAdmin(@RequestBody UserDto userDto){
        return userService.registerAdmin(userDto);
    }

    @RequestMapping(value = "/admin/delete",method = RequestMethod.GET)
    @RequiresRoles("admin")
    @RequiresPermissions("root")
    public ResultDto deleteAdmin(@RequestParam int adminId){
        return userService.deleteAdmin(adminId);
    }
}
