package br.com.ConsultaCepModelos;

public class Endereco {

    private int cep;
    private String rua;
    private String bairro;
    private String cidade;

    public int getCep() {
        return cep;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public Endereco(enderecoViaCep enderecoPesquisado){
        this.cep = Integer.parseInt(enderecoPesquisado.cep());
        this.rua = enderecoPesquisado.logradouro();
        this.cidade = enderecoPesquisado.localidade();
        this.bairro = enderecoPesquisado.bairro();


    }

    @Override
    public String toString() {
        return "cep pesquisado: " + getCep() + "bairro: " + getBairro() + " rua: " + getRua() + " localidade: " + getCidade();
    }

}
