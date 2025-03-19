import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.time.LocalDate;
import java.util.Base64;

public class CodificadorForte implements Codificador {
    private static final String ALGORITMO = "AES";
    private static final int TAMANHO_CHAVE = 128;
    private SecretKey chaveSecreta;

    public CodificadorForte() {
        try {
            KeyGenerator keyGen = KeyGenerator.getInstance(ALGORITMO);
            keyGen.init(TAMANHO_CHAVE);
            chaveSecreta = keyGen.generateKey();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao gerar chave AES", e);
        }
    }

    public String getNome() {
        return "Codificador Forte";
    }

    public LocalDate getDataCriacao() {
        return LocalDate.of(2025, 03, 13);
    }

    public int getNivelSeguranca() {
        return 3;
    }

    public String codifica(String str) {
        try {
            Cipher cipher = Cipher.getInstance(ALGORITMO);
            cipher.init(Cipher.ENCRYPT_MODE, chaveSecreta);
            byte[] textoCodificado = cipher.doFinal(str.getBytes());
            return Base64.getEncoder().encodeToString(textoCodificado); // Codifica em Base64 para facilitar armazenamento
        } catch (Exception e) {
            throw new RuntimeException("Erro ao codificar texto", e);
        }
    }

    public String decodifica(String str) {
        try {
            Cipher cipher = Cipher.getInstance(ALGORITMO);
            cipher.init(Cipher.DECRYPT_MODE, chaveSecreta);
            byte[] textoDecodificado = cipher.doFinal(Base64.getDecoder().decode(str)); // Decodifica de Base64
            return new String(textoDecodificado);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao decodificar texto", e);
        }
    }
}
