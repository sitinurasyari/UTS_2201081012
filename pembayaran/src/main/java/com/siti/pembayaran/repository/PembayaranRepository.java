/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.siti.pembayaran.repository;

import com.siti.pembayaran.entity.Pembayaran;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Windows
 */
@Repository
public interface PembayaranRepository extends JpaRepository<Pembayaran, Long> {
    public List<Pembayaran> findAll();
}
