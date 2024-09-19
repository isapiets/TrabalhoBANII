package Floricultura;

public class FornecedoresProdutosBean {

    private int idFornecedor;
    private int idProduto;

    public FornecedoresProdutosBean(int idFornecedor, int idProduto) {
        this.idFornecedor = idFornecedor;
        this.idProduto = idProduto;
    }

    public int getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(int idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    @Override
    public String toString() {
        return "FornecedoresProdutosBean [ID Fornecedor=" + idFornecedor + ", ID Produto=" + idProduto + "]";
    }
}