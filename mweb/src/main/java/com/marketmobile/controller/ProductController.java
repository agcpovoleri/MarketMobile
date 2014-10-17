package com.marketmobile.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javassist.NotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.marketmobile.controller.beans.ProductVo;
import com.marketmobile.controller.beans.SimpleProductVo;
import com.marketmobile.model.vo.CategoriaVo;
import com.marketmobile.model.vo.InfoEstabelecimentoVo;
import com.marketmobile.model.vo.UsuarioLoginVo;
import com.marketmobile.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;

	private Logger logger = LoggerFactory.getLogger(ProductController.class);

	@InitBinder
	public void initBinder(WebDataBinder binder) {

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
	
	@RequestMapping(method = RequestMethod.GET)
    public @ResponseBody List<SimpleProductVo> getAllSimpleDescriptionProducts() {   
        List<SimpleProductVo> simpleProductList = new ArrayList<SimpleProductVo>();
        logger.info(simpleProductList.toString());
        return simpleProductList; 
    }

    @RequestMapping( value = "/{id}", method = RequestMethod.GET )
    public @ResponseBody ProductVo getById(@PathVariable Long id ) {      
    	ProductVo productVo = new ProductVo();//productService.findById(id);
    	
    	return productVo;     
    }
    
    @Secured(value="ROLE_ADMIN")
    @RequestMapping( value = "/{id}", method = RequestMethod.DELETE )
    @ResponseStatus( value = HttpStatus.NO_CONTENT )
    public void delete(@PathVariable Integer id ) throws NotFoundException {     
    	productService.delete(id);      
    }
    
    @Secured(value="ROLE_ADMIN")
    @RequestMapping(method = RequestMethod.POST )
	@ResponseStatus(value = HttpStatus.CREATED)
	public @ResponseBody String persist( @RequestBody UsuarioLoginVo usuario ) {
    	
    	return null;
    }
}
