package com.example.ga.kelompok11.controllers;

import com.example.ga.kelompok11.model.Karyawan;
import com.example.ga.kelompok11.service.KaryawanService;
import com.example.ga.kelompok11.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class LoginController {
    @Autowired
    KaryawanService karyawanService;
    @Autowired
    LoginService loginService;

    @GetMapping("/")
    public String getLogin(HttpSession session){
        session.getAttribute("namakaryawan");
        return ("/login/login");
    }

    @PostMapping("/Login")
    public String isLoggin(Karyawan karyawan, HttpSession nama, HttpSession NPK){
        System.out.println(karyawan.getNPK());
        System.out.println(karyawan.getPassword());
        List<Karyawan> karyawanList = karyawanService.getAllKaryawan();
        for (Karyawan login : karyawanList) {
            if (karyawan.getNPK().equals(login.getNPK()) && karyawan.getPassword().equals(login.getPassword())) {
                nama.setAttribute("namakaryawan", login.getNamaKaryawan());
                NPK.setAttribute("npkkaryawan", login.getNPK());
                return ("redirect:/index");
            }
        }
        return ("redirect:/");
    }

    @GetMapping("/index")
    public String Index () {
        return "index";
    }
}
