package com.example.ga.kelompok11.repository;

import com.example.ga.kelompok11.model.Karyawan;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface KaryawanRepository extends CrudRepository<Karyawan, String> {
    @Query("select * from Karyawan where NPK =:NPK")
    Karyawan findByNPK(@Param("NPK") String NPK);
}
