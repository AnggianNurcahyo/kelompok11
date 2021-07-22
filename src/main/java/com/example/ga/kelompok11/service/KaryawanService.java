package com.example.ga.kelompok11.service;

import com.example.ga.kelompok11.generator.GeneratorId;
import com.example.ga.kelompok11.model.Karyawan;
import com.example.ga.kelompok11.repository.KaryawanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class KaryawanService {
    @Autowired
    KaryawanRepository karyawanRepository;

    public List<Karyawan> getAllKaryawan() {
        List<Karyawan> KaryawanList = (List<Karyawan>) karyawanRepository.findAll();
        return KaryawanList;
    }

    public Karyawan getKaryawanByNPK(String NPK){
        Karyawan karyawan = karyawanRepository.findByNPK(NPK);
        return karyawan;
    }

    public void saveKaryawan(Karyawan karyawan) {
        karyawan.setNPK(generateId());
        karyawanRepository.save(karyawan);
    }

    public  void updateKaryawan(Karyawan karyawan) {
        karyawanRepository.save(karyawan);
    }

    private int getLastCounter() {
        List<Karyawan> karyawanList = getAllKaryawan();
        if (karyawanList.size() > 0) {
            karyawanList.sort(Comparator.comparing(Karyawan::getNPK));
            int idNumber = Integer.parseInt(karyawanList.get(karyawanList.size() - 2).getNPK().replace("KRY", "").replace("0", ""));
            idNumber = idNumber + 1;
            return idNumber;
        }
        return 0;
    }

    private String generateId() {
        int lastCounter = getLastCounter();
        return "KRY" + GeneratorId.generateMasterId(lastCounter);
    }
}
