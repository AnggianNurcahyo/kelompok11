package com.example.ga.kelompok11.service;

import com.example.ga.kelompok11.model.Role;
import com.example.ga.kelompok11.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    @Autowired
    RoleRepository roleRepository;

    public List<Role> getAllRole() {
        List<Role> RoleList = (List<Role>) roleRepository.findAll();
        return RoleList;
    }

    public Role getRole(int IdRole) {
        return roleRepository.findById(IdRole)
                .orElseThrow(() -> new IllegalArgumentException("Tidak ditemukan : " + IdRole));
    }

    public void saveRole(Role role) {
        roleRepository.save(role);
    }
}
