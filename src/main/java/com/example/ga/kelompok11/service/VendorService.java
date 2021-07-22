package com.example.ga.kelompok11.service;

import com.example.ga.kelompok11.model.Vendor;
import com.example.ga.kelompok11.repository.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendorService {
    @Autowired
    VendorRepository vendorRepository;

    public List<Vendor> getAllVendor() {
        List<Vendor> VendorList = (List<Vendor>) vendorRepository.findAll();
        return VendorList;
    }

    public Vendor getVendor(int IdVendor) {
        return vendorRepository.findById(IdVendor)
                .orElseThrow(() -> new IllegalArgumentException("Tidak ditemukan : " + IdVendor));

    }

    public void saveVendor(Vendor vendor) {
        vendorRepository.save(vendor);
    }
}
