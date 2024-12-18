
package com.findshen.modules.bz.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.findshen.modules.bz.entity.Student;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StudentDao extends BaseMapper<Student> {
	
}
