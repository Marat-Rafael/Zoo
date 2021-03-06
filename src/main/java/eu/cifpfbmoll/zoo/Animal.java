package eu.cifpfbmoll.zoo;

import java.util.Scanner;

/**
 *
 * @author Marat Rafael
 */
public abstract class Animal {

    public static Scanner scNum = new Scanner(System.in);
    public static Scanner scString = new Scanner(System.in);
    //ATRIBUTOS
    private static int contadorAnimales;
    private String nombre;
    private double peso;

    //CONSTRUCTORES
    //constructor vacio
    public Animal() {
        contadorAnimales++;
    }

    //constructor con todos atributos
    public Animal(String nombre, double peso) {
        contadorAnimales++;
        this.nombre = nombre;
        this.peso = peso;
    }

    //constructor copia
    public Animal(Animal animal) {
        contadorAnimales++;
        this.nombre = animal.nombre;
        this.peso = animal.peso;
    }

    /*
    *   El nombre debe tener todas las letras en minúscula. 
        Y el peso nunca puede ser menor o igual a cero, 
        en caso contrario se pedirá indefinidamente
    *   hasta que ponga el usuario un peso mayor que cero.
     */
    // GETTER/SETTER
    public static int getContadorAnimales() {
        return contadorAnimales;
    }

    public static void setContador(int contador) {
        Animal.contadorAnimales = contador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        nombre = nombre.toLowerCase();
        this.nombre = nombre;

    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
        if (peso < 0) {
            do {
                System.out.println("El peso nunca puede ser menor o igual a cero");
                this.peso = scNum.nextDouble();
            } while (peso <= 0 );
        }
    }

    //toString
        @Override
    public String toString() {
        return "Animal{" + "nombre=" + nombre + ", peso=" + peso + '}';
    }
    /**
     * Un metodo para mostrar toda la informacion del animal
     * @return String "Es un animal "+nombre+" su peso es "+peso
     */
    public String mostrarAnimal(){   
       
        String animal = " Animal: "+nombre+"\n Peso: "+peso ;
        //System.out.println("Es un animal "+nombre+" su peso es "+peso );
        return animal;
    }

    /**
     * obligamos a todo subclases implementar este metodo, uso String para mostrar con texto 
     */
    public abstract void mostrarContador();
    
}// fin clase
