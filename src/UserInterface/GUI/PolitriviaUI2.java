// import java.awt.BorderLayout;

// import javax.swing.BoxLayout;
// import javax.swing.JComboBox;
// import javax.swing.JPanel;

// class PoliTriviaUIPanel extends JPanel {

// private static final long serialVersionUID = 1L;

// public PoliTriviaUIPanel() {
// setLayout(new BorderLayout());

// // Creando etiqueta
// JLabel welcomeLabel = new JLabel("Bienvenido a la PoliTrivia",
// SwingConstants.CENTER);
// add(welcomeLabel, BorderLayout.NORTH);

// // Creando panel central con BoxLayout
// JPanel centerPanel = new JPanel();
// centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
// add(centerPanel, BorderLayout.CENTER);

// // Creando etiqueta de seleccion
// JLabel selectLabel = new JLabel("Seleccione la Tematica deseada",
// SwingConstants.CENTER);
// centerPanel.add(selectLabel);

// // Creando JComboBox
// String[] options = { "Cultura General Politecnica", "Politecnico Basico",
// "Revisar Puntajes de la Partida" };
// JComboBox<String> comboBox1 = new JComboBox<>(options);
// centerPanel.add(comboBox1);

// // Creando etiqueta de seleccion de categoría
// JLabel categoryLabel = new JLabel("Seleccione la categoria que le gustaria
// jugar", SwingConstants.CENTER);
// centerPanel.add(categoryLabel);

// // Creando segundo JComboBox
// JComboBox<String> comboBox2 = new JComboBox<>();
// centerPanel.add(comboBox2);

// // Creando etiqueta de número de jugadores
// JLabel numPlayersLabel = new JLabel("Numero de jugadores",
// SwingConstants.CENTER);
// centerPanel.add(numPlayersLabel);

// // Creando JComboBox para el número de jugadores
// Integer[] numPlayers = { 1, 2, 3, 4, 5 };
// JComboBox<Integer>
// }
// }
