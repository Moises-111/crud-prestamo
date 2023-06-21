package com.example.ejemplos.entities;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode
public class PrestamosPK implements Serializable {
    private String cliente;
    private short id;




}
