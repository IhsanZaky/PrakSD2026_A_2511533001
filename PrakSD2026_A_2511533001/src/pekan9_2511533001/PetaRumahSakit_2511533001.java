package pekan9_2511533001;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.RenderingHints;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class PetaRumahSakit_2511533001 extends JFrame {

    private static final long serialVersionUID = 1L;

    private Map<String, List<String>> graph_3001;
    private Map<String, int[]> posisi_3001;
    private Set<String> visitedNodes_3001;
    private List<String> pathNodes_3001;

    private JComboBox<String> comboAwal_3001;
    private JComboBox<String> comboTujuan_3001;
    private JTextArea hasilArea_3001;
    private GraphPanel_2511533001 graphPanel_3001;

    public PetaRumahSakit_2511533001() {
        graph_3001 = new LinkedHashMap<>();
        posisi_3001 = new LinkedHashMap<>();
        visitedNodes_3001 = new HashSet<>();
        pathNodes_3001 = new ArrayList<>();

        inisialisasiGraph_3001();

        setTitle("Pencarian Jalur Peta Rumah Sakit - 2511533001");
        setSize(900, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(5, 5));

        // Panel Atas
        JPanel panelKontrol_3001 = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 8));
        panelKontrol_3001.setBackground(new Color(30, 60, 100));

        String[] nodes_3001 = graph_3001.keySet().toArray(new String[0]);
        comboAwal_3001 = new JComboBox<>(nodes_3001);
        comboTujuan_3001 = new JComboBox<>(nodes_3001);
        comboTujuan_3001.setSelectedIndex(nodes_3001.length - 1);

        JLabel lblAwal_3001 = new JLabel("Lokasi Awal  :");
        JLabel lblTujuan_3001 = new JLabel("Lokasi Tujuan:");
        lblAwal_3001.setForeground(Color.WHITE);
        lblTujuan_3001.setForeground(Color.WHITE);

        JButton btnBFS_3001 = new JButton("[ BFS ]");
        JButton btnDFS_3001 = new JButton("[ DFS ]");
        JButton btnReset_3001 = new JButton("[ RESET ]");

        btnBFS_3001.setBackground(new Color(0, 180, 80));
        btnBFS_3001.setForeground(Color.WHITE);
        btnBFS_3001.setFont(new Font("Monospaced", Font.BOLD, 13));

        btnDFS_3001.setBackground(new Color(200, 130, 0));
        btnDFS_3001.setForeground(Color.WHITE);
        btnDFS_3001.setFont(new Font("Monospaced", Font.BOLD, 13));

        btnReset_3001.setBackground(new Color(180, 30, 30));
        btnReset_3001.setForeground(Color.WHITE);
        btnReset_3001.setFont(new Font("Monospaced", Font.BOLD, 13));

        JPanel leftPanel_3001 = new JPanel(new GridLayout(2, 2, 5, 3));
        leftPanel_3001.setOpaque(false);
        leftPanel_3001.add(lblAwal_3001);
        leftPanel_3001.add(comboAwal_3001);
        leftPanel_3001.add(lblTujuan_3001);
        leftPanel_3001.add(comboTujuan_3001);

        panelKontrol_3001.add(leftPanel_3001);
        panelKontrol_3001.add(Box.createHorizontalStrut(30));
        panelKontrol_3001.add(btnBFS_3001);
        panelKontrol_3001.add(btnDFS_3001);
        panelKontrol_3001.add(btnReset_3001);

        add(panelKontrol_3001, BorderLayout.NORTH);

        // Panel Graph
        graphPanel_3001 = new GraphPanel_2511533001();
        graphPanel_3001.setBorder(BorderFactory.createTitledBorder("  VISUALISASI GRAPH PETA RUMAH SAKIT  "));
        graphPanel_3001.setPreferredSize(new Dimension(900, 380));
        add(graphPanel_3001, BorderLayout.CENTER);

        // Panel Hasil
        hasilArea_3001 = new JTextArea(6, 80);
        hasilArea_3001.setEditable(false);
        hasilArea_3001.setFont(new Font("Monospaced", Font.BOLD, 12));
        hasilArea_3001.setBackground(new Color(20, 20, 20));
        hasilArea_3001.setForeground(new Color(180, 255, 180));
        hasilArea_3001.setText("Hasil Pencarian :\nJalur :\nNode Dikunjungi :\nJumlah Node Dikunjungi : 0");
        JScrollPane scrollHasil_3001 = new JScrollPane(hasilArea_3001);
        scrollHasil_3001.setBorder(BorderFactory.createTitledBorder("  HASIL PENCARIAN  "));
        add(scrollHasil_3001, BorderLayout.SOUTH);

        // Event Listeners
        btnBFS_3001.addActionListener(e -> {
            String awal_3001 = (String) comboAwal_3001.getSelectedItem();
            String tujuan_3001 = (String) comboTujuan_3001.getSelectedItem();
            BFS_3001(awal_3001, tujuan_3001);
        });

        btnDFS_3001.addActionListener(e -> {
            String awal_3001 = (String) comboAwal_3001.getSelectedItem();
            String tujuan_3001 = (String) comboTujuan_3001.getSelectedItem();
            DFS_3001(awal_3001, tujuan_3001);
        });

        btnReset_3001.addActionListener(e -> resetGraph_3001());
    }

    private void inisialisasiGraph_3001() {
        addEdge_3001("Pintu Masuk",   "Lobi Utama");
        addEdge_3001("Pintu Masuk",   "Parkiran");
        addEdge_3001("Lobi Utama",    "Pendaftaran");
        addEdge_3001("Lobi Utama",    "Apotek");
        addEdge_3001("Pendaftaran",   "Poli Umum");
        addEdge_3001("Pendaftaran",   "Poli Anak");
        addEdge_3001("Poli Umum",     "Laboratorium");
        addEdge_3001("Poli Umum",     "Radiologi");
        addEdge_3001("Poli Anak",     "Radiologi");
        addEdge_3001("Laboratorium",  "IGD");
        addEdge_3001("Radiologi",     "IGD");
        addEdge_3001("IGD",           "Ruang Operasi");
        addEdge_3001("IGD",           "ICU");
        addEdge_3001("Ruang Operasi", "ICU");
        addEdge_3001("ICU",           "Rawat Inap");
        addEdge_3001("Apotek",        "Kasir");
        addEdge_3001("Kasir",         "Pintu Keluar");

        posisi_3001.put("Pintu Masuk",   new int[]{80,  180});
        posisi_3001.put("Parkiran",      new int[]{80,  310});
        posisi_3001.put("Lobi Utama",    new int[]{220, 180});
        posisi_3001.put("Pendaftaran",   new int[]{360, 100});
        posisi_3001.put("Apotek",        new int[]{360, 260});
        posisi_3001.put("Poli Umum",     new int[]{490, 60});
        posisi_3001.put("Poli Anak",     new int[]{490, 160});
        posisi_3001.put("Laboratorium",  new int[]{620, 60});
        posisi_3001.put("Radiologi",     new int[]{620, 160});
        posisi_3001.put("IGD",           new int[]{730, 110});
        posisi_3001.put("Ruang Operasi", new int[]{820, 60});
        posisi_3001.put("ICU",           new int[]{820, 160});
        posisi_3001.put("Rawat Inap",    new int[]{820, 260});
        posisi_3001.put("Kasir",         new int[]{490, 310});
        posisi_3001.put("Pintu Keluar",  new int[]{620, 310});
    }

    private void addEdge_3001(String a_3001, String b_3001) {
        graph_3001.putIfAbsent(a_3001, new ArrayList<>());
        graph_3001.putIfAbsent(b_3001, new ArrayList<>());
        graph_3001.get(a_3001).add(b_3001);
        graph_3001.get(b_3001).add(a_3001);
    }

    public void BFS_3001(String start_3001, String goal_3001) {
        Map<String, String> parent_3001 = new LinkedHashMap<>();
        Queue<String> queue_3001 = new LinkedList<>();
        Set<String> visited_3001 = new LinkedHashSet<>();

        queue_3001.add(start_3001);
        visited_3001.add(start_3001);
        parent_3001.put(start_3001, null);

        while (!queue_3001.isEmpty()) {
            String current_3001 = queue_3001.poll();
            if (current_3001.equals(goal_3001)) break;
            List<String> neighbors_3001 = graph_3001.get(current_3001);
            if (neighbors_3001 == null) continue;
            for (String neighbor_3001 : neighbors_3001) {
                if (!visited_3001.contains(neighbor_3001)) {
                    visited_3001.add(neighbor_3001);
                    parent_3001.put(neighbor_3001, current_3001);
                    queue_3001.add(neighbor_3001);
                }
            }
        }

        List<String> path_3001 = bangunJalur_3001(parent_3001, start_3001, goal_3001);
        displayPath_3001("BFS", new ArrayList<>(visited_3001), path_3001);
    }

    public void DFS_3001(String start_3001, String goal_3001) {
        Map<String, String> parent_3001 = new LinkedHashMap<>();
        Set<String> visited_3001 = new LinkedHashSet<>();
        parent_3001.put(start_3001, null);
        dfsHelper_3001(start_3001, goal_3001, visited_3001, parent_3001);

        List<String> path_3001 = bangunJalur_3001(parent_3001, start_3001, goal_3001);
        displayPath_3001("DFS", new ArrayList<>(visited_3001), path_3001);
    }

    private boolean dfsHelper_3001(String current_3001, String goal_3001,
                                    Set<String> visited_3001, Map<String, String> parent_3001) {
        visited_3001.add(current_3001);
        if (current_3001.equals(goal_3001)) return true;
        List<String> neighbors_3001 = graph_3001.get(current_3001);
        if (neighbors_3001 == null) return false;
        for (String neighbor_3001 : neighbors_3001) {
            if (!visited_3001.contains(neighbor_3001)) {
                parent_3001.put(neighbor_3001, current_3001);
                if (dfsHelper_3001(neighbor_3001, goal_3001, visited_3001, parent_3001)) return true;
            }
        }
        return false;
    }

    private List<String> bangunJalur_3001(Map<String, String> parent_3001, String start_3001, String goal_3001) {
        List<String> path_3001 = new ArrayList<>();
        if (!parent_3001.containsKey(goal_3001)) return path_3001;
        String curr_3001 = goal_3001;
        while (curr_3001 != null) {
            path_3001.add(0, curr_3001);
            curr_3001 = parent_3001.get(curr_3001);
        }
        return path_3001;
    }

    public void displayPath_3001(String metode_3001, List<String> visited_3001, List<String> path_3001) {
        visitedNodes_3001 = new HashSet<>(visited_3001);
        pathNodes_3001 = new ArrayList<>(path_3001);
        graphPanel_3001.repaint();

        StringBuilder sb_3001 = new StringBuilder();
        sb_3001.append("Hasil Pencarian : ").append(metode_3001).append("\n");
        sb_3001.append("Jalur           : ").append(path_3001.isEmpty() ? "Tidak ditemukan" : String.join(" -> ", path_3001)).append("\n");
        sb_3001.append("Node Dikunjungi : ").append(String.join(", ", visited_3001)).append("\n");
        sb_3001.append("Jumlah Node Dikunjungi : ").append(visited_3001.size());
        hasilArea_3001.setText(sb_3001.toString());
    }

    public void displayGraph_3001(Graphics g_3001) {
        Graphics2D g2_3001 = (Graphics2D) g_3001;
        g2_3001.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Gambar edge
        Set<String> drawnEdges_3001 = new HashSet<>();
        for (String node_3001 : graph_3001.keySet()) {
            int[] pos1_3001 = posisi_3001.get(node_3001);
            if (pos1_3001 == null) continue;
            List<String> neighbors_3001 = graph_3001.get(node_3001);
            if (neighbors_3001 == null) continue;
            for (String neighbor_3001 : neighbors_3001) {
                String edgeKey_3001 = node_3001.compareTo(neighbor_3001) < 0
                        ? node_3001 + "-" + neighbor_3001
                        : neighbor_3001 + "-" + node_3001;
                if (drawnEdges_3001.contains(edgeKey_3001)) continue;
                drawnEdges_3001.add(edgeKey_3001);
                int[] pos2_3001 = posisi_3001.get(neighbor_3001);
                if (pos2_3001 == null) continue;

                boolean isPath_3001 = false;
                if (pathNodes_3001.contains(node_3001) && pathNodes_3001.contains(neighbor_3001)) {
                    int idx1_3001 = pathNodes_3001.indexOf(node_3001);
                    int idx2_3001 = pathNodes_3001.indexOf(neighbor_3001);
                    if (Math.abs(idx1_3001 - idx2_3001) == 1) isPath_3001 = true;
                }

                if (isPath_3001) {
                    g2_3001.setColor(new Color(255, 220, 0));
                    g2_3001.setStroke(new BasicStroke(3f));
                } else {
                    g2_3001.setColor(new Color(120, 120, 120));
                    g2_3001.setStroke(new BasicStroke(1.5f));
                }
                g2_3001.drawLine(pos1_3001[0], pos1_3001[1], pos2_3001[0], pos2_3001[1]);
            }
        }

        // Gambar node
        int r_3001 = 28;
        for (String node_3001 : posisi_3001.keySet()) {
            int[] pos_3001 = posisi_3001.get(node_3001);
            Color fillColor_3001;
            if (pathNodes_3001.contains(node_3001)) {
                fillColor_3001 = new Color(255, 210, 0);
            } else if (visitedNodes_3001.contains(node_3001)) {
                fillColor_3001 = new Color(80, 160, 255);
            } else {
                fillColor_3001 = new Color(50, 50, 80);
            }
            g2_3001.setColor(fillColor_3001);
            g2_3001.fillOval(pos_3001[0] - r_3001, pos_3001[1] - r_3001, r_3001 * 2, r_3001 * 2);
            g2_3001.setColor(Color.WHITE);
            g2_3001.setStroke(new BasicStroke(1.5f));
            g2_3001.drawOval(pos_3001[0] - r_3001, pos_3001[1] - r_3001, r_3001 * 2, r_3001 * 2);

            g2_3001.setColor(Color.WHITE);
            g2_3001.setFont(new Font("Arial", Font.BOLD, 9));
            FontMetrics fm_3001 = g2_3001.getFontMetrics();
            String[] words_3001 = node_3001.split(" ");
            int lineH_3001 = fm_3001.getHeight();
            int startY_3001 = pos_3001[1] - (lineH_3001 * words_3001.length) / 2 + fm_3001.getAscent();
            for (String word_3001 : words_3001) {
                int w_3001 = fm_3001.stringWidth(word_3001);
                g2_3001.drawString(word_3001, pos_3001[0] - w_3001 / 2, startY_3001);
                startY_3001 += lineH_3001;
            }
        }

        // Legend
        g2_3001.setFont(new Font("Arial", Font.PLAIN, 11));
        int lx_3001 = 15;
        int ly_3001 = 20;
        g2_3001.setColor(new Color(50, 50, 80));
        g2_3001.fillOval(lx_3001, ly_3001, 14, 14);
        g2_3001.setColor(Color.LIGHT_GRAY);
        g2_3001.drawString("Belum dikunjungi", lx_3001 + 18, ly_3001 + 11);
        ly_3001 += 20;
        g2_3001.setColor(new Color(80, 160, 255));
        g2_3001.fillOval(lx_3001, ly_3001, 14, 14);
        g2_3001.setColor(Color.LIGHT_GRAY);
        g2_3001.drawString("Dikunjungi", lx_3001 + 18, ly_3001 + 11);
        ly_3001 += 20;
        g2_3001.setColor(new Color(255, 210, 0));
        g2_3001.fillOval(lx_3001, ly_3001, 14, 14);
        g2_3001.setColor(Color.LIGHT_GRAY);
        g2_3001.drawString("Jalur ditemukan", lx_3001 + 18, ly_3001 + 11);
    }

    public void resetGraph_3001() {
        visitedNodes_3001.clear();
        pathNodes_3001.clear();
        graphPanel_3001.repaint();
        hasilArea_3001.setText("Hasil Pencarian :\nJalur :\nNode Dikunjungi :\nJumlah Node Dikunjungi : 0");
    }

    class GraphPanel_2511533001 extends JPanel {
        private static final long serialVersionUID = 1L;

        public GraphPanel_2511533001() {
            setBackground(new Color(15, 15, 30));
        }

        @Override
        protected void paintComponent(Graphics g_3001) {
            super.paintComponent(g_3001);
            displayGraph_3001(g_3001);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new PetaRumahSakit_2511533001().setVisible(true);
            }
        });
    }
}