package pekan3_2511533001;
import java.util.ArrayList;
class Siswa_3001 {
	String nama_3001;
	int nim_3001;
	
public Siswa_3001(String nama, int nim) {
	this.nama_3001 = nama;
	this.nim_3001 = nim;
}

	
	public String toString() {
		return "Nim: " + nim_3001 + ", Nama: " + nama_3001;
	}
}

public class SiswaStack_2511533001 {
	private ArrayList<Siswa_3001> stack;
	
	public SiswaStack_2511533001 () {
		stack = new ArrayList<>();
	}
	
	public void push(Siswa_3001 mhs) {
		stack.add(mhs);
	}
	
	public Siswa_3001 pop_3001 () {
		if (!isEmpty()) {
			return stack.remove(stack.size() - 1);
		}
		return null;
	}
	
	public Siswa_3001 peek_3001() {
		if (!isEmpty()) {
			return stack.remove(stack.size() - 1);
		}
		return null;
	}
	
	public boolean isEmpty() {
		return stack.isEmpty();
	}
	public void tampilkansiswa_3001() {
		for (int i = stack.size () - 1; i >= 0; i--) {
			System.out.println(stack.get(i));
		}
	}
 public static void main(String[] args) {
	 SiswaStack_2511533001 studentStack_3001 = new SiswaStack_2511533001 ();
 
	 Siswa_3001 mhs1 = new Siswa_3001("Ali", 1);
	 Siswa_3001 mhs2 = new Siswa_3001("Boby", 2);
	 Siswa_3001 mhs3 = new Siswa_3001("Charles", 3);
	 
	 studentStack_3001.push(mhs1);
	 studentStack_3001.push(mhs2);
	 studentStack_3001.push(mhs3);
	 
	 System.out.println("Siswa di dalam stack:");
	 studentStack_3001.tampilkansiswa_3001();
	 
	 System.out.println("siswa teratas " + studentStack_3001.peek_3001());
	 System.out.println("mengeluarkan siswa teratas dari stack: " + studentStack_3001.pop_3001());
	 System.out.println("daftar siswa setelah di pop :");
	 studentStack_3001.tampilkansiswa_3001();
 }
 } 
 
 
 
 
 
