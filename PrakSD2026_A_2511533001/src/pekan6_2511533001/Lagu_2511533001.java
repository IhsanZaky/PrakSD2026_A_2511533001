package pekan6_2511533001;

public class Lagu_2511533001 {
    String judul_3001;
    String penyanyi_3001;
    Lagu_2511533001 next_3001;
    Lagu_2511533001 prev_3001;

    public Lagu_2511533001(String judul_3001, String penyanyi_3001) {
        this.judul_3001 = judul_3001;
        this.penyanyi_3001 = penyanyi_3001;
        this.next_3001 = null;
        this.prev_3001 = null;
    }

    public String getJudul_3001() { return judul_3001; }
    public String getPenyanyi_3001() { return penyanyi_3001; }
    public Lagu_2511533001 getNext_3001() { return next_3001; }
    public Lagu_2511533001 getPrev_3001() { return prev_3001; }
    public void setNext_3001(Lagu_2511533001 next_3001) { this.next_3001 = next_3001; }
    public void setPrev_3001(Lagu_2511533001 prev_3001) { this.prev_3001 = prev_3001; }
}