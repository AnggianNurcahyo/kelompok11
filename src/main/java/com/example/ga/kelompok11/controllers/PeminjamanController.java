package com.example.ga.kelompok11.controllers;

import com.example.ga.kelompok11.model.Karyawan;
import com.example.ga.kelompok11.model.Peminjaman;
import com.example.ga.kelompok11.model.Role;
import com.example.ga.kelompok11.model.Seksi;
import com.example.ga.kelompok11.service.KaryawanService;
import com.example.ga.kelompok11.service.PeminjamanService;
import com.example.ga.kelompok11.service.RoleService;
import com.example.ga.kelompok11.service.SeksiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.List;

@Controller
public class PeminjamanController {
    @Autowired
    PeminjamanService peminjamanService;
    @Autowired
    KaryawanService karyawanService;
    @Autowired
    RoleService roleService;
    @Autowired
    SeksiService seksiService;

    @GetMapping("/Peminjaman")
    public String getPeminjaman(Model model){
        List<Peminjaman> peminjamanList = peminjamanService.getAllPeminjaman();
        model.addAttribute("listPeminjaman", peminjamanList);
        List<Karyawan> karyawanList = karyawanService.getAllKaryawan();


        return "/peminjaman/list";
    }

//    @GetMapping("/Peminjaman-add")
//    public String gotoAdd(
//            Model model
//    ){
////        List<Role> roleList = roleService.getAllRole();
////        model.addAttribute("ddlRole", roleList);
////        List<Seksi> seksiList = seksiService.getAllSeksi();
////        model.addAttribute("ddlSeksi", seksiList);
//        model.addAttribute("Peminjaman", new Peminjaman());
//        return "/peminjaman/add";
//    }

//    @GetMapping("/Peminjaman-edit")
//    public String gotoEdit(
//            @RequestParam("IdPeminjaman") String IdPeminjaman,
//            Model model
//    ){
//        Peminjaman peminjaman = peminjamanService.getPeminjamanByIdPeminjaman(IdPeminjaman);
////        List<Role> roleList = roleService.getAllRole();
////        model.addAttribute("ddlRole", roleList);
////        List<Seksi> seksiList = seksiService.getAllSeksi();
////        model.addAttribute("ddlSeksi", seksiList);
//        model.addAttribute("Peminjaman", peminjaman);
//        return "/peminjaman/edit";
//    }

//    @GetMapping("/Peminjaman-detail")
//    public String gotoDetail(
//            @RequestParam("IdPeminjaman") String IdPeminjaman,
//            Model model
//    ){
//        Peminjaman peminjaman = peminjamanService.getPeminjamanByIdPeminjaman(IdPeminjaman);
//        model.addAttribute("Peminjaman", peminjaman);
//        return "/peminjaman/detail";
//    }

    @RequestMapping("/Peminjaman-add")
    public String addPeminjaman(HttpSession httpSession){
        Peminjaman peminjaman = new Peminjaman();

        peminjaman.setNPK(httpSession.getAttribute("npkkaryawan").toString());

        peminjaman.setTglPeminjaman(LocalDateTime.now());
        peminjaman.setLastModifiedTime(LocalDateTime.now());
        peminjaman.setAcceptedBy("");
        peminjaman.setModifiedBy(httpSession.getAttribute("namakaryawan").toString());
        peminjaman.setStatus(0);
        peminjaman.setIsLate(0);
        peminjaman.setDenda(0);
        peminjaman.setStatusDenda("Tidak Ada Denda");

        peminjamanService.savePeminjaman(peminjaman);
        return "redirect:/Peminjaman";
    }

//    @PostMapping("/editPeminjaman/{idPeminjaman}")
//    public String editPeminjaman(Peminjaman peminjaman , @PathVariable("idPeminjaman") String IdPeminjaman, HttpSession httpSession){
//        Peminjaman peminjaman1 = peminjamanService.getPeminjamanByIdPeminjaman(IdPeminjaman);
//
//
//        peminjaman1.setNPK(peminjaman1.getNPK(httpSession.getAttribute("npkkaryawan").toString());
//        peminjaman.setLastModifiedTime(LocalDateTime.now());
//        peminjaman.setAcceptedBy("");
//        peminjaman.setModifiedBy(httpSession.getAttribute("namakaryawan").toString());
//        peminjaman.setStatus(1);
//        peminjaman.setIsLate(0);
//        peminjaman.setDenda(0);
//        peminjaman.setStatusDenda("Tidak Ada Denda");
//
////        old.setModifiedBy("Yang sekarang login");
////        old.setLastModifiedTime(LocalDateTime.now());
////        old.setNamaKaryawan(karyawan.getNamaKaryawan());
////        old.setJenisKelamin(karyawan.getJenisKelamin());
////        old.setTanggalLahir(karyawan.getTanggalLahir());
////        old.setAlamat(karyawan.getAlamat());
////        old.setEmail(karyawan.getEmail());
////        old.setNoTelepon(karyawan.getNoTelepon());
////        old.setIdRole(karyawan.getIdRole());
////        old.setIdSeksi(karyawan.getIdSeksi());
////        old.setPassword(karyawan.getPassword());
//
//        karyawanService.updateKaryawan(old);
//
//        return "redirect:/Karyawan";
//    }
}
