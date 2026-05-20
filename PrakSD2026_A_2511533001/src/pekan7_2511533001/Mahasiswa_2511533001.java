package pekan7_2511533001;

public class Mahasiswa_2511533001 {

    private String nama_3001;
    private String nim_3001;
    private String prodi_3001;

    public Mahasiswa_2511533001(String nama_3001, String nim_3001, String prodi_3001) {

        this.nama_3001 = nama_3001;
        this.nim_3001 = nim_3001;
        this.prodi_3001 = prodi_3001;
    }

    public String getNama_3001() {
        return nama_3001;
    }

    public String getNim_3001() {
        return nim_3001;
    }

    public String getProdi_3001() {
        return prodi_3001;
    }

    @Override
    public String toString() {

        return nama_3001 + " (" + nim_3001 + " - " + prodi_3001 + ")";
    }
}