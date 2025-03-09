package com.example.springboot.service.impl;

import com.example.springboot.entity.AppointmentEntity;
import com.example.springboot.mapper.AppointmentMapper;
import com.example.springboot.service.AppointmentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 预约表 服务实现类
 * </p>
 *
 * @author he
 * @since 2023-12-25
 */
@Service
public class AppointmentServiceImpl extends ServiceImpl<AppointmentMapper, AppointmentEntity> implements AppointmentService {

}
