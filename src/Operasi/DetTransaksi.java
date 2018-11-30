/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operasi;

import java.util.ArrayList;
import java.util.*;
/**
 *
 * @author Alfaza
 */
public class DetTransaksi {
    private String kode; //Variabel Kode
    private float Total; //Variabel Total
    private ArrayList <Item> barang = new ArrayList<>(); //Variabel Item

    public DetTransaksi(String kode, ArrayList<Item> barang) {
        this.kode = kode;
        this.barang=barang;
    }
    
    //Setter Total
    public void setTotal(){
        float total =0;
        for (Item items : this.barang){
            Total += items.getTotal();
    }
        this.Total=Total;
    }
    
    public String Info(){
        setTotal();
        String info = "";
        info += "Kode\t\t:" + this.kode + "\n";
        info += "Daftar Belanja: \n";
        for(Item items : this.barang){
            info +="\t" +items.getJumlah()+" "+ items.getNama()+":"+ items.getHarga()+"\n";
        }
        info += "\t"+"Total :" +this.Total;
        return info;
    }
    
    
} 
