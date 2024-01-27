package kr.co.shield.controller;

import kr.co.shield.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test {
    final
    AdminRepository adminRepository;

    public Test(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @GetMapping("/hello")
    public void hello() {
        this.adminRepository.findByAdminId("hello");
    }
}
