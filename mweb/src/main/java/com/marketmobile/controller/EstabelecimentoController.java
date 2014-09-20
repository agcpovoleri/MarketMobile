package com.marketmobile.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javassist.NotFoundException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.marketmobile.model.vo.CategoriaVo;
import com.marketmobile.model.vo.InfoEstabelecimentoVo;
import com.marketmobile.model.vo.UsuarioLoginVo;
import com.marketmobile.service.EstabelecimentoService;


@Controller
@RequestMapping("/estabelecimento")
public class EstabelecimentoController {
	
	@Autowired
	private EstabelecimentoService estabelecimentoService;

	private Logger logger = LoggerFactory.getLogger(EstabelecimentoController.class);

	@InitBinder
	public void initBinder(WebDataBinder binder) {

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
	
	@RequestMapping(method = RequestMethod.GET)
    public @ResponseBody List<CategoriaVo> getAll(@RequestParam( value = "type", required = false ) String type) {   
        List<CategoriaVo> estabelecimentos = estabelecimentoService.findAllVo();   
        logger.info(estabelecimentos.toString());
        return estabelecimentos; 
    }

    @RequestMapping( value = "/{id}", method = RequestMethod.GET )
    public @ResponseBody InfoEstabelecimentoVo getById(@PathVariable Long id ) {      
    	InfoEstabelecimentoVo infoEstabelecimentoVo = estabelecimentoService.findById(id);
    	infoEstabelecimentoVo.setCategoriasMenu(estabelecimentoService.findCategoriasMenuById(id));
    	return infoEstabelecimentoVo;     
    }
    
    @RequestMapping( value = "/{id}", method = RequestMethod.DELETE )
    @ResponseStatus( value = HttpStatus.NO_CONTENT )
    public void delete(@PathVariable Integer id ) throws NotFoundException {     
    	estabelecimentoService.delete(id);      
    }
    
    @RequestMapping(method = RequestMethod.POST )
	@ResponseStatus(value = HttpStatus.CREATED)
	public @ResponseBody String persist( @RequestBody UsuarioLoginVo usuario ) {
    	
    	return null;
    }

	@RequestMapping(value="/update", method=RequestMethod.PUT)
	public @ResponseBody InfoEstabelecimentoVo update(HttpServletRequest request, @RequestParam InfoEstabelecimentoVo place){

		logger.info("Controller success! Param: [idEstabelecimento]:"+place.getId());
		return place;
		
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
    public @ResponseBody List<CategoriaVo> searchByAll(@RequestParam String strSearch) {   
       
    	List<CategoriaVo> estabelecimentos = estabelecimentoService.findBy(strSearch);   
        logger.info(estabelecimentos.toString());
        return estabelecimentos; 
    }
    
}
