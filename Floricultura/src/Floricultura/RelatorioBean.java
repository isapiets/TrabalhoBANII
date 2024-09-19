package Floricultura;

public class RelatorioBean {
    private String fornecedor;
    private String produto;
    private String cliente;
    private int vendaId;
    private double total;
    private int quantidade;

    // Getters e Setters
    public String getFornecedor() { return fornecedor; }
    public void setFornecedor(String fornecedor) { this.fornecedor = fornecedor; }

    public String getProduto() { return produto; }
    public void setProduto(String produto) { this.produto = produto; }

    public String getCliente() { return cliente; }
    public void setCliente(String cliente) { this.cliente = cliente; }

    public int getVendaId() { return vendaId; }
    public void setVendaId(int vendaId) { this.vendaId = vendaId; }

    public double getTotal() { return total; }
    public void setTotal(double total) { this.total = total; }

    public int getQuantidade() { return quantidade; }
    public void setQuantidade(int quantidade) { this.quantidade = quantidade; }
}