import interfaz.LoginFrame;
import modelo.Nino;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import java.util.ArrayList;

/**
 * Punto de entrada de NutriKids.
 * Crea la lista principal de niños y abre el login.
 */
public class Principal {

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            // Si falla, se usa el Look and Feel por defecto.
        }

        final ArrayList<Nino> listaNinos = new ArrayList<>();

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                LoginFrame login = new LoginFrame(listaNinos);
                login.setVisible(true);
            }
        });
    }
}
