package com.visonarycrafting.vs_mvc.Dao;



import com.visonarycrafting.vs_mvc.Entities.CommandItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandItemRepository extends JpaRepository<CommandItem,Integer> { }
