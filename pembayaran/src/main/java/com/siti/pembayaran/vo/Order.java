/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.siti.pembayaran.vo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 *
 * @author Windows
 */
@Entity
@Table(name="t_order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long produkId;
    private Integer jumlah;
    private String tanggal;
    private String status;
    private double total;
    
    public Order(){
    }
    
    public Order(Long id, Long produkId, Integer jumlah, String tanggal, String status, double total){
        this.id = id;
        this.produkId = produkId;
        this.jumlah = jumlah;
        this.tanggal = tanggal;
        this.status = status;
        this.total = total;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProdukId() {
        return produkId;
    }

    public void setProdukId(Long produkId) {
        this.produkId = produkId;
    }

    public Integer getJumlah() {
        return jumlah;
    }

    public void setJumlah(Integer jumlah) {
        this.jumlah = jumlah;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Order{" + "id=" + id + ", produkId=" + produkId + ", jumlah=" + jumlah + ", tanggal=" + tanggal + ", status=" + status + ", total=" + total + '}';
    }
    
    
}
