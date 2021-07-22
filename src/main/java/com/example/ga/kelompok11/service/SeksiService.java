package com.example.ga.kelompok11.service;

import com.example.ga.kelompok11.model.Role;
import com.example.ga.kelompok11.model.Seksi;
import com.example.ga.kelompok11.repository.RoleRepository;
import com.example.ga.kelompok11.repository.SeksiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeksiService {
    @Autowired
    SeksiRepository seksiRepository;

    public List<Seksi> getAllSeksi() {
        List<Seksi> SeksiList = (List<Seksi>) seksiRepository.findAll();
        return SeksiList;
    }

    public Seksi getSeksi(int IdSeksi) {
        return seksiRepository.findById(IdSeksi)
                .orElseThrow(() -> new IllegalArgumentException("Tidak ditemukan : " + IdSeksi));
    }

    public void saveSeksi(Seksi seksi) {
        seksiRepository.save(seksi);
    }
}
