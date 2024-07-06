package ExemploLayouts;

import javax.swing.*;
import java.awt.*;

// Organiza os componentes em cinco regiões: Norte, Sul, Leste, Oeste e Centro.
// Cada região pode conter apenas um componente.
public class BorderLayoutExample {
  public static void main(String[] args) {
    JFrame frame = new JFrame("BorderLayout Example");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(400, 200);
    frame.setLayout(new BorderLayout());

    frame.add(new JButton("Norte"), BorderLayout.NORTH);
    frame.add(new JButton("Sul"), BorderLayout.SOUTH);
    frame.add(new JButton("Leste"), BorderLayout.EAST);
    frame.add(new JButton("Oeste"), BorderLayout.WEST);
    frame.add(new JButton("Centro"), BorderLayout.CENTER);

    frame.setVisible(true);
  }
}