package com.cenfotec.cenfoteca.controllers;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cenfotec.cenfoteca.contracts.RentResponse;
import com.cenfotec.cenfoteca.contracts.TipoUsuarioResponse;
import com.cenfotec.cenfoteca.ejb.Alquiler;
import com.cenfotec.cenfoteca.ejb.TipoUsuario;
import com.cenfotec.cenfoteca.services.TipoUsuarioServiceInterface;
import com.cenfotec.cenfoteca.services.UsersServiceInterface;
import com.cenfotec.cenfoteca.utils.Utils;

@RestController
@RequestMapping(value ="rest/protected/tipoUsuario")
public class TipoUsuarioController {
	@Autowired private ServletContext servletContext;
	@Autowired private UsersServiceInterface usersService;
	@Autowired private TipoUsuarioServiceInterface tipoUsuarioService;
	@Autowired private HttpServletRequest request;
	
	@RequestMapping(value ="/getAll", method = RequestMethod.GET)
	public TipoUsuarioResponse getAll(){
	TipoUsuarioResponse response = new TipoUsuarioResponse();

	response.setTipoUsuarioList(tipoUsuarioService.getAll());
	return response;		
   }
	
	
	@RequestMapping(value ="/create", method = RequestMethod.POST)
	public TipoUsuarioResponse create(
			@RequestParam("idTipoUsuario") int idTipoUsuario,
			@RequestParam("tipo") String tipo){	
		
		    TipoUsuarioResponse us = new TipoUsuarioResponse();
			TipoUsuario tipoUsuario = new TipoUsuario();
			
			if(tipoUsuario.getIdTipoUsuario() == tipoUsuario.getIdTipoUsuario() ){
				tipoUsuario.setTipo(tipo);
				tipoUsuario.setIdTipoUsuario(idTipoUsuario);
			    tipoUsuarioService.addTipoUsuario(tipoUsuario);
			}else{
				tipoUsuario.setTipo(tipo);
			    tipoUsuarioService.addTipoUsuario(tipoUsuario);
			}
			
			//Boolean state = tipoUsuarioService.addTipoUsuario(tipoUsuario);
		
		    return us;		
	}
	
	@RequestMapping(value ="/delete", method = RequestMethod.DELETE)
	public void delete(
			@RequestParam("idTipoUsuario") int idTipoUsuario){	
		
		    tipoUsuarioService.deleteTipoUsuario(idTipoUsuario);
			
	}
	
}
