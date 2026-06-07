package com.app.tntt_manager.repository;

import com.app.tntt_manager.entity.ThieuNhi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ThieuNhiRepository extends JpaRepository<ThieuNhi, UUID> {
}
