import java.net.URL;
import java.net.HttpURLConnection;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
import com.google.gson.JsonParser;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class Conversor {
    public static void converterMoeda(String moedaOrigem, String moedaDestino, Scanner scanner) {
        try {
            String apiKey = "dcd0be7704549945229aa612"; // Chave da API
            String url_str = "https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/" + moedaOrigem;

            URL url = new URL(url_str);
            HttpURLConnection request = (HttpURLConnection) url.openConnection();
            request.connect();

            JsonParser jp = new JsonParser();
            JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
            JsonObject jsonobj = root.getAsJsonObject();

            JsonObject conversionRates = jsonobj.getAsJsonObject("conversion_rates");

            if (!conversionRates.has(moedaDestino)) {
                System.out.println("Moeda de destino inválida.");
                return;
            }

            double taxaDeCambio = conversionRates.get(moedaDestino).getAsDouble();

            System.out.print("Digite o valor a ser convertido: ");
            double valor = scanner.nextDouble();

            double valorConvertido = valor * taxaDeCambio;

            System.out.println("************* - RESULTADO DA CONVERSÃO - ***********************");
            System.out.println("           " + valor + " " + moedaOrigem + " Equivalem a " + valorConvertido + " " + moedaDestino);
            System.out.println("****************************************************************");

            // Após exibir o resultado, aguarda a entrada do usuário para retornar ao menu principal
            System.out.println("\nPressione Enter para voltar ao menu principal...");
            scanner.nextLine(); // Limpa o buffer
            scanner.nextLine(); // Aguarda a entrada do usuário
        } catch (Exception e) {
            System.out.println("*********************** - ERRO - *******************************");
            System.out.println("Ocorreu um erro: " + e.getMessage());
            System.out.println("****************************************************************");
            // Finalizar a aplicação
            System.exit(1);
        }
    }
}
