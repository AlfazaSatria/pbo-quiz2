/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operasi;

/**
 *
 * @author Alfaza
 */
public class Item {
    private String nama; //Variabel nama barang
    private float harga; //Variabel Harga barang
    private int jumlah;// Variabel jumlah barang

    public Item(String nama, float harga) {
        this.nama = nama;
        this.harga = harga;
    }
    
    //Constructor
    public Item(String nama, float harga, int jumlah) {
        this.nama = nama;
        this.harga = harga;
        this.jumlah = jumlah;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public float getHarga() {
        return harga;
    }

    public void setHarga(float harga) {
        this.harga = harga;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }
    
    //Getter Total
    public float getTotal(){
        float total = this.harga * this.jumlah;
        return total;
    }
    
    @Override
    public String toString(){
        return this.nama;
    }
}
