package org.enset.hospital;

import org.enset.hospital.config.AppConstants;
import org.enset.hospital.entites.Patient;
import org.enset.hospital.entites.Role;
import org.enset.hospital.repositories.PatientRepository;
import org.enset.hospital.repositories.RoleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class HospitalApplication implements CommandLineRunner {
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private RoleRepository roleRepository;

    public static void main(String[] args) {
        SpringApplication.run(HospitalApplication.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Override
    public void run(String... args) throws Exception {
//        patientRepository.save(new Patient("Zakaria", new Date(), false));
//        patientRepository.save(new Patient( "Iliass", new Date(), false));
    }
}
