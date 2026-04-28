package pekan4_2511533001;

import java.util.*;

public class IterasiQueue_2511533001 {
	public static void main(String[] args) 
	{		
		Queue<String> q_3001 = new LinkedList<>();
		
		q_3001.add("Praktikum");
		q_3001.add("Struktur");
		q_3001.add("Data");
		q_3001.add("Dan");
		q_3001.add("Algoritma");
		Iterator<String> iterator_3001 = q_3001.iterator();
		while (iterator_3001.hasNext()) {
			System.out.print(iterator_3001.next() + " ");
		}
	}
}
