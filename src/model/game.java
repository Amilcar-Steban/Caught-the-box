
package model;

public class game {
    private int puntaje;

    public game() {
        puntaje = 0;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }
    public void sum(int puntaje) {
        this.puntaje += puntaje;
    }
    
    
}
