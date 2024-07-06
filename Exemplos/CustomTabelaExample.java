
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class CustomTabelaExample extends JFrame {
	public CustomTabelaExample() {
		setTitle("Custom JTable Example");
		setSize(600, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		// Definindo os dados da tabela
		String[][] data = {
				{ "1", "John Doe", "35", "Engineer" },
				{ "2", "Anna Smith", "28", "Designer" },
				{ "3", "Paul Brown", "45", "Manager" }
		};

		// Definindo os nomes das colunas
		String[] columnNames = { "ID", "Name", "Age", "Occupation" };

		// Criando o TableModel
		DefaultTableModel model = new DefaultTableModel(data, columnNames) {
			@Override
			public boolean isCellEditable(int row, int column) {
				// Apenas a coluna "Age" é editável
				return column == 2;
			}
		};

		// Criando a JTable com o modelo
		JTable table = new JTable(model);

		// Personalizando a renderização das células
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);

		// Adicionando a tabela a um JScrollPane para barras de rolagem
		JScrollPane scrollPane = new JScrollPane(table);
		add(scrollPane, BorderLayout.CENTER);

		// Configurando a JTable
		table.setFillsViewportHeight(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			CustomTabelaExample frame = new CustomTabelaExample();
			frame.setVisible(true);
		});
	}
}