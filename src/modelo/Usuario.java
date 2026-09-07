package modelo;

/**
 * Maneja las credenciales de acceso al sistema.
 */
public class Usuario {

    private String nombreUsuario;
    private String contrasena;

    public Usuario(String nombreUsuario, String contrasena) {
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
    }

    public boolean validarUsuario(String usuario, String contrasena) {
        return nombreUsuario.equals(usuario)
                && this.contrasena.equals(contrasena);
    }
}
