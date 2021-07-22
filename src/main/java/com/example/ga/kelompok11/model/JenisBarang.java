package com.example.ga.kelompok11.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class JenisBarang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdJenisBarang")
    private Integer IdJenisBarang;
    @Column(name = "NamaBarang")
    private String NamaBarang;
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

    public Integer getIdJenisBarang() {
        return IdJenisBarang;
    }

    public void setIdJenisBarang(Integer idJenisBarang) {
        IdJenisBarang = idJenisBarang;
    }

    public String getNamaBarang() {
        return NamaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        NamaBarang = namaBarang;
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

    @Column(name = "RowStatus")
    private Integer RowStatus;
}
