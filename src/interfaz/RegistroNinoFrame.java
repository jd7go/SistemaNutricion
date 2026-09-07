package interfaz;

import modelo.Nino;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;

/**
 * Formulario para registrar un nuevo niño.
 */
public class RegistroNinoFrame extends JFrame {

    private static final Color VERDE = new Color(46, 125, 89);
    private static final Color VERDE_OSCURO = new Color(36, 101, 72);
    private static final Color FONDO = new Color(245, 248, 247);
    private static final Color TEXTO = new Color(45, 55, 50);
    private static final Color TEXTO_SUAVE = new Color(105, 118, 111);
    private static final Color BORDE = new Color(218, 225, 221);

    private final ArrayList<Nino> listaNinos;
    private final MenuFrame menuFrame;

    private JTextField txtNombre;
    private JTextField txtAnos;
    private JTextField txtMeses;
    private JTextField txtPeso;
    private JTextField txtTalla;

    public RegistroNinoFrame(ArrayList<Nino> listaNinos, MenuFrame menuFrame) {
        this.listaNinos = listaNinos;
        this.menuFrame = menuFrame;
        inicializar();
    }

    private void inicializar() {
        setTitle("NutriKids - Registrar niño");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);

        JPanel raiz = new JPanel(new BorderLayout(0, 18));
        raiz.setBackground(FONDO);
        raiz.setBorder(new EmptyBorder(24, 28, 24, 28));

        JLabel lblTitulo = new JLabel("Registrar niño");
        lblTitulo.setFont(new Font("SansSerif", Font.BOLD, 24));
        lblTitulo.setForeground(TEXTO);

        JLabel lblSub = new JLabel("Si el niño aún no cumple años, deje Años vacío y escriba solo los meses.");
        lblSub.setFont(new Font("SansSerif", Font.PLAIN, 13));
        lblSub.setForeground(TEXTO_SUAVE);
        lblSub.setBorder(new EmptyBorder(4, 0, 0, 0));

        JPanel encabezado = new JPanel();
        encabezado.setLayout(new BoxLayout(encabezado, BoxLayout.Y_AXIS));
        encabezado.setOpaque(false);
        encabezado.add(lblTitulo);
        encabezado.add(lblSub);

        txtNombre = crearCampo();
        txtAnos = crearCampo();
        txtMeses = crearCampo();
        txtPeso = crearCampo();
        txtTalla = crearCampo();

        JPanel formulario = new JPanel(new GridBagLayout());
        formulario.setOpaque(false);
        formulario.setBorder(new EmptyBorder(8, 0, 0, 0));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        gbc.insets = new Insets(0, 0, 4, 0);

        int fila = 0;
        agregarCampo(formulario, gbc, fila++, "Nombre", txtNombre);
        agregarCampo(formulario, gbc, fila++, "Años (0 a 4) — puede dejarse vacío", txtAnos);
        agregarCampo(formulario, gbc, fila++, "Meses (0 a 11) — puede dejarse vacío", txtMeses);
        agregarCampo(formulario, gbc, fila++, "Peso (kg)", txtPeso);
        agregarCampo(formulario, gbc, fila, "Talla (cm)", txtTalla);

        JPanel botones = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 0));
        botones.setOpaque(false);

        JButton btnCancelar = crearBotonSecundario("Cancelar");
        btnCancelar.addActionListener(e -> dispose());

        JButton btnGuardar = crearBotonPrincipal("Guardar");
        btnGuardar.addActionListener(e -> guardar());

        botones.add(btnCancelar);
        botones.add(btnGuardar);

        raiz.add(encabezado, BorderLayout.NORTH);
        raiz.add(formulario, BorderLayout.CENTER);
        raiz.add(botones, BorderLayout.SOUTH);
        setContentPane(raiz);

        pack();
        setSize(Math.max(getWidth(), 520), Math.max(getHeight(), 580));
        setLocationRelativeTo(menuFrame);
    }

    private void agregarCampo(JPanel panel, GridBagConstraints gbc,
                              int fila, String etiqueta, JTextField campo) {
        JLabel lbl = new JLabel(etiqueta);
        lbl.setFont(new Font("SansSerif", Font.BOLD, 13));
        lbl.setForeground(TEXTO);

        gbc.gridy = fila * 2;
        gbc.insets = new Insets(fila == 0 ? 0 : 10, 0, 4, 0);
        panel.add(lbl, gbc);

        gbc.gridy = fila * 2 + 1;
        gbc.insets = new Insets(0, 0, 0, 0);
        panel.add(campo, gbc);
    }

    private JTextField crearCampo() {
        JTextField campo = new JTextField();
        campo.setFont(new Font("SansSerif", Font.PLAIN, 14));
        campo.setPreferredSize(new Dimension(420, 36));
        campo.setMinimumSize(new Dimension(200, 36));
        campo.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(BORDE),
                new EmptyBorder(8, 10, 8, 10)));
        return campo;
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
        boton.setPreferredSize(new Dimension(120, 38));
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

    private void guardar() {
        String nombre = txtNombre.getText().trim();

        if (nombre.isEmpty()) {
            mostrarError("El nombre no puede estar vacío.");
            return;
        }

        int anos;
        int meses;
        double peso;
        double talla;

        // Si Años o Meses quedan vacíos, se toman como 0
        // (útil para bebés de solo meses, ej. Mateo: 3 meses).
        try {
            anos = parsearEnteroOpcional(txtAnos.getText(), "Años");
            meses = parsearEnteroOpcional(txtMeses.getText(), "Meses");
            peso = parsearDecimalObligatorio(txtPeso.getText(), "Peso");
            talla = parsearDecimalObligatorio(txtTalla.getText(), "Talla");
        } catch (IllegalArgumentException e) {
            mostrarError(e.getMessage());
            return;
        }

        if (anos < 0 || anos > 4) {
            mostrarError("Los años deben estar entre 0 y 4.");
            return;
        }

        if (meses < 0 || meses > 11) {
            mostrarError("Los meses deben estar entre 0 y 11.");
            return;
        }

        int edadMeses = (anos * 12) + meses;
        if (edadMeses >= 60) {
            mostrarError("Solo se admiten niños menores de 5 años (menos de 60 meses).");
            return;
        }

        if (peso <= 0) {
            mostrarError("El peso debe ser mayor que 0.");
            return;
        }

        if (talla <= 0) {
            mostrarError("La talla debe ser mayor que 0.");
            return;
        }

        int nuevoId = generarId();
        Nino nino = new Nino(nuevoId, nombre, anos, meses, peso, talla);
        listaNinos.add(nino);
        menuFrame.actualizarInicio();

        JOptionPane.showMessageDialog(this,
                "Niño registrado correctamente.\n"
                        + nino.getNombre() + " — " + nino.getEdadTexto(),
                "Registro exitoso",
                JOptionPane.INFORMATION_MESSAGE);
        dispose();
    }

    /**
     * Convierte un texto a entero. Si está vacío, devuelve 0.
     */
    private int parsearEnteroOpcional(String texto, String campo) {
        String valor = texto == null ? "" : texto.trim();
        if (valor.isEmpty()) {
            return 0;
        }
        try {
            return Integer.parseInt(valor);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(
                    campo + " debe ser un número entero válido, o dejarse vacío.");
        }
    }

    /**
     * Convierte un texto a decimal. No puede quedar vacío.
     */
    private double parsearDecimalObligatorio(String texto, String campo) {
        String valor = texto == null ? "" : texto.trim().replace(',', '.');
        if (valor.isEmpty()) {
            throw new IllegalArgumentException(campo + " no puede estar vacío.");
        }
        try {
            return Double.parseDouble(valor);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(campo + " debe ser un valor numérico válido.");
        }
    }

    private int generarId() {
        int max = 0;
        for (Nino nino : listaNinos) {
            if (nino.getId() > max) {
                max = nino.getId();
            }
        }
        return max + 1;
    }

    private void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Validación", JOptionPane.WARNING_MESSAGE);
    }
}
