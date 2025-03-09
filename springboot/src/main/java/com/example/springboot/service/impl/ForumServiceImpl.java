package com.example.springboot.service.impl;

import com.example.springboot.entity.ForumEntity;
import com.example.springboot.mapper.ForumMapper;
import com.example.springboot.service.ForumService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 论坛表 服务实现类
 * </p>
 *
 * @author he
 * @since 2023-12-25
 */
@Service
public class ForumServiceImpl extends ServiceImpl<ForumMapper, ForumEntity> implements ForumService {

}
