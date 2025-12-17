package com.example.Warehouse;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Warehouse {
    @Id
  //  @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="Deal Unique Id",nullable = false)
    private String uniqueId;
    @Column(name="Ordering Currency")
    private String fromCurrency;
    @Column(name="To Currency")
    private String toCurrency;
    @Column(name="Deal timestamp")
    private String timeStamp;
    @Column(name="Deal Amount")
    private long amount;
}
