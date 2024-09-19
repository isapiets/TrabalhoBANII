package Floricultura;

public class ProdutosBean {

    private int idProduto;
    private String descricao;
    private double precoUnitario;
    private int qtdEstoque;
    private int idCategoria;

    public ProdutosBean(int idProduto, String descricao, double precoUnitario, int qtdEstoque, int idCategoria) {
        this.idProduto = idProduto;
        this.descricao = descricao;
        this.precoUnitario = precoUnitario;
        this.qtdEstoque = qtdEstoque;
        this.idCategoria = idCategoria;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public int getQtdEstoque() {
        return qtdEstoque;
    }

    public void setQtdEstoque(int qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    @Override
    public String toString() {
        return "ProdutoBean [ID=" + idProduto + ", Descrição=" + descricao + ", Preço Unitário=" + precoUnitario + ", Quantidade em Estoque=" + qtdEstoque + ", ID Categoria=" + idCategoria + "]";
    }
}