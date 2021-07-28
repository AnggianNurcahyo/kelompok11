package com.example.ga.kelompok11.service;

import com.example.ga.kelompok11.model.Karyawan;
import com.example.ga.kelompok11.repository.KaryawanRepository;
import com.example.ga.kelompok11.repository.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService {
    @Autowired
    KaryawanRepository karyawanRepository;
    @Autowired
    VendorRepository vendorRepository;
}
