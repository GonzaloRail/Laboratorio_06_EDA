public class Trie {
    private Nodo raiz;

    public Trie() {
        raiz = new Nodo();
    }

    public void insertar(String palabra) {
        Nodo nodoActual = raiz;

        for (int i = 0; i < palabra.length(); i++) {
            char caracter = palabra.charAt(i);
            Nodo nodo = nodoActual.getHijos().getOrDefault(caracter, new Nodo());
            nodoActual.getHijos().put(caracter, nodo);
            nodoActual = nodo;
        }

        nodoActual.setEsFinalPalabra(true);
    }

    public boolean buscar(String palabra) {
        Nodo nodoActual = raiz;

        for (int i = 0; i < palabra.length(); i++) {
            char caracter = palabra.charAt(i);
            if (!nodoActual.getHijos().containsKey(caracter)) {
                return false;
            }
            nodoActual = nodoActual.getHijos().get(caracter);
        }

        return nodoActual.esFinalPalabra();
    }

    public boolean empiezaCon(String prefijo) {
        Nodo nodoActual = raiz;

        for (int i = 0; i < prefijo.length(); i++) {
            char caracter = prefijo.charAt(i);
            if (!nodoActual.getHijos().containsKey(caracter)) {
                return false;
            }
            nodoActual = nodoActual.getHijos().get(caracter);
        }

        return true;
    }
}
