package com.example.ga.kelompok11.repository;

import com.example.ga.kelompok11.model.Peminjaman;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface PeminjamanRepository extends CrudRepository<Peminjaman,Integer > {
//    @Query("select * from Peminjaman where IdPeminjaman =:IdPeminjaman")
//    Peminjaman findByIdPeminjaman(@Param("IdPeminjaman") String IdPeminjaman);
//    Peminjaman findByIdPeminjaman(@Param("IdPeminjaman")String IdPeminjaman);
}
