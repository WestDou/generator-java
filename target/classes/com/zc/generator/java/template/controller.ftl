package com.shudailaoshi.web.controller.${moduleName};

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shudailaoshi.entity.${moduleName}.${entityName};
import com.shudailaoshi.pojo.query.${moduleName}.${entityName}Query;
import com.shudailaoshi.pojo.annotation.Comment;
import com.shudailaoshi.pojo.vos.common.ResultVO;
import com.shudailaoshi.service.${moduleName}.${entityName}Service;
import com.shudailaoshi.web.controller.base.BaseController;
import com.shudailaoshi.web.utils.ResultUtil;

@RequestMapping("${moduleName}/${packageName}")
@RestController
public class ${entityName}Controller extends BaseController {

	@Autowired
	private ${entityName}Service ${packageName}Service;

	/**
	 * ��ѯ${serviceName}
 	 * 
	 * @createAuthor ${generatorName}
	 * @createDate ${currentDate}
	 * @modifyAuthor ${generatorName}
	 * @modifyDate ${currentDate}
 	 * @param ${packageName}Query
	 * @param start
	 * @param limit
	 * @return
	 */
	@GetMapping("page${entityName}")
	public ResultVO page${entityName}(${entityName}Query ${packageName}Query, Integer start, Integer limit) {
		try {
			return ResultUtil.success(this.${packageName}Service.page${entityName}(${packageName}Query, start, limit));
		} catch (Exception e) {
			return ResultUtil.error(log, e);
		}
	}

	/**
	 * ����${serviceName}
	 * 
	 * @createAuthor ${generatorName}
	 * @createDate ${currentDate}
	 * @modifyAuthor ${generatorName}
	 * @modifyDate ${currentDate}
	 * @param ${packageName}
	 * @return
	 */
	@Comment("����${serviceName}")
	@PostMapping("save${entityName}")
	public ResultVO save${entityName}(${entityName} ${packageName}) {
		try {
			this.${packageName}Service.save${entityName}(${packageName});
			return ResultUtil.success();
		} catch (Exception e) {
			return ResultUtil.error(log, e);
		}
	}
	
	/**
	 * ����${serviceName}
	 * 
	 * @createAuthor ${generatorName}
	 * @createDate ${currentDate}
	 * @modifyAuthor ${generatorName}
	 * @modifyDate ${currentDate}
	 * @param ${packageName}
	 * @return
	 */
	@Comment("����${serviceName}")
	@PostMapping("update${entityName}")
	public ResultVO update${entityName}(${entityName} ${packageName}) {
		try {
			this.${packageName}Service.update${entityName}(${packageName});
			return ResultUtil.success();
		} catch (Exception e) {
			return ResultUtil.error(log, e);
		}
	}

	/**
	 * ɾ��${serviceName}
	 * 
	 * @createAuthor ${generatorName}
	 * @createDate ${currentDate}
	 * @modifyAuthor ${generatorName}
	 * @modifyDate ${currentDate}
	 * @param id
	 * @return
	 */
	@Comment("ɾ��${serviceName}")
	@PostMapping("remove${entityName}")
	public ResultVO remove${entityName}(long id) {
		try {
			this.${packageName}Service.remove${entityName}(id);
			return ResultUtil.success();
		} catch (Exception e) {
			return ResultUtil.error(log, e);
		}
	}

	/**
	 * ����
	 * 
	 * @createAuthor ${generatorName}
	 * @createDate ${currentDate}
	 * @modifyAuthor ${generatorName}
	 * @modifyDate ${currentDate}
	 * @param id
	 * @return
	 */
	@Comment("����${serviceName}")
	@PostMapping("freeze")
	public ResultVO freeze(long id) {
		try {
			this.${packageName}Service.freeze(id);
			return ResultUtil.success();
		} catch (Exception e) {
			return ResultUtil.error(log, e);
		}
	}

	/**
	 * �ⶳ${serviceName}
	 * 
	 * @createAuthor ${generatorName}
	 * @createDate ${currentDate}
	 * @modifyAuthor ${generatorName}
	 * @modifyDate ${currentDate}
	 * @param id
	 * @return
	 */
	@Comment("�ⶳ${serviceName}")
	@PostMapping("unfreeze")
	public ResultVO unfreeze(long id) {
		try {
			this.${packageName}Service.unfreeze(id);
			return ResultUtil.success();
		} catch (Exception e) {
			return ResultUtil.error(log, e);
		}
	}

}