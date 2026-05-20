package pekan7_2511533001;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class SortingGUI_2511533001 extends JFrame {

    private ArrayList<Mahasiswa_2511533001> listMahasiswa_3001 = new ArrayList<>();

    private JTextField txtNama_3001, txtNim_3001, txtProdi_3001;
    private JTextArea txtHasil_3001;
    private JComboBox<String> comboSort_3001;

    public SortingGUI_2511533001() {

        // data awal
        listMahasiswa_3001.add(new Mahasiswa_2511533001(
                "Zaky", "2511533001", "Informatika"));

        listMahasiswa_3001.add(new Mahasiswa_2511533001(
                "Digo", "2511523017", "Sistem Informasi"));

        listMahasiswa_3001.add(new Mahasiswa_2511533001(
                "Karim", "2511512029", "Teknik Komputer"));

        listMahasiswa_3001.add(new Mahasiswa_2511533001(
                "Endy", "2511531017", "Informatika"));

        listMahasiswa_3001.add(new Mahasiswa_2511533001(
                "Fahri", "2511511007", "Teknik Komputer"));

        setTitle("Sorting GUI Mahasiswa");
        setSize(600, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // panel input
        JPanel panelInput_3001 = new JPanel(new GridLayout(4,2,5,5));

        txtNama_3001 = new JTextField();
        txtNim_3001 = new JTextField();
        txtProdi_3001 = new JTextField();

        panelInput_3001.add(new JLabel("Nama"));
        panelInput_3001.add(txtNama_3001);

        panelInput_3001.add(new JLabel("NIM"));
        panelInput_3001.add(txtNim_3001);

        panelInput_3001.add(new JLabel("Prodi"));
        panelInput_3001.add(txtProdi_3001);

        JButton btnTambah_3001 = new JButton("Tambah");
        JButton btnReset_3001 = new JButton("Reset");

        panelInput_3001.add(btnTambah_3001);
        panelInput_3001.add(btnReset_3001);

        add(panelInput_3001, BorderLayout.NORTH);

        // text area
        txtHasil_3001 = new JTextArea();
        txtHasil_3001.setEditable(false);

        add(new JScrollPane(txtHasil_3001), BorderLayout.CENTER);

        // panel bawah
        JPanel panelBawah_3001 = new JPanel();

        String[] metode_3001 = {
                "Insertion Sort",
                "Selection Sort",
                "Bubble Sort"
        };

        comboSort_3001 = new JComboBox<>(metode_3001);

        JButton btnSort_3001 = new JButton("Sorting");

        panelBawah_3001.add(comboSort_3001);
        panelBawah_3001.add(btnSort_3001);

        add(panelBawah_3001, BorderLayout.SOUTH);

        tampilData_3001();

        // tombol tambah
        btnTambah_3001.addActionListener(e -> {

            String nama_3001 = txtNama_3001.getText();
            String nim_3001 = txtNim_3001.getText();
            String prodi_3001 = txtProdi_3001.getText();

            if(nama_3001.isEmpty() ||
               nim_3001.isEmpty() ||
               prodi_3001.isEmpty()){

                JOptionPane.showMessageDialog(
                        null,
                        "Isi semua data!");
            }else{

                listMahasiswa_3001.add(
                        new Mahasiswa_2511533001(
                                nama_3001,
                                nim_3001,
                                prodi_3001));

                tampilData_3001();

                txtNama_3001.setText("");
                txtNim_3001.setText("");
                txtProdi_3001.setText("");
            }
        });

        // tombol reset
        btnReset_3001.addActionListener(e -> {

            listMahasiswa_3001.clear();
            txtHasil_3001.setText("Data telah di-reset");
        });

        // tombol sorting
        btnSort_3001.addActionListener(e -> {

            ArrayList<Mahasiswa_2511533001> data_3001 =
                    new ArrayList<>(listMahasiswa_3001);

            String pilih_3001 =
                    comboSort_3001.getSelectedItem().toString();

            txtHasil_3001.setText(
                    "=== " + pilih_3001.toUpperCase() + " ===\n");

            txtHasil_3001.append(
                    "Data Awal : " +
                    tampilNama_3001(data_3001) + "\n\n");

            if(pilih_3001.equals("Insertion Sort")){

                insertionSort_3001(data_3001);

            }else if(pilih_3001.equals("Selection Sort")){

                selectionSort_3001(data_3001);

            }else{

                bubbleSort_3001(data_3001);
            }

            txtHasil_3001.append("\n=== HASIL AKHIR ===\n");

            for(Mahasiswa_2511533001 mhs_3001 : data_3001){

                txtHasil_3001.append(mhs_3001 + "\n");
            }
        });
    }

    // tampil data
    private void tampilData_3001() {

        txtHasil_3001.setText("Data Saat Ini:\n");

        for(Mahasiswa_2511533001 mhs_3001 : listMahasiswa_3001){

            txtHasil_3001.append(mhs_3001 + "\n");
        }
    }

    // tampil nama
    private String tampilNama_3001(ArrayList<Mahasiswa_2511533001> list_3001){

        String hasil_3001 = "[";

        for(int i_3001 = 0; i_3001 < list_3001.size(); i_3001++){

            hasil_3001 += list_3001.get(i_3001).getNama_3001();

            if(i_3001 != list_3001.size()-1){

                hasil_3001 += ", ";
            }
        }

        return hasil_3001 + "]";
    }

    // insertion sort
    private void insertionSort_3001(ArrayList<Mahasiswa_2511533001> arr_3001){

        for(int i_3001 = 1; i_3001 < arr_3001.size(); i_3001++){

            Mahasiswa_2511533001 key_3001 = arr_3001.get(i_3001);

            int j_3001 = i_3001 - 1;

            while(j_3001 >= 0 &&
                    arr_3001.get(j_3001).getNama_3001()
                            .compareToIgnoreCase(
                                    key_3001.getNama_3001()) > 0){

                arr_3001.set(j_3001 + 1,
                        arr_3001.get(j_3001));

                j_3001--;
            }

            arr_3001.set(j_3001 + 1, key_3001);

            txtHasil_3001.append(
                    "Langkah " + i_3001 + " : " +
                    tampilNama_3001(arr_3001) + "\n");
        }
    }

    // selection sort
    private void selectionSort_3001(ArrayList<Mahasiswa_2511533001> arr_3001){

        for(int i_3001 = 0; i_3001 < arr_3001.size()-1; i_3001++){

            int min_3001 = i_3001;

            for(int j_3001 = i_3001 + 1;
                j_3001 < arr_3001.size();
                j_3001++){

                if(arr_3001.get(j_3001).getNama_3001()
                        .compareToIgnoreCase(
                                arr_3001.get(min_3001)
                                        .getNama_3001()) < 0){

                    min_3001 = j_3001;
                }
            }

            Mahasiswa_2511533001 temp_3001 = arr_3001.get(min_3001);

            arr_3001.set(min_3001, arr_3001.get(i_3001));
            arr_3001.set(i_3001, temp_3001);

            txtHasil_3001.append(
                    "Pass " + (i_3001+1) + " : " +
                    tampilNama_3001(arr_3001) + "\n");
        }
    }

    // bubble sort
    private void bubbleSort_3001(ArrayList<Mahasiswa_2511533001> arr_3001){

        for(int i_3001 = 0; i_3001 < arr_3001.size()-1; i_3001++){

            for(int j_3001 = 0;
                j_3001 < arr_3001.size()-i_3001-1;
                j_3001++){

                if(arr_3001.get(j_3001).getNama_3001()
                        .compareToIgnoreCase(
                                arr_3001.get(j_3001+1)
                                        .getNama_3001()) > 0){

                    Mahasiswa_2511533001 temp_3001 =
                            arr_3001.get(j_3001);

                    arr_3001.set(j_3001,
                            arr_3001.get(j_3001+1));

                    arr_3001.set(j_3001+1,
                            temp_3001);
                }
            }

            txtHasil_3001.append(
                    "Pass " + (i_3001+1) + " : " +
                    tampilNama_3001(arr_3001) + "\n");
        }
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            new SortingGUI_2511533001().setVisible(true);
        });
    }
}