package com.ceribeirogouvea.pesqcerg.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceribeirogouvea.pesqcerg.dto.GameDTO;
import com.ceribeirogouvea.pesqcerg.services.GameService;

@RestController
@RequestMapping(value = "/games")
public class GameController {
	
	@Autowired
	GameService service;
	
	@GetMapping
	public ResponseEntity<List<GameDTO>> findAll(){		
		List<GameDTO> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

}
