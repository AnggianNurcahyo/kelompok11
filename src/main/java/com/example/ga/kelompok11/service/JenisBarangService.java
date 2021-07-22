package com.example.ga.kelompok11.service;

import com.example.ga.kelompok11.model.JenisBarang;
import com.example.ga.kelompok11.repository.JenisBarangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JenisBarangService {

    @Autowired
    JenisBarangRepository jenisBarangRepository;
    public List<JenisBarang> getAllJenisBarang() {
        List<JenisBarang> JenisBarangList = (List<JenisBarang>) jenisBarangRepository.findAll();
        return JenisBarangList;
    }

    public JenisBarang getJenisBarang(int IdJenisBarang) {
        return jenisBarangRepository.findById(IdJenisBarang)
                .orElseThrow(() -> new IllegalArgumentException("Tidak ditemukan : " + IdJenisBarang));
    }

    public void saveJenisBarang(JenisBarang jenisBarang) {
        jenisBarangRepository.save(jenisBarang);
    }
}
