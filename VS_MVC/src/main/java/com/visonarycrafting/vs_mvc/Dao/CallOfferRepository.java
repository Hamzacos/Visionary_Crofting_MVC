package com.visonarycrafting.vs_mvc.Dao;

import com.visonarycrafting.vs_mvc.Entities.CallOffer;
import com.visonarycrafting.vs_mvc.Entities.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CallOfferRepository extends JpaRepository<CallOffer, Integer> {
    List<CallOffer> findAllByStatus(Status status);
}
