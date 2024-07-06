package ExemploLayouts;

import javax.swing.*;

// Organiza os componentes em uma linha (X_AXIS) ou em uma coluna (Y_AXIS).
public class BoxLayoutExample {
  public static void main(String[] args) {
    JFrame frame = new JFrame("BoxLayout Example");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(400, 200);

    JPanel panel = new JPanel();
    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // Layout em coluna

    panel.add(new JButton("Button 1"));
    panel.add(new JButton("Button 2"));
    panel.add(new JButton("Button 3"));
    panel.add(new JButton("Button 4"));
    panel.add(new JButton("Button 5"));

    frame.add(panel);
    frame.setVisible(true);
  }
}
