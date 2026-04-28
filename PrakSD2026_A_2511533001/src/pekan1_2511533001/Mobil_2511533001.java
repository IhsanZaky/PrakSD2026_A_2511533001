package pekan1_2511533001;
import java.util.ArrayList;

public final class Mobil_2511533001 {
    private String nama, merk;
    private int tahun, cc, harga;

    private static ArrayList<Mobil_2511533001> daftarMobil = new ArrayList<>();

    // konstruktor
    public Mobil_2511533001(String nama, int tahun, int cc, int harga, String merk) {
        this.nama = nama;
        this.tahun = tahun;
        this.cc = cc;
        this.harga = harga;
        this.merk = merk;
    }

    // getter
    public String getNama() { return nama; }
    public int getTahun() { return tahun; }
    public int getCc() { return cc; }
    public int getHarga() { return harga; }
    public String getMerk() { return merk; }

    // setter
    public void setNama(String nama) { this.nama = nama; }
    public void setTahun(int tahun) { this.tahun = tahun; }
    public void setCc(int cc) { this.cc = cc; }
    public void setHarga(int harga) { this.harga = harga; }
    public void setMerk(String merk) { this.merk = merk; }

    // tambah mobil
    public static void tambahMobil(Mobil_2511533001 m) {
        daftarMobil.add(m);
    }

    // hapus mobil
    public static void hapusMobil(String nama) {
        for (int i = 0; i < daftarMobil.size(); i++) {
            if (daftarMobil.get(i).getNama().equalsIgnoreCase(nama)) {
                daftarMobil.remove(i);
                break;
            }
        }
    }

    // tampilkan
    public static void tampilkan() {
        if (daftarMobil.isEmpty()) {
            System.out.println("Data mobil kosong.");
        } else {
            for (Mobil_2511533001 m : daftarMobil) {
                System.out.println(m);
            }
        }
    }

    // cari mobil
    public static Mobil_2511533001 cariMobil(String nama) {
        for (Mobil_2511533001 m : daftarMobil) {
            if (m.getNama().equalsIgnoreCase(nama)) {
                return m;
            }
        }
        return null;
    }

    // compare harga
    public int compareTo(Mobil_2511533001 other) {
        return this.harga - other.harga;
    }

    // equals
    public boolean equals(Object obj) {
        if (obj instanceof Mobil_2511533001) {
            Mobil_2511533001 m = (Mobil_2511533001) obj;
            return this.nama.equalsIgnoreCase(m.nama) &&
                   this.merk.equalsIgnoreCase(m.merk);
        }
        return false;
    }

    // toString
    public String toString() {
        return nama + " | " + merk + " | " + tahun + " | " + cc + "cc | Rp" + harga;
    }
}
