package pekan3_2511533001;

public class Website_2511533001 {
    private String judul_3001;
    private String url_3001;

    public Website_2511533001(String judul_3001, String url_3001) {
        this.judul_3001 = judul_3001;
        this.url_3001 = url_3001;
    }

    public String getJudul_3001() {
        return judul_3001;
    }

    public String getUrl_3001() {
        return url_3001;
    }

    public void setJudul_3001(String judul_3001) {
        this.judul_3001 = judul_3001;
    }

    public void setUrl_3001(String url_3001) {
        this.url_3001 = url_3001;
    }

    @Override
    public String toString() {
        return "Judul: " + judul_3001 + "\nURL : " + url_3001;
    }
}