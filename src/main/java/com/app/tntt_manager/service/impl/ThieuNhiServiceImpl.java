package com.app.tntt_manager.service.impl;

import com.app.tntt_manager.dto.request.ThieuNhiRequestDTO;
import com.app.tntt_manager.dto.response.ThieuNhiResponseDTO;
import com.app.tntt_manager.entity.ThieuNhi;
import com.app.tntt_manager.exception.ResourceNotFoundException;
import com.app.tntt_manager.repository.ThieuNhiRepository;
import com.app.tntt_manager.service.ThieuNhiService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ThieuNhiServiceImpl implements ThieuNhiService {

    private final ThieuNhiRepository thieuNhiRepository;

    @Override
    @Transactional
    public ThieuNhiResponseDTO createThieuNhi(ThieuNhiRequestDTO requestDTO) {
        ThieuNhi thieuNhi = new ThieuNhi();
        mapDtoToEntity(requestDTO, thieuNhi);
        thieuNhi = thieuNhiRepository.save(thieuNhi);
        return mapEntityToResponseDTO(thieuNhi);
    }

    @Override
    @Transactional
    public ThieuNhiResponseDTO updateThieuNhi(UUID id, ThieuNhiRequestDTO requestDTO) {
        ThieuNhi thieuNhi = thieuNhiRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ThieuNhi not found with id: " + id));
        mapDtoToEntity(requestDTO, thieuNhi);
        thieuNhi = thieuNhiRepository.save(thieuNhi);
        return mapEntityToResponseDTO(thieuNhi);
    }

    @Override
    @Transactional(readOnly = true)
    public ThieuNhiResponseDTO getThieuNhiById(UUID id) {
        ThieuNhi thieuNhi = thieuNhiRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ThieuNhi not found with id: " + id));
        return mapEntityToResponseDTO(thieuNhi);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ThieuNhiResponseDTO> getAllThieuNhi() {
        return thieuNhiRepository.findAll().stream()
                .map(this::mapEntityToResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void deleteThieuNhi(UUID id) {
        ThieuNhi thieuNhi = thieuNhiRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ThieuNhi not found with id: " + id));
        thieuNhiRepository.delete(thieuNhi);
    }

    private void mapDtoToEntity(ThieuNhiRequestDTO dto, ThieuNhi entity) {
        entity.setTenThanh(dto.getTenThanh());
        entity.setHoVaTen(dto.getHoVaTen());
        entity.setNgaySinh(dto.getNgaySinh());
        entity.setGioiTinh(dto.getGioiTinh());
        if (dto.getTrangThai() != null) {
            entity.setTrangThai(dto.getTrangThai());
        }
    }

    private ThieuNhiResponseDTO mapEntityToResponseDTO(ThieuNhi entity) {
        return ThieuNhiResponseDTO.builder()
                .id(entity.getId())
                .tenThanh(entity.getTenThanh())
                .hoVaTen(entity.getHoVaTen())
                .ngaySinh(entity.getNgaySinh())
                .gioiTinh(entity.getGioiTinh())
                .trangThai(entity.getTrangThai())
                .build();
    }
}
