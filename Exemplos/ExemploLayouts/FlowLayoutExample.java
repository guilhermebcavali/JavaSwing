package ExemploLayouts;

import javax.swing.*;
import java.awt.*;

// Organiza os componentes em uma linha, um após o outro.
// Quebra para a próxima linha quando não há espaço suficiente.
public class FlowLayoutExample {
  public static void main(String[] args) {
    JFrame frame = new JFrame("FlowLayout Example");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(800, 400);
    frame.setLayout(new FlowLayout());

    frame.add(new JButton("Button 1"));
    frame.add(new JButton("Button 2"));
    frame.add(new JButton("Button 3"));
    frame.add(new JButton("Button 4"));
    frame.add(new JButton("Button 5"));

    frame.setVisible(true);
  }
}
