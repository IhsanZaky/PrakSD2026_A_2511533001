package pekan8_2511533001;

public class Sorting_2511533001 {

    static Lagu_2511533001[] dataLagu_3001 = new Lagu_2511533001[20];
    static int jumlahData_3001 = 0;

    public static void inputData_3001() {

        dataLagu_3001[jumlahData_3001++] =
                new Lagu_2511533001("Monokrom", "Tulus", 214);

        dataLagu_3001[jumlahData_3001++] =
                new Lagu_2511533001("Hati-Hati di Jalan", "Tulus", 242);

        dataLagu_3001[jumlahData_3001++] =
                new Lagu_2511533001("Rumah ke Rumah", "Hindia", 276);

        dataLagu_3001[jumlahData_3001++] =
                new Lagu_2511533001("Evaluasi", "Hindia", 234);

        dataLagu_3001[jumlahData_3001++] =
                new Lagu_2511533001("Zona Nyaman", "Fourtwnty", 230);

        dataLagu_3001[jumlahData_3001++] =
                new Lagu_2511533001("Akad", "Payung Teduh", 269);

        dataLagu_3001[jumlahData_3001++] =
                new Lagu_2511533001("Sampai Jadi Debu", "Banda Neira", 298);

        dataLagu_3001[jumlahData_3001++] =
                new Lagu_2511533001("Bertaut", "Nadin Amizah", 315);

        dataLagu_3001[jumlahData_3001++] =
                new Lagu_2511533001("Untuk Perempuan yang Sedang Dalam Pelukan", "Payung Teduh", 337);

        dataLagu_3001[jumlahData_3001++] =
                new Lagu_2511533001("Kuning", "Rumahsakit", 258);
    }
    
    public static void insertionSort_3001() {

        for (int i_3001 = 1; i_3001 < jumlahData_3001; i_3001++) {

            Lagu_2511533001 kunci_3001 = dataLagu_3001[i_3001];
            int j_3001 = i_3001 - 1;

            while (j_3001 >= 0 &&
                    dataLagu_3001[j_3001].durasi_3001 > kunci_3001.durasi_3001) {

                dataLagu_3001[j_3001 + 1] = dataLagu_3001[j_3001];
                j_3001--;
            }

            dataLagu_3001[j_3001 + 1] = kunci_3001;
        }
    }

    public static void tampilData_3001() {

        for (int i_3001 = 0; i_3001 < jumlahData_3001; i_3001++) {

            System.out.println(
                    (i_3001 + 1) + ". "
                    + dataLagu_3001[i_3001].judul_3001 + " | "
                    + dataLagu_3001[i_3001].penyanyi_3001 + " | "
                    + dataLagu_3001[i_3001].durasi_3001 + " detik");
        }
    }

    public static void main(String[] args) {

        inputData_3001();

        System.out.println("=== DATA SEBELUM SORTING ===");
        tampilData_3001();

        insertionSort_3001();

        System.out.println("\n=== DATA SETELAH SORTING DURASI ===");
        tampilData_3001();
    }
}