package com.example.globalhistorybe.repository;

import com.example.globalhistorybe.entity.HistoricalEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoricalEventRepository extends JpaRepository<HistoricalEvent, Long> {
}
