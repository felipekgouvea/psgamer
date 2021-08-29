package com.ceribeirogouvea.pesqcerg.dto;

import java.io.Serializable;
import java.time.Instant;
import com.ceribeirogouvea.pesqcerg.entities.Record;
import com.ceribeirogouvea.pesqcerg.entities.enums.Platform;

public class RecordDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private Instant moment;
	private String name;
	private Integer age;
	private String gameTitle;
	private Platform gamePlatform;
	private String genreGame;

	public RecordDTO() {
	}

	public RecordDTO(Long id, Instant moment, String name, Integer age, String gameTitle, Platform gamePlatform,
			String genreGame) {
		this.id = id;
		this.moment = moment;
		this.name = name;
		this.age = age;
		this.gameTitle = gameTitle;
		this.gamePlatform = gamePlatform;
		this.genreGame = genreGame;
	}

	public RecordDTO(Record entity) {
		id = entity.getId();
		moment = entity.getMoment();
		name = entity.getName();
		age = entity.getAge();
		gameTitle = entity.getGame().getTitle();
		gamePlatform = entity.getGame().getPlatform();
		genreGame = entity.getGame().getGenre().getName();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getGameTitle() {
		return gameTitle;
	}

	public void setGameTitle(String gameTitle) {
		this.gameTitle = gameTitle;
	}

	public Platform getGamePlatform() {
		return gamePlatform;
	}

	public void setGamePlatform(Platform gamePlatform) {
		this.gamePlatform = gamePlatform;
	}

	public String getGenreGame() {
		return genreGame;
	}

	public void setGenreGame(String genreGame) {
		this.genreGame = genreGame;
	}

}
