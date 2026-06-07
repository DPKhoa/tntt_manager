package com.app.tntt_manager.service;

import com.app.tntt_manager.dto.request.ThieuNhiRequestDTO;
import com.app.tntt_manager.dto.response.ThieuNhiResponseDTO;

import java.util.List;
import java.util.UUID;

public interface ThieuNhiService {
    ThieuNhiResponseDTO createThieuNhi(ThieuNhiRequestDTO requestDTO);
    ThieuNhiResponseDTO updateThieuNhi(UUID id, ThieuNhiRequestDTO requestDTO);
    ThieuNhiResponseDTO getThieuNhiById(UUID id);
    List<ThieuNhiResponseDTO> getAllThieuNhi();
    void deleteThieuNhi(UUID id);
}
