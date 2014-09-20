package com.marketmobile.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.marketmobile.model.vo.CardapioVo;
import com.marketmobile.model.vo.ItemCardapioVo;
import com.marketmobile.model.vo.PedidoVo;
import com.marketmobile.service.CardapioService;


@Controller
@RequestMapping("/pedido")
public class PedidoController {
	
	@Autowired
	private CardapioService cardapioService;
	
	private Logger logger = org.slf4j.LoggerFactory.getLogger(PedidoController.class);

	@InitBinder
	public void initBinder(WebDataBinder binder) {

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public @ResponseBody String create(HttpServletRequest request, @RequestParam PedidoVo pedidoVo){

		logger.info("Controller success! Param: [PedidoVo]: "+pedidoVo.toString());

		return "";
		
	}
	   
}
