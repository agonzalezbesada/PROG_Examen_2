import java.io.*;
import java.util.Scanner;

public class Restaurante extends Hosteleria implements NormasRestaurante{



    public Restaurante() {
        entrantes = new String[3];
        entrantes[0] = "Pan";
        entrantes[1] = "Croquetas";
        entrantes[2] = "Tortilla";

        primeros = new String[3];
        primeros[0] = "Carbonara";
        primeros[1] = "Spagetti";
        primeros[2] = "Lomo";

        segundos = new String[3];
        segundos[0] = "Cabiar";
        segundos[1] = "Ostras";
        segundos[2] = "Pulpo";

        postres = new String[3];
        postres[0] = "Tarta de la abuela";
        postres[1] = "Tarta Red Velvet";
        postres[2] = "Helado";


    }

    @Override
    public void generarMenuAleatorio() {
        FileWriter escribe = null; // Instancia a null para no recordar la ruta si se vuelve a utilizar

        int indice1 = (int) (Math.random() * (2 - 0 + 1) - 0 ); // Se elige un producto aleatorio del menú
        try {
            escribe = new FileWriter("src\\entrantes.txt", false); // Se asigna una ruta

            escribe.write(entrantes[indice1]); // Se escribe el producto del array
            escribe.close(); // Se cierra el FileWrtiter para que se guarden los cambios

        } catch (IOException e) { // Control de errores
            System.out.println(e.toString()); // Se informa del posible error
        }

        escribe = null; // Se iguala a null para no recordar la ruta

        int indice2 = (int) (Math.random() * (2 - 0 + 1) - 0 );
        try {
            escribe = new FileWriter("src\\primeros.txt", false);

            escribe.write(primeros[indice2]);
            escribe.close();

        } catch (IOException e) {
            System.out.println(e.toString());
        }

        escribe = null;

        int indice3 = (int) (Math.random() * (2 - 0 + 1) - 0 );
        try {
            escribe = new FileWriter("src\\segundos.txt", false);


            escribe.write(segundos[indice3]);
            escribe.close();

        } catch (IOException e) {
            System.out.println(e.toString());
        }

        escribe = null;

        int indice4 = (int) (Math.random() * (2 - 0 + 1) - 0 );
        try {
            escribe = new FileWriter("src\\postres.txt", false);

            escribe.write(postres[indice4]);
            escribe.close();

        } catch (IOException e) {
            System.out.println(e.toString());
        }

        FileWriter guardarHistorico = null; // Se crea un FileWriter para escribir el menú en el historico

        try {
            guardarHistorico = new FileWriter("src\\menus_historico.txt", true);
            guardarHistorico.write(entrantes[indice1]+"\n");
            guardarHistorico.write(primeros[indice2]+"\n");
            guardarHistorico.write(segundos[indice3]+"\n");
            guardarHistorico.write(postres[indice4]+"\n"+"\n");
            guardarHistorico.close();
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }

    @Override
    public void visualizarDecidir(Scanner entrada) { // SE LEE EL MENÚ ACTUAL Y SE OFRECEN OPCIONES
        System.out.println("\nSu menú señor"); // SE LEE EL MENU ACTUAL
        FileReader lee = null; // Se iguala a null para no recordar la ruta
        StringBuffer bufferEntrante = null; // Se instancia a null para no recordar la ruta
        int indice = -1; // Crea un punto de inicio para el índice del StringBuffer

        try {
            lee = new FileReader("src\\entrantes.txt");
            bufferEntrante = new StringBuffer();
            int caracter = lee.read(); // Muestra el primer elemento de la queue en forma de código de caracter

            while (caracter != -1) {
                indice ++; // Igualo el indice a 0 en la primera vuelta, en las siguientes aumenta
                char imprimir = (char) caracter; // Convertimos el codigo de caracter a un char
                bufferEntrante.insert(indice,imprimir); // Inserto nos char de uno en uno
                caracter = lee.read(); // Igualamos al siguiente de la cola (si es -1 indicará el final del fichero)
            }
            lee.close();
            String entranteText = null;
            entranteText = String.valueOf(bufferEntrante);
            System.out.println(bufferEntrante);

        } catch (IOException e) {
            System.out.println(e.toString());
            bufferEntrante.setLength(0);
        }

        lee = null; // igualamos a null para no recordar rutas
        StringBuffer bufferPrimeros = null;
        indice = -1;

        try {
            lee = new FileReader("src\\primeros.txt");
            bufferPrimeros = new StringBuffer();
            int caracter = lee.read();

            while (caracter != -1) {
                indice ++;
                char imprimir = (char) caracter;
                bufferPrimeros.insert(indice,imprimir);
                caracter = lee.read();
            }
            lee.close();
            String primeroText = null;
            primeroText = String.valueOf(bufferEntrante);
            System.out.println(bufferPrimeros);

        } catch (IOException e) {
            System.out.println(e.toString());
            bufferPrimeros.setLength(0);
        }

        lee = null;
        StringBuffer bufferSegundos = null;
        indice = -1;

        try {
            lee = new FileReader("src\\segundos.txt");
            bufferSegundos = new StringBuffer();
            int caracter = lee.read();

            while (caracter != -1) {
                indice ++;
                char imprimir = (char) caracter;
                bufferSegundos.insert(indice,imprimir);
                caracter = lee.read();
            }
            lee.close();
            String segundoText = null;
            segundoText = String.valueOf(bufferEntrante);
            System.out.println(bufferSegundos);

        } catch (IOException e) {
            System.out.println(e.toString());
            bufferSegundos.setLength(0);
        }

        lee = null;
        StringBuffer bufferPostres = null;
        indice = -1;

        try {
            lee = new FileReader("src\\postres.txt");
            bufferPostres = new StringBuffer();
            int caracter = lee.read();

            while (caracter != -1) {
                indice ++;
                char imprimir = (char) caracter;
                bufferPostres.insert(indice,imprimir);
                caracter = lee.read();
            }
            lee.close();
            System.out.println(bufferPostres);

        } catch (IOException e) {
            System.out.println(e.toString());
            bufferPostres.setLength(0);
        }

        System.out.println("\nl"+"Le gusa el menú o desea hacer otro?"+"\n"+"1. Hacer otro"+"\n"+"2. Me gusta"); // SE CONSULTA AL USUARIO
        int decision = 0;
        try {
            decision = entrada.nextInt();
            entrada.nextLine();
        } catch (NullPointerException e) {
            System.out.println(e.toString());
        }

        if (decision==2) {
            generarMenuAleatorio(); // SE GENERA UN NUEVO MENÚ
        } else { // SE GUARDA EL MENU
            FileWriter borraMenu;
            FileWriter guardaMenu;

            try {
                borraMenu = new FileWriter("src\\menu.txt",false);
                guardaMenu = new FileWriter("src\\menu.txt",true);
                borraMenu.write(""); // Se borra el menú actual
                borraMenu.close(); // Cerramos para que se guardrn los cambios
                guardaMenu.write(bufferEntrante.toString()+"\n");
                guardaMenu.write(bufferPrimeros.toString()+"\n");
                guardaMenu.write(bufferSegundos.toString()+"\n");
                guardaMenu.write(bufferPostres.toString()+"\n");
                guardaMenu.close();
            } catch (IOException e) {
                System.out.println(e.toString());
            }
        }
    }

    @Override
    public void visualizarMenu() { // VISUALIZA EL MENU
        System.out.println("\nSu menú señor");
        FileReader lee = null; // Se iguala a null para no recordar la ruta
        StringBuffer bufferEntrante = null; // Se instancia a null para no recordar la ruta
        int indice = -1; // Crea un punto de inicio para el índice del StringBuffer

        try {
            lee = new FileReader("src\\menu.txt");
            bufferEntrante = new StringBuffer();
            int caracter = lee.read();

            while (caracter != -1) {
                indice ++;
                char imprimir = (char) caracter;
                bufferEntrante.insert(indice,imprimir);
                caracter = lee.read();
            }
            lee.close();
            String entranteText = null;
            entranteText = String.valueOf(bufferEntrante);
            System.out.println(bufferEntrante);

        } catch (IOException e) {
            System.out.println(e.toString());
            bufferEntrante.setLength(0);
        }

    }

    @Override
    public void visualizarMenuHistorico() { // VISUALIZA EL HISTORICO DE MENÚS
        System.out.println("\nSu historico de menús señor");
        FileReader leeHistorico = null; // Se iguala a null para no recordar la ruta
        StringBuffer bufferHistorico = null; // Se instancia a null para no recordar la ruta
        int indice = -1; // Crea un punto de inicio para el índice del StringBuffer

        try {
            leeHistorico = new FileReader("src\\menus_historico.txt");
            bufferHistorico = new StringBuffer();
            int caracter = leeHistorico.read();

            while (caracter != -1) {
                indice ++;
                char imprimir = (char) caracter;
                bufferHistorico.insert(indice,imprimir);
                caracter = leeHistorico.read();
            }
            leeHistorico.close();

            System.out.println(bufferHistorico);

        } catch (IOException | NullPointerException e) {
            System.out.println(e.toString());
            bufferHistorico.setLength(0); // Borra el bufferHistorico
        }
    }

    public void borrarMenu() { // BORRA EL MENU ACTUAL
        FileWriter borrarMenu = null;

        try {
            borrarMenu = new FileWriter("src\\menu.txt", false);
            borrarMenu.write(""); // Borra el contenido del archivo
            borrarMenu.close();
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }

    public void borrarHistorico() { // BORRA EL HISTORICO DE MENÚS
        FileWriter borrarHistorico = null;

        try {
            borrarHistorico = new FileWriter("src\\menus_historico.txt", false);
            borrarHistorico.write(""); // Borra el contenido del archivo
            borrarHistorico.close();
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }

    public String getNombreRestaurante() {
        return nombreRestaurante;
    }
}