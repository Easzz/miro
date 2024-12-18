package com.example.caseProject.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.caseProject.entity.CaseProjectFile;
import com.example.caseProject.mapper.CaseProjectFileMapper;
import com.example.caseProject.service.CaseProjectFileService;
import org.springframework.stereotype.Service;

@Service
public class CaseProjectFileServiceImpl extends ServiceImpl<CaseProjectFileMapper, CaseProjectFile> implements CaseProjectFileService {
}
