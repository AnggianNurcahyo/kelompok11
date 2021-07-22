package com.example.ga.kelompok11.controllers;

import com.example.ga.kelompok11.model.JenisBank;
import com.example.ga.kelompok11.model.Karyawan;
import com.example.ga.kelompok11.model.Vendor;
import com.example.ga.kelompok11.service.JenisBankService;
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
public class VendorController {
    @Autowired
    VendorService vendorService;
    @Autowired
    JenisBankService jenisBankService;

    @GetMapping("/Vendor")
    public String getVendor(Model model) {
        List<Vendor> vendorList = vendorService.getAllVendor();
        model.addAttribute("listvendor", vendorList);
        return "/vendor/list";
    }

    @GetMapping("/Vendor-add")
    public String gotoAdd(
            Model model
    ){
        List<JenisBank> jenisBankList = jenisBankService.getAllJenisBank();
        model.addAttribute("ddlJenisBank", jenisBankList);
        model.addAttribute("Vendor", new Vendor());
        return "/vendor/add";
    }

    @GetMapping("/Vendor-edit")
    public String gotoEdit(
            @RequestParam("IdVendor") int IdVendor,
            Model model
    ){
        Vendor vendor = vendorService.getVendor(IdVendor);
        List<JenisBank> jenisBankList = jenisBankService.getAllJenisBank();
        model.addAttribute("ddlJenisBank", jenisBankList);
        model.addAttribute("Vendor", vendor);
        return "/vendor/edit";
    }

    @PostMapping("/editVendor/{idvendor}")
    public String editVendor(Vendor vendor , @PathVariable("idvendor") Integer IdVendor){
        Vendor old = vendorService.getVendor(IdVendor);
        old.setModifiedBy("Yang sekarang login");
        old.setLastModifiedTime(LocalDateTime.now());
        old.setNamaVendor(vendor.getNamaVendor());
        old.setAlamat(vendor.getAlamat());
        old.setEmail(vendor.getEmail());
        old.setNoTelepon(vendor.getNoTelepon());
        old.setNoRekening(vendor.getNoRekening());
        old.setIdJenisBank(vendor.getIdJenisBank());

        vendorService.saveVendor(old);

        return "redirect:/Vendor";
    }

    @PostMapping("/addVendor")
    public String addVendor(Vendor vendor){

        vendor.setCreatedBy("yang login");
        vendor.setCreatedTime(LocalDateTime.now());
        vendor.setModifiedBy("");
        vendor.setLastModifiedTime(LocalDateTime.now());
        vendor.setRowStatus(1);

        vendorService.saveVendor(vendor);
        return "redirect:/Vendor?IdJenisBank="+vendor.getIdJenisBank();
    }

    @GetMapping("/deleteVendor/{idvendor}")
    public String deleteVendor(Vendor vendor , @PathVariable("idvendor") Integer IdVendor){
        Vendor old = vendorService.getVendor(IdVendor);

        old.setModifiedBy("Dihapus oleh ...");
        old.setLastModifiedTime(LocalDateTime.now());
        if(old.getRowStatus() == 1){
            old.setRowStatus(0);
        }else{
            old.setRowStatus(1);
        }
        vendorService.saveVendor(old);
        return "redirect:/Vendor";
    }
}
