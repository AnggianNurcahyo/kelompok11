package com.example.ga.kelompok11.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Peminjaman {
    @Id
    @Column(name = "IdPeminjaman")
    private String IdPeminjaman;
    @Column(name = "NPK")
    private String NPK;
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    @Column(name = "TglPeminjaman")
    private LocalDateTime TglPeminjaman;
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    @Column(name = "TglPengembalian")
    private LocalDateTime TglPengembalian;
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    @Column(name = "LastModifiedTime")
    private LocalDateTime LastModifiedTime;
    @Column(name = "AcceptedBy")
    private String AcceptedBy;
    @Column(name = "ModifiedBy")
    private String ModifiedBy;
    @Column(name = "Status")
    private Integer Status;
    @Column(name = "IsLate")
    private Integer IsLate;
    @Column(name = "Denda")
    private Integer Denda;
    @Column(name = "StatusDenda")
    private String StatusDenda;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "NPK", referencedColumnName = "NPK", insertable = false, updatable = false)
    private Karyawan karyawanList;

    public String getIdPeminjaman() {
        return IdPeminjaman;
    }

    public void setIdPeminjaman(String idPeminjaman) {
        IdPeminjaman = idPeminjaman;
    }

    public String getNPK() {
        return NPK;
    }

    public void setNPK(String NPK) {
        this.NPK = NPK;
    }

    public LocalDateTime getTglPeminjaman() {
        return TglPeminjaman;
    }

    public void setTglPeminjaman(LocalDateTime tglPeminjaman) {
        TglPeminjaman = tglPeminjaman;
    }

    public LocalDateTime getTglPengembalian() {
        return TglPengembalian;
    }

    public void setTglPengembalian(LocalDateTime tglPengembalian) {
        TglPengembalian = tglPengembalian;
    }

    public LocalDateTime getLastModifiedTime() {
        return LastModifiedTime;
    }

    public void setLastModifiedTime(LocalDateTime lastModifiedTime) {
        LastModifiedTime = lastModifiedTime;
    }

    public String getAcceptedBy() {
        return AcceptedBy;
    }

    public void setAcceptedBy(String acceptedBy) {
        AcceptedBy = acceptedBy;
    }

    public String getModifiedBy() {
        return ModifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        ModifiedBy = modifiedBy;
    }

    public Integer getStatus() {
        return Status;
    }

    public void setStatus(Integer status) {
        Status = status;
    }

    public Integer getIsLate() {
        return IsLate;
    }

    public void setIsLate(Integer isLate) {
        IsLate = isLate;
    }

    public Integer getDenda() {
        return Denda;
    }

    public void setDenda(Integer denda) {
        Denda = denda;
    }

    public String getStatusDenda() {
        return StatusDenda;
    }

    public void setStatusDenda(String statusDenda) {
        StatusDenda = statusDenda;
    }

    public Karyawan getKaryawanList() {
        return karyawanList;
    }

    public void setKaryawanList(Karyawan karyawanList) {
        this.karyawanList = karyawanList;
    }
}
