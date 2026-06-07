package com.app.tntt_manager.dto.response;

import com.app.tntt_manager.enums.TrangThaiThieuNhi;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@Builder
public class ThieuNhiResponseDTO {
    private UUID id;
    private String tenThanh;
    private String hoVaTen;
    private LocalDate ngaySinh;
    private String gioiTinh;
    private TrangThaiThieuNhi trangThai;
}
