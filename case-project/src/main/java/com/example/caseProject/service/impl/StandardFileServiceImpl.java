package com.example.caseProject.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.caseProject.entity.StandardFile;
import com.example.caseProject.mapper.StandardFileMapper;
import com.example.caseProject.service.StandardFileService;
import org.springframework.stereotype.Service;

@Service
public class StandardFileServiceImpl extends ServiceImpl<StandardFileMapper, StandardFile> implements StandardFileService {
}
