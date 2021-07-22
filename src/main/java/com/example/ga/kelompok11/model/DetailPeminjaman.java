package com.example.ga.kelompok11.model;

import org.springframework.data.relational.core.sql.In;

import javax.persistence.*;

@Entity
public class DetailPeminjaman {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdDetailP")
    private Integer IdDetailP;
    @Column(name = "IdPeminjaman")
    private String IdPeminjaman;
    @Column(name = "IdBarangP")
    private Integer IdBarangP;
    @Column(name = "Kuantitas")
    private Integer Kuantitas;
    @Column(name = "HargaBarang")
    private Integer HargaBarang;
    @Column(name = "KondisiBarang")
    private Integer KondisiBarang;
    @Column(name = "Keterangan")
    private String Keterangan;

    public Integer getIdDetailP() {
        return IdDetailP;
    }

    public void setIdDetailP(Integer idDetailP) {
        IdDetailP = idDetailP;
    }

    public String getIdPeminjaman() {
        return IdPeminjaman;
    }

    public void setIdPeminjaman(String idPeminjaman) {
        IdPeminjaman = idPeminjaman;
    }

    public Integer getIdBarangP() {
        return IdBarangP;
    }

    public void setIdBarangP(Integer idBarangP) {
        IdBarangP = idBarangP;
    }

    public Integer getKuantitas() {
        return Kuantitas;
    }

    public void setKuantitas(Integer kuantitas) {
        Kuantitas = kuantitas;
    }

    public Integer getHargaBarang() {
        return HargaBarang;
    }

    public void setHargaBarang(Integer hargaBarang) {
        HargaBarang = hargaBarang;
    }

    public Integer getKondisiBarang() {
        return KondisiBarang;
    }

    public void setKondisiBarang(Integer kondisiBarang) {
        KondisiBarang = kondisiBarang;
    }

    public String getKeterangan() {
        return Keterangan;
    }

    public void setKeterangan(String keterangan) {
        Keterangan = keterangan;
    }
}
