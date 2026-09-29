/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tugasprak4;

/**
 * L0325004_Iqbal Rifa'i
 * @author NITRO
 */
public class MainAset {
public static void main(String[] args) {
 
        ManajemenAset manajemen = new ManajemenAset();
 
        manajemen.tambahAset(new AsetIT("AST001", "Server Dell R740", "Ruang Server", "Baik"));
        manajemen.tambahAset(new AsetIT("AST002", "Router Cisco 2900", "Ruang Jaringan", "Baik"));
        manajemen.tambahAset(new AsetIT("AST003", "Switch TP-Link 24 Port", "Ruang Jaringan", "Rusak"));
        manajemen.tambahAset(new AsetIT("AST004", "PC Dell OptiPlex 3090", "Ruang Admin", "Baik"));
 
        manajemen.tampilkanSemuaAset();
 
        System.out.println("\n>>> Menghapus aset dengan ID AST003 (Switch) <<<");
        manajemen.hapusAset("AST003");
 
        System.out.println("\n>>> Mencoba menghapus aset dengan ID yang tidak ada (AST999) <<<");
        manajemen.hapusAset("AST999");
 
        manajemen.tampilkanSemuaAset();
    }
}