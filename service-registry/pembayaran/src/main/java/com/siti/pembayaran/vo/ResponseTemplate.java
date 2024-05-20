/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.siti.pembayaran.vo;

import com.siti.pembayaran.entity.Pembayaran;


public class ResponseTemplate {
    Pembayaran pembayaran;
    Order order;


    public ResponseTemplate(){

    }

    public ResponseTemplate(Pembayaran pembayaran, Order order) {
        this.pembayaran = pembayaran;
        this.order = order;

    }
    public Pembayaran getPembayaran() {
        return pembayaran;
    }

    public Order getOrder() {
        return order;
    }
    public void setPembayaran(Pembayaran pembayaran) {
        this.pembayaran = pembayaran;
    }
    public void setOrder(Order order) {
        this.order = order;
    }


}