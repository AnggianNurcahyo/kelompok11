package com.example.ga.kelompok11.service;

import com.example.ga.kelompok11.generator.GeneratorId;
import com.example.ga.kelompok11.model.DetailPeminjaman;
import com.example.ga.kelompok11.model.Peminjaman;
import com.example.ga.kelompok11.repository.PeminjamanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class PeminjamanService {
    @Autowired
    PeminjamanRepository peminjamanRepository;

    public List<Peminjaman> getAllPeminjaman() {
        List<Peminjaman> PeminjamanList = (List<Peminjaman>) peminjamanRepository.findAll();
        return PeminjamanList;
    }

    public Peminjaman getAllByIdPeminjaman(String idPeminjaman){
        List<Peminjaman> a = getAllPeminjaman();
        for(Peminjaman b : a){
            if(b.getIdPeminjaman().equals(idPeminjaman)){
                return b ;
            }
        }
        return null;
    }

    public void savePeminjaman(Peminjaman peminjaman) {
        peminjaman.setIdPeminjaman(generateId());
        peminjamanRepository.save(peminjaman);
    }

    public void updatePeminjaman(Peminjaman peminjaman) {
        peminjamanRepository.save(peminjaman);
    }

    private int getLastCounter() {
        List<Peminjaman> peminjamanList = getAllPeminjaman();
        if (peminjamanList.size() > 0) {
            peminjamanList.sort(Comparator.comparing(Peminjaman::getIdPeminjaman));
            int idNumber = Integer.parseInt(peminjamanList.get(peminjamanList.size() - 1).getIdPeminjaman().replace("PNJ", "").replace("0", ""));
            idNumber = idNumber + 1;
            return idNumber;
        }
        return 0;
    }

    private String generateId() {
        int lastCounter = getLastCounter();
        return "PNJ" + GeneratorId.generateMasterId(lastCounter);
    }
}
