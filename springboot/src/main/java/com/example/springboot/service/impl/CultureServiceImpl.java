package com.example.springboot.service.impl;

import com.example.springboot.entity.CultureEntity;
import com.example.springboot.mapper.CultureMapper;
import com.example.springboot.service.CultureService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 文化遗产表 服务实现类
 * </p>
 *
 * @author he
 * @since 2023-12-25
 */
@Service
public class CultureServiceImpl extends ServiceImpl<CultureMapper, CultureEntity> implements CultureService {

}
