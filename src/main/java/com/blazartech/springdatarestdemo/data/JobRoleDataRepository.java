/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.blazartech.springdatarestdemo.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 *
 * @author scott
 */
@RepositoryRestResource(collectionResourceRel = "role", path = "role")
public interface JobRoleDataRepository extends JpaRepository<JobRoleData, Long> {
    
}
