package com.myhome.web;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.myhome.web.dept.model.DeptDTO;
import com.myhome.web.dept.service.DeptService;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private DeptService deptService;
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(Model model) {
		logger.info("Welcome index!");
		
		List<DeptDTO> deptDatas = deptService.getAll();
		
		model.addAttribute("deptDatas", deptDatas);
		
		return "index";
	}
	
}
