package eu.cifpfbmoll.zoo;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Marat Rafael
 */
public class Pez extends Animal {

    //atributos
    private static int totalPez;
    private String color;
    private int tamanio;
    private String distribucion;
    private int longevidad;

    //constructores
    //constructor vacio
    public Pez() {
    }

    //constructor con todos atributos
    public Pez(String color, int tamanio, String distribucion, int longevidad, String nombre, double peso) {
        super(nombre, peso);
        this.color = color;

        this.tamanio = tamanio;
        this.distribucion = distribucion;
        this.longevidad = longevidad;
    }
    //constructor copia

    public Pez(Pez pez) {
        super(pez.getNombre(), pez.getPeso());
        this.color = pez.getColor();
        this.tamanio = pez.getTamanio();
        this.distribucion = pez.getDistribucion();
        this.longevidad = pez.getLongevidad();
    }

    //getter/setter
    public static int getTotalPez() {
        return totalPez;
    }

    public static void setTotalPez(int totalPez) {
        Pez.totalPez = totalPez;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getTamanio() {
        return tamanio;
    }

    public void setTamanio(int tamanio) {
        this.tamanio = tamanio;
    }

    public String getDistribucion() {
        return distribucion;
    }

    public void setDistribucion(String distribucion) {
        this.distribucion = distribucion;
    }

    public int getLongevidad() {
        return longevidad;
    }

    public void setLongevidad(int longevidad) {
        this.longevidad = longevidad;
    }

    @Override
    public String toString() {
        return super.toString() + "Pez{" + "color=" + color + ", tamanio=" + tamanio + ", distribucion=" + distribucion + ", longevidad=" + longevidad + '}';
    }

    /**
     * String color, int tamanio, String distribucion, int longevidad, String
     * nombre, double peso
     */
    public static void nuevoPez(ArrayList<Animal> listaAnimales) {
        Pez pez = new Pez();

        System.out.println("Nombre: ");
        pez.setNombre(scString.nextLine().toLowerCase());

        System.out.println("Peso: ");
        pez.setPeso(scNum.nextDouble());

        System.out.println("Color: ");
        pez.setColor(scString.nextLine().toLowerCase());

        System.out.println("Tamaño: ");
        pez.setTamanio(scNum.nextInt());

        System.out.println("Distribucion: ");
        pez.setDistribucion(scString.nextLine().toLowerCase());

        System.out.println("Color: ");
        pez.setColor(scString.nextLine().toLowerCase());

        System.out.println("Longevidad: ");
        pez.setLongevidad(scString.nextInt());

        listaAnimales.add(pez);
    }

    public static void ordenarLista(ArrayList<Pez> listaPez) {
        boolean salir = false;
        do {
            System.out.println("Como desea ordenar: ");
            System.out.println("1-Nombre");
            System.out.println("2-Peso");
            System.out.println("3-Color");
            System.out.println("4-Tamaño");
            System.out.println("5-Distribucion");
            System.out.println("6-Color");
            System.out.println("7-Longevidad");
            System.out.println("0-Salir");
            byte opcion = scNum.nextByte();
            switch (opcion) {
                case 1:
                    Pez.ordenarPorNombre(listaPez);
                    break;
                case 2:

                    break;
                case 3:
                    break;
                case 4:
                    Pez.ordenarPorTamano(listaPez);
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opciones de 1 a 7, 0-para salir");
                    break;

            }
        } while (!salir);
    }

    public static void mostrarTodosPeces(ArrayList<Pez> listaPez) {
        for (int i = 0; i < listaPez.size(); i++) {
            System.out.println(listaPez.get(i).toString());
        }
    }

    /**
     * alfo falla, hay que reviar
     * @param listaPez 
     */
    private static void ordenarPorNombre(ArrayList<Pez> listaPez) {
        //creamos un objeto pez auxiliar
        Pez aux;
        for (int i = 0; i < listaPez.size() - i; i++) {
            for (int j = 0; j < listaPez.size() - i - 1; j++) {
                if (listaPez.get(j).getNombre().charAt(0) < listaPez.get(j).getNombre().charAt(0)) {
                    aux = listaPez.get(j + 1);
                    listaPez.set(j + 1, listaPez.get(j));
                    listaPez.set(j, aux);
                }
            }
        }
        mostrarTodosPeces(listaPez);
    }// fin metodo ordenarPorNombre

    /**
     * 
     * @param listaPez 
     */
    private static void ordenarPorTamano(ArrayList<Pez> listaPez) {
        Pez auxPez;
        for (int i = 0; i < listaPez.size()-1; i++) {
            for (int j = 0; j < listaPez.size()-i-1; j++) {
                if (listaPez.get(j+1).getTamanio() < listaPez.get(j).getTamanio()) {
                    auxPez = listaPez.get(j + 1);
                    listaPez.set(j + 1, listaPez.get(j));
                    listaPez.set(j, auxPez);
                }
            }
        }
        mostrarTodosPeces(listaPez);
    }//fin metodo ordenarPorTamanio

    @Override
    public void mostrarContador() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
