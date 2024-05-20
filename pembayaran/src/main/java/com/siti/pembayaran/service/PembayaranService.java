/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.siti.pembayaran.service;

import com.siti.pembayaran.entity.Pembayaran;
import com.siti.pembayaran.repository.PembayaranRepository;
import com.siti.pembayaran.vo.Order;
import com.siti.pembayaran.vo.ResponseTemplate;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Windows
 */
@Service
public class PembayaranService {
    @Autowired
  private PembayaranRepository pembayaranRepository;
     
@Autowired
     private RestTemplate restTemplate;
     
    @GetMapping
    public List<Pembayaran> getAll(){
        return pembayaranRepository.findAll();
    } 
     public Pembayaran getPembayaranById(Long id){
        return pembayaranRepository.findById(id).get();

    }
     public void insert(Pembayaran pembayaran){
        pembayaranRepository.save(pembayaran);
    }
    @Transactional
    public void update(Long pembayaranId,String mode_pembayaran, String nomor_referensi, String tgl_bayar ){
        Pembayaran pembayaran = pembayaranRepository.findById(pembayaranId).orElseThrow
                (() 
                -> new IllegalStateException("Pembayaran Tidak ada"));
       if(mode_pembayaran != null && mode_pembayaran.length()>0
                && !Objects.equals(pembayaran.getMode_Pembayaran(), mode_pembayaran)){
            pembayaran.setMode_Pembayaran(mode_pembayaran);
        }
       if(nomor_referensi != null && nomor_referensi.length()>0
                && !Objects.equals(pembayaran.getNomor_Referensi(), nomor_referensi)){
            pembayaran.setNomor_Referensi(nomor_referensi);
        }
       if(tgl_bayar != null && tgl_bayar.length()>0
                && !Objects.equals(pembayaran.getTgl_Bayar(), tgl_bayar)){
            pembayaran.setTgl_Bayar(tgl_bayar);
        }

    }
     public void delete(Long id){
         pembayaranRepository.deleteById(id);
     }
     
     public ResponseTemplate getPembayaranWithOrderById(Long id){
         ResponseTemplate responseTemplate = new ResponseTemplate();
         Pembayaran pembayaran = getPembayaranById(id);
         Order order = restTemplate.getForObject("http://localhost:9002/api/v1/order/" +pembayaran.getOrder_Id(), Order.class);
         responseTemplate.setPembayaran(pembayaran);
         responseTemplate.setOrder(order);
         return responseTemplate;
     }
}