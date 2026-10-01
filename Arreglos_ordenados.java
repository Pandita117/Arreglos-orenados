import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.Date;
import java.util.Scanner;



public class Arreglos_ordenados {
    static Scanner scan = new Scanner(System.in);
    static int n = 0;
    static int MAX = 20;
    static LocalDate[] fechas = new LocalDate[MAX];
    static int ciclos = 0;
    static DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");


    public static void main(String[] args) {

    }

    public static void inicializar() {
        if (n==0){
            System.out.println("El arrego ya esta iniciado");
        }else {
            n= -1;
        }


    }

}