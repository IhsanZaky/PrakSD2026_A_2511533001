package pekan1_2511533001;

public final class Jam_2511533001 {
	private int hh; // 0..23
	private int mm; // 0..59
	private int ss; // 0..59
	
	// -- Validator ---
	public static boolean isValid(int h, int m, int s) {
		return (0 <= h && h<=23) && (0 <= m && m<=59) && (0 <= s && s<=59);
	}

	// -- Konstruktor/kreator ---
	public Jam_2511533001(int h, int m, int s) {
		this.hh = h; this.mm = m; this.ss = s; 
	}

public int getHour() {return hh;}
public int getMinute() {return mm;}
public int getSecond() {return ss;}

public void SetHour(int h) {this.hh =h;}
public void SetMinute(int m) {this.mm =m;}
public void SetSecond(int s) {this.ss =s;}
	
	//---Konversi---
public int toSeconds() {return hh * 3600 + mm * 60 + ss;}
public static Jam_2511533001 fromSeconds (int total)	{
	if (total < 0) throw new IllegalArgumentException("detik negatif");
	total %= 24 * 3600;
	int h = total /3600; total %= 3600;
	int m = total /60;
	int s = total % 60;
	return new Jam_2511533001(h,m,s);
}
	//---Relasional---
public int compareTo (Jam_2511533001 other) {return Integer.compare(this.toSeconds(), other.toSeconds());}
public boolean equals (Object o) {
	if (!(o instanceof Jam_2511533001 j)) return false;
	return hh == j.hh && mm == j.mm && ss == j.ss;
}
public int hashCode() {return java.util.Objects.hash(hh,mm,ss);}
	
	//---Aritmatika---
public Jam_2511533001 plus (Jam_2511533001 other) {return fromSeconds (this.toSeconds() + other.toSeconds());}
public Jam_2511533001 minus (Jam_2511533001 other) {return fromSeconds (Math.floorMod(this.toSeconds() - other.toSeconds(), 24*3600));}
public Jam_2511533001 nextSecond () {return fromSeconds(this.toSeconds() +1); }
public Jam_2511533001 nextNSecond (int n) {return fromSeconds (this.toSeconds() + Math.max(0, n));}
public Jam_2511533001 prevSecond () {return fromSeconds (Math.floorMod(this.toSeconds() - 1, 24*3600));}
public Jam_2511533001 prevNSecond (int n) {return fromSeconds (Math.floorMod(this.toSeconds() - Math.max(0,n), 24*3600));}

	//---Durasi (detik)-- bisa negatif jika this > other? sesuai spesifikasi durasi (JAw, JAkh)
public static int durasiDetik(Jam_2511533001 jaw, Jam_2511533001 jakh) {return jakh.toSeconds() - jaw.toSeconds();}
	//---overriding ke string
public String toString() {return String.format("%02d:%02d:%02d", hh, mm,ss);}

}


