package com.ceribeirogouvea.pesqcerg.services;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ceribeirogouvea.pesqcerg.dto.RecordDTO;
import com.ceribeirogouvea.pesqcerg.dto.RecordInsertDTO;
import com.ceribeirogouvea.pesqcerg.entities.Game;
import com.ceribeirogouvea.pesqcerg.entities.Record;
import com.ceribeirogouvea.pesqcerg.repositories.GameRepository;
import com.ceribeirogouvea.pesqcerg.repositories.RecordRepository;

@Service
public class RecordService {

	@Autowired
	RecordRepository recordRepository;

	@Autowired
	GameRepository gameRepository;
	
	@Transactional(readOnly = true)
	public Page<RecordDTO> findByMoment(Instant minDate, Instant maxDate, Pageable pageable){
		Page<Record> page = recordRepository.findByMoment(minDate, maxDate, pageable);		
		return page.map(x -> new RecordDTO(x));  
	}

	@Transactional
	public RecordDTO insert(RecordInsertDTO dto) {
		Record entity = new Record();

		entity.setName(dto.getName());
		entity.setAge(dto.getAge());
		entity.setMoment(Instant.now());

		Game game = gameRepository.getById(dto.getGameId());
		entity.setGame(game);

		entity = recordRepository.save(entity);
		return new RecordDTO(entity);
	}

}
