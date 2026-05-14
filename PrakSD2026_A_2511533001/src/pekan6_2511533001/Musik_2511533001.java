package pekan6_2511533001;
import java.util.*;

public class Musik_2511533001 {

    Lagu_2511533001 head_3001 = null;
    Lagu_2511533001 tail_3001 = null;

    public void tambahLagu_3001(String judul_3001, String penyanyi_3001) {
        Lagu_2511533001 baru_3001 = new Lagu_2511533001(judul_3001, penyanyi_3001);
        if (head_3001 == null) {
            head_3001 = baru_3001;
            tail_3001 = baru_3001;
        } else {
            tail_3001.next_3001 = baru_3001;
            baru_3001.prev_3001 = tail_3001;
            tail_3001 = baru_3001;
        }
        System.out.println("Lagu berhasil ditambahkan!");
    }

    public void hapusLaguAwal_2511533001() {
        if (head_3001 == null) {
            System.out.println("Playlist kosong!");
            return;
        }
        System.out.println("Lagu " + head_3001.getJudul_3001() + " berhasil dihapus");
        head_3001 = head_3001.next_3001;
        if (head_3001 != null) {
            head_3001.prev_3001 = null;
        } else {
            tail_3001 = null;
        }
    }

    public void tampilMaju_2511533001() {
        if (head_3001 == null) {
            System.out.println("Playlist kosong!");
            return;
        }
        Lagu_2511533001 curr_3001 = head_3001;
        System.out.println("=== Playlist Maju ===");
        while (curr_3001 != null) {
            System.out.println(curr_3001.getJudul_3001() + " - " + curr_3001.getPenyanyi_3001());
            curr_3001 = curr_3001.next_3001;
        }
    }

    public void tampilMundur_2511533001() {
        if (tail_3001 == null) {
            System.out.println("Playlist kosong!");
            return;
        }
        Lagu_2511533001 curr_3001 = tail_3001;
        System.out.println("=== Playlist Mundur ===");
        while (curr_3001 != null) {
            System.out.println(curr_3001.getJudul_3001() + " - " + curr_3001.getPenyanyi_3001());
            curr_3001 = curr_3001.prev_3001;
        }
    }

    public void cariLagu_2511533001(String judul_3001) {
        if (head_3001 == null) {
            System.out.println("Playlist kosong!");
            return;
        }
        Lagu_2511533001 curr_3001 = head_3001;
        boolean ketemu_3001 = false;
        while (curr_3001 != null) {
            if (curr_3001.getJudul_3001().equalsIgnoreCase(judul_3001)) {
                System.out.println("Lagu ditemukan!");
                System.out.println("Judul    : " + curr_3001.getJudul_3001());
                System.out.println("Penyanyi : " + curr_3001.getPenyanyi_3001());
                ketemu_3001 = true;
                break;
            }
            curr_3001 = curr_3001.next_3001;
        }
        if (!ketemu_3001) {
            System.out.println("Lagu tidak ditemukan!");
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Musik_2511533001 musik_3001 = new Musik_2511533001();
        int pilihan_3001;
        do {
            System.out.println("\n=== Playlist Musik NIM: 2511533001 ===");
            System.out.println("1. Tambah Lagu");
            System.out.println("2. Hapus Lagu Pertama");
            System.out.println("3. Lihat Playlist (Maju)");
            System.out.println("4. Lihat Playlist (Mundur)");
            System.out.println("5. Cari Lagu");
            System.out.println("6. Keluar");
            System.out.print("Pilihan: ");
            pilihan_3001 = input.nextInt();
            input.nextLine();
            switch (pilihan_3001) {
                case 1:
                    System.out.print("Judul Lagu: ");
                    String judul_3001 = input.nextLine();
                    System.out.print("Penyanyi: ");
                    String penyanyi_3001 = input.nextLine();
                    musik_3001.tambahLagu_3001(judul_3001, penyanyi_3001);
                    break;
                case 2:
                    musik_3001.hapusLaguAwal_2511533001();
                    break;
                case 3:
                    musik_3001.tampilMaju_2511533001();
                    break;
                case 4:
                    musik_3001.tampilMundur_2511533001();
                    break;
                case 5:
                    System.out.print("Masukkan judul lagu: ");
                    String cari_3001 = input.nextLine();
                    musik_3001.cariLagu_2511533001(cari_3001);
                    break;
                case 6:
                    System.out.println("Program selesai");
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        } while (pilihan_3001 != 6);
        input.close();
    }
}