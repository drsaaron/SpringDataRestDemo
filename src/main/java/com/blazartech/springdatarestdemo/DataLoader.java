/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.blazartech.springdatarestdemo;

import com.blazartech.products.services.date.DateServices;
import com.blazartech.springdatarestdemo.data.JobRoleData;
import com.blazartech.springdatarestdemo.data.JobRoleDataRepository;
import com.blazartech.springdatarestdemo.data.JobRoleType;
import com.blazartech.springdatarestdemo.data.PersonAddressData;
import com.blazartech.springdatarestdemo.data.PersonAddressDataRepository;
import com.blazartech.springdatarestdemo.data.PersonData;
import com.blazartech.springdatarestdemo.data.PersonDataRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 *
 * @author scott
 */
@Component
@Slf4j
public class DataLoader implements CommandLineRunner {

    @Autowired
    private PersonDataRepository personRepo;
    
    @Autowired
    private JobRoleDataRepository roleRepo;
    
    @Autowired
    private PersonAddressDataRepository addressRepo;
    
    @Autowired
    private DateServices dateServices;
    
    @Override
    public void run(String... args) throws Exception {
        PersonData p = new PersonData("Scott", "Aaron", 25);
        log.info("adding person {}", p);
        personRepo.save(p);
        
        JobRoleData ceoRole = new JobRoleData(dateServices.parseDate("2023-01-01"), dateServices.parseDate("2023-12-31"), JobRoleType.CEO, p);
        log.info("saving job role {}", ceoRole);
        roleRepo.save(ceoRole);
        
        PersonAddressData address = new PersonAddressData();
        address.setPersonId(p);
        address.setStateText("phl17");
        address.setStreetText("123456 aBV");
        address.setZipCode("1234");
        addressRepo.save(address);
    }
    
}
