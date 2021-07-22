package com.example.ga.kelompok11.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class JenisBank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdJenisBank")
    private Integer IdJenisBank;
    @Column(name = "NamaBank")
    private String NamaBank;
    @Column(name = "Keterangan")
    private String Keterangan;
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    @Column(name = "CreatedTime")
    private LocalDateTime CreatedTime;
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    @Column(name = "LastModifiedTime")
    private LocalDateTime LastModifiedTime;
    @Column(name = "CreatedBy")
    private String CreatedBy;
    @Column(name = "ModifiedBy")
    private String ModifiedBy;
    @Column(name = "RowStatus")
    private Integer RowStatus;

    public Integer getIdJenisBank() {
        return IdJenisBank;
    }

    public void setIdJenisBank(Integer idJenisBank) {
        IdJenisBank = idJenisBank;
    }

    public String getNamaBank() {
        return NamaBank;
    }

    public void setNamaBank(String namaBank) {
        NamaBank = namaBank;
    }

    public String getKeterangan() {
        return Keterangan;
    }

    public void setKeterangan(String keterangan) {
        Keterangan = keterangan;
    }

    public LocalDateTime getCreatedTime() {
        return CreatedTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        CreatedTime = createdTime;
    }

    public LocalDateTime getLastModifiedTime() {
        return LastModifiedTime;
    }

    public void setLastModifiedTime(LocalDateTime lastModifiedTime) {
        LastModifiedTime = lastModifiedTime;
    }

    public String getCreatedBy() {
        return CreatedBy;
    }

    public void setCreatedBy(String createdBy) {
        CreatedBy = createdBy;
    }

    public String getModifiedBy() {
        return ModifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        ModifiedBy = modifiedBy;
    }

    public Integer getRowStatus() {
        return RowStatus;
    }

    public void setRowStatus(Integer rowStatus) {
        RowStatus = rowStatus;
    }
}
