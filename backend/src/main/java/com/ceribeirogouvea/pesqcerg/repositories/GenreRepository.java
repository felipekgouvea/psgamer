package com.ceribeirogouvea.pesqcerg.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ceribeirogouvea.pesqcerg.entities.Genre;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long>{

}
