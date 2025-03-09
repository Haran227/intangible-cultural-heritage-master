package com.example.springboot.mapper;

import com.example.springboot.entity.ForumEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 论坛表 Mapper 接口
 * </p>
 *
 * @author he
 * @since 2023-12-25
 */
@Mapper
public interface ForumMapper extends BaseMapper<ForumEntity> {

}
