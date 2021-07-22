package com.example.ga.kelompok11.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Vendor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdVendor")
    private Integer IdVendor;
    @Column(name = "NamaVendor")
    private String NamaVendor;
    @Column(name = "Alamat")
    private String Alamat;
    @Column(name = "Email")
    private String Email;
    @Column(name = "NoTelepon")
    private String NoTelepon;
    @Column(name = "NoRekening")
    private String NoRekening;
    @Column(name = "IdJenisBank")
    private Integer IdJenisBank;
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
    @JoinColumn(name = "IdJenisBank", referencedColumnName = "IdJenisBank", insertable = false, updatable = false)
    private JenisBank jenisBankList;

    public Integer getIdVendor() {
        return IdVendor;
    }

    public void setIdVendor(Integer idVendor) {
        IdVendor = idVendor;
    }

    public String getNamaVendor() {
        return NamaVendor;
    }

    public void setNamaVendor(String namaVendor) {
        NamaVendor = namaVendor;
    }

    public String getAlamat() {
        return Alamat;
    }

    public void setAlamat(String alamat) {
        Alamat = alamat;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getNoTelepon() {
        return NoTelepon;
    }

    public void setNoTelepon(String noTelepon) {
        NoTelepon = noTelepon;
    }

    public String getNoRekening() {
        return NoRekening;
    }

    public void setNoRekening(String noRekening) {
        NoRekening = noRekening;
    }

    public Integer getIdJenisBank() {
        return IdJenisBank;
    }

    public void setIdJenisBank(Integer idJenisBank) {
        IdJenisBank = idJenisBank;
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

    public JenisBank getJenisBankList() {
        return jenisBankList;
    }

    public void setJenisBankList(JenisBank jenisBankList) {
        this.jenisBankList = jenisBankList;
    }
}
