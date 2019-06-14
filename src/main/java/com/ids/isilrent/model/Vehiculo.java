package com.ids.isilrent.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Vehiculo {
    private int id;
    private String marca;
    private String modelo;
    private String preciorent;
}
