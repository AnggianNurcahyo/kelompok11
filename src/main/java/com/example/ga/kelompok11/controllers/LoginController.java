package com.example.ga.kelompok11.controllers;

import com.example.ga.kelompok11.model.Karyawan;
import com.example.ga.kelompok11.model.Vendor;
import com.example.ga.kelompok11.service.KaryawanService;
import com.example.ga.kelompok11.service.LoginService;
import com.example.ga.kelompok11.service.VendorService;
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
    @Autowired
    VendorService vendorService;

    @GetMapping("/")
    public String getLogin(HttpSession session){
        session.getAttribute("namakaryawan");
        return ("/login/login");
    }

    @GetMapping("/HalVendor")
    public String halVendor(HttpSession session){
        session.getAttribute("namavendor");
        return "login/login_vendor";
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
                switch (login.getIdRole())
                {
                    case 1:
                        return "redirect:/index_admin";
                    case 2:
                        return "redirect:/index_ga";
                    case 4:
                        return "redirect:/index_karyawan";
                    case 3:
                        return "redirect:/index_kepala";
                    default:
                        return ("redirect:/");
                }
            }
        }
        return ("redirect:/");
    }

    @PostMapping("/LoginVendor")
    public String isLogginVendor(Vendor vendor, HttpSession nama, HttpSession idVendor){
        System.out.println(vendor.getIdVendor());
        List<Vendor> karyawanList = vendorService.getAllVendor();
        for (Vendor login : karyawanList) {
            if (vendor.getIdVendor() == login.getIdVendor()) {
                nama.setAttribute("namavendor", login.getNamaVendor());
                idVendor.setAttribute("idvendor", login.getIdVendor());
                        return ("redirect:/index");
                }
            }
        return ("redirect:/");
    }

    @GetMapping("/index_ga")
    public String Dashbaord_ga () {
        return "layout/layout_ga";
    }

    @GetMapping("/index_kepala")
    public String Dashbaord_kepala () {
        return "layout/layout_kepala";
    }

    @GetMapping("/index_karyawan")
    public String Dashbaord_karyawan () {
        return "layout/layout_karyawan";
    }

    @GetMapping("/index_admin")
    public String Dashbaord_admin () {
        return "layout/layout_admin";
    }

    @GetMapping("/index")
    public String Dashbaord_vendor () {
        return "layout/layout_vendor";
    }

    @GetMapping("/Logout")
    public String isLogout() {
        return "redirect:/";
    }
}
