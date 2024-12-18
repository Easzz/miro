package com.example.caseProject.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@TableName("item")
@NoArgsConstructor
@AllArgsConstructor
public class Item extends Model<Item> {
	private static final long serialVersionUID = 1L;

	@TableId
	private Long id;
	private String itemName;

	@JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
	private Date itemDate;


	@TableField(exist = false)
	private String itemDateStr;


	private String person;
	private String detail;
	private String author;

	@TableField(exist = false)
	private List<ItemFile> files;


	private String fileUrl;
	private String realityName;

	private String remark;



	//	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	@TableField(value = "gmt_create", fill = FieldFill.INSERT)
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date gmtCreate;


	@TableField(value = "gmt_modified", fill = FieldFill.UPDATE)
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date gmtModified;

}
