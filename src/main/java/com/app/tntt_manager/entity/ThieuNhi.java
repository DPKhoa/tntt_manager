package com.app.tntt_manager.entity;

import com.app.tntt_manager.enums.TrangThaiThieuNhi;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "thieu_nhi")
@Getter
@Setter
@NoArgsConstructor
public class ThieuNhi {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "ten_thanh", length = 50)
    private String tenThanh;

    @Column(name = "ho_va_ten", length = 100, nullable = false)
    private String hoVaTen;

    @Column(name = "ngay_sinh", nullable = false)
    private LocalDate ngaySinh;

    @Column(name = "gioi_tinh", length = 10, nullable = false)
    private String gioiTinh;

    @Enumerated(EnumType.STRING)
    @JdbcTypeCode(SqlTypes.NAMED_ENUM)
    @Column(name = "trang_thai", nullable = false, columnDefinition = "trang_thai_thieu_nhi")
    private TrangThaiThieuNhi trangThai = TrangThaiThieuNhi.DANG_HOC;
}
