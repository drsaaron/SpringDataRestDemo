/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.blazartech.springdatarestdemo.data;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 *
 * @author scott
 */
@RepositoryRestResource(collectionResourceRel = "person", path = "person")
public interface PersonDataRepository extends JpaRepository<PersonData, Long> {
    List<PersonData> findByLastName(@Param("lastName") String lastName);
}
