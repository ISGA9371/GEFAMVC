package com.bbva.bancomer.business.repository;

import com.bbva.bancomer.business.model.Level_;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LevelRepository_ extends JpaRepository<Level_, Integer> {
}
