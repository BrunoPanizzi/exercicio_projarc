public class CodificadorFactory {
    private static CodificadorFactory instance;

    private CodificadorFactory() {
    }

    public static CodificadorFactory getInstance() {
        if (instance == null) {
            instance = new CodificadorFactory();
        }
        return instance;
    }

    synchronized public Codificador getCodificador(String tipo) {
        if (tipo.equals("1")) {
            return new CodificadorSimples();
        } else if (tipo.equals("2")) {
            return new CodificadorMedio();
        } else if (tipo.equals("3")) {
            return new CodificadorForte();
        } else {
            return null;
        }
    }

    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }
}
