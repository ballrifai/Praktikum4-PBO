/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tugasprak4;

/**
 * L0325004_Iqbal Rifa'i
 * @author NITRO
 */
import java.util.LinkedList;
import java.util.Iterator;

public class ManajemenAset {

   LinkedList<AsetIT> daftarAset;

    public ManajemenAset() {
        daftarAset = new LinkedList<>();
    }

    public void tambahAset(AsetIT asetBaru) {
        daftarAset.add(asetBaru);
        System.out.println("[INFO] Aset dengan ID " + asetBaru.getIdAset() + " berhasil ditambahkan.");
    }

    public void tampilkanSemuaAset() {
        System.out.println("\n===== DAFTAR SEMUA ASET IT =====");
        if (daftarAset.isEmpty()) {
            System.out.println("Belum ada data aset.");
            return;
        }
        for (AsetIT aset : daftarAset) {
            aset.tampilkanInfoAset();
        }
    }

    public void hapusAset(String idAset) {
        Iterator<AsetIT> iterator = daftarAset.iterator();
        boolean ditemukan = false;

        while (iterator.hasNext()) {
            AsetIT aset = iterator.next();
            if (aset.getIdAset().equalsIgnoreCase(idAset)) {
                iterator.remove(); // hapus aset dari list secara aman lewat iterator
                ditemukan = true;
                System.out.println("[INFO] Aset dengan ID " + idAset + " berhasil dihapus.");
                break;
            }
        }

        if (!ditemukan) {
            System.out.println("[PERINGATAN] Aset dengan ID " + idAset + " tidak ditemukan!");
        }
    }
}