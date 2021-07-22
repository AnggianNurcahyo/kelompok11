package com.example.ga.kelompok11.controllers;

import com.example.ga.kelompok11.model.BarangPerusahaan;
import com.example.ga.kelompok11.model.BarangVendor;
import com.example.ga.kelompok11.model.JenisBarang;
import com.example.ga.kelompok11.model.Vendor;
import com.example.ga.kelompok11.service.BarangVendorService;
import com.example.ga.kelompok11.service.JenisBarangService;
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
public class BarangVendorController {
    @Autowired
    BarangVendorService barangVendorService;
    @Autowired
    JenisBarangService jenisBarangService;
    @Autowired
    VendorService vendorService;

    @GetMapping("/BarangVendor")
    public String getBarangVendor(Model model) {
        List<BarangVendor> barangVendorList = barangVendorService.getAllBarangVendor();
        model.addAttribute("listbarangVendor", barangVendorList);
        return "/barangvendor/list";
    }

    @GetMapping("/BarangVendor-add")
    public String gotoAdd(
            Model model
    ){
        List<JenisBarang> jenisBarangList = jenisBarangService.getAllJenisBarang();
        model.addAttribute("ddlJenisBarang", jenisBarangList);
        List<Vendor> vendorList = vendorService.getAllVendor();
        model.addAttribute("ddlVendor", vendorList);
        model.addAttribute("BarangVendor", new BarangVendor());
        return "/barangvendor/add";
    }

    @GetMapping("/BarangVendor-edit")
    public String gotoEdit(
            @RequestParam("IdBarangV") int IdBarangV,
            Model model
    ){

        BarangVendor barangVendor = barangVendorService.getBarangVendor(IdBarangV);
        List<JenisBarang> jenisBarangList = jenisBarangService.getAllJenisBarang();
        model.addAttribute("ddlJenisBarang", jenisBarangList);
        List<Vendor> vendorList = vendorService.getAllVendor();
        model.addAttribute("ddlVendor", vendorList);
        model.addAttribute("barangVendor", barangVendor);
        return "/barangvendor/edit";
    }

    @PostMapping("/addBarangVendor")
    public String addBarangVendor(BarangVendor barangVendor){

        barangVendor.setCreatedBy("yang login");
        barangVendor.setCreatedTime(LocalDateTime.now());
        barangVendor.setModifiedBy("");
        barangVendor.setLastModifiedTime(LocalDateTime.now());
        barangVendor.setRowStatus(1);

        barangVendorService.saveBarangVendor(barangVendor);
        return "redirect:/BarangVendor?IdJenisBarang="+barangVendor.getIdJenisBarang();
    }

    @PostMapping("/editBarangVendor/{id}")
    public String editBarangVendor(BarangVendor barangVendor, @PathVariable("id") Integer IdBarangV ){
        BarangVendor msRole = barangVendorService.getBarangVendor(IdBarangV);
        msRole.setNamaBarangV(barangVendor.getNamaBarangV());
        msRole.setKeterangan(barangVendor.getKeterangan());
        msRole.setIdJenisBarang(barangVendor.getIdJenisBarang());
        msRole.setIdVendor(barangVendor.getIdVendor());
        msRole.setHarga(barangVendor.getHarga());
        msRole.setModifiedBy("Dirubah oleh ...");
        msRole.setLastModifiedTime(LocalDateTime.now());
        barangVendorService.saveBarangVendor(msRole);
        return "redirect:/BarangVendor";
    }

    @GetMapping("/deleteBarangVendor/{id}")
    public String deleteBarangPerusahaan(
            @PathVariable("id") Integer IdBarangV, BarangVendor barangVendor
    ){
        BarangVendor msRole = barangVendorService.getBarangVendor(IdBarangV);
        msRole.setModifiedBy("Dihapus oleh ...");
        msRole.setLastModifiedTime(LocalDateTime.now());
        if(msRole.getRowStatus() == 1){
            msRole.setRowStatus(0);
        }else{
            msRole.setRowStatus(1);
        }
        barangVendorService.saveBarangVendor(msRole);
        return "redirect:/BarangVendor";
    }
}
