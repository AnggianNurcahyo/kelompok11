package com.example.ga.kelompok11.controllers;

import com.example.ga.kelompok11.model.BarangPerusahaan;
import com.example.ga.kelompok11.model.DetailPeminjaman;
import com.example.ga.kelompok11.service.BarangPerusahaanService;
import com.example.ga.kelompok11.service.Detail_peminjaman_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class Detail_peminjaman_controller {
    @Autowired
    Detail_peminjaman_service detailPeminjamanService;

    @Autowired
    BarangPerusahaanService barangPerusahaanService;

    @GetMapping("/Tambah-detail")
    public String goto_tambah_detail(
            @RequestParam("id") String idPeminjaman,
            Model model
    ){
        List<BarangPerusahaan> bp = barangPerusahaanService.getAllBarangPerusahaan();
        List<DetailPeminjaman> dp = detailPeminjamanService.getAllByIdPeminjaman(idPeminjaman);

        model.addAttribute("listBarang", bp);
        model.addAttribute("listDetail", dp);
        model.addAttribute("idPeminjaman", idPeminjaman);
        return "/detail_peminjaman/list_detail";
    }

    @GetMapping("/Tambah-barang-detail")
    public String goto_tambah_barang_detail(
            @RequestParam("id") String idPeminjaman,
            Model model
    ){
        List<BarangPerusahaan> bp = barangPerusahaanService.getAllBarangPerusahaan();

        model.addAttribute("listBarang", bp);
        model.addAttribute("idPeminjaman", idPeminjaman);
        return "detail_peminjaman/detail_barang_tambah";
    }

    @GetMapping("/Edit-barang-detail")
    public String goto_edit_barang_detail(
            @RequestParam("id") int idBarang
    ){
        return "detail_peminjaman/edit_barang_detail";
    }

    @PostMapping("/Post-tambah-barang")
    public String post_tambah_barang(
            @RequestParam("idPeminjaman") String idPeminjaman,
            @RequestParam("idBarang") int idBarang,
            Model model
    ){
        BarangPerusahaan barangPerusahaan = barangPerusahaanService.getBarangPerusahaan(idBarang);
        List<DetailPeminjaman> details = detailPeminjamanService.getAllByIdPeminjaman(idPeminjaman);
        for(DetailPeminjaman dt : details){
            if(dt.getIdBarangP() == idBarang){
                return "redirect:Tambah-detail?id="+idPeminjaman;
            }
        }
        DetailPeminjaman dt = new DetailPeminjaman();
        dt.setIdPeminjaman(idPeminjaman);
        dt.setHargaBarang(0);
        dt.setIdBarangP(idBarang);
        dt.setKondisiBarang(new Integer(0));
        dt.setKeterangan("");
        dt.setKuantitas(0);

        detailPeminjamanService.save(dt);
        System.out.println("MASUK SAMPE SINI");
        return "redirect:Tambah-detail?id="+idPeminjaman;
    }
}
