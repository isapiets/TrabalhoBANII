package Floricultura;

public class ItensDaVendaBean {

    private int idItemDaVenda;
    private int idVenda;
    private int idProduto;
    private int quantidade;

    public ItensDaVendaBean(int idItemDaVenda, int idVenda, int idProduto, int quantidade) {
        this.idItemDaVenda = idItemDaVenda;
        this.idVenda = idVenda;
        this.idProduto = idProduto;
        this.quantidade = quantidade;
    }

    public int getIdItemDaVenda() {
        return idItemDaVenda;
    }

    public void setIdItemDaVenda(int idItemDaVenda) {
        this.idItemDaVenda = idItemDaVenda;
    }

    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "ItensDaVendaBean [ID Item da Venda=" + idItemDaVenda + ", ID Venda=" + idVenda + ", ID Produto=" + idProduto + ", Quantidade=" + quantidade + "]";
    }
}