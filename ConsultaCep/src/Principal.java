import br.com.ConsultaCepModelos.Endereco;
import br.com.ConsultaCepModelos.enderecoViaCep;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) throws IOException, InterruptedException {


        System.out.println("Digite seu CEP:");
        Scanner busca = new Scanner(System.in);
        int leituraBusca = busca.nextInt();


        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://viacep.com.br/ws/"+ leituraBusca + "/json/"))
                .build();

        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        String json = response.body();

        Gson gson = new Gson();
        enderecoViaCep enderecoPesquisado = gson.fromJson(json, enderecoViaCep.class);


        System.out.println(enderecoPesquisado.cep());
        System.out.println(enderecoPesquisado.bairro());
        System.out.println(enderecoPesquisado.localidade());
        System.out.println(enderecoPesquisado.logradouro());



    }
}
