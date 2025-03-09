package com.example.springboot.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.common.resp.Result;
import com.example.springboot.entity.UserEntity;
import com.example.springboot.mapper.UserMapper;
import com.example.springboot.req.LoginReq;
import com.example.springboot.req.UserReq;
import com.example.springboot.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author he
 * @since 2023-12-25
 */
@Tag(name = "用户") // Swagger 标签，用于 API 文档分类
@RestController // 标记该类为 RESTful 控制器
@RequestMapping("/userEntity") // 定义该控制器的根路径为 "/userEntity"
public class UserController {
    @Autowired // 自动注入 UserMapper，用于数据库操作
    private UserMapper userMapper;
    @Autowired // 自动注入 UserService，用于业务逻辑处理
    private UserService userService;

    @Operation(summary = "用户登录") // Swagger 注解，描述 API 功能
    @PostMapping("/login") // 处理 POST 请求，路径为 "/userEntity/login"
    public Result login(@RequestBody @Validated LoginReq param, HttpSession session) {
        // 创建查询条件，检查账号是否存在
        QueryWrapper<UserEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("acc", param.getAcc());
        if (userMapper.selectCount(wrapper) == 0) {
            return Result.failure("账号不存在");
        }
        // 检查密码是否正确
        if (!userService.getOne(wrapper).getPwd().equals(param.getPwd())) {
            return Result.failure("密码错误");
        }
        // 检查验证码是否正确
        if (!(session.getAttribute("code").toString().equals(param.getCode()))) {
            return Result.failure("验证码错误");
        }
        // 获取用户信息
        UserEntity user = userService.getOne(wrapper);
        // 返回登录结果
        return Result.success(user);
    }

    @Operation(summary = "用户注册") // Swagger 注解，描述 API 功能
    @PostMapping("/regist") // 处理 POST 请求，路径为 "/userEntity/regist"
    public Result regist(@RequestBody @Validated UserReq param) {
        // 设置注册时间
        param.setCreateTime(String.valueOf(new Date()));
        // 检查账号是否已存在
        if (existUser(param)) {
            return Result.failure("账号已存在");
        }
        // 将请求参数复制到 UserEntity 对象
        UserEntity user = new UserEntity();
        BeanUtils.copyProperties(param, user);
        // 保存用户信息
        if (userService.save(user)) {
            return Result.success("注册成功");
        }
        return Result.failure("注册失败，请稍后重试");
    }

    @Operation(summary = "用户修改信息") // Swagger 注解，描述 API 功能
    @PostMapping("/change") // 处理 POST 请求，路径为 "/userEntity/change"
    public Result change(@RequestBody @Validated UserReq param) {
        // 检查账号是否存在
        if (!existUser(param)) {
            return Result.failure("账号不存在");
        }
        // 创建查询条件
        QueryWrapper<UserEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("acc", param.getAcc());
        // 更新用户信息
        if (userService.update(wrapper)) {
            return Result.success("注册成功");
        }
        return Result.failure("注册失败，请稍后重试");
    }

    @Operation(summary = "账号是否存在") // Swagger 注解，描述 API 功能
    @PostMapping("/exist") // 处理 POST 请求，路径为 "/userEntity/exist"
    public boolean existUser(@RequestBody @Validated UserReq param) {
        // 创建查询条件，检查账号是否存在
        QueryWrapper<UserEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("acc", param.getAcc());
        if (userService.count(wrapper) == 0) {
            return false;
        }
        return true;
    }

    @Operation(summary = "根据账号查找") // Swagger 注解，描述 API 功能
    @PostMapping("/detail") // 处理 POST 请求，路径为 "/userEntity/detail"
    public Result<UserEntity> detailUser(@RequestBody @Validated UserReq param) {
        // 检查账号是否存在
        if (!existUser(param)) {
            return Result.failure("用户不存在");
        }
        // 创建查询条件，查找用户信息
        QueryWrapper<UserEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("acc", param.getAcc());
        UserEntity userEntity = userService.getOne(wrapper);
        // 返回用户信息
        return Result.success(userEntity);
    }

    @Operation(summary = "用户列表") // Swagger 注解，描述 API 功能
    @GetMapping("/list") // 处理 GET 请求，路径为 "/userEntity/list"
    public Result<List<UserEntity>> listUser() {
        // 获取所有用户列表
        List<UserEntity> userEntityList = userService.list();
        // 返回用户列表
        return Result.success(userEntityList);
    }
}