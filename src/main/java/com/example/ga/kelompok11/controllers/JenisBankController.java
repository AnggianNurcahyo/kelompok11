package com.example.ga.kelompok11.controllers;

import com.example.ga.kelompok11.model.JenisBank;
import com.example.ga.kelompok11.service.JenisBankService;
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
public class JenisBankController {
    @Autowired
    JenisBankService jenisBankService;

    @GetMapping("/JenisBank")
    public String getJenisBank(Model model) {
        List<JenisBank> jenisBankList = jenisBankService.getAllJenisBank();
        model.addAttribute("listJenisBank", jenisBankList);
        return "jenisbank/list";
    }

    @GetMapping("/JenisBank-add")
    public String gotoAdd(Model model){
        model.addAttribute("JenisBank", new JenisBank());
        return "jenisbank/add";
    }

    @GetMapping("/JenisBank-edit")
    public String gotoEdit(
            @RequestParam("id_jenisbank") int IdJenisBank,
            Model model
    ){
        JenisBank jenisBank = jenisBankService.getJenisBank(IdJenisBank);
        model.addAttribute("jenisbank", jenisBank);
        return "jenisbank/edit";
    }

    @PostMapping("/addJenisBank")
    public String addJenisBank(
            @RequestParam("NamaJenisBank") String NamaJenisBank,
            @RequestParam("Keterangan") String Keterangan
    ){
        JenisBank msRole = new JenisBank();
        msRole.setNamaBank(NamaJenisBank);
        msRole.setKeterangan(Keterangan);
        msRole.setCreatedBy("Dibuat oleh ....");
        msRole.setCreatedTime(LocalDateTime.now());
        msRole.setModifiedBy("");
        msRole.setLastModifiedTime(LocalDateTime.now());
        msRole.setRowStatus(1);
        jenisBankService.saveJenisBank(msRole);
        return "redirect:/JenisBank";
    }

    @PostMapping("/editJenisBank/{id}")
    public String editJenisBank(
            @PathVariable("id") Integer IdJenisBank, JenisBank jenisBank
    ){
        JenisBank msRole = jenisBankService.getJenisBank(IdJenisBank);
        System.out.println(jenisBank.getNamaBank());
        msRole.setNamaBank(jenisBank.getNamaBank());
        msRole.setKeterangan(jenisBank.getKeterangan());
        msRole.setModifiedBy("Dirubah oleh ...");
        msRole.setLastModifiedTime(LocalDateTime.now());
        jenisBankService.saveJenisBank(msRole);
        return "redirect:/JenisBank";
    }

    @GetMapping("/deleteJenisBank/{id}")
    public String deleteJenisBank(
            @PathVariable("id") Integer IdJenisBank, JenisBank jenisBank
    ){
        JenisBank msRole = jenisBankService.getJenisBank(IdJenisBank);
        msRole.setModifiedBy("Dihapus oleh ...");
        msRole.setLastModifiedTime(LocalDateTime.now());
        if(msRole.getRowStatus() == 1){
            msRole.setRowStatus(0);
        }else{
            msRole.setRowStatus(1);
        }
        jenisBankService.saveJenisBank(msRole);
        return "redirect:/JenisBank";
    }
}
