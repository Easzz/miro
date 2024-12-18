package com.findshen.modules.bz.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@TableName("bz_people")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class People {
	/**
	 * <p>
	 * 主键策略6种：
	 * AUTO(0),
	 * NONE(1),
	 * INPUT(2),
	 * ID_WORKER(3),
	 * UUID(4),
	 * ID_WORKER_STR(5);
	 */
	@TableId(type = IdType.AUTO)
	private Long id;

	@TableField("name")
	private String name;

	private Integer age;

	private String email;

	private Long managerId;

	private Date createTime;

	@Version
	private Integer version;

	/**
	 * 排除非表字段的三种方式
	 * 1、private transient String remark; 无法序列化
	 * 2、private static String remark; 实例无法独有一份
	 * 3、@TableField(exist=false)
	 */
	@TableField(exist = false)
	private String remark;


	/**
	 * 管理者姓名
	 */
	@TableField(exist = false)
	private String managerName;

	/**
	 * 管理者年龄
	 */
	@TableField(exist = false)
	private String managerAge;
}
