package pekan5_2511533001;
import java.util.Scanner;

public class RumahSakit_2511533001 {
	Pasien_2511533001 head_3001, tail_3001;
    int nomor_3001 = 0, jumlah_3001 = 0;

    // insert pasien
    void daftarkanPasien_3001(String nama_3001, String keluhan_3001) {

        nomor_3001++;

        Pasien_2511533001 baru_3001 =
                new Pasien_2511533001(nama_3001, keluhan_3001, nomor_3001);

        if (head_3001 == null) {

            head_3001 = tail_3001 = baru_3001;

        } else {

            tail_3001.next_3001 = baru_3001;
            tail_3001 = baru_3001;
        }

        jumlah_3001++;

        System.out.println("Pasien berhasil didaftarkan!");
    }

    // delete head
    void panggilPasien_3001() {

        if (head_3001 == null) {

            System.out.println("Antrian kosong.");
            return;
        }

        System.out.println("\n=== Pasien Dipanggil ===");
        System.out.println("No Antrian : " + head_3001.getNomorAntrian_3001());
        System.out.println("Nama       : " + head_3001.getNamaPasien_3001());
        System.out.println("Keluhan    : " + head_3001.getPenyakit_3001());

        head_3001 = head_3001.next_3001;

        if (head_3001 == null) {
            tail_3001 = null;
        }

        jumlah_3001--;
    }

    // display
    void tampilkanAntrian_3001() {

        if (head_3001 == null) {

            System.out.println("Antrian kosong.");
            return;
        }

        Pasien_2511533001 temp_3001 = head_3001;

        System.out.println("\n=== DAFTAR ANTRIAN ===");

        while (temp_3001 != null) {

            System.out.println(
                    temp_3001.getNomorAntrian_3001()
                    + ". "
                    + temp_3001.getNamaPasien_3001()
                    + " - "
                    + temp_3001.getPenyakit_3001()
            );

            temp_3001 = temp_3001.next_3001;
        }
    }

    // search
    void cariPasien_3001(String nama_3001) {

        Pasien_2511533001 temp_3001 = head_3001;

        while (temp_3001 != null) {

            if (temp_3001.getNamaPasien_3001().equalsIgnoreCase(nama_3001)) {

                System.out.println("Pasien ditemukan!");
                System.out.println("No Antrian : " + temp_3001.getNomorAntrian_3001());

                return;
            }

            temp_3001 = temp_3001.next_3001;
        }

        System.out.println("Pasien tidak ditemukan.");
    }

    // status antrian
    void cekStatus_3001() {

        if (head_3001 == null) {

            System.out.println("Antrian kosong.");
            return;
        }

        System.out.println("Jumlah pasien : " + jumlah_3001);
        System.out.println("Pasien terdepan : "
                + head_3001.getNamaPasien_3001());
    }

    public static void main(String[] args) {

        RumahSakit_2511533001 rs_3001 =
                new RumahSakit_2511533001();

        Scanner input_3001 = new Scanner(System.in);

        int pilih_3001;

        do {

            System.out.println("\n=== Antrian Rumah Sakit NIM: 2511533001 ===");
            System.out.println("1. Daftarkan Pasien (Insert)");
            System.out.println("2. Panggil Pasien (Delete Head)");
            System.out.println("3. Tampilkan Antrian (Display)");
            System.out.println("4. Cari Pasien (Search)");
            System.out.println("5. Cek Status Antrian");
            System.out.println("6. Keluar");
            System.out.print("Pilihan : ");

            pilih_3001 = input_3001.nextInt();
            input_3001.nextLine();

            switch (pilih_3001) {

                case 1:

                    System.out.print("Masukkan nama pasien : ");
                    String nama_3001 = input_3001.nextLine();

                    System.out.print("Masukkan keluhan : ");
                    String keluhan_3001 = input_3001.nextLine();

                    rs_3001.daftarkanPasien_3001(nama_3001, keluhan_3001);

                    break;

                case 2:

                    rs_3001.panggilPasien_3001();

                    break;

                case 3:

                    rs_3001.tampilkanAntrian_3001();

                    break;

                case 4:

                    System.out.print("Masukkan nama pasien : ");
                    String cari_3001 = input_3001.nextLine();

                    rs_3001.cariPasien_3001(cari_3001);

                    break;

                case 5:

                    rs_3001.cekStatus_3001();

                    break;

                case 6:

                    System.out.println("Program selesai.");

                    break;

                default:

                    System.out.println("Pilihan tidak valid!");
            }

        } while (pilih_3001 != 6);

        input_3001.close();
    }
}	
	    