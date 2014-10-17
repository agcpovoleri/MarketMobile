package com.marketmobile.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.marketmobile.model.vo.CategoriaVo;
import com.marketmobile.service.CategoryService;

@Controller
@RequestMapping("/menu")
public class MenuController {
	
	@Autowired
	private CategoryService categoryService;

    @RequestMapping( value = "/category", method = RequestMethod.GET )
    public @ResponseBody List<CategoriaVo> getSubCategories() {      

    	List<CategoriaVo> superCategories = new ArrayList<CategoriaVo>();
		try {
			superCategories = categoryService.findAllSuperCategoriesVo();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return superCategories;     
    }
}
