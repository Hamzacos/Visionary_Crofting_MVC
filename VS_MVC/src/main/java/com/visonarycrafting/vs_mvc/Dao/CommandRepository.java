package com.visonarycrafting.vs_mvc.Dao;

import com.visonarycrafting.vs_mvc.Entities.Command;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommandRepository extends JpaRepository<Command,Integer> {
    public List<Command> findCommandByReferenceLike(String s);
}

