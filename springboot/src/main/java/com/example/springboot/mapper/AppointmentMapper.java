package com.example.springboot.mapper;

import com.example.springboot.entity.AppointmentEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 预约表 Mapper 接口
 * </p>
 *
 * @author he
 * @since 2023-12-25
 */
@Mapper
public interface AppointmentMapper extends BaseMapper<AppointmentEntity> {

}
