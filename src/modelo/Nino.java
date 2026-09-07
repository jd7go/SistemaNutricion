package modelo;

/**
 * Representa un niño registrado en NutriKids.
 */
public class Nino {

    private int id;
    private String nombre;
    private int anos;
    private int meses;
    private double peso;
    private double talla;

    public Nino(int id, String nombre, int anos, int meses,
                double peso, double talla) {
        this.id = id;
        this.nombre = nombre;
        this.anos = anos;
        this.meses = meses;
        this.peso = peso;
        this.talla = talla;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getAnos() {
        return anos;
    }

    public int getMeses() {
        return meses;
    }

    public double getPeso() {
        return peso;
    }

    public double getTalla() {
        return talla;
    }

    public int getEdadEnMeses() {
        return (anos * 12) + meses;
    }

    public String getEdadTexto() {
        if (anos == 0) {
            return meses + " meses";
        }
        if (meses == 0) {
            return anos + (anos == 1 ? " año" : " años");
        }
        return anos + (anos == 1 ? " año " : " años ") + meses + " meses";
    }
}
