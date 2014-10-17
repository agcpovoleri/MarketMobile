package com.marketmobile.controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.event.ListSelectionEvent;

import javassist.NotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.google.common.collect.Lists;
import com.marketmobile.model.vo.CategoriaItemVo;
import com.marketmobile.model.vo.CategoriaVo;
import com.marketmobile.service.CategoryService;

@Controller
@RequestMapping("/category")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;

	private Logger logger = LoggerFactory.getLogger(ProductController.class);

	@RequestMapping(method = RequestMethod.GET)
    public @ResponseBody List<CategoriaVo> getAll() {   
        
		List<CategoriaVo> simpleCategoryList = new ArrayList<CategoriaVo>();
		try {
			simpleCategoryList = categoryService.findAllVo();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		logger.info(simpleCategoryList.toString());
		
		return simpleCategoryList; 
    }

    @RequestMapping( value = "/{id}", method = RequestMethod.GET )
    public @ResponseBody List<CategoriaItemVo> getById(@PathVariable Long id ) {      

    	List<CategoriaItemVo> itemsCategoria = categoryService.findItensByCategoria(id);
    	List<CategoriaItemVo> newList = itemsCategoria;
    	
    	for (int i = 0; i < 10; i++) {
    		itemsCategoria.addAll(newList);
		}
    	
    	return itemsCategoria;     
    }
    
    @Secured(value="ROLE_ADMIN")
    @RequestMapping( value = "/{id}", method = RequestMethod.DELETE )
    @ResponseStatus( value = HttpStatus.NO_CONTENT )	
    public void delete(@PathVariable Integer id ) throws NotFoundException {     
    	categoryService.delete(id);      
    }

}
