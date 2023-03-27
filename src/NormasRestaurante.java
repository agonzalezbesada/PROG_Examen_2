import java.util.Scanner;

public interface NormasRestaurante { //

    String nombreRestaurante = "Restaurante de la esquina";

    void generarMenuAleatorio();

    void visualizarDecidir(Scanner entrada);

    void visualizarMenu();

    void visualizarMenuHistorico();

    void borrarMenu();

    void borrarHistorico();

}
