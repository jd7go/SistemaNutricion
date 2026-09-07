package interfaz;

import modelo.Nino;
import modelo.Usuario;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;

/**
 * Ventana de inicio de sesión de NutriKids.
 */
public class LoginFrame extends JFrame {

    private static final Color VERDE = new Color(46, 125, 89);
    private static final Color VERDE_OSCURO = new Color(36, 101, 72);
    private static final Color FONDO = new Color(245, 248, 247);
    private static final Color TEXTO = new Color(45, 55, 50);
    private static final Color TEXTO_SUAVE = new Color(105, 118, 111);

    private final ArrayList<Nino> listaNinos;
    private final Usuario usuarioSistema;
    private JTextField txtUsuario;
    private JPasswordField txtContrasena;

    public LoginFrame(ArrayList<Nino> listaNinos) {
        this.listaNinos = listaNinos;
        this.usuarioSistema = new Usuario("admin", "1234");
        inicializar();
    }

    private void inicializar() {
        setTitle("NutriKids - Inicio de sesión");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(820, 480);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel raiz = new JPanel(new GridLayout(1, 2));
        raiz.add(crearPanelIzquierdo());
        raiz.add(crearPanelDerecho());
        setContentPane(raiz);
    }

    private JPanel crearPanelIzquierdo() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(VERDE);
        panel.setBorder(new EmptyBorder(50, 40, 50, 40));

        JLabel lblMarca = new JLabel("NutriKids");
        lblMarca.setFont(new Font("SansSerif", Font.BOLD, 36));
        lblMarca.setForeground(Color.WHITE);
        lblMarca.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel lblSub = new JLabel("<html>Orientación nutricional<br>para niños menores<br>de 5 años</html>");
        lblSub.setFont(new Font("SansSerif", Font.PLAIN, 16));
        lblSub.setForeground(new Color(220, 235, 228));
        lblSub.setAlignmentX(Component.LEFT_ALIGNMENT);
        lblSub.setBorder(new EmptyBorder(20, 0, 0, 0));

        JLabel lblInfo = new JLabel("<html>Información general<br>sobre alimentación infantil</html>");
        lblInfo.setFont(new Font("SansSerif", Font.PLAIN, 14));
        lblInfo.setForeground(new Color(200, 220, 210));
        lblInfo.setAlignmentX(Component.LEFT_ALIGNMENT);
        lblInfo.setBorder(new EmptyBorder(30, 0, 0, 0));

        JLabel lblAcad = new JLabel("Proyecto académico");
        lblAcad.setFont(new Font("SansSerif", Font.ITALIC, 13));
        lblAcad.setForeground(new Color(180, 205, 192));
        lblAcad.setAlignmentX(Component.LEFT_ALIGNMENT);
        lblAcad.setBorder(new EmptyBorder(40, 0, 0, 0));

        panel.add(lblMarca);
        panel.add(lblSub);
        panel.add(lblInfo);
        panel.add(Box.createVerticalGlue());
        panel.add(lblAcad);
        return panel;
    }

    private JPanel crearPanelDerecho() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(FONDO);
        panel.setBorder(new EmptyBorder(50, 45, 50, 45));

        JLabel lblBienvenida = new JLabel("Bienvenido");
        lblBienvenida.setFont(new Font("SansSerif", Font.BOLD, 26));
        lblBienvenida.setForeground(TEXTO);
        lblBienvenida.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel lblIngresa = new JLabel("Ingresa tus datos para continuar");
        lblIngresa.setFont(new Font("SansSerif", Font.PLAIN, 14));
        lblIngresa.setForeground(TEXTO_SUAVE);
        lblIngresa.setAlignmentX(Component.LEFT_ALIGNMENT);
        lblIngresa.setBorder(new EmptyBorder(8, 0, 28, 0));

        JLabel lblUsuario = new JLabel("Usuario");
        lblUsuario.setFont(new Font("SansSerif", Font.BOLD, 13));
        lblUsuario.setForeground(TEXTO);
        lblUsuario.setAlignmentX(Component.LEFT_ALIGNMENT);

        txtUsuario = new JTextField();
        txtUsuario.setMaximumSize(new Dimension(Integer.MAX_VALUE, 38));
        txtUsuario.setFont(new Font("SansSerif", Font.PLAIN, 14));
        txtUsuario.setAlignmentX(Component.LEFT_ALIGNMENT);
        txtUsuario.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(218, 225, 221)),
                new EmptyBorder(8, 10, 8, 10)));

        JLabel lblPass = new JLabel("Contraseña");
        lblPass.setFont(new Font("SansSerif", Font.BOLD, 13));
        lblPass.setForeground(TEXTO);
        lblPass.setAlignmentX(Component.LEFT_ALIGNMENT);
        lblPass.setBorder(new EmptyBorder(16, 0, 0, 0));

        txtContrasena = new JPasswordField();
        txtContrasena.setMaximumSize(new Dimension(Integer.MAX_VALUE, 38));
        txtContrasena.setFont(new Font("SansSerif", Font.PLAIN, 14));
        txtContrasena.setAlignmentX(Component.LEFT_ALIGNMENT);
        txtContrasena.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(218, 225, 221)),
                new EmptyBorder(8, 10, 8, 10)));

        JButton btnLogin = new JButton("INICIAR SESIÓN");
        btnLogin.setAlignmentX(Component.LEFT_ALIGNMENT);
        btnLogin.setMaximumSize(new Dimension(Integer.MAX_VALUE, 44));
        btnLogin.setFont(new Font("SansSerif", Font.BOLD, 14));
        btnLogin.setBackground(VERDE);
        btnLogin.setForeground(Color.WHITE);
        btnLogin.setFocusPainted(false);
        btnLogin.setBorderPainted(false);
        btnLogin.setOpaque(true);
        btnLogin.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnLogin.setBorder(new EmptyBorder(10, 0, 10, 0));
        btnLogin.addActionListener(e -> iniciarSesion());

        JPanel espacioBoton = new JPanel();
        espacioBoton.setOpaque(false);
        espacioBoton.setMaximumSize(new Dimension(Integer.MAX_VALUE, 28));
        espacioBoton.setAlignmentX(Component.LEFT_ALIGNMENT);

        panel.add(lblBienvenida);
        panel.add(lblIngresa);
        panel.add(lblUsuario);
        panel.add(Box.createRigidArea(new Dimension(0, 6)));
        panel.add(txtUsuario);
        panel.add(lblPass);
        panel.add(Box.createRigidArea(new Dimension(0, 6)));
        panel.add(txtContrasena);
        panel.add(espacioBoton);
        panel.add(btnLogin);

        getRootPane().setDefaultButton(btnLogin);
        return panel;
    }

    private void iniciarSesion() {
        String usuario = txtUsuario.getText().trim();
        String contrasena = new String(txtContrasena.getPassword());

        if (usuario.isEmpty() || contrasena.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Por favor complete usuario y contraseña.",
                    "Campos incompletos",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (usuarioSistema.validarUsuario(usuario, contrasena)) {
            MenuFrame menu = new MenuFrame(listaNinos);
            menu.setVisible(true);
            dispose();
        } else {
            JOptionPane.showMessageDialog(this,
                    "Usuario o contraseña incorrectos.\nIntente nuevamente.",
                    "Acceso denegado",
                    JOptionPane.ERROR_MESSAGE);
            txtContrasena.setText("");
            txtContrasena.requestFocus();
        }
    }
}
