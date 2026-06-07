package com.app.tntt_manager.controller;

import com.app.tntt_manager.dto.request.ThieuNhiRequestDTO;
import com.app.tntt_manager.dto.response.ThieuNhiResponseDTO;
import com.app.tntt_manager.service.ThieuNhiService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/thieu-nhi")
@RequiredArgsConstructor
public class ThieuNhiController {

    private final ThieuNhiService thieuNhiService;

    @PostMapping
    public ResponseEntity<ThieuNhiResponseDTO> createThieuNhi(@Valid @RequestBody ThieuNhiRequestDTO requestDTO) {
        return new ResponseEntity<>(thieuNhiService.createThieuNhi(requestDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ThieuNhiResponseDTO> updateThieuNhi(@PathVariable UUID id, @Valid @RequestBody ThieuNhiRequestDTO requestDTO) {
        return ResponseEntity.ok(thieuNhiService.updateThieuNhi(id, requestDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ThieuNhiResponseDTO> getThieuNhiById(@PathVariable UUID id) {
        return ResponseEntity.ok(thieuNhiService.getThieuNhiById(id));
    }

    @GetMapping
    public ResponseEntity<List<ThieuNhiResponseDTO>> getAllThieuNhi() {
        return ResponseEntity.ok(thieuNhiService.getAllThieuNhi());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteThieuNhi(@PathVariable UUID id) {
        thieuNhiService.deleteThieuNhi(id);
        return ResponseEntity.noContent().build();
    }
}
