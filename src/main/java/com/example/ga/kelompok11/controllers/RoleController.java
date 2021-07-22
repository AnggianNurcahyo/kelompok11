package com.example.ga.kelompok11.controllers;

import com.example.ga.kelompok11.model.Role;
import com.example.ga.kelompok11.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.List;

@Controller
public class RoleController {
    @Autowired
    RoleService roleService;

    @GetMapping("/Role")
    public String getRole(Model model) {
        List<Role> roleList = roleService.getAllRole();
        model.addAttribute("listRole", roleList);
        return "role/list";
    }

    @GetMapping("/Role-add")
    public String gotoAdd(Model model){
        model.addAttribute("Role", new Role());
        return "role/add";
    }

    @GetMapping("/Role-edit")
    public String gotoEdit(
            @RequestParam("id_role") int IdRole,
            Model model
    ){
        Role role = roleService.getRole(IdRole);
        model.addAttribute("role", role);
        return "role/edit";
    }

    //========================================
    @PostMapping("/addRole")
    public String addRole(
            @RequestParam("NamaRole") String NamaRole,
            HttpSession session
    ){
        Role msRole = new Role();
        msRole.setNamaRole(NamaRole);
        msRole.setCreatedBy(session.getAttribute("namakaryawan").toString());
        msRole.setCreatedTime(LocalDateTime.now());
        msRole.setModifiedBy("");
        msRole.setLastModifiedTime(LocalDateTime.now());
        msRole.setRowStatus(1);

        roleService.saveRole(msRole);
        return "redirect:/Role";
    }

    @PostMapping("/editRole/{id}")
    public String editRole(
            @PathVariable("id") Integer IdRole, Role role
    ){
        Role msRole = roleService.getRole(IdRole);

        msRole.setNamaRole(role.getNamaRole());
        msRole.setModifiedBy("Dirubah oleh ...");
        msRole.setLastModifiedTime(LocalDateTime.now());

        roleService.saveRole(msRole);
        return "redirect:/Role";
    }

    @GetMapping("/deleteRole/{id}")
    public String deleteRole(
            @PathVariable("id") Integer IdRole, Role role
    ){
        Role msRole = roleService.getRole(IdRole);

        msRole.setModifiedBy("Dihapus oleh ...");
        msRole.setLastModifiedTime(LocalDateTime.now());
        if(msRole.getRowStatus() == 1){
            msRole.setRowStatus(0);
        }else{
            msRole.setRowStatus(1);
        }
        roleService.saveRole(msRole);
        return "redirect:/Role";
    }

}
