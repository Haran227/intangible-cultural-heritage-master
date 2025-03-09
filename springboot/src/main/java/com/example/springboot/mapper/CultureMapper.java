package com.example.springboot.mapper;

import com.example.springboot.entity.CultureEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 文化遗产表 Mapper 接口
 * </p>
 *
 * @author he
 * @since 2023-12-25
 */
@Mapper
public interface CultureMapper extends BaseMapper<CultureEntity> {

}
