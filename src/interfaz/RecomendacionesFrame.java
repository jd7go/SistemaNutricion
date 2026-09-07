package interfaz;

import logica.Recomendaciones;
import modelo.Nino;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * Muestra la orientación nutricional del niño seleccionado.
 */
public class RecomendacionesFrame extends JFrame {

    private static final Color VERDE = new Color(46, 125, 89);
    private static final Color FONDO = new Color(245, 248, 247);
    private static final Color TEXTO = new Color(45, 55, 50);
    private static final Color TEXTO_SUAVE = new Color(105, 118, 111);
    private static final Color BORDE = new Color(218, 225, 221);
    private static final Color AVISO_FONDO = new Color(255, 248, 230);
    private static final Color AVISO_BORDE = new Color(230, 200, 140);

    public RecomendacionesFrame(Nino nino) {
        inicializar(nino);
    }

    private void inicializar(Nino nino) {
        setTitle("NutriKids - Recomendaciones");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(700, 640);
        setLocationRelativeTo(null);
        setMinimumSize(new Dimension(620, 520));

        Recomendaciones recomendaciones = new Recomendaciones();

        JPanel raiz = new JPanel(new BorderLayout());
        raiz.setBackground(FONDO);

        JPanel encabezado = new JPanel();
        encabezado.setLayout(new BoxLayout(encabezado, BoxLayout.Y_AXIS));
        encabezado.setOpaque(false);
        encabezado.setBorder(new EmptyBorder(24, 24, 8, 24));

        JLabel lblTitulo = new JLabel("Recomendaciones");
        lblTitulo.setFont(new Font("SansSerif", Font.BOLD, 24));
        lblTitulo.setForeground(TEXTO);
        lblTitulo.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel lblSub = new JLabel("Orientación general según el grupo de edad");
        lblSub.setFont(new Font("SansSerif", Font.PLAIN, 13));
        lblSub.setForeground(TEXTO_SUAVE);
        lblSub.setAlignmentX(Component.LEFT_ALIGNMENT);
        lblSub.setBorder(new EmptyBorder(4, 0, 0, 0));

        encabezado.add(lblTitulo);
        encabezado.add(lblSub);

        JPanel contenido = new JPanel();
        contenido.setLayout(new BoxLayout(contenido, BoxLayout.Y_AXIS));
        contenido.setBackground(FONDO);
        contenido.setBorder(new EmptyBorder(8, 24, 16, 24));

        String datos = "Nombre: " + nino.getNombre()
                + "\nEdad: " + nino.getEdadTexto() + " (" + nino.getEdadEnMeses() + " meses)"
                + "\nPeso: " + nino.getPeso() + " kg"
                + "\nTalla: " + nino.getTalla() + " cm";

        contenido.add(crearTarjeta("DATOS DEL NIÑO", datos));
        contenido.add(Box.createRigidArea(new Dimension(0, 12)));
        contenido.add(crearTarjeta("GRUPO DE EDAD", recomendaciones.obtenerGrupoEdad(nino)));
        contenido.add(Box.createRigidArea(new Dimension(0, 12)));
        contenido.add(crearTarjeta("ALIMENTACIÓN", recomendaciones.obtenerAlimentacion(nino)));
        contenido.add(Box.createRigidArea(new Dimension(0, 12)));
        contenido.add(crearTarjeta("FRECUENCIA", recomendaciones.obtenerFrecuencia(nino)));
        contenido.add(Box.createRigidArea(new Dimension(0, 12)));
        contenido.add(crearTarjeta("CONSEJOS PARA EL FAMILIAR", recomendaciones.obtenerConsejos(nino)));
        contenido.add(Box.createRigidArea(new Dimension(0, 12)));
        contenido.add(crearTarjetaAdvertencia(recomendaciones.obtenerAdvertencia()));

        JScrollPane scroll = new JScrollPane(contenido);
        scroll.setBorder(null);
        scroll.getVerticalScrollBar().setUnitIncrement(16);
        scroll.getViewport().setBackground(FONDO);

        JPanel inferior = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        inferior.setBackground(FONDO);
        inferior.setBorder(new EmptyBorder(0, 24, 16, 24));

        JButton btnCerrar = new JButton("Cerrar");
        btnCerrar.setFont(new Font("SansSerif", Font.BOLD, 13));
        btnCerrar.setBackground(VERDE);
        btnCerrar.setForeground(Color.WHITE);
        btnCerrar.setFocusPainted(false);
        btnCerrar.setBorderPainted(false);
        btnCerrar.setOpaque(true);
        btnCerrar.setPreferredSize(new Dimension(120, 38));
        btnCerrar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnCerrar.addActionListener(e -> dispose());
        inferior.add(btnCerrar);

        raiz.add(encabezado, BorderLayout.NORTH);
        raiz.add(scroll, BorderLayout.CENTER);
        raiz.add(inferior, BorderLayout.SOUTH);
        setContentPane(raiz);
    }

    private JPanel crearTarjeta(String titulo, String texto) {
        JPanel tarjeta = new JPanel(new BorderLayout(0, 8));
        tarjeta.setBackground(Color.WHITE);
        tarjeta.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(BORDE),
                new EmptyBorder(14, 16, 14, 16)));
        tarjeta.setAlignmentX(Component.LEFT_ALIGNMENT);
        tarjeta.setMaximumSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));

        JLabel lblTitulo = new JLabel(titulo);
        lblTitulo.setFont(new Font("SansSerif", Font.BOLD, 13));
        lblTitulo.setForeground(VERDE);

        JTextArea area = new JTextArea(texto);
        area.setEditable(false);
        area.setLineWrap(true);
        area.setWrapStyleWord(true);
        area.setFont(new Font("SansSerif", Font.PLAIN, 13));
        area.setForeground(TEXTO);
        area.setBackground(Color.WHITE);
        area.setBorder(null);

        tarjeta.add(lblTitulo, BorderLayout.NORTH);
        tarjeta.add(area, BorderLayout.CENTER);
        return tarjeta;
    }

    private JPanel crearTarjetaAdvertencia(String texto) {
        JPanel tarjeta = new JPanel(new BorderLayout(0, 8));
        tarjeta.setBackground(AVISO_FONDO);
        tarjeta.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(AVISO_BORDE),
                new EmptyBorder(14, 16, 14, 16)));
        tarjeta.setAlignmentX(Component.LEFT_ALIGNMENT);
        tarjeta.setMaximumSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));

        JLabel lblTitulo = new JLabel("ADVERTENCIA");
        lblTitulo.setFont(new Font("SansSerif", Font.BOLD, 13));
        lblTitulo.setForeground(new Color(140, 100, 30));

        JTextArea area = new JTextArea(texto);
        area.setEditable(false);
        area.setLineWrap(true);
        area.setWrapStyleWord(true);
        area.setFont(new Font("SansSerif", Font.PLAIN, 13));
        area.setForeground(TEXTO);
        area.setBackground(AVISO_FONDO);
        area.setBorder(null);

        tarjeta.add(lblTitulo, BorderLayout.NORTH);
        tarjeta.add(area, BorderLayout.CENTER);
        return tarjeta;
    }
}
