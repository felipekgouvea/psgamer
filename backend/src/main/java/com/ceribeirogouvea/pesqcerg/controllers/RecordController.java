package com.ceribeirogouvea.pesqcerg.controllers;

import java.net.URI;
import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ceribeirogouvea.pesqcerg.dto.RecordDTO;
import com.ceribeirogouvea.pesqcerg.dto.RecordInsertDTO;
import com.ceribeirogouvea.pesqcerg.services.RecordService;

@RestController
@RequestMapping(value = "/records")
public class RecordController {

	@Autowired
	private RecordService service;

	@GetMapping
	public ResponseEntity<Page<RecordDTO>> findAll(
			@RequestParam(value = "min", defaultValue = "") String min,
			@RequestParam(value = "max", defaultValue = "") String max,
			Pageable pageable){	
		
		Instant minDate = ("".equals(min) ? null : Instant.parse(min));
		Instant maxDate = ("".equals(max) ? null : Instant.parse(max));
		
		Page<RecordDTO> list = service.findByMoment(minDate, maxDate, pageable);
		return ResponseEntity.ok().body(list);
	}
	
	@PostMapping
	public ResponseEntity<RecordDTO> insert(@RequestBody RecordInsertDTO dto) {
		RecordDTO newDTO = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getGameId()).toUri();
		return ResponseEntity.created(uri).body(newDTO);
	}

}
