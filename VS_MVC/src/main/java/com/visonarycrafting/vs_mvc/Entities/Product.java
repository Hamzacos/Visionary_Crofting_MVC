package com.visonarycrafting.vs_mvc.Entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.visonarycrafting.vs_mvc.Entities.CommandItem;
import jakarta.persistence.*;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Product implements  java.io.Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private CommandItem commandItem;
    @Column
    private String productName;
    @Column
    private Double productPrice;
    @Column
    private String category;
    @Column
    private String description;
    @Column
    private Integer quantity;
    @ManyToOne
    private Stock stock;

}
