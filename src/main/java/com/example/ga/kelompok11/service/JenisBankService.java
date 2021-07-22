package com.example.ga.kelompok11.service;

import com.example.ga.kelompok11.model.JenisBank;
import com.example.ga.kelompok11.model.Seksi;
import com.example.ga.kelompok11.repository.JenisBankRepository;
import com.example.ga.kelompok11.repository.SeksiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JenisBankService {
    @Autowired
    JenisBankRepository jenisBankRepository;

    public List<JenisBank> getAllJenisBank() {
        List<JenisBank> JenisBankList = (List<JenisBank>) jenisBankRepository.findAll();
        return JenisBankList;
    }

    public JenisBank getJenisBank(int IdJenisBank) {
        return jenisBankRepository.findById(IdJenisBank)
                .orElseThrow(() -> new IllegalArgumentException("Tidak ditemukan : " + IdJenisBank));
    }

    public void saveJenisBank(JenisBank jenisBank) {
        jenisBankRepository.save(jenisBank);
    }
}
