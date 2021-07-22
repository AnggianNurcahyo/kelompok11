package com.example.ga.kelompok11.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class BarangVendor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdBarangV")
    private Integer IdBarangV;
    @Column(name = "NamaBarangV")
    private String NamaBarangV;
    @Column(name = "Keterangan")
    private String Keterangan;
    @Column(name = "IdJenisBarang")
    private Integer IdJenisBarang;
    @Column(name = "IdVendor")
    private Integer IdVendor;
    @Column(name = "Harga")
    private Integer Harga;
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

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "IdJenisBarang", referencedColumnName = "IdJenisBarang", insertable = false, updatable = false)
    private JenisBarang jenisBarangList;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "IdVendor", referencedColumnName = "IdVendor", insertable = false, updatable = false)
    private Vendor vendorList;

    public Integer getIdBarangV() {
        return IdBarangV;
    }

    public void setIdBarangV(Integer idBarangV) {
        IdBarangV = idBarangV;
    }

    public String getNamaBarangV() {
        return NamaBarangV;
    }

    public void setNamaBarangV(String namaBarangV) {
        NamaBarangV = namaBarangV;
    }

    public String getKeterangan() {
        return Keterangan;
    }

    public void setKeterangan(String keterangan) {
        Keterangan = keterangan;
    }

    public Integer getIdJenisBarang() {
        return IdJenisBarang;
    }

    public void setIdJenisBarang(Integer idJenisBarang) {
        IdJenisBarang = idJenisBarang;
    }

    public Integer getIdVendor() {
        return IdVendor;
    }

    public void setIdVendor(Integer idVendor) {
        IdVendor = idVendor;
    }

    public Integer getHarga() {
        return Harga;
    }

    public void setHarga(Integer harga) {
        Harga = harga;
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

    public JenisBarang getJenisBarangList() {
        return jenisBarangList;
    }

    public void setJenisBarangList(JenisBarang jenisBarangList) {
        this.jenisBarangList = jenisBarangList;
    }

    public Vendor getVendorList() {
        return vendorList;
    }

    public void setVendorList(Vendor vendorList) {
        this.vendorList = vendorList;
    }
}
