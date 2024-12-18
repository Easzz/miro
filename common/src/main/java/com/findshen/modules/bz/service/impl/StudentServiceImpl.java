package com.findshen.modules.bz.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.findshen.modules.bz.dao.StudentDao;
import com.findshen.modules.bz.entity.Student;
import com.findshen.modules.bz.service.StudentService;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl extends ServiceImpl<StudentDao, Student> implements StudentService {
}
