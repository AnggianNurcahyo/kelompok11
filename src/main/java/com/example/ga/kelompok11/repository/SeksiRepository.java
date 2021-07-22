package com.example.ga.kelompok11.repository;

import com.example.ga.kelompok11.model.Seksi;
import org.springframework.data.repository.CrudRepository;

public interface SeksiRepository extends CrudRepository<Seksi, Integer> {
    //    @Query("from Role r where r.IdRole = :IdRole")
//    Role findByIdRole(@Param("IdRole") int IdRole);
}
