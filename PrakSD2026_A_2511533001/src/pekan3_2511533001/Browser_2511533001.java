package pekan3_2511533001;
import java.util.Scanner;
import java.util.Stack;
public class Browser_2511533001 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<Website_2511533001> history_3001 = new Stack<>();
        int pilihan;
        do {
            System.out.println("\n=== Browser History NIM: 2511533001 ===");
            System.out.println("1. Kunjungi Website");
            System.out.println("2. Tombol Back");
            System.out.println("3. Lihat Halaman Aktif");
            System.out.println("4. Cek Status History");
            System.out.println("5. Keluar");
            System.out.print("Pilih: ");
            pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan Judul: ");
                    String judul_3001 = scanner.nextLine();
                    System.out.print("Masukkan URL: ");
                    String url_3001 = scanner.nextLine();

                    history_3001.push(new Website_2511533001(judul_3001, url_3001));
                    System.out.println("Berhasil mengunjungi halaman.");
                    break;

                case 2:
                    if (history_3001.isEmpty()) {
                        System.out.println("History kosong. Tidak ada halaman untuk dikembalikan.");
                    } else {
                        Website_2511533001 lastSite = history_3001.pop();
                        System.out.println("Berhasil kembali. Halaman yang dihapus: " + lastSite.getJudul_3001());
                    }
                    break;

                case 3:
                    if (history_3001.isEmpty()) {
                        System.out.println("History kosong. Tidak ada halaman aktif.");
                    } else {
                        Website_2511533001 currentSite = history_3001.peek();
                        System.out.println("\n=== Halaman Aktif ===");
                        System.out.println(currentSite.toString());
                    }
                    break;

                case 4:
                    System.out.println("Status History: " + (history_3001.isEmpty() ? "Kosong" : "Terdapat Data"));
                    System.out.println("Jumlah total riwayat tersimpan: " + history_3001.size());
                    break;

                case 5:
                    System.out.println("Keluar dari program...");
                    break;

                default:
                    System.out.println("Pilihan tidak valid.");
                    break;
            }

        } while (pilihan != 5);

        scanner.close();
    }
}