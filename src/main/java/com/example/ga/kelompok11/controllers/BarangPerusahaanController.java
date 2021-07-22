package com.example.ga.kelompok11.controllers;

import com.example.ga.kelompok11.model.BarangPerusahaan;
import com.example.ga.kelompok11.model.JenisBarang;
import com.example.ga.kelompok11.model.Seksi;
import com.example.ga.kelompok11.model.Vendor;
import com.example.ga.kelompok11.service.BarangPerusahaanService;
import com.example.ga.kelompok11.service.JenisBarangService;
import com.example.ga.kelompok11.service.SeksiService;
import com.example.ga.kelompok11.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class BarangPerusahaanController {
    @Autowired
    BarangPerusahaanService barangPerusahaanService;
    @Autowired
    SeksiService seksiService;
    @Autowired
    JenisBarangService jenisBarangService;
    @Autowired
    VendorService vendorService;

    @GetMapping("/BarangPerusahaan")
    public String getBarangPerusahaan(Model model) {
        List<BarangPerusahaan> BarangPerusahaanList = barangPerusahaanService.getAllBarangPerusahaan();
        model.addAttribute("listBarangPerusahaan", BarangPerusahaanList);
        return "barangperusahaan/list";
    }

    @GetMapping("/BarangPerusahaan-add")
    public String gotoAdd(
            Model model
    ){
        List<JenisBarang> jenisBarangList = jenisBarangService.getAllJenisBarang();
        model.addAttribute("ddlJenisBarang", jenisBarangList);
        List<Seksi> seksiList = seksiService.getAllSeksi();
        model.addAttribute("ddlSeksi", seksiList);
        List<Vendor> vendorList = vendorService.getAllVendor();
        model.addAttribute("ddlVendor", vendorList);
        model.addAttribute("BarangPerusahaan", new BarangPerusahaan());
        return "/barangperusahaan/add";
    }

    @GetMapping("/BarangPerusahaan-edit")
    public String gotoEdit(
            @RequestParam("IdBarangP") int IdBarangP,
            Model model
    ){
        BarangPerusahaan barangPerusahaan = barangPerusahaanService.getBarangPerusahaan(IdBarangP);
        List<JenisBarang> jenisBarangList = jenisBarangService.getAllJenisBarang();
        model.addAttribute("ddlJenisBarang", jenisBarangList);
        List<Seksi> seksiList = seksiService.getAllSeksi();
        model.addAttribute("ddlSeksi", seksiList);
        List<Vendor> vendorList = vendorService.getAllVendor();
        model.addAttribute("ddlVendor", vendorList);
        model.addAttribute("barangperusahaan", barangPerusahaan);
        return "barangperusahaan/edit";
    }

    @PostMapping("/addBarangPerusahaan")
    public String addBarangPerusahaan(BarangPerusahaan barangPerusahaan){
        barangPerusahaan.setCreatedBy("yang login");
        barangPerusahaan.setCreatedTime(LocalDateTime.now());
        barangPerusahaan.setModifiedBy("");
        barangPerusahaan.setLastModifiedTime(LocalDateTime.now());
        barangPerusahaan.setRowStatus(1);

        barangPerusahaanService.saveBarangPerusahaan(barangPerusahaan);
        return "redirect:/BarangPerusahaan?IdSeksi="+barangPerusahaan.getIdSeksi();
    }

    @PostMapping("/editBarangPerusahaan/{id}")
    public String editBarangPerusahaan(BarangPerusahaan barangPerusahaan, @PathVariable("id") Integer IdBarangP ){
        BarangPerusahaan msRole = barangPerusahaanService.getBarangPerusahaan(IdBarangP);
        msRole.setNamaBarangP(barangPerusahaan.getNamaBarangP());
        msRole.setKeterangan(barangPerusahaan.getKeterangan());
        msRole.setIdJenisBarang(barangPerusahaan.getIdJenisBarang());
        msRole.setIdSeksi(barangPerusahaan.getIdSeksi());
        msRole.setIdVendor(barangPerusahaan.getIdVendor());
        msRole.setStok(barangPerusahaan.getStok());
        msRole.setHarga(barangPerusahaan.getHarga());
        msRole.setModifiedBy("Dirubah oleh ...");
        msRole.setLastModifiedTime(LocalDateTime.now());
        barangPerusahaanService.saveBarangPerusahaan(msRole);
        return "redirect:/BarangPerusahaan";
    }

    @GetMapping("/deleteBarangPerusahaan/{id}")
    public String deleteBarangPerusahaan(
            @PathVariable("id") Integer IdBarangP, BarangPerusahaan barangPerusahaan
    ){
        BarangPerusahaan msRole = barangPerusahaanService.getBarangPerusahaan(IdBarangP);
        msRole.setModifiedBy("Dihapus oleh ...");
        msRole.setLastModifiedTime(LocalDateTime.now());
        if(msRole.getRowStatus() == 1){
            msRole.setRowStatus(0);
        }else{
            msRole.setRowStatus(1);
        }
        barangPerusahaanService.saveBarangPerusahaan(msRole);
        return "redirect:/BarangPerusahaan";
    }
}
