package com.example.ga.kelompok11.service;

import com.example.ga.kelompok11.model.Karyawan;
import com.example.ga.kelompok11.repository.KaryawanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService {
    @Autowired
    KaryawanRepository karyawanRepository;

//    public boolean checkNPK(String NPK){
//        Karyawan karyawan = karyawanRepository.findByNPK(NPK);
//        if (optional.isPresent()) {
//            karyawan = optional.get();
//        } else {
//            return false;
//        }
//
//        return true;
//    }
//
//    public Karyawan getKaryawan(String NPK){
//        Optional<Karyawan> optional = karyawanRepository.findsByNPK(NPK);
//        Karyawan karyawan = null;
//        if (optional.isPresent()) {
//            karyawan = optional.get();
//        }
//
//        return karyawan;
//    }

//    public boolean authentication(String password,String passwordInput){
//        if (password == passwordInput) {
//            return true;
//        }
//        else
//            return false;
//    }
}
