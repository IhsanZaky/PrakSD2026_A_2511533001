package pekan1_2511533001;
public class Driver_2511533001 {
    public static void main(String[] args) {

        Mobil_2511533001 m1 = new Mobil_2511533001("Koenigsegg Jesko Absolut", 2024, 3000, 150000000, "Koenigsegg");
        Mobil_2511533001 m2 = new Mobil_2511533001("Ford Mustang GT", 2001, 2100, 160000000, "Ford");
        Mobil_2511533001 m3 = new Mobil_2511533001("Ferrari SF90 Stradale", 2010, 2500, 510000000, "Ferrari");

        Mobil_2511533001.tambahMobil(m1);
        Mobil_2511533001.tambahMobil(m2);
        Mobil_2511533001.tambahMobil(m3);

        System.out.println("Data Mobil:");
        Mobil_2511533001.tampilkan();

        System.out.println("\nCari Mobil:");
        Mobil_2511533001 hasil = Mobil_2511533001.cariMobil("Koenigsegg Jesko Absolut");
        if (hasil != null) {
            System.out.println("Ditemukan: " + hasil);
        }

        System.out.println("\nPerbandingan Harga:");
        if (m1.compareTo(m2) > 0) {
            System.out.println(m1.getNama() + " lebih mahal");
        } else {
            System.out.println(m2.getNama() + " lebih mahal");
        }

        Mobil_2511533001.hapusMobil("Ferrari SF90 Stradale");

        System.out.println("\nSetelah dihapus:");
        Mobil_2511533001.tampilkan();
    }
}