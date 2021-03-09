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

    @Override
    public String toString() {
        return super.toString();
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

    private static void mostrarTodosAves(ArrayList<Ave> listaAve) {
        for (int i = 0; i < listaAve.size(); i++) {
            System.out.println(listaAve.get(i).mostrarAnimal());
        }
    }// fon mostrarAve

    private static ArrayList<Ave> ExtraerAves(ArrayList<Animal> listaAnimales) {
        ArrayList<Ave> listaAves = new ArrayList<>();
        for (int i = 0; i < listaAnimales.size(); i++) {
            if (listaAnimales.get(i) instanceof Ave) {
                listaAves.add((Ave) listaAnimales.get(i));
            }
        }
        return listaAves;
    }//fin metodo extraer Aves

    private static void ordenarPorLongitudVuelo(ArrayList<Animal> listaAnimales) {
        // creamos nuevo array solo para aves
        ArrayList<Ave> listaAves = ExtraerAves(listaAnimales);
        //Creamos Ave auxiliar
        Ave aux;
        for (int i = 0; i < listaAves.size() - 1; i++) {
            for (int j = 0; j < listaAves.size() - i - 1; j++) {
                if (listaAves.get(j + 1).getLongitudVuelo() < listaAves.get(j).getLongitudVuelo()) {
                    aux = listaAves.get(j + 1);
                    listaAves.set(j + 1, listaAves.get(j));
                    listaAves.set(j, aux);
                }
            }
        }
        mostrarTodosAves(listaAves);
    }// fin metodo ordenarPorLongitudVuelo

    private static void ordenarPorNumAlas(ArrayList<Animal> listaAnimales) {
        //creamos arraylist solo para aves
        ArrayList<Ave> listaAves = ExtraerAves(listaAnimales);
        //creamos ave auxiliar
        Ave aux;
        for (int i = 0; i < listaAves.size()-1; i++) {
            for (int j = 0; j < listaAves.size()-i-1; j++) {
                if(listaAves.get(j+1).getNumAlas()<listaAves.get(j).getNumAlas()){
                    aux = listaAves.get(j+1);
                    listaAves.set(j+1, listaAves.get(j));
                    listaAves.set(j, aux);                   
                }               
            }            
        }
        mostrarTodosAves(listaAves);
    }//fin metodo ordenarPorNumAlas

    public static void mostrarAvesOrdenado(ArrayList<Animal> listaAnimales) {
        boolean salir = false;
        do {
            System.out.println("Como desea ordenar Aves ? ");
            System.out.println("1-Longitud de vuelo");
            System.out.println("2-Numero de alas");
            System.out.println("0-Salir");
            byte opcionMenu = scNum.nextByte();
            switch (opcionMenu) {
                case 1:
                    ordenarPorLongitudVuelo(listaAnimales);
                    break;
                case 2:
                    ordenarPorNumAlas(listaAnimales);
                    break;
                case 0:
                    salir = true;
                    break;
                default:
                    System.out.println("Opciones disponibles 1-longitud de vuelo, 2-Numero de alas, 0-Salir");
            }

        } while (!salir);

    }// fin mostrarOrdenado

}// fin clase
