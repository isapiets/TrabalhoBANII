package Floricultura;

import java.sql.Date;

public class VendasBean {

    private int idVenda;
    private double total;
    private Date data;
    private int idCliente;

    public VendasBean(int idVenda, double total, Date data, int idCliente) {
        this.idVenda = idVenda;
        this.total = total;
        this.data = data;
        this.idCliente = idCliente;
    }

    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    @Override
    public String toString() {
        return "VendasBean [ID=" + idVenda + ", Total=" + total + ", Data=" + data + ", ID Cliente=" + idCliente + "]";
    }
}