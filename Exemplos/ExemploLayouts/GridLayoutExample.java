package ExemploLayouts;

import javax.swing.*;
import java.awt.*;

// Organiza os componentes em uma grade (linhas e colunas).
// Todos os componentes têm o mesmo tamanho.
public class GridLayoutExample {
  public static void main(String[] args) {
    JFrame frame = new JFrame("GridLayout Example");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(400, 200);
    frame.setLayout(new GridLayout(2, 3)); // 2 linhas, 3 colunas

    frame.add(new JButton("Button 1"));
    frame.add(new JButton("Button 2"));
    frame.add(new JButton("Button 3"));
    frame.add(new JButton("Button 4"));
    frame.add(new JButton("Button 5"));
    frame.add(new JButton("Button 6"));

    frame.setVisible(true);
  }
}
