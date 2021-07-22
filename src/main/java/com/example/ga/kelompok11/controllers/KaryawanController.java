package com.example.ga.kelompok11.controllers;

import com.example.ga.kelompok11.model.Karyawan;
import com.example.ga.kelompok11.model.Role;
import com.example.ga.kelompok11.model.Seksi;
import com.example.ga.kelompok11.service.KaryawanService;
import com.example.ga.kelompok11.service.RoleService;
import com.example.ga.kelompok11.service.SeksiService;
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
public class KaryawanController {
    @Autowired
    KaryawanService karyawanService;
    @Autowired
    RoleService roleService;
    @Autowired
    SeksiService seksiService;

    @GetMapping("/Karyawan")
    public String getKaryawan(Model model){
        List<Karyawan> karyawanList = karyawanService.getAllKaryawan();
        model.addAttribute("listKaryawan", karyawanList);
//        model.addAttribute("IdRole", IdRole);
        return "/karyawan/list";
    }

    @GetMapping("/Karyawan-add")
    public String gotoAdd(
            Model model
    ){
        List<Role> roleList = roleService.getAllRole();
        model.addAttribute("ddlRole", roleList);
        List<Seksi> seksiList = seksiService.getAllSeksi();
        model.addAttribute("ddlSeksi", seksiList);
        model.addAttribute("Karyawan", new Karyawan());
        return "/karyawan/add";
    }

    @GetMapping("/Karyawan-edit")
    public String gotoEdit(
            @RequestParam("NPK") String NPK,
            Model model
    ){
        Karyawan karyawan = karyawanService.getKaryawanByNPK(NPK);
        List<Role> roleList = roleService.getAllRole();
        model.addAttribute("ddlRole", roleList);
        List<Seksi> seksiList = seksiService.getAllSeksi();
        model.addAttribute("ddlSeksi", seksiList);
        model.addAttribute("Karyawan", karyawan);
        return "/karyawan/edit";
    }

    @GetMapping("/Karyawan-detail")
    public String gotoDetail(
            @RequestParam("NPK") String NPK,
            Model model
    ){
        Karyawan karyawan = karyawanService.getKaryawanByNPK(NPK);
        model.addAttribute("Karyawan", karyawan);
        return "/karyawan/detail";
    }

    // ===================================
    @PostMapping("/addKaryawan")
    public String addKaryawan(Karyawan karyawan){

        karyawan.setCreatedBy("yang login");
        karyawan.setCreatedTime(LocalDateTime.now());
        karyawan.setModifiedBy("");
        karyawan.setLastModifiedTime(LocalDateTime.now());
        karyawan.setRowStatus(1);

        karyawanService.saveKaryawan(karyawan);
        return "redirect:/Karyawan?IdRole="+karyawan.getIdRole();
    }

    @PostMapping("/editKaryawan/{npk}")
    public String editLapangan(Karyawan karyawan , @PathVariable ("npk") String NPK){
        Karyawan old = karyawanService.getKaryawanByNPK(NPK);
        old.setModifiedBy("Yang sekarang login");
        old.setLastModifiedTime(LocalDateTime.now());
        old.setNamaKaryawan(karyawan.getNamaKaryawan());
        old.setJenisKelamin(karyawan.getJenisKelamin());
        old.setTanggalLahir(karyawan.getTanggalLahir());
        old.setAlamat(karyawan.getAlamat());
        old.setEmail(karyawan.getEmail());
        old.setNoTelepon(karyawan.getNoTelepon());
        old.setIdRole(karyawan.getIdRole());
        old.setIdSeksi(karyawan.getIdSeksi());
        old.setPassword(karyawan.getPassword());

        karyawanService.updateKaryawan(old);

        return "redirect:/Karyawan";
    }


    @GetMapping("/deleteKaryawan/{npk}")
    public String deleteLapangan(Karyawan karyawan, @PathVariable ("npk") String NPK){
        Karyawan old = karyawanService.getKaryawanByNPK(NPK);

        old.setModifiedBy("Dihapus oleh ...");
        old.setLastModifiedTime(LocalDateTime.now());
        if(old.getRowStatus() == 1){
            old.setRowStatus(0);
        }else{
            old.setRowStatus(1);
        }
        karyawanService.updateKaryawan(old);
        return "redirect:/Karyawan";
    }

}
