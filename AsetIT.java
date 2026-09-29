/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tugasprak4;

/**
 * L0325004_Iqbal Rifa'i
 * @author NITRO
 */
public class AsetIT {
    
    String idAset;
    String namaPerangkat;
    String lokasi;
    String statusKondisi; 
 
    public AsetIT(String idAset, String namaPerangkat, String lokasi, String statusKondisi) {
        this.idAset = idAset;
        this.namaPerangkat = namaPerangkat;
        this.lokasi = lokasi;
        this.statusKondisi = statusKondisi;
    }
 
    public String getIdAset() {
        return idAset;
    }
 
    public String getNamaPerangkat() {
        return namaPerangkat;
    }
 
    public String getLokasi() {
        return lokasi;
    }
 
    public String getStatusKondisi() {
        return statusKondisi;
    }
 
    public void tampilkanInfoAset() {
        System.out.println("ID Aset        : " + idAset);
        System.out.println("Nama Perangkat : " + namaPerangkat);
        System.out.println("Lokasi         : " + lokasi);
        System.out.println("Status Kondisi : " + statusKondisi);
        System.out.println("-----------------------------------");
    }
}