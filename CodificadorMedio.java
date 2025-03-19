import java.time.LocalDate;

public class CodificadorMedio implements Codificador {
		private final int CHAVE = 10;

    public String getNome() {
        return "Codificador Medio";
    }

    public LocalDate getDataCriacao() {
        return LocalDate.of(2025, 03, 19);
    }

    public int getNivelSeguranca(){
        return 2;
    }

    public String codifica(String str) {
        StringBuilder encoded = new StringBuilder();

				int i = 0;
        for (char c : str.toCharArray()) {
            encoded.append((char) (c + i + 1));
						i = (i + 1) % CHAVE;
        }

        return encoded.toString();
    }

    public String decodifica(String str) {
        StringBuilder encoded = new StringBuilder();
        
				int i = 0;
        for (char c : str.toCharArray()) {
            encoded.append((char) (c - i - 1));
						i = (i + 1) % CHAVE;
        }
        
        return encoded.toString();
    }
}
