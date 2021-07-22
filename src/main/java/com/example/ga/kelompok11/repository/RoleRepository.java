package com.example.ga.kelompok11.repository;

import com.example.ga.kelompok11.model.Role;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface RoleRepository extends CrudRepository<Role, Integer> {

//    @Query("from Role r where r.IdRole = :IdRole")
//    Role findByIdRole(@Param("IdRole") int IdRole);
}
