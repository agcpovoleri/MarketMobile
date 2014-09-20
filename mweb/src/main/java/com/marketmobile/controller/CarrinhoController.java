package com.marketmobile.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.marketmobile.controller.beans.FormUsuario;


@Controller
public class CarrinhoController {
	
	Logger logger = LoggerFactory.getLogger(CarrinhoController.class);

	@InitBinder
	public void initBinder(WebDataBinder binder) {

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
	
	@RequestMapping(value="/cart", method=RequestMethod.GET)
	public String index(HttpServletRequest request, Model model) {

		logger.info("Controller success! Param: [idCategory]: ");

		model.addAttribute("teste", new Date());
		model.addAttribute(new FormUsuario());
		
		return "/content/carrinho/cart";
	}
	
	@RequestMapping(value="/checkout", method=RequestMethod.GET)
	public String checkout(HttpServletRequest request, Model model) {

		return "/content/carrinho/checkout";
	}
   
}
