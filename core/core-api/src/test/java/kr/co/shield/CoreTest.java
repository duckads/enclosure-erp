package kr.co.shield;

import kr.co.shield.domain.Admin;
import kr.co.shield.repository.AdminRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class CoreTest {

    @Autowired
    AdminRepository adminRepository;

    @Test
    void hello() {
        String adminId = "asj";
        Optional<Admin> hello = adminRepository.findByAdminId("hello");
    }
}
