package pekan8_2511533001;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import java.util.LinkedList;
import java.util.Queue;

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
import javax.swing.SwingUtilities;

public class MergeSortGUI_2511533001 extends JFrame {

    private static final long serialVersionUID_3001 = 1L;

    private int[] array_3001;
    private JLabel[] labelArray_3001;
    private JButton stepButton_3001, resetButton_3001, setButton_3001;
    private JTextField inputField_3001;
    private JPanel panelArray_3001;
    private JTextArea stepArea_3001;

    private int i_3001, j_3001, k_3001;
    private int left_3001, mid_3001, right_3001;
    private int[] temp_3001;

    private boolean isMerging_3001 = false;
    private boolean copying_3001 = false;
    private int stepCount_3001 = 1;

    private Queue<int[]> mergeQueue_3001 = new LinkedList<>();

    public MergeSortGUI_2511533001() {
        setTitle("Merge Sort Langkah per Langkah");
        setSize(750, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Panel input
        JPanel inputPanel_3001 = new JPanel(new FlowLayout());
        inputField_3001 = new JTextField(30);
        setButton_3001 = new JButton("Set Array");
        inputPanel_3001.add(new JLabel("Masukkan angka (pisahkan dengan koma):"));
        inputPanel_3001.add(inputField_3001);
        inputPanel_3001.add(setButton_3001);

        // Panel array visual
        panelArray_3001 = new JPanel();
        panelArray_3001.setLayout(new FlowLayout());

        // Panel kontrol
        JPanel controlPanel_3001 = new JPanel();
        stepButton_3001 = new JButton("Langkah Selanjutnya");
        resetButton_3001 = new JButton("Reset");
        stepButton_3001.setEnabled(false);
        controlPanel_3001.add(stepButton_3001);
        controlPanel_3001.add(resetButton_3001);

        // Area teks untuk log langkah-langkah
        stepArea_3001 = new JTextArea(8, 60);
        stepArea_3001.setEditable(false);
        stepArea_3001.setFont(new Font("Monospaced", Font.PLAIN, 14));
        JScrollPane scrollPane_3001 = new JScrollPane(stepArea_3001);

        // Tambahkan panel ke frame
        add(inputPanel_3001, BorderLayout.NORTH);
        add(panelArray_3001, BorderLayout.CENTER);
        add(controlPanel_3001, BorderLayout.SOUTH);
        add(scrollPane_3001, BorderLayout.EAST);

        // Event Set Array
        setButton_3001.addActionListener(e_3001 -> setArrayFromInput_3001());

        // Event Langkah Selanjutnya
        stepButton_3001.addActionListener(e_3001 -> performStep_3001());

        // Event Reset
        resetButton_3001.addActionListener(e_3001 -> reset_3001());
    }

    private void setArrayFromInput_3001() {
        String text_3001 = inputField_3001.getText().trim();
        if (text_3001.isEmpty()) return;

        String[] parts_3001 = text_3001.split(",");
        array_3001 = new int[parts_3001.length];

        try {
            for (int i_3001 = 0; i_3001 < parts_3001.length; i_3001++) {
                array_3001[i_3001] = Integer.parseInt(parts_3001[i_3001].trim());
            }
        } catch (NumberFormatException e_3001) {
            JOptionPane.showMessageDialog(this, "Masukkan hanya angka!",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        labelArray_3001 = new JLabel[array_3001.length];
        panelArray_3001.removeAll();

        for (int i_3001 = 0; i_3001 < array_3001.length; i_3001++) {
            labelArray_3001[i_3001] = new JLabel(String.valueOf(array_3001[i_3001]));
            labelArray_3001[i_3001].setFont(new Font("Arial", Font.BOLD, 24));
            labelArray_3001[i_3001].setOpaque(true);
            labelArray_3001[i_3001].setBackground(Color.WHITE);
            labelArray_3001[i_3001].setBorder(BorderFactory.createLineBorder(Color.BLACK));
            labelArray_3001[i_3001].setPreferredSize(new Dimension(50, 50));
            labelArray_3001[i_3001].setHorizontalAlignment(SwingConstants.CENTER);
            panelArray_3001.add(labelArray_3001[i_3001]);
        }

        mergeQueue_3001.clear();
        generateMergeSteps_3001(0, array_3001.length - 1);

        stepButton_3001.setEnabled(true);
        stepArea_3001.setText("");
        stepCount_3001 = 1;
        isMerging_3001 = false;
        copying_3001 = false;

        panelArray_3001.revalidate();
        panelArray_3001.repaint();
    }

    private void generateMergeSteps_3001(int left_3001, int right_3001) {
        if (left_3001 < right_3001) {
            int mid_3001 = left_3001 + (right_3001 - left_3001) / 2;

            generateMergeSteps_3001(left_3001, mid_3001);
            generateMergeSteps_3001(mid_3001 + 1, right_3001);

            mergeQueue_3001.add(new int[] { left_3001, mid_3001, right_3001 });
        }
    }

    private void performStep_3001() {
        resetHighlights_3001();

        if (!isMerging_3001 && !mergeQueue_3001.isEmpty()) {
            int[] range_3001 = mergeQueue_3001.poll();

            left_3001 = range_3001[0];
            mid_3001 = range_3001[1];
            right_3001 = range_3001[2];

            temp_3001 = new int[right_3001 - left_3001 + 1];

            i_3001 = left_3001;
            j_3001 = mid_3001 + 1;
            k_3001 = 0;

            copying_3001 = false;
            isMerging_3001 = true;

            stepArea_3001.append(
                    "Langkah " + stepCount_3001++
                            + ": Mulai merge dari "
                            + left_3001 + " ke "
                            + right_3001 + "\n"
            );

            return;
        }

        if (isMerging_3001 && !copying_3001) {
            if (i_3001 <= mid_3001 && j_3001 <= right_3001) {
                labelArray_3001[i_3001].setBackground(Color.CYAN);
                labelArray_3001[j_3001].setBackground(Color.CYAN);

                if (array_3001[i_3001] <= array_3001[j_3001]) {
                    temp_3001[k_3001++] = array_3001[i_3001++];
                } else {
                    temp_3001[k_3001++] = array_3001[j_3001++];
                }

                stepArea_3001.append(
                        "Langkah " + stepCount_3001++
                                + ": Bandingkan dan salin elemen\n"
                );

                return;

            } else if (i_3001 <= mid_3001) {
                temp_3001[k_3001++] = array_3001[i_3001++];

                stepArea_3001.append(
                        "Langkah " + stepCount_3001++
                                + ": Salin sisa kiri\n"
                );

                return;

            } else if (j_3001 <= right_3001) {
                temp_3001[k_3001++] = array_3001[j_3001++];

                stepArea_3001.append(
                        "Langkah " + stepCount_3001++
                                + ": Salin sisa kanan\n"
                );

                return;

            } else {
                copying_3001 = true;
                k_3001 = 0;
                return;
            }
        }

        if (copying_3001 && k_3001 < temp_3001.length) {
            array_3001[left_3001 + k_3001] = temp_3001[k_3001];
            labelArray_3001[left_3001 + k_3001].setText(String.valueOf(temp_3001[k_3001]));
            labelArray_3001[left_3001 + k_3001].setBackground(Color.GREEN);
            k_3001++;

            stepArea_3001.append("Langkah " + stepCount_3001++ + ": Tempelkan ke array utama\n");
            return;
        }

        if (copying_3001 && k_3001 == temp_3001.length) {
            isMerging_3001 = false;
            copying_3001 = false;
        }

        if (mergeQueue_3001.isEmpty() && !isMerging_3001) {
            stepArea_3001.append("Selesai.\n");
            stepButton_3001.setEnabled(false);
            JOptionPane.showMessageDialog(this, "Merge Sort selesai!");
        }
    }

    private void resetHighlights_3001() {
        if (labelArray_3001 == null) return;

        for (JLabel label_3001 : labelArray_3001) {
            label_3001.setBackground(Color.WHITE);
        }
    }

    private void reset_3001() {
        inputField_3001.setText("");
        panelArray_3001.removeAll();
        panelArray_3001.revalidate();
        panelArray_3001.repaint();
        stepArea_3001.setText("");
        stepButton_3001.setEnabled(false);
        mergeQueue_3001.clear();
        isMerging_3001 = false;
        copying_3001 = false;
        stepCount_3001 = 1;
    }

    public static void main(String[] args_3001) {
        SwingUtilities.invokeLater(() -> {
            MergeSortGUI_2511533001 frame_3001 = new MergeSortGUI_2511533001();
            frame_3001.setVisible(true);
        });
    }
}