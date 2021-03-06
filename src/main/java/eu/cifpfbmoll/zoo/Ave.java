package eu.cifpfbmoll.zoo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author Marat Rafael
 */
public class Ave extends Animal {

    //ATRIBUTOS
    private static int totalAves;
    private int numAlas;
    private double longitudVuelo;

    //CONSTRUCTORES
    // constructo vacio
    public Ave() {
        totalAves++;
    }

    // constructor con todos atributos
    public Ave(int numAlas, double longitudVuelo, String nombre, double peso) {
        super(nombre, peso);
        this.numAlas = numAlas;
        this.longitudVuelo = longitudVuelo;
        totalAves++;
    }

    // constructor copia
    public Ave(Ave ave) {
        super(ave.getNombre(), ave.getPeso());
        this.numAlas = ave.numAlas;
        this.longitudVuelo = ave.longitudVuelo;
        totalAves++;
    }

    //GETTER/SETTER
    public static int getTotalAves() {
        return totalAves;
    }

    public static void setTotalAves(int totalAves) {
        Ave.totalAves = totalAves;
    }

    public int getNumAlas() {
        return numAlas;
    }

    public void setNumAlas(int numAlas) {
        this.numAlas = numAlas;
    }

    public double getLongitudVuelo() {
        return longitudVuelo;
    }

    public void setLongitudVuelo(double longitudVuelo) {
        this.longitudVuelo = longitudVuelo;
    }

    // RESTO DE METODOS
    /**
     * metodo para mostrar atributos tanto del padre como de la ave
     */
    @Override
    public String mostrarAnimal() {
        String linea = "****************************************************";
        String animal = linea + "\n" + super.mostrarAnimal() + "\n Numero de alas: " + numAlas
                + "\n Longitud del vuelo: " + longitudVuelo + "\n" + linea;

        //super.mostrarAnimal();
        //System.out.println(" Numero de alas es " + numAlas + " y longitud del vuelo es " + longitudVuelo);
        return animal;
    }

    /**
     * Un metodo que muestra contador de animales y el contador de aves
     */
    @Override
    public void mostrarContador() {
        System.out.println("El numero total de animales en zoo es: " + Animal.getContadorAnimales()
                + " de los cuales " + Ave.getTotalAves() + " son aves");

    }

    public static void nuevoAve(ArrayList<Animal> listaAnimales) {
        
        Ave ave = new Ave();
        
        System.out.println("Nombre: ");
        String nombre = scString.nextLine();
        ave.setNombre(nombre);
        
        System.out.println("Peso: ");
        ave.setPeso(scNum.nextDouble());
        
        System.out.println("Numero alas: ");
        ave.setNumAlas(scNum.nextInt());
        
        System.out.println("Longitud del vuelo: ");
        ave.setLongitudVuelo(scNum.nextDouble());

        listaAnimales.add(ave);
    }

    public static void mostrarOrdenAveVuelo(ArrayList<Animal> listaAnimales) {

        ArrayList<Ave> listaAves = new ArrayList<>();

        for (int i = 0; i < listaAnimales.size(); i++) {
            if (listaAnimales.get(i) instanceof Ave) {
                // si es ave usamos casting y metemos en arrayList de aves
                listaAves.add((Ave) listaAnimales.get(i));
            }
        }
        Collections.sort(listaAves, new Comparator<Ave>() {
            public int compare(Ave a1, Ave a2) {
                // usamos double porque longitud de vuelo declarado como double
                // asi sera orden ascedente
                // para descendente cambiamos a1 y a2 
                return Double.valueOf(a1.getLongitudVuelo()).compareTo(a2.getLongitudVuelo());
            }
        });
        // usamos 'for' para mostrar 
        for (int i = 0; i < listaAves.size(); i++) {
            System.out.println(listaAves.get(i).mostrarAnimal());

        }
    }// fin metodo mostrar orden vuelo
    
    public static void mostrarOrdenAveNumAlas(ArrayList<Animal>listaAnimales){
        // creo un array solo para aves
        ArrayList<Ave> listaAves = new ArrayList<>();
        
        for (int i = 0; i < listaAnimales.size(); i++) {
            if(listaAnimales.get(i) instanceof Ave){
                listaAves.add((Ave)listaAnimales.get(i));
            }           
        }
        // usamos collections para ordenar
        Collections.sort(listaAves,new Comparator<Ave>()
        // tenemos que especificar que metodo usamos para comparar, va entre llaves
        {
            public int compare(Ave a1, Ave a2){
                
                return Integer.valueOf(a1.getNumAlas()).compareTo(a2.getNumAlas());
            }
        }
        );
        // usamos 'for' para mostrar
        for (int i = 0; i < listaAves.size(); i++) {
            System.out.println(listaAves.get(i).mostrarAnimal());
            
        }
    }// fin metodo mostrarOrdenAveNumAlas

    

}// fin clase
