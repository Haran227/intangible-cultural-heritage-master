package com.example.springboot.service.impl;

import com.example.springboot.entity.CollectionEntity;
import com.example.springboot.mapper.CollectionMapper;
import com.example.springboot.service.CollectionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 收藏表 服务实现类
 * </p>
 *
 * @author he
 * @since 2023-12-25
 */
@Service
public class CollectionServiceImpl extends ServiceImpl<CollectionMapper, CollectionEntity> implements CollectionService {

}
