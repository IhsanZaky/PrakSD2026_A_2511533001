package pekan7_2511533001;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class InsertionSortGUI_2511533001 extends JFrame {

	private static final long serialVersionUID = 1L;
	private int[] array_3001;
	private JLabel[] labelArray_3001;
	JButton stepButton_3001;
	private JButton resetButton_3001;
	JButton setButton_3001;
	private JTextField inputField_3001;
	private JPanel panelArray_3001;
	private JTextArea stepArea_3001;

	private int i_3001 = 1, j_3001;
	private boolean sorting_3001 = false;
	private int stepCount_3001 = 1;

	public InsertionSortGUI_2511533001() {
		setTitle("Insertion Sort Langkah per Langkah");
		setSize(750, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());

		// FIX 3: inputField dibuat di sini dan ditambahkan ke inputPanel (bukan ke scrollPane)
		JPanel inputPanel_3001 = new JPanel(new FlowLayout());
		inputField_3001 = new JTextField(30);
		setButton_3001 = new JButton("Set Array");

		inputPanel_3001.add(new JLabel("Masukkan angka (pisahkan dengan koma):"));
		inputPanel_3001.add(inputField_3001);
		inputPanel_3001.add(setButton_3001);

		panelArray_3001 = new JPanel();
		panelArray_3001.setLayout(new FlowLayout());

		JPanel controlPanel_3001 = new JPanel();
		stepButton_3001 = new JButton("Langkah Selanjutnya");
		resetButton_3001 = new JButton("Reset");
		stepButton_3001.setEnabled(false);
		controlPanel_3001.add(stepButton_3001);
		controlPanel_3001.add(resetButton_3001);

		stepArea_3001 = new JTextArea(8, 60);
		stepArea_3001.setEditable(false);
		stepArea_3001.setFont(new Font("Monospaced", Font.PLAIN, 14));
		JScrollPane scrollPane = new JScrollPane(stepArea_3001);

		getContentPane().add(inputPanel_3001, BorderLayout.NORTH);
		getContentPane().add(panelArray_3001, BorderLayout.CENTER);
		getContentPane().add(controlPanel_3001, BorderLayout.SOUTH);
		getContentPane().add(scrollPane, BorderLayout.EAST);

		setButton_3001.addActionListener(e -> setArrayFromInput_3001());
		stepButton_3001.addActionListener(e -> performStep_3001());
		resetButton_3001.addActionListener(e -> reset_3001());
	}

	private void setArrayFromInput_3001() {
		String text_3001 = inputField_3001.getText().trim();
		if (text_3001.isEmpty()) return;
		String[] parts_3001 = text_3001.split(",");
		array_3001 = new int[parts_3001.length];
		try {
			for (int k_3001 = 0; k_3001 < parts_3001.length; k_3001++) {
				array_3001[k_3001] = Integer.parseInt(parts_3001[k_3001].trim());
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "Masukan hanya angka dipisahkan dengan koma!", "Error",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		i_3001 = 1;
		stepCount_3001 = 1;
		sorting_3001 = true;
		stepButton_3001.setEnabled(true);
		stepArea_3001.setText("");
		panelArray_3001.removeAll();
		labelArray_3001 = new JLabel[array_3001.length];
		for (int k_3001 = 0; k_3001 < array_3001.length; k_3001++) {
			labelArray_3001[k_3001] = new JLabel(String.valueOf(array_3001[k_3001]));
			labelArray_3001[k_3001].setFont(new Font("Arial", Font.BOLD, 24));
			labelArray_3001[k_3001].setBorder(BorderFactory.createLineBorder(Color.BLACK));
			labelArray_3001[k_3001].setPreferredSize(new Dimension(50, 50));
			labelArray_3001[k_3001].setHorizontalAlignment(SwingConstants.CENTER);
			panelArray_3001.add(labelArray_3001[k_3001]);
		}
		panelArray_3001.revalidate();
		panelArray_3001.repaint();
	}

	private void performStep_3001() {
		if (i_3001 < array_3001.length && sorting_3001) {
			int key_3001 = array_3001[i_3001];
			j_3001 = i_3001 - 1;

			StringBuilder stepLog_3001 = new StringBuilder();
			stepLog_3001.append("Langkah ").append(stepCount_3001).append(": Memasukkan ").append(key_3001).append("\n");

			while (j_3001 >= 0 && array_3001[j_3001] > key_3001) {
				array_3001[j_3001 + 1] = array_3001[j_3001];
				j_3001--;
			}

			// FIX 1: j_3001 + 1 bukan j_3001 = 1
			array_3001[j_3001 + 1] = key_3001;

			updateLabels_3001();

			stepLog_3001.append("Hasil: ").append(arrayToString_3001(array_3001)).append("\n\n");

			// FIX 2: append log ke stepArea agar muncul di layar
			stepArea_3001.append(stepLog_3001.toString());

			i_3001++;
			stepCount_3001++;

			if (i_3001 == array_3001.length) {
				sorting_3001 = false;
				stepButton_3001.setEnabled(false);
				JOptionPane.showMessageDialog(this, "Sorting selesai!");
			}
		}
	}

	private void updateLabels_3001() {
		for (int k = 0; k < array_3001.length; k++) {
			labelArray_3001[k].setText(String.valueOf(array_3001[k]));
		}
	}

	private void reset_3001() {
		inputField_3001.setText("");
		panelArray_3001.removeAll();
		panelArray_3001.revalidate();
		panelArray_3001.repaint();
		stepArea_3001.setText("");
		stepButton_3001.setEnabled(false);
		sorting_3001 = false;
		i_3001 = 1;
		stepCount_3001 = 1;
	}

	private String arrayToString_3001(int[] arr_3001) {
		StringBuilder sb = new StringBuilder();
		for (int k = 0; k < arr_3001.length; k++) {
			sb.append(arr_3001[k]);
			if (k < arr_3001.length - 1) sb.append(", ");
		}
		return sb.toString();
	}

	// FIX 4: Tambah method main agar bisa dijalankan
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InsertionSortGUI_2511533001 frame = new InsertionSortGUI_2511533001();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}