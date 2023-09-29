package com.binarybeast.entity;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
public class Clients {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long clientId;

    private String firstName;
    private String lastName;
    private String userName;
    private String email;
    private String password;
    private String role;
    private LocalDateTime dateOfRegistration;


    @ManyToMany(mappedBy = "clients", fetch = FetchType.EAGER)
    private Set<Transactions> transactions = new HashSet<>();

    @ManyToMany(mappedBy = "clients", fetch = FetchType.EAGER)
    private Set<Category> category = new HashSet<>();

    @ManyToMany(mappedBy = "clients", fetch = FetchType.EAGER)
    private Set<PaymentMethods> paymentMethods = new HashSet<>();

//	@JsonIgnore
//	@ManyToMany(fetch = FetchType.EAGER)
//	@JoinTable(
//			name = "client_paymentMethod",
//			joinColumns = @JoinColumn( name = "client_id" ),
//			inverseJoinColumns = @JoinColumn( name = "id" )
//			)
//	private List<PaymentMethods> PaymentMethods;

}
