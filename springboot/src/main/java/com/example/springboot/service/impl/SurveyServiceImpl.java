package com.example.springboot.service.impl;

import com.example.springboot.entity.SurveyEntity;
import com.example.springboot.mapper.SurveyMapper;
import com.example.springboot.service.SurveyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 调研表 服务实现类
 * </p>
 *
 * @author he
 * @since 2023-12-25
 */
@Service
public class SurveyServiceImpl extends ServiceImpl<SurveyMapper, SurveyEntity> implements SurveyService {

}
