package com.app.tntt_manager.dto.request;

import com.app.tntt_manager.enums.TrangThaiThieuNhi;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ThieuNhiRequestDTO {

    @Size(max = 50)
    private String tenThanh;

    @NotBlank(message = "Họ và tên không được để trống")
    @Size(max = 100)
    private String hoVaTen;

    @NotNull(message = "Ngày sinh không được để trống")
    private LocalDate ngaySinh;

    @NotBlank(message = "Giới tính không được để trống")
    @Size(max = 10)
    private String gioiTinh;

    private TrangThaiThieuNhi trangThai;
}
