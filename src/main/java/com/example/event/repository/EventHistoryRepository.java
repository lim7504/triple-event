package com.example.event.repository;

import com.example.event.domain.EventHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EventHistoryRepository extends JpaRepository<EventHistory, UUID> {
}
