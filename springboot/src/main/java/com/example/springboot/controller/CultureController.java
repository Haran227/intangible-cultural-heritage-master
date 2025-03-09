package com.example.springboot.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.common.resp.Result;
import com.example.springboot.entity.CultureEntity;
import com.example.springboot.entity.EstateEntity;
import com.example.springboot.mapper.CultureMapper;
import com.example.springboot.mapper.EstateMapper;
import com.example.springboot.service.CultureService;
import com.example.springboot.service.EstateService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * 文化遗产表 前端控制器
 * </p>
 *
 * @author he
 * @since 2023-12-25
 */
@Tag(name = "文化遗产") // Swagger 标签，用于 API 文档分类
@RestController // 标记该类为 RESTful 控制器
@RequestMapping("/cultureEntity") // 定义该控制器的根路径为 "/cultureEntity"
public class CultureController {
    @Autowired // 自动注入 CultureMapper，用于数据库操作
    private CultureMapper cultureMapper;
    @Autowired // 自动注入 CultureService，用于业务逻辑处理
    private CultureService cultureService;
    @Autowired // 自动注入 EstateMapper，用于数据库操作
    private EstateMapper estateMapper;
    @Autowired // 自动注入 EstateService，用于业务逻辑处理
    private EstateService estateService;

    @Operation(summary = "遗产分页列表") // Swagger 注解，描述 API 功能
    @GetMapping("/list") // 处理 GET 请求，路径为 "/cultureEntity/list"
    public Result<List<CultureEntity>> pageCulture(@RequestParam Integer current, @RequestParam Integer size) {
        // 创建分页对象，current 为当前页码，size 为每页大小
        Page<CultureEntity> page = new Page<>(current, size);
        // 查询分页数据
        Page<CultureEntity> entityPage = cultureMapper.selectPage(page, null);
        // 返回分页结果
        return Result.success(entityPage);
    }

    @Operation(summary = "获取地图数据") // Swagger 注解，描述 API 功能
    @GetMapping("/map") // 处理 GET 请求，路径为 "/cultureEntity/map"
    public Result<List<CultureEntity>> mapCulture(@RequestParam String city) {
        // 创建一个空的列表，用于存储地图数据
        ArrayList<Object> list = new ArrayList<>();
        // 获取遗产类别的总数
        long num = estateService.count();
        // 遍历每个遗产类别
        for (int i = 1; i <= num; i++) {
            // 创建查询条件，筛选指定城市和类别的文化遗产
            QueryWrapper<CultureEntity> wrapper = new QueryWrapper<>();
            wrapper.eq("city", city).eq("category", i);
            // 查询指定类别的遗产信息
            QueryWrapper<EstateEntity> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("id", i);
            EstateEntity byId = estateService.getOne(queryWrapper);
            // 统计符合条件的文化遗产数量
            Long count = cultureMapper.selectCount(wrapper);
            // 将类别和数量存入 Map
            HashMap<String, String> map = new HashMap<>();
            map.put("label", byId.getCategory());
            map.put("count", count.toString());
            // 将 Map 添加到列表中
            list.add(map);
        }
        // 返回地图数据
        return Result.success(list);
    }
}