package com.example.ga.kelompok11.controllers;

import com.example.ga.kelompok11.model.JenisBank;
import com.example.ga.kelompok11.model.JenisBarang;
import com.example.ga.kelompok11.service.JenisBankService;
import com.example.ga.kelompok11.service.JenisBarangService;
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
public class JenisBarangController {
    @Autowired
    JenisBarangService jenisBarangService;

    @GetMapping("/JenisBarang")
    public String getJenisBarang(Model model) {
        List<JenisBarang> jenisBarangList = jenisBarangService.getAllJenisBarang();
        model.addAttribute("listJenisBarang", jenisBarangList);
        return "jenisbarang/list";
    }

    @GetMapping("/JenisBarang-add")
    public String gotoAdd(Model model){
        model.addAttribute("JenisBarang", new JenisBarang());
        return "jenisbarang/add";
    }

    @GetMapping("/JenisBarang-edit")
    public String gotoEdit(
            @RequestParam("id_jenisbarang") int IdJenisBarang,
            Model model
    ){
        JenisBarang jenisBarang = jenisBarangService.getJenisBarang(IdJenisBarang);
        model.addAttribute("jenisbarang", jenisBarang);
        return "jenisbarang/edit";
    }

    //========================================
    @PostMapping("/addJenisBarang")
    public String addJenisBarang(
            @RequestParam("NamaJenisBarang") String NamaJenisBarang,
            @RequestParam("Keterangan") String Keterangan
    ){
        JenisBarang msRole = new JenisBarang();
        msRole.setNamaBarang(NamaJenisBarang);
        msRole.setKeterangan(Keterangan);
        msRole.setCreatedBy("Dibuat oleh ....");
        msRole.setCreatedTime(LocalDateTime.now());
        msRole.setModifiedBy("");
        msRole.setLastModifiedTime(LocalDateTime.now());
        msRole.setRowStatus(1);

        jenisBarangService.saveJenisBarang(msRole);
        return "redirect:/JenisBarang";
    }

    @PostMapping("/editJenisBarang/{id}")
    public String editJenisBarang(
            @PathVariable("id") Integer IdJenisBarang, JenisBarang jenisBarang
    ){
        JenisBarang msRole = jenisBarangService.getJenisBarang(IdJenisBarang);

        msRole.setNamaBarang(jenisBarang.getNamaBarang());
        msRole.setKeterangan(jenisBarang.getKeterangan());
        msRole.setModifiedBy("Dirubah oleh ...");
        msRole.setLastModifiedTime(LocalDateTime.now());

        jenisBarangService.saveJenisBarang(msRole);
        return "redirect:/JenisBarang";
    }

    @GetMapping("/deleteJenisBarang/{id}")
    public String deleteJenisBarang(
            @PathVariable("id") Integer IdJenisBarang, JenisBarang jenisBarang
    ){
        JenisBarang msRole = jenisBarangService.getJenisBarang(IdJenisBarang);

        msRole.setModifiedBy("Dihapus oleh ...");
        msRole.setLastModifiedTime(LocalDateTime.now());
        if(msRole.getRowStatus() == 1){
            msRole.setRowStatus(0);
        }else{
            msRole.setRowStatus(1);
        }
        jenisBarangService.saveJenisBarang(msRole);
        return "redirect:/JenisBarang";
    }
}
