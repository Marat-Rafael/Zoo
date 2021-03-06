package eu.cifpfbmoll.zoo;


import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Marat Rafael
 */
public class AppZoo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
          
        
        ArrayList<Animal> listaAnimales = new ArrayList<>();
        Zoo zoo = new Zoo();       
        zoo.setListaAnimales(listaAnimales);
        
        cargarZooAves(listaAnimales);
        
        boolean salir = false;
        byte opcionMenu;
        do {
            System.out.println("***********************************************");
            System.out.println("************MENU*******************************");
            System.out.println("1-Alta pez");
            System.out.println("2-Alta Ave");
            System.out.println("3-Mostrar aves ordenado Vuelo");
            System.out.println("4-Mostrar aves ordenado numero alas");
            System.out.println("0-Salir");
            opcionMenu = sc.nextByte();
            switch (opcionMenu) {
                case 1:
                    
                    break;
                case 2:
                    zoo.altaAve();
                    break;
                case 3:
                    Ave.mostrarOrdenAveVuelo(listaAnimales);
                    break;
                case 4:
                    Ave.mostrarOrdenAveNumAlas(listaAnimales);
                    break;
                case 0:
                    salir=true;
                    break;
                default:
                    System.out.println("Solo opciones disponibles de 0 a 4");
                    break;

            }

        } while (!salir);

      

    }

    public static void cargarZooAves(ArrayList<Animal> listaAnimales) {
        Ave a1 = new Ave(2, 200, "ave1", 1);
        Ave a2 = new Ave(10, 4200, "ave2", 55);
        Ave a3 = new Ave(6, 500, "ave3", 7);
        Ave a4 = new Ave(8, 800, "ave4", 8);
        Ave a5 = new Ave(4, 400, "ave5", 22);

        listaAnimales.add(a1);
        listaAnimales.add(a2);
        listaAnimales.add(a3);
        listaAnimales.add(a4);
        listaAnimales.add(a5);

        //Ave.ordenarNumAlas(listaAnimales);
/*
        for (Animal a : listaAnimales) {
            System.out.println(a.mostrarAnimal());
        }
*/
    }

}
