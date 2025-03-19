public class App {
    public static void main(String[] args) throws Exception {
        Codificador cod1 = new CodificadorFactory().getCodificador("1");
        Codificador cod2 = new CodificadorFactory().getCodificador("2");
        Codificador cod3 = new CodificadorFactory().getCodificador("3");

        for(int i = 0; i < 3; i++) {
            Codificador cod = null;
            if(i == 0) {
                cod = cod1;
            } else if(i == 1) {
                cod = cod2;
            } else if(i == 2) {
                cod = cod3;
            }
            System.out.println("Codificador: "+cod.getNome());
            System.out.println("Versao: "+cod.getDataCriacao());
            System.out.println("Nivel de segurança: "+cod.getNivelSeguranca());
            
            String texto = "Este e o string a ser codificado";
            String codificado = cod.codifica(texto);
            String decodificado = cod.decodifica(codificado);

            System.out.println("Texto original: "+texto);
            System.out.println("Texto codificado: "+codificado);
            System.out.println("Texto decodificado: "+decodificado);
        }
    }
}
