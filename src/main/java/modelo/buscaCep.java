public class buscaCep {

    private int cep;
    private String logradouro;

    public buscaCep(int cep, String logradouro){
        this.cep = cep;
        this.logradouro = logradouro;
    }

    public int getCep(){
        return cep;
    }

    public String getLogradouro(){
        return logradouro;
    }
}