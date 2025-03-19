public class CodificadorFactory {
    public static Codificador getCodificador(String tipo) {
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
}
