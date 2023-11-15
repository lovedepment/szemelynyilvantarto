package com.kesmarki.szemelynyilvantarto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kesmarki.szemelynyilvantarto.model.Szemely;

public interface SzemelyRepository extends JpaRepository<Szemely, Long> {

}
