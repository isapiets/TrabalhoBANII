package Floricultura;

public class FornecedoresBean {

    private int idFornecedor;
    private String nome;
    private String rua;
    private int numero;
    private String bairro;
    private String cidade;
    private String estado;
    private String email;
    private String telefone;

    public FornecedoresBean(int idFornecedor, String nome, String rua, int numero, String bairro, String cidade, String estado, String email, String telefone) {
        this.idFornecedor = idFornecedor;
        this.nome = nome;
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.email = email;
        this.telefone = telefone;
    }

    public int getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(int idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "FornecedoresBean [ID=" + idFornecedor + ", Nome=" + nome + ", Rua=" + rua + ", Numero=" + numero +
               ", Bairro=" + bairro + ", Cidade=" + cidade + ", Estado=" + estado + ", Email=" + email + ", Telefone=" + telefone + "]";
    }
}