package com.zc.generator.java;

import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;

import com.zc.generator.base.BaseGenerator;

import cn.hutool.core.date.DateUtil;
import freemarker.core.ParseException;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;

public class JavaGenerator extends BaseGenerator {public static void main(String[] args) {
	new JavaGenerator().generate("D:\\java", "msg", "History","��Ϣ��ʷ��","zhangcheng");
}

/**
 * ����java
 * 
 * @param generatePath
 * @param moduleName
 * @param entityName
 */
public void generate(String generatePath, String moduleName, String entityName, String serviceName,
		String generatorName) {
	try {
		moduleName = moduleName.toLowerCase();
		entityName = entityName.toUpperCase().charAt(0) + entityName.substring(1);
		String packageName = entityName.toLowerCase().charAt(0) + entityName.substring(1);
		System.out.println(DateUtil.now() + "==>>��ʼ����" + entityName + "Dao.java");
		this.generateDao(generatePath, moduleName, entityName, packageName, serviceName, generatorName);
		System.out.println(DateUtil.now() + "==>>��ʼ����" + entityName + "Service.java");
		this.generateService(generatePath, moduleName, entityName, packageName, serviceName, generatorName);
		System.out.println(DateUtil.now() + "==>>��ʼ����" + entityName + "ServiceImpl.java");
		this.generateServiceImpl(generatePath, moduleName, entityName, packageName, serviceName, generatorName);
		System.out.println(DateUtil.now() + "==>>��ʼ����" + entityName + "Controller.java");
		this.generateController(generatePath, moduleName, entityName, packageName, serviceName, generatorName);
	} catch (Exception e) {
		e.printStackTrace();
	}
}

private void generateDao(String generatePath, String moduleName, String entityName, String packageName, String serviceName,
		String generatorName)
		throws TemplateNotFoundException, MalformedTemplateNameException, ParseException, IOException,
		TemplateException {
	Map<String, String> params = new HashMap<String, String>();
	params.put("moduleName", moduleName);
	params.put("entityName", entityName);
	params.put("packageName", packageName);
	params.put("serviceName", serviceName);
	params.put("generatorName", generatorName);
	params.put("currentDate", DateUtil.now());
	System.out.println(DateUtil.now() + "==>>��ȡ" + entityName + "Dao.javaģ��");
	Template template = super.config.getTemplate("dao.ftl");
	String filePath = generatePath + "/" + this.getClass().getSimpleName() + "/" + entityName + "Dao.java";
	System.out.println(DateUtil.now() + "==>>д��" + entityName + "Dao.java");
	template.process(params, new OutputStreamWriter(FileUtils.openOutputStream(new File(filePath))));
	System.out.println(DateUtil.now() + "==>>" + filePath + "�������");
}

private void generateService(String generatePath, String moduleName, String entityName, String packageName, String serviceName,
		String generatorName)
		throws TemplateNotFoundException, MalformedTemplateNameException, ParseException, IOException,
		TemplateException {
	Map<String, String> params = new HashMap<String, String>();
	params.put("moduleName", moduleName);
	params.put("packageName", packageName);
	params.put("entityName", entityName);
	params.put("serviceName", serviceName);
	params.put("generatorName", generatorName);
	params.put("currentDate", DateUtil.now());
	System.out.println(DateUtil.now() + "==>>��ȡ" + entityName + "Service.javaģ��");
	Template template = super.config.getTemplate("service.ftl");
	String filePath = generatePath + "/" + this.getClass().getSimpleName() + "/" + entityName + "Service.java";
	System.out.println(DateUtil.now() + "==>>д��" + entityName + "Service.java");
	template.process(params, new OutputStreamWriter(FileUtils.openOutputStream(new File(filePath))));
	System.out.println(DateUtil.now() + "==>>" + filePath + "�������");
}

private void generateServiceImpl(String generatePath, String moduleName, String entityName, String packageName, String serviceName,
		String generatorName)
		throws TemplateNotFoundException, MalformedTemplateNameException, ParseException, IOException,
		TemplateException {
	Map<String, String> params = new HashMap<String, String>();
	params.put("moduleName", moduleName);
	params.put("entityName", entityName);
	params.put("packageName", packageName);
	System.out.println(DateUtil.now() + "==>>��ȡ" + entityName + "ServiceImpl.javaģ��");
	Template template = super.config.getTemplate("serviceImpl.ftl");
	String filePath = generatePath + "/" + this.getClass().getSimpleName() + "/" + entityName + "ServiceImpl.java";
	System.out.println(DateUtil.now() + "==>>д��" + entityName + "ServiceImpl.java");
	template.process(params, new OutputStreamWriter(FileUtils.openOutputStream(new File(filePath))));
	System.out.println(DateUtil.now() + "==>>" + filePath + "�������");
}

private void generateController(String generatePath, String moduleName, String entityName, String packageName, String serviceName,
		String generatorName)
		throws TemplateNotFoundException, MalformedTemplateNameException, ParseException, IOException,
		TemplateException {
	Map<String, String> params = new HashMap<String, String>();
	params.put("moduleName", moduleName);
	params.put("entityName", entityName);
	params.put("packageName", packageName);
	params.put("serviceName", serviceName);
	params.put("generatorName", generatorName);
	params.put("currentDate", DateUtil.now());
	System.out.println(DateUtil.now() + "==>>��ȡ" + entityName + "Controller.javaģ��");
	Template template = super.config.getTemplate("controller.ftl");
	String filePath = generatePath + "/" + this.getClass().getSimpleName() + "/" + entityName + "Controller.java";
	System.out.println(DateUtil.now() + "==>>д��" + entityName + "Controller.java");
	template.process(params, new OutputStreamWriter(FileUtils.openOutputStream(new File(filePath))));
	System.out.println(DateUtil.now() + "==>>" + filePath + "�������");
}
}
