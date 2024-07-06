package ExemploPanels;

import javax.swing.*;
import java.awt.*;

public class SwingPanelsExample extends JFrame {
  public SwingPanelsExample() {
    setTitle("Swing Panels Example");
    setSize(600, 400);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);

    // JPanel com FlowLayout (painel padrão / comum) --> agrupar componentes
    // internamente em uma view
    JPanel panel = new JPanel();
    panel.setLayout(new FlowLayout());
    panel.add(new JLabel("FlowLayout Panel:"));
    panel.add(new JButton("Button 1"));
    panel.add(new JButton("Button 2"));

    // JScrollPane cria uma área de expansão dinâmica --> ScrollView
    JTextArea textArea = new JTextArea(5, 20);
    JScrollPane scrollPane = new JScrollPane(textArea);

    // JSplitPane --> restrito a 2 componentes --> organiza eles em uma área que
    // pode ser reajustavel pelo usuario
    JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
        new JButton("Left Component"),
        new JButton("Right Component"));

    // JTabbedPane (TableView)
    JTabbedPane tabbedPane = new JTabbedPane();
    tabbedPane.addTab("Tab 1", new JLabel("Content of Tab 1"));
    tabbedPane.addTab("Tab 2", new JLabel("Content of Tab 2"));

    // Adicionando componentes ao JFrame (janela principal)
    this.setLayout(new BorderLayout()); // LAYOUT DO FRAM
    this.add(panel, BorderLayout.NORTH);
    this.add(scrollPane, BorderLayout.CENTER);
    this.add(splitPane, BorderLayout.SOUTH);
    this.add(tabbedPane, BorderLayout.EAST);
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
      SwingPanelsExample frame = new SwingPanelsExample();
      frame.setVisible(true);
    });
  }
}