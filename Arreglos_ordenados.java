import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;



public class Arreglos_ordenados {
    static Scanner scan = new Scanner(System.in);
    static int n = -1;
    static int MAX = 20;
    static LocalDate[] Array_fechas = new LocalDate[MAX];
    static int ciclos = 0;
    static DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");


    public static void main(String[] args) {

    }
    //aca inicializamos el arreglo con 0 si ya ta en 0 pues ya esta y si no se reincia
    public static void inicializar() {
        if (n==0){
            System.out.println("El arrego ya esta iniciado");
        }else {
            n=0;
        }


    }

    public static void  mostrar() {
        if (n==-1){
            System.out.println("El arreglo esta vacio");
        } else{
            for (int i =0; i<=n; i++){
                //aqui recorre el arreglo y muestra fechas y localidaes libres en el formato pedido
                System.out.println("Localidades del arreglo libres son: " + (MAX - n));
                System.out.println(Array_fechas[i].format(formato));
            }
        }

    }
    public static void insertar(){
        if (n==MAX-1){
            System.out.println("El areglo esta lleno no se puede intertar mas Array_fechas");
        }
        else {
            //pasamo primero el formato de fecha
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            System.out.println("Ingrese la fecha a insertar (dd/MM/yyyy): ");
           //guardamos fecha a string
            String fechaStr = scan.nextLine();

            //fecha parseada a localdate
            LocalDate fecha_ingresar = LocalDate.parse(fechaStr, formato);

            //i es la posicion
            int i =0;
            //mientras la posicion sea mayor o igual a 0 y la fecha ingresada sea menor a la fecha en el arreglo, se mueve la fecha en el arreglo una posicion hacia adelante
            while (i>= 0 && fecha_ingresar.isBefore(Array_fechas[i])){
                Array_fechas[i+1] = Array_fechas[i];
                i = i-1;
                //aqui pone la fecha a inglesar en la posicon
                Array_fechas[i+1] = fecha_ingresar;
                n=n+1;
                System.out.println("Fecha insertada correctamente en la posición " + (i+1));
            }

        }
    }



}