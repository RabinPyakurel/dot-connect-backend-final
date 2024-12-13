package com.codefestnepal.dotconnect;

import com.codefestnepal.dotconnect.models.Agency;
import com.codefestnepal.dotconnect.repositories.AgencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class DotConnectApplication implements CommandLineRunner {
    @Autowired
    private AgencyRepository agencyRepository;
    @Autowired
    private PasswordEncoder encoder;


    public static void main(String[] args) {
        SpringApplication.run(DotConnectApplication.class, args);

    }

    @Override
    public void run(String... args) throws Exception {
        Agency agency = new Agency();
        agency.setAgencyId("0643a0d9-053e-4a7d-b316-1aa13c672a49");
        agency.setAddress("Lagankhel lalitpur");
        agency.setName("Patan Hospital");
        agency.setPassword(encoder.encode("Patan123"));
        agency.setPhone("01502040");
        agency.setUsername("patanhospital");
        agency.setAccess("ReadWrite");

        Agency agency2 = new Agency();
        agency2.setAgencyId("e79d86d6-2bf0-411e-af40-4c2717fafeac");
        agency2.setName("Bir Hospital");
        agency2.setAddress("kathmandu,Ratnapark");
        agency2.setUsername("BirHospital");
        agency2.setPassword(encoder.encode("Bir123"));
        agency2.setPhone("01502041");
        agency2.setAccess("ReadWrite");

        Agency agency3 = new Agency();
        agency3.setAgencyId("00b039b9-2116-4985-8653-61ebd384245b");
        agency3.setName("US embasssy");
        agency3.setAddress("Lainchaur,kathmandu");
        agency3.setUsername("UsEmbassy");
        agency3.setPassword(encoder.encode("Us123456"));
        agency3.setPhone("01502042");
        agency3.setAccess("Read");
        Agency agency4 = new Agency();
        agency4.setAgencyId("f6e6f884-4a73-4ce5-b126-1bd93021f636");
        agency4.setName("Nepal life Insurance");
        agency4.setAddress("Ramshahpath,kathmandu");
        agency4.setUsername("NepalLifeInsurance");
        agency4.setPassword(encoder.encode("Nepal1212"));
        agency4.setPhone("01502043");
        agency4.setAccess("Read");

        Agency agency5 = new Agency();
        agency5.setAgencyId("54f6e788-0e86-4140-9ed1-b13ea0883091");
        agency5.setName("Shahid Gangalal Hospital");
        agency5.setAddress("Bansbari,kathmandu");
        agency5.setUsername("ShahidGangalalHospital");
        agency5.setPassword(encoder.encode("Ban123"));
        agency5.setPhone("01502044");
        agency5.setAccess("ReadWrite");

        agencyRepository.deleteAll();
        agencyRepository.save(agency);
        agencyRepository.save(agency2);
        agencyRepository.save(agency3);
        agencyRepository.save(agency4);
        agencyRepository.save(agency5);

    }
}
