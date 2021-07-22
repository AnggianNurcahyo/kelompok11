package com.example.ga.kelompok11.service;

import com.example.ga.kelompok11.model.BarangPerusahaan;
import com.example.ga.kelompok11.repository.BarangPerusahaanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BarangPerusahaanService {
    @Autowired
    BarangPerusahaanRepository barangPerusahaanRepository;

    public List<BarangPerusahaan> getAllBarangPerusahaan() {
        List<BarangPerusahaan> BarangPerusahaanList = (List<BarangPerusahaan>) barangPerusahaanRepository.findAll();
        return BarangPerusahaanList;
    }

    public BarangPerusahaan getBarangPerusahaan(int IdBarangP) {
        return barangPerusahaanRepository.findById(IdBarangP)
                .orElseThrow(() -> new IllegalArgumentException("Tidak ditemukan : " + IdBarangP));
    }

    public void saveBarangPerusahaan(BarangPerusahaan barangPerusahaan) {
        barangPerusahaanRepository.save(barangPerusahaan);
    }
}
