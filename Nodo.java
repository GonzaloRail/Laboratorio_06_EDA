import java.util.HashMap;
import java.util.Map;

class Nodo {
    private Map<Character, Nodo> hijos;
    private boolean esFinalPalabra;

    public Nodo() {
        hijos = new HashMap<>();
        esFinalPalabra = false;
    }

    public Map<Character, Nodo> getHijos() {
        return hijos;
    }

    public boolean esFinalPalabra() {
        return esFinalPalabra;
    }

    public void setEsFinalPalabra(boolean esFinalPalabra) {
        this.esFinalPalabra = esFinalPalabra;
    }
}