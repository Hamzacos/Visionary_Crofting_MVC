package com.visonarycrafting.vs_mvc.Dao;

import com.visonarycrafting.vs_mvc.Entities.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendorRepository extends JpaRepository<Vendor, Integer> {
}
