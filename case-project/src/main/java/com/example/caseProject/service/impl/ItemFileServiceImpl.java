package com.example.caseProject.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.caseProject.entity.ItemFile;
import com.example.caseProject.mapper.ItemFileMapper;
import com.example.caseProject.service.ItemFileService;
import org.springframework.stereotype.Service;

@Service
public class ItemFileServiceImpl extends ServiceImpl<ItemFileMapper, ItemFile> implements ItemFileService {
}
