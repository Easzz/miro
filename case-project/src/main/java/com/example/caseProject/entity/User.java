package com.example.caseProject.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@TableName("user")
@NoArgsConstructor
@AllArgsConstructor
public class User extends Model<User> {
	private static final long serialVersionUID = 1L;

	@TableId
	private Long id;
	private String username;
	private String pwd;
	private Integer role;

	private Integer valid;

	private String realName;

	@TableField(exist = false)
	private List<Integer> permissionIds;


//	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	@TableField(value = "gmt_create", fill = FieldFill.INSERT)
	private Date gmtCreate;


	@TableField(value = "gmt_modified", fill = FieldFill.UPDATE)
	private Date gmtModified;
}
