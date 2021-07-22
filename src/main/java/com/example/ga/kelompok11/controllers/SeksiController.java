package com.example.ga.kelompok11.controllers;

import com.example.ga.kelompok11.model.Role;
import com.example.ga.kelompok11.model.Seksi;
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
public class SeksiController {
    @Autowired
    SeksiService seksiService;

    @GetMapping("/Seksi")
    public String getSeksi(Model model) {
        List<Seksi> seksiList = seksiService.getAllSeksi();
        model.addAttribute("listSeksi", seksiList);
        return "seksi/list";
    }

    @GetMapping("/Seksi-add")
    public String gotoAdd(Model model){
        model.addAttribute("Seksi", new Seksi());
        return "seksi/add";
    }

    @GetMapping("/Seksi-edit")
    public String gotoEdit(
            @RequestParam("id_seksi") int IdSeksi,
            Model model
    ){
        Seksi seksi = seksiService.getSeksi(IdSeksi);
        model.addAttribute("seksi", seksi);
        return "seksi/edit";
    }

    //========================================
    @PostMapping("/addSeksi")
    public String addSeksi(
            @RequestParam("NamaSeksi") String NamaSeksi,
            @RequestParam("Keterangan") String Keterangan
    ){
        Seksi msRole = new Seksi();
        msRole.setNamaSeksi(NamaSeksi);
        msRole.setKeterangan(Keterangan);
        msRole.setCreatedBy("Dibuat oleh ....");
        msRole.setCreatedTime(LocalDateTime.now());
        msRole.setModifiedBy("");
        msRole.setLastModifiedTime(LocalDateTime.now());
        msRole.setRowStatus(1);

        seksiService.saveSeksi(msRole);
        return "redirect:/Seksi";
    }

    @PostMapping("/editSeksi/{id}")
    public String editSeksi(
            @PathVariable("id") Integer IdSeksi, Seksi seksi
    ){
        Seksi msRole = seksiService.getSeksi(IdSeksi);

        msRole.setNamaSeksi(seksi.getNamaSeksi());
        msRole.setKeterangan(seksi.getKeterangan());
        msRole.setModifiedBy("Dirubah oleh ...");
        msRole.setLastModifiedTime(LocalDateTime.now());

        seksiService.saveSeksi(msRole);
        return "redirect:/Seksi";
    }

    @GetMapping("/deleteSeksi/{id}")
    public String deleteSeksi(
            @PathVariable("id") Integer IdSeksi, Seksi seksi
    ){
        Seksi msRole = seksiService.getSeksi(IdSeksi);

        msRole.setModifiedBy("Dihapus oleh ...");
        msRole.setLastModifiedTime(LocalDateTime.now());
        if(msRole.getRowStatus() == 1){
            msRole.setRowStatus(0);
        }else{
            msRole.setRowStatus(1);
        }
        seksiService.saveSeksi(msRole);
        return "redirect:/Seksi";
    }
}
