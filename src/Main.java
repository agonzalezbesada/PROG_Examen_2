import java.util.InputMismatchException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        int eleccion = 9;

        System.out.println("Bienvenido a nuestro restaurante\n");
        Restaurante restaurante = new Restaurante();

        do {
            try {
                System.out.println("\nQué desea?"+"\n"+"1. Generar menú"+"\n"+"2. Visualizar menú y decidir"+"\n"+"3. Visualizar menú actual o generar uno nuevo"+"\n"+"4. Visualizar historico de menús"+"\n"+"5. Borrar menú actual"+"\n"+"6. Borrar historico de menús"+"\n"+"7. Ver nombre del restaurante"+"\n"+"0. Salir");
                eleccion = entrada.nextInt();
                entrada.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Por favor, use un número entero");
                entrada = new Scanner(System.in); // Reinstancio el Scanner porque al ejecutarse el catch introduce el valor erroneo en bucle en .nextInt() las siguientes iteraciones
            }


            switch (eleccion) {

                case 1:
                    restaurante.generarMenuAleatorio();
                    break;


                case 2:
                    restaurante.visualizarDecidir(entrada);
                    break;


                case 3:
                    System.out.println("\nDesea visualizar el menú o generar uno nuevo?"+"\n"+"1. Visualizarlo"+"\n"+"2. Generar uno nuevo (Tenga en cuenta que esto borrará el anterior menú)");
                    int decision3 = 0;
                    try {
                        decision3 = entrada.nextInt();
                        entrada.nextLine();
                    } catch (NullPointerException e) {
                        System.out.println(e.toString());
                    }

                    if (decision3==1) {
                        restaurante.visualizarMenu();
                    } else if (decision3==2) {
                        restaurante.generarMenuAleatorio();
                    }

                    break;

                case 4:
                    restaurante.visualizarMenuHistorico();
                    break;

                case 5:
                    restaurante.borrarMenu();
                    break;

                case 6:
                    restaurante.borrarHistorico();
                    break;

                case 7:
                    restaurante.getNombreRestaurante();
                    break;

                default:
                    break;

            }


        } while (eleccion!=0);

    }
}