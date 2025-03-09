package com.example.springboot.service.impl;

import com.example.springboot.entity.EstateEntity;
import com.example.springboot.mapper.EstateMapper;
import com.example.springboot.service.EstateService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 遗产类别表 服务实现类
 * </p>
 *
 * @author he
 * @since 2023-12-25
 */
@Service
public class EstateServiceImpl extends ServiceImpl<EstateMapper, EstateEntity> implements EstateService {

}
