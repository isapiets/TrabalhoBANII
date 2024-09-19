package Floricultura;

public class ClientesBean {

    private int idCliente;
    private String nome;
    private String sobrenome;
    private String telefone;
    private String email;
    private long cpf;

    public ClientesBean(int idCliente, String nome, String sobrenome, String telefone, String email, long cpf) {
        this.idCliente = idCliente;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.telefone = telefone;
        this.email = email;
        this.cpf = cpf;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "ClientesBean [ID=" + idCliente + ", Nome=" + nome + ", Sobrenome=" + sobrenome + 
               ", Telefone=" + telefone + ", Email=" + email + ", CPF=" + cpf + "]";
    }
}