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

    @GetMapping("/DaftarPeminjaman")
    public String getAllPeminjaman(Model model){
        List<Peminjaman> peminjamanList = peminjamanService.getAllPeminjaman();
        model.addAttribute("listPeminjaman", peminjamanList);
        List<Karyawan> karyawanList = karyawanService.getAllKaryawan();
        return "/peminjaman/daftar";
    }

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

    @GetMapping("/Peminjaman_Update/{id}")
    public String updatePeminjaman(
            HttpSession session,
            @PathVariable String id){
        Peminjaman pj = peminjamanService.getAllByIdPeminjaman(id);
        pj.setStatus(1);
        pj.setAcceptedBy(session.getAttribute("namakaryawan").toString());
        peminjamanService.updatePeminjaman(pj);
        return "redirect:/DaftarPeminjaman";
    }

}
