package com.example.ga.kelompok11.service;

import com.example.ga.kelompok11.model.BarangVendor;
import com.example.ga.kelompok11.repository.BarangVendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BarangVendorService {
    @Autowired
    BarangVendorRepository barangVendorRepository;

    public List<BarangVendor> getAllBarangVendor() {
        List<BarangVendor> BarangVendorList = (List<BarangVendor>) barangVendorRepository.findAll();
        return BarangVendorList;
    }

    public BarangVendor getBarangVendor(int IdBarangV) {
        return barangVendorRepository.findById(IdBarangV)
                .orElseThrow(() -> new IllegalArgumentException("Tidak ditemukan : " + IdBarangV));

    }

    public void saveBarangVendor(BarangVendor barangvendor) {
        barangVendorRepository.save(barangvendor);
    }
}
