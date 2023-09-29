package com.binarybeast.entity;

import java.util.List;

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
public class PaymentMethods {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;
    private String description;
    private String userName;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "client_paymentMethod",
            joinColumns = @JoinColumn( name = "id" ),
            inverseJoinColumns = @JoinColumn( name = "client_id" )
    )
    private List<Clients> clients;

//	@JsonIgnore
//	@ManyToMany(fetch = FetchType.EAGER)
//	@JoinTable(
//			name = "transaction_paymentMethod",
//			joinColumns = @JoinColumn( name  = "id" ),
//			inverseJoinColumns = @JoinColumn(name = "transaction_id")
//			)
//	private List<Transactions> transactions;

//	@ManyToMany(mappedBy = "paymentMethods", fetch = FetchType.EAGER)
//	private List<Clients> client;

}
