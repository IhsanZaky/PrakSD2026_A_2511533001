package pekan5_2511533001;

public class Pasien_2511533001 {

	// data pasien
    private String namaPasien_3001;
    private String penyakit_3001;
    private int nomorAntrian_3001;

    // pointer ke node berikutnya
    Pasien_2511533001 next_3001;

    // konstruktor
    public Pasien_2511533001(String namaPasien_3001,
                             String penyakit_3001,
                             int nomorAntrian_3001) {

        this.namaPasien_3001 = namaPasien_3001;
        this.penyakit_3001 = penyakit_3001;
        this.nomorAntrian_3001 = nomorAntrian_3001;

        this.next_3001 = null;
    }

    // getter nama pasien
    public String getNamaPasien_3001() {
        return namaPasien_3001;
    }

    // getter penyakit
    public String getPenyakit_3001() {
        return penyakit_3001;
    }

    // getter nomor antrian
    public int getNomorAntrian_3001() {
        return nomorAntrian_3001;
    }
}


		
			    