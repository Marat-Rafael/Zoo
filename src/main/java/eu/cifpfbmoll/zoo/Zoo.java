
package eu.cifpfbmoll.zoo;

import java.util.ArrayList;

/**
 *
 * @author Marat Rafael
 */
public class Zoo {
    
    private ArrayList<Animal> listaAnimales = new ArrayList<>();

    public Zoo() {
    }
    

    public ArrayList<Animal> getListaAnimales() {
        return listaAnimales;
    }

    public void setListaAnimales(ArrayList<Animal> listaAnimales) {
        this.listaAnimales = listaAnimales;
    }

    @Override
    public String toString() {
        return "Zoo{" + "listaAnimales=" + listaAnimales + '}';
    }
    
    public void altaAve(){
        Ave.nuevoAve(listaAnimales);
    }
 
}
