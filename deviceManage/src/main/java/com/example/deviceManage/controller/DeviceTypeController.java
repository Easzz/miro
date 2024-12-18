package com.example.deviceManage.controller;

/**
 * Created by shenxuan on 2021/5/28 11:51
 */

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.deviceManage.config.R;
import com.example.deviceManage.entity.DeviceType;
import com.example.deviceManage.service.DeviceTypeService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/type")
public class DeviceTypeController {

	@Autowired
	private DeviceTypeService deviceTypeService;

	@GetMapping("/list")
	public R<IPage<DeviceType>> list(Integer page,Integer limit,DeviceType deviceType) {
		if (page==null||limit==null){
			page=1;
			limit=Integer.MAX_VALUE;
		}

		IPage list = deviceTypeService.page(new Page<>(page,limit), new QueryWrapper<DeviceType>()
				.like(StringUtils.isNotBlank(deviceType.getTypeName()), "type_name", deviceType.getTypeName())
				.orderByAsc("type_name")
		);

		return R.ok(list);
	}


	@PostMapping("/save")
	public R save(DeviceType deviceType) {
		Integer count = deviceTypeService.count(new QueryWrapper<DeviceType>()
				.eq("type_name", deviceType.getTypeName())
		);
		if (count > 0) {
			return R.failed("已存在重复记录");
		}

		deviceType.insert();
		return R.ok();
	}


//
//	@GetMapping("/getProjectList")
//	public R<List<Project>> getProjectList(Integer page, Integer limit, String projectName) {
//
//		if (page == null || limit == null) {
//			page = 1;
//			limit = Integer.MAX_VALUE;
//		}
//
//		IPage<Project> projectIPage = projectMapper.selectPage(new Page<>(page, limit), new QueryWrapper<Project>()
//				.like(StringUtils.isNotBlank(projectName), "project_name", projectName)
//				.orderByDesc("id"));
//		return new R<>(projectIPage.getRecords());
//	}
//
//
//	@GetMapping("/getProjectByName")
//	public R<List<Project>> getFacilityList(String projectName) {
//
//		return new R<>(projectMapper.selectList(new QueryWrapper<Project>()
//				.like("project_name", projectName)
//		));
//	}
//
//
//	/**
//	 * map 按 key 升序排序
//	 */
//	private static Map<String,  List<ProjectItemSub>> sortByKey(Map<String,  List<ProjectItemSub>> map) {
//		Map<String,  List<ProjectItemSub>> result = new LinkedHashMap<>(map.size());
//		map.entrySet().stream()
//				.sorted(Map.Entry.comparingByKey())
//				.forEachOrdered(e -> result.put(e.getKey(), e.getValue()));
//		return result;
//	}
//
//
//	@GetMapping("/getListByProjectId")
//	public R<List<ProjectItem>> getFacilityList(Long projectId) {
////		List<ProjectItemSub> projectItems = projectItemMapper.buildList(projectId);
//
//		List<ProjectItemSub> projectItems = projectItemSubMapper.selectList(new QueryWrapper<ProjectItemSub>()
//				.eq("project_id", projectId)
//		);
//
//
//		List<ProjectItem> result = new ArrayList<>();
//
//		//首先根据设备分组
//		Map<String, List<ProjectItemSub>> driveMap = projectItems.stream().collect(Collectors.groupingBy(ProjectItemSub::getDriveName, Collectors.toList()));
//
//		Map<String, List<ProjectItemSub>> driveMapSort = sortByKey(driveMap);
//
//
//		for (String s : driveMapSort.keySet()) {
//
//			List<ProjectItemSub> projectItemSubs = driveMapSort.get(s);
//			Map<String, List<ProjectItemSub>> manufacturerMap = projectItemSubs.stream().collect(Collectors.groupingBy(ProjectItemSub::getManufacturer, Collectors.toList()));
//
//			//根据厂商分组
//			for (String manufacturerKey : manufacturerMap.keySet()) {
//				ProjectItem item = new ProjectItem();
//				item.setDriveName(s);
//
//				item.setManufacturer(manufacturerKey);
//
//				List<ProjectItemSub> projectItemSubs1 = manufacturerMap.get(manufacturerKey);
//
//				String description = projectItemSubs1.get(0).getDescription();
//				if (StringUtils.isBlank(description)){
//					item.setDescription("-");
//				}else {
//					item.setDescription(description);
//				}
//
//				//根据平台分组
//
//				Map<String, List<ProjectItemSub>> platformMap = projectItemSubs1.stream().collect(Collectors.groupingBy(ProjectItemSub::getPlatform, Collectors.toList()));
//
//				for (String platformKey : platformMap.keySet()) {
//
//					List<ProjectItemSub> sub = platformMap.get(platformKey);
//
//					if (platformKey.equalsIgnoreCase("win7")) {
//						item.setWin7SubList(sub);
//					}
//					if (platformKey.equalsIgnoreCase("win10")) {
//						item.setWin10SubList(sub);
//					}
//
//				}
//				result.add(item);
//
//			}
//
//
//		}
//
////		System.out.println(result);
//		return new R<>(result);
//	}


}
