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
        if (n == -1) {
            System.out.println("El arreglo ya esta vacio (inicializado)");
        }else {
            n= -1;
            System.out.println("Arreglo inicializado y borrado correctamente");
        }


    }

    public static void  mostrar() {
        if (n==-1){
            System.out.println("El arreglo esta vacio");
        } else{
            int libres = MAX - (n + 1);
            System.out.println("Localidades del arreglo libres: " + libres);
            for (int i = 0; i <= n; i++) {
                System.out.println("Índice [" + i + "]: " + Array_fechas[i].format(formato));
            }
        }

    }
    public static void insertar() {
        if (n == MAX - 1) { // Si el índice llegó a 19 ya hay 20 elementos.
            System.out.println("El arreglo está lleno, no se pueden insertar más fechas.");
            return;
        }

        System.out.println("Ingrese la fecha a insertar (dd/MM/yyyy): ");
        String fechaStr = scan.nextLine();
        LocalDate fecha_ingresar = LocalDate.parse(fechaStr, formato);

        // 1. Apuntamos a la última celda de memoria que está ocupada
        int i = n;

        // 2. Empujamos los datos: Mientras no nos salgamos del inicio (i >= 0)
        // Y la fecha en memoria sea más reciente (isAfter) que la que queremos meter.
        while (i >= 0 && Array_fechas[i].isAfter(fecha_ingresar)) {
            Array_fechas[i + 1] = Array_fechas[i]; // Movemos físicamente el dato a la derecha
            i--; // Caminamos un paso hacia atrás para revisar la siguiente
        }

        // 3. Cuando el ciclo se rompe, significa que encontramos un hueco donde
        // la fecha de la izquierda ya es más antigua. Insertamos en el hueco de enfrente (i + 1).
        Array_fechas[i + 1] = fecha_ingresar;

        // 4. Oficializamos que hay una fecha más en memoria
        n++;
        System.out.println("Fecha insertada correctamente ");
    }


    //  Busqueda lineal optimizada
    public static int busquedaLinealOptimizada(LocalDate fechaBuscada) {
        ciclos = 0; // reiniciamos ciclos
        if (n == -1) return -1; // Si el arreglo está vacío ggs

        for (int i = 0; i <= n; i++) {
            ciclos++;
            int comparacion = fechaBuscada.compareTo(Array_fechas[i]);

            if (comparacion == 0) {
                System.out.println("Fecha encontrada en: " + i);
                System.out.println("Ciclos tomados (Lineal Optimizada): " + ciclos);
                return i;
            }

            // stop si la fecha buscada es menor a la que estamos leyendo
            if (comparacion < 0) {
                break;
            }
        }
        System.out.println("No existe dicha fecha en el arreglo.");
        System.out.println("Ciclos tomados (Lineal Optimizada): " + ciclos);
        return -1;
    }

    // busqueda binaria
    public static int busquedaBinaria(LocalDate fechaBuscada) {
        ciclos = 0;
        int izq = 0;
        int der = n;
        while (izq <= der) {
            ciclos++;
            int centro = izq + (der - izq) / 2;
            int comparacion = fechaBuscada.compareTo(Array_fechas[centro]);

            if (comparacion == 0) {
                System.out.println("Fecha encontrada en la localidad: " + centro);
                System.out.println("Ciclos tomados (Binaria): " + ciclos);
                return centro;
            }
            if (comparacion < 0) {
                der = centro - 1; // descartamos mitad derecha
            } else {
                izq = centro + 1; // descartamos mitad izquierda
            }
        }
        System.out.println("No existe dicha fecha en el arreglo.");
        System.out.println("Ciclos tomados (Binaria): " + ciclos);
        return -1;
    }

    // Eliminar
    public static void eliminar() {
        if (n == -1) {
            System.out.println("El arreglo está vacio no hay nada que eliminar.");
            return;
        }

        System.out.println("Ingrese la fecha a eliminar (dd/MM/yyyy): ");
        String fechaStr = scan.nextLine();
        LocalDate fecha_eliminar = LocalDate.parse(fechaStr, formato);

        System.out.println("Buscando fecha para eliminar...");
        //  llamamos al metodo de búsqueda  binaria por rapidez
        int posicion = busquedaBinaria(fecha_eliminar);
        // si regresó diferente de -1 es que sí la encontró
        if (posicion != -1) {
            // Recorremos la memoria: aplastamos la fecha moviendo todo hacia la izquierda
            for (int i = posicion; i < n; i++) {
                Array_fechas[i] = Array_fechas[i + 1];
            }
            // limpiamos el último espacio duplicado y reducimos el contador N
            Array_fechas[n] = null;
            n = n - 1;
            System.out.println("Fecha eliminada exitosamente Conservando el orden.");
        } else {
            System.out.println("No se pudo localizar y por lo tanto no procede la operación de eliminación.");
        }
    }
}