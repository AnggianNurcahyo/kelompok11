package com.example.ga.kelompok11.service;

import com.example.ga.kelompok11.model.DetailPeminjaman;
import com.example.ga.kelompok11.repository.DetailPeminjamanRepositoy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Detail_peminjaman_service {
    @Autowired
    DetailPeminjamanRepositoy detailPeminjamanRepositoy;

    public List<DetailPeminjaman> getAll(){
        List<DetailPeminjaman> a = (List<DetailPeminjaman>) detailPeminjamanRepositoy.findAll();
        return  a;
    }

    public DetailPeminjaman getAllByIdDetail(int idDetailP){
        List<DetailPeminjaman> a = getAll();
        for(DetailPeminjaman b : a){
            if(b.getIdDetailP() == idDetailP){
                return b ;
            }
        }
        return null;
    }

    public List<DetailPeminjaman> getAllByIdPeminjaman(String idPeminjaman){
        List<DetailPeminjaman> a = getAll();
        List<DetailPeminjaman> output = new ArrayList<>();
        for(DetailPeminjaman b : a){
            if(b.getIdPeminjaman().equals(idPeminjaman)){
                output.add(b);
            }
        }
        return output;
    }

//    ====================================================
    public void save(DetailPeminjaman dt){
        detailPeminjamanRepositoy.save(dt);
    }
}
