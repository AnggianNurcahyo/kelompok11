package com.example.ga.kelompok11.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class Karyawan {
    @Id
    @Column(name = "NPK")
    private String NPK;
    @Column(name = "NamaKaryawan")
    private String NamaKaryawan;
    @Column(name = "JenisKelamin")
    private String JenisKelamin;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "TanggalLahir")
    private Date TanggalLahir;
    @Column(name = "Alamat")
    private String Alamat;
    @Column(name = "Email")
    private String Email;
    @Column(name = "NoTelepon")
    private String NoTelepon;
    @Column(name = "IdRole")
    private Integer IdRole;
    @Column(name = "IdSeksi")
    private Integer IdSeksi;
    @Column(name = "Password")
    private String Password;
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
    @JoinColumn(name = "IdRole", referencedColumnName = "IdRole", insertable = false, updatable = false)
    private Role roleList;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "IdSeksi", referencedColumnName = "IdSeksi", insertable = false, updatable = false)
    private Seksi seksiList;

    public String getNPK() {
        return NPK;
    }

    public Role getRoleList() {
        return roleList;
    }

    public void setRoleList(Role roleList) {
        this.roleList = roleList;
    }

    public Seksi getSeksiList() {
        return seksiList;
    }

    public void setSeksiList(Seksi seksiList) {
        this.seksiList = seksiList;
    }

    public void setNPK(String NPK) {
        this.NPK = NPK;
    }

    public String getNamaKaryawan() {
        return NamaKaryawan;
    }

    public void setNamaKaryawan(String namaKaryawan) {
        NamaKaryawan = namaKaryawan;
    }

    public String getJenisKelamin() {
        return JenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        JenisKelamin = jenisKelamin;
    }

    public Date getTanggalLahir() {
        return TanggalLahir;
    }

    public void setTanggalLahir(Date tanggalLahir) {
        TanggalLahir = tanggalLahir;
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

    public Integer getIdRole() {
        return IdRole;
    }

    public void setIdRole(Integer idRole) {
        IdRole = idRole;
    }

    public Integer getIdSeksi() {
        return IdSeksi;
    }

    public void setIdSeksi(Integer idSeksi) {
        IdSeksi = idSeksi;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
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

    public String getFoto() {
        return Foto;
    }

    public void setFoto(String foto) {
        Foto = foto;
    }

    @Column(name = "Foto")
    private String Foto;
}
