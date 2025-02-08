package com.rex.pharmaC.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "medicine")

public class Medicine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long medId;

    String medName;
    float medPrice;
    int medQty;
    //int med
    String medLocation;

}
