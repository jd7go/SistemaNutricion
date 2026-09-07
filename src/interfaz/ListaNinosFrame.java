package interfaz;

import modelo.Nino;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

/**
 * Lista de niños registrados en una tabla.
 */
public class ListaNinosFrame extends JFrame {

    private static final Color VERDE = new Color(46, 125, 89);
    private static final Color VERDE_OSCURO = new Color(36, 101, 72);
    private static final Color FONDO = new Color(245, 248, 247);
    private static final Color TEXTO = new Color(45, 55, 50);
    private static final Color TEXTO_SUAVE = new Color(105, 118, 111);
    private static final Color BORDE = new Color(218, 225, 221);

    private final ArrayList<Nino> listaNinos;
    private JTable tabla;
    private DefaultTableModel modeloTabla;

    public ListaNinosFrame(ArrayList<Nino> listaNinos, MenuFrame menuFrame) {
        this.listaNinos = listaNinos;
        inicializar();
        cargarTabla();
    }

    private void inicializar() {
        setTitle("NutriKids - Niños registrados");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(720, 480);
        setLocationRelativeTo(null);
        setMinimumSize(new Dimension(640, 400));

        JPanel raiz = new JPanel(new BorderLayout(0, 16));
        raiz.setBackground(FONDO);
        raiz.setBorder(new EmptyBorder(24, 24, 24, 24));

        JLabel lblTitulo = new JLabel("Niños registrados");
        lblTitulo.setFont(new Font("SansSerif", Font.BOLD, 24));
        lblTitulo.setForeground(TEXTO);

        JLabel lblSub = new JLabel("Elija un niño de la lista y pulse \"Ver recomendaciones\"");
        lblSub.setFont(new Font("SansSerif", Font.PLAIN, 13));
        lblSub.setForeground(TEXTO_SUAVE);
        lblSub.setBorder(new EmptyBorder(4, 0, 0, 0));

        JPanel encabezado = new JPanel();
        encabezado.setLayout(new BoxLayout(encabezado, BoxLayout.Y_AXIS));
        encabezado.setOpaque(false);
        encabezado.add(lblTitulo);
        encabezado.add(lblSub);

        String[] columnas = {"ID", "Nombre", "Edad", "Peso", "Talla"};
        modeloTabla = new DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        tabla = new JTable(modeloTabla);
        tabla.setFont(new Font("SansSerif", Font.PLAIN, 13));
        tabla.setRowHeight(28);
        tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tabla.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 13));
        tabla.getTableHeader().setBackground(new Color(230, 236, 233));
        tabla.setGridColor(BORDE);
        tabla.setShowVerticalLines(false);
        // Doble clic también abre las recomendaciones del niño elegido
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                if (e.getClickCount() == 2) {
                    verRecomendaciones();
                }
            }
        });

        JScrollPane scroll = new JScrollPane(tabla);
        scroll.setBorder(BorderFactory.createLineBorder(BORDE));
        scroll.getViewport().setBackground(Color.WHITE);

        JPanel botones = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 0));
        botones.setOpaque(false);

        JButton btnVolver = crearBotonSecundario("Volver");
        btnVolver.addActionListener(e -> dispose());

        JButton btnVer = crearBotonPrincipal("Ver recomendaciones");
        btnVer.addActionListener(e -> verRecomendaciones());

        botones.add(btnVolver);
        botones.add(btnVer);

        raiz.add(encabezado, BorderLayout.NORTH);
        raiz.add(scroll, BorderLayout.CENTER);
        raiz.add(botones, BorderLayout.SOUTH);
        setContentPane(raiz);
    }

    private void cargarTabla() {
        modeloTabla.setRowCount(0);
        for (Nino nino : listaNinos) {
            modeloTabla.addRow(new Object[]{
                    nino.getId(),
                    nino.getNombre(),
                    nino.getEdadTexto(),
                    nino.getPeso() + " kg",
                    nino.getTalla() + " cm"
            });
        }
    }

    private void verRecomendaciones() {
        int fila = tabla.getSelectedRow();
        if (fila < 0) {
            JOptionPane.showMessageDialog(this,
                    "Seleccione un niño de la tabla para ver sus recomendaciones.",
                    "Sin selección",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        int id = (int) modeloTabla.getValueAt(fila, 0);
        Nino seleccionado = null;
        for (Nino nino : listaNinos) {
            if (nino.getId() == id) {
                seleccionado = nino;
                break;
            }
        }

        if (seleccionado != null) {
            RecomendacionesFrame frame = new RecomendacionesFrame(seleccionado);
            frame.setVisible(true);
        }
    }

    private JButton crearBotonPrincipal(String texto) {
        JButton boton = new JButton(texto);
        boton.setFont(new Font("SansSerif", Font.BOLD, 13));
        boton.setBackground(VERDE);
        boton.setForeground(Color.WHITE);
        boton.setFocusPainted(false);
        boton.setBorderPainted(false);
        boton.setOpaque(true);
        boton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        boton.setPreferredSize(new Dimension(180, 38));
        boton.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                boton.setBackground(VERDE_OSCURO);
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
                boton.setBackground(VERDE);
            }
        });
        return boton;
    }

    private JButton crearBotonSecundario(String texto) {
        JButton boton = new JButton(texto);
        boton.setFont(new Font("SansSerif", Font.PLAIN, 13));
        boton.setBackground(Color.WHITE);
        boton.setForeground(TEXTO);
        boton.setFocusPainted(false);
        boton.setOpaque(true);
        boton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        boton.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(BORDE),
                new EmptyBorder(8, 16, 8, 16)));
        boton.setPreferredSize(new Dimension(120, 38));
        return boton;
    }
}
