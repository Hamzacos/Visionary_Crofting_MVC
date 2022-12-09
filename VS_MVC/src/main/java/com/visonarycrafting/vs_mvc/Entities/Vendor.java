package com.visonarycrafting.vs_mvc.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@NotNull
public class Vendor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column
    @NotBlank
    private String firstName;
    @Column
    @NotBlank
    private String lastName;
    @Column
    @Email
    private String email;
    @Column
    @Size(min=10,max=12)
    private String phone;
    @Column
    @Size(min=8)
    private String password;
    @OneToMany(mappedBy = "vendor")
    private List<CallOffer> callOffers;
}
