/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.pA2.repository;

import com.example.pA2.model.Reserva;

import org.springframework.data.jpa.repository.JpaRepository;
public interface  ReservaRepository  extends JpaRepository<Reserva, Long>{
    
}
