package logica;

import modelo.Nino;

/**
 * Orientación general de alimentación según el grupo de edad.
 * Basada en lineamientos educativos de OMS/UNICEF.
 * No constituye diagnóstico ni prescripción médica.
 */
public class Recomendaciones {

    public String obtenerGrupoEdad(Nino nino) {
        int edad = nino.getEdadEnMeses();

        if (edad >= 0 && edad <= 5) {
            return "0–5 meses";
        } else if (edad >= 6 && edad <= 8) {
            return "6–8 meses";
        } else if (edad >= 9 && edad <= 11) {
            return "9–11 meses";
        } else if (edad >= 12 && edad <= 23) {
            return "12–23 meses";
        } else if (edad >= 24 && edad <= 59) {
            return "24–59 meses";
        }
        return "Edad fuera de rango";
    }

    public String obtenerAlimentacion(Nino nino) {
        int edad = nino.getEdadEnMeses();

        if (edad >= 0 && edad <= 5) {
            return "• Lactancia materna exclusiva durante los primeros 6 meses, cuando sea posible.\n"
                    + "• Alimentar según las necesidades del bebé.\n"
                    + "• Si hay dificultades para alimentarlo, consultar con un profesional de la salud.";
        } else if (edad >= 6 && edad <= 8) {
            return "• Continuar con la lactancia materna.\n"
                    + "• Iniciar alimentación complementaria alrededor de los 6 meses.\n"
                    + "• Comenzar con pequeñas cantidades e ir aumentando progresivamente.\n"
                    + "• Aumentar la variedad de alimentos.\n"
                    + "• Aumentar gradualmente la consistencia de los alimentos.";
        } else if (edad >= 9 && edad <= 11) {
            return "• Continuar con la lactancia materna.\n"
                    + "• Ofrecer alimentos variados y nutritivos.\n"
                    + "• Aumentar la variedad y la consistencia de los alimentos.\n"
                    + "• No obligar al niño a comer.";
        } else if (edad >= 12 && edad <= 23) {
            return "• Continuar la lactancia materna hasta los 2 años o más.\n"
                    + "• Ofrecer alimentos variados y nutritivos.\n"
                    + "• Incorporar alimentos familiares adecuados para su edad.\n"
                    + "• Mantener higiene y manipular los alimentos de forma segura.";
        } else if (edad >= 24 && edad <= 59) {
            return "• Ofrecer una variedad de alimentos: frutas, verduras y fuentes de proteínas.\n"
                    + "• Mantener una alimentación equilibrada.\n"
                    + "• Cuidar la higiene en la preparación de los alimentos.\n"
                    + "• Fomentar buenos hábitos alimentarios.\n"
                    + "• Respetar las señales de hambre y saciedad.\n"
                    + "• No utilizar los alimentos como premio o castigo.";
        }
        return "No hay orientación disponible para esta edad.";
    }

    public String obtenerFrecuencia(Nino nino) {
        int edad = nino.getEdadEnMeses();

        if (edad >= 0 && edad <= 5) {
            return "• Alimentar a demanda, según las necesidades del bebé.";
        } else if (edad >= 6 && edad <= 8) {
            return "• Aproximadamente 2–3 comidas al día, además de la lactancia.";
        } else if (edad >= 9 && edad <= 11) {
            return "• Aproximadamente 3–4 comidas al día.\n"
                    + "• Se pueden ofrecer 1–2 refrigerios nutritivos según las necesidades.";
        } else if (edad >= 12 && edad <= 23) {
            return "• 3–4 comidas al día.\n"
                    + "• 1–2 refrigerios nutritivos cuando sean necesarios.";
        } else if (edad >= 24 && edad <= 59) {
            return "• Mantener horarios regulares de comidas y refrigerios nutritivos.\n"
                    + "• Adaptar las porciones a la edad y al apetito del niño.";
        }
        return "No hay información de frecuencia disponible.";
    }

    public String obtenerConsejos(Nino nino) {
        int edad = nino.getEdadEnMeses();

        if (edad >= 0 && edad <= 5) {
            return "• Observar las señales de hambre y saciedad del bebé.\n"
                    + "• Buscar apoyo profesional si surgen dudas sobre la lactancia.\n"
                    + "• Mantener un ambiente tranquilo durante la alimentación.";
        } else if (edad >= 6 && edad <= 8) {
            return "• Alimentar de manera paciente y sin prisas.\n"
                    + "• Respetar las señales del niño.\n"
                    + "• Introducir un alimento nuevo a la vez para observar su aceptación.";
        } else if (edad >= 9 && edad <= 11) {
            return "• Permitir que el niño explore texturas y sabores.\n"
                    + "• Evitar forzar la comida.\n"
                    + "• Supervisar siempre durante la alimentación.";
        } else if (edad >= 12 && edad <= 23) {
            return "• Compartir momentos de comida en familia cuando sea posible.\n"
                    + "• Ofrecer ejemplos positivos de alimentación.\n"
                    + "• Evitar distracciones excesivas durante las comidas.";
        } else if (edad >= 24 && edad <= 59) {
            return "• Involucrar al niño en hábitos saludables de forma sencilla.\n"
                    + "• Evitar el uso de comida como premio o castigo.\n"
                    + "• Mantener rutinas claras de higiene antes de comer.";
        }
        return "No hay consejos disponibles.";
    }

    public String obtenerAdvertencia() {
        return "Las recomendaciones son de orientación general y educativa. "
                + "No sustituyen la valoración de un médico, nutricionista u otro "
                + "profesional de la salud. Ante cualquier duda sobre la alimentación "
                + "o el crecimiento del niño, consulte a un profesional.";
    }

    public String obtenerRecomendacion(Nino nino) {
        return "Grupo: " + obtenerGrupoEdad(nino) + "\n\n"
                + "Alimentación:\n" + obtenerAlimentacion(nino) + "\n\n"
                + "Frecuencia:\n" + obtenerFrecuencia(nino) + "\n\n"
                + "Consejos:\n" + obtenerConsejos(nino) + "\n\n"
                + "Advertencia:\n" + obtenerAdvertencia();
    }
}
