package com.marketmobile.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.marketmobile.model.vo.CardapioVo;
import com.marketmobile.model.vo.ItemCardapioVo;
import com.marketmobile.service.CardapioService;


@Controller
@RequestMapping("/cardapio")
public class CardapioController {
	
	@Autowired
	private CardapioService cardapioService;
	
	Logger logger = LoggerFactory.getLogger(CardapioController.class);

	@InitBinder
	public void initBinder(WebDataBinder binder) {

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
	
    @RequestMapping( value = "/{id}", method = RequestMethod.GET )
    public @ResponseBody CardapioVo getById(@PathVariable Long id ) {      
    	CardapioVo cardapio = cardapioService.getByIdCardapio(id);
    	return cardapio;     
    }
    
    @RequestMapping( value = "/categoria/{idCategoria}", method = RequestMethod.GET )
    public @ResponseBody List<ItemCardapioVo> getItensCategoriaCardapioByIdCategoria(@PathVariable Long idCategoria ) {      
    	
    	List<ItemCardapioVo> listItensByCategoria = cardapioService.getItensCategoriaCardapioByIdCategoria(idCategoria);
    	return listItensByCategoria;     
    }
   
}
