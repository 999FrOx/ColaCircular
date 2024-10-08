import java.util.Scanner;

public class Main {

    private final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        operacionesConPilaCircular();
    }


    public static void operacionesConPilaCircular() {
        System.out.print("Ingrese el tamaño de la cola circular: ");
        int tamanio = scanner.nextInt();

        ColaCircular cola = new ColaCircular(tamanio);

        int opcion;
        do {
            System.out.println("\n--- OPCIONES ---");
            System.out.println("1. Agregar Paciente");
            System.out.println("2. Paciente atendido");
            System.out.println("3. Verificar disponibilidad de Cita");
            System.out.println("4. Verificar si ya hay citas");
            System.out.println("5. Mostrar primera cita");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el NSS del paciente: ");
                    String valor = scanner.next();
                    cola.encolar(valor);
                    break;

                case 2:
                    try {
                        String eliminado = cola.deseencolar();
                        if (eliminado != null) {
                            System.out.println("Paciente eliminado: " + eliminado);
                        }
                    } catch (RuntimeException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 3:
                    if (cola.estaLlena()) {
                        System.out.println("No hay mas citas disponibles.");
                    } else {
                        System.out.println("Aún hay citas disponibles.");
                    }
                    break;

                case 4:
                    if (cola.estaVacia()) {
                        System.out.println("Aún hay citas disponibles.");
                    } else {
                        System.out.println("No hay mas citas disponibles.");
                    }
                    break;

                case 5:
                    String frente = cola.frente();
                    if (frente != null) {
                        System.out.println("El frente de la cola es: " + frente);
                    }
                    break;

                case 6:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (opcion != 6);

        scanner.close();
    }
}
//Ángel Gabriel Guzmán Ramírez
//Jimena Hernández Luna
//Luis Manuel Pérez González
