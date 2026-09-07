package interfaz;

import modelo.Nino;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;

/**
 * Dashboard principal de NutriKids.
 */
public class MenuFrame extends JFrame {

    private static final Color VERDE = new Color(46, 125, 89);
    private static final Color VERDE_OSCURO = new Color(36, 101, 72);
    private static final Color FONDO = new Color(245, 248, 247);
    private static final Color TEXTO = new Color(45, 55, 50);
    private static final Color TEXTO_SUAVE = new Color(105, 118, 111);
    private static final Color BORDE = new Color(218, 225, 221);

    private final ArrayList<Nino> listaNinos;
    private JLabel lblCantidad;
    private JLabel lblEstado;
    private JLabel lblOrientacion;
    private JTextArea areaResumen;

    public MenuFrame(ArrayList<Nino> listaNinos) {
        this.listaNinos = listaNinos;
        inicializar();
        actualizarInicio();
    }

    private void inicializar() {
        setTitle("NutriKids - Menú principal");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(960, 600);
        setLocationRelativeTo(null);
        setMinimumSize(new Dimension(860, 520));

        JPanel raiz = new JPanel(new BorderLayout());
        raiz.add(crearPanelLateral(), BorderLayout.WEST);
        raiz.add(crearPanelContenido(), BorderLayout.CENTER);
        setContentPane(raiz);
    }

    private JPanel crearPanelLateral() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(VERDE_OSCURO);
        panel.setPreferredSize(new Dimension(220, 0));
        panel.setBorder(new EmptyBorder(28, 18, 28, 18));

        JLabel lblMarca = new JLabel("NutriKids");
        lblMarca.setFont(new Font("SansSerif", Font.BOLD, 24));
        lblMarca.setForeground(Color.WHITE);
        lblMarca.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel lblSub = new JLabel("Menú principal");
        lblSub.setFont(new Font("SansSerif", Font.PLAIN, 12));
        lblSub.setForeground(new Color(190, 210, 200));
        lblSub.setAlignmentX(Component.LEFT_ALIGNMENT);
        lblSub.setBorder(new EmptyBorder(4, 0, 28, 0));

        panel.add(lblMarca);
        panel.add(lblSub);
        panel.add(crearBotonMenu("Inicio", e -> actualizarInicio()));
        panel.add(Box.createRigidArea(new Dimension(0, 8)));
        panel.add(crearBotonMenu("Registrar niño", e -> abrirRegistro()));
        panel.add(Box.createRigidArea(new Dimension(0, 8)));
        panel.add(crearBotonMenu("Niños registrados", e -> abrirLista()));
        panel.add(Box.createVerticalGlue());
        panel.add(crearBotonMenu("Cerrar sesión", e -> cerrarSesion()));
        return panel;
    }

    private JButton crearBotonMenu(String texto, java.awt.event.ActionListener accion) {
        JButton boton = new JButton(texto);
        boton.setAlignmentX(Component.LEFT_ALIGNMENT);
        boton.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        boton.setFont(new Font("SansSerif", Font.PLAIN, 14));
        boton.setBackground(VERDE);
        boton.setForeground(Color.WHITE);
        boton.setFocusPainted(false);
        boton.setBorderPainted(false);
        boton.setOpaque(true);
        boton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        boton.setHorizontalAlignment(SwingConstants.LEFT);
        boton.setBorder(new EmptyBorder(8, 14, 8, 14));
        boton.addActionListener(accion);
        return boton;
    }

    private JPanel crearPanelContenido() {
        JPanel panel = new JPanel(new BorderLayout(0, 16));
        panel.setBackground(FONDO);
        panel.setBorder(new EmptyBorder(28, 28, 28, 28));

        JLabel lblTitulo = new JLabel("Inicio");
        lblTitulo.setFont(new Font("SansSerif", Font.BOLD, 26));
        lblTitulo.setForeground(TEXTO);

        JLabel lblDesc = new JLabel("Resumen del sistema y niños registrados");
        lblDesc.setFont(new Font("SansSerif", Font.PLAIN, 14));
        lblDesc.setForeground(TEXTO_SUAVE);

        JPanel encabezado = new JPanel();
        encabezado.setLayout(new BoxLayout(encabezado, BoxLayout.Y_AXIS));
        encabezado.setOpaque(false);
        encabezado.add(lblTitulo);
        encabezado.add(Box.createRigidArea(new Dimension(0, 4)));
        encabezado.add(lblDesc);

        JPanel tarjetas = new JPanel(new GridLayout(1, 3, 16, 0));
        tarjetas.setOpaque(false);

        lblCantidad = new JLabel("0");
        lblEstado = new JLabel("Activo");
        lblOrientacion = new JLabel("Disponible");

        tarjetas.add(crearTarjeta("Niños registrados", lblCantidad));
        tarjetas.add(crearTarjeta("Estado del sistema", lblEstado));
        tarjetas.add(crearTarjeta("Orientación", lblOrientacion));

        JPanel panelResumen = new JPanel(new BorderLayout());
        panelResumen.setBackground(Color.WHITE);
        panelResumen.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(BORDE),
                new EmptyBorder(16, 16, 16, 16)));

        JLabel lblResumen = new JLabel("Información de los niños registrados");
        lblResumen.setFont(new Font("SansSerif", Font.BOLD, 15));
        lblResumen.setForeground(TEXTO);

        areaResumen = new JTextArea();
        areaResumen.setEditable(false);
        areaResumen.setFont(new Font("SansSerif", Font.PLAIN, 13));
        areaResumen.setForeground(TEXTO);
        areaResumen.setBackground(Color.WHITE);
        areaResumen.setLineWrap(true);
        areaResumen.setWrapStyleWord(true);

        JScrollPane scroll = new JScrollPane(areaResumen);
        scroll.setBorder(null);
        scroll.getViewport().setBackground(Color.WHITE);

        panelResumen.add(lblResumen, BorderLayout.NORTH);
        panelResumen.add(Box.createRigidArea(new Dimension(0, 10)), BorderLayout.CENTER);

        JPanel centroResumen = new JPanel(new BorderLayout(0, 10));
        centroResumen.setOpaque(false);
        centroResumen.add(lblResumen, BorderLayout.NORTH);
        centroResumen.add(scroll, BorderLayout.CENTER);
        panelResumen.add(centroResumen, BorderLayout.CENTER);

        JPanel centro = new JPanel(new BorderLayout(0, 16));
        centro.setOpaque(false);
        centro.add(tarjetas, BorderLayout.NORTH);
        centro.add(panelResumen, BorderLayout.CENTER);

        panel.add(encabezado, BorderLayout.NORTH);
        panel.add(centro, BorderLayout.CENTER);
        return panel;
    }

    private JPanel crearTarjeta(String titulo, JLabel valor) {
        JPanel tarjeta = new JPanel();
        tarjeta.setLayout(new BoxLayout(tarjeta, BoxLayout.Y_AXIS));
        tarjeta.setBackground(Color.WHITE);
        tarjeta.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(BORDE),
                new EmptyBorder(18, 18, 18, 18)));

        JLabel lblTitulo = new JLabel(titulo);
        lblTitulo.setFont(new Font("SansSerif", Font.PLAIN, 13));
        lblTitulo.setForeground(TEXTO_SUAVE);
        lblTitulo.setAlignmentX(Component.LEFT_ALIGNMENT);

        valor.setFont(new Font("SansSerif", Font.BOLD, 28));
        valor.setForeground(VERDE);
        valor.setAlignmentX(Component.LEFT_ALIGNMENT);
        valor.setBorder(new EmptyBorder(8, 0, 0, 0));

        tarjeta.add(lblTitulo);
        tarjeta.add(valor);
        return tarjeta;
    }

    public void actualizarInicio() {
        lblCantidad.setText(String.valueOf(listaNinos.size()));
        lblEstado.setText("Activo");
        lblOrientacion.setText(listaNinos.isEmpty() ? "Pendiente" : "Disponible");

        if (listaNinos.isEmpty()) {
            areaResumen.setText("Aún no hay niños registrados.\n"
                    + "Use la opción \"Registrar niño\" para agregar el primero.");
        } else {
            StringBuilder sb = new StringBuilder();
            for (Nino nino : listaNinos) {
                sb.append("ID ").append(nino.getId())
                        .append("  |  ").append(nino.getNombre())
                        .append("  |  ").append(nino.getEdadTexto())
                        .append("  |  Peso: ").append(nino.getPeso()).append(" kg")
                        .append("  |  Talla: ").append(nino.getTalla()).append(" cm")
                        .append("\n");
            }
            areaResumen.setText(sb.toString());
        }
    }

    private void abrirRegistro() {
        RegistroNinoFrame registro = new RegistroNinoFrame(listaNinos, this);
        registro.setVisible(true);
    }

    private void abrirLista() {
        ListaNinosFrame lista = new ListaNinosFrame(listaNinos, this);
        lista.setVisible(true);
    }

    private void cerrarSesion() {
        int opcion = JOptionPane.showConfirmDialog(this,
                "¿Desea cerrar la sesión?",
                "Cerrar sesión",
                JOptionPane.YES_NO_OPTION);
        if (opcion == JOptionPane.YES_OPTION) {
            LoginFrame login = new LoginFrame(listaNinos);
            login.setVisible(true);
            dispose();
        }
    }
}
