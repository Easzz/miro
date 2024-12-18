package com.example.caseProject.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StandardReceiveVo {

	private Standard standard;

	private List<StandardFile> files;

}
