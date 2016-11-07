/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dto;

/**
 *
 * @author alunoads
 */
public class DtoVenda {
    
    private int idvenda;
    private DtoUsuario usuario;
    private DtoProduto produto;
    private double vlvenda;
    
    public DtoVenda(){
    }

    public int getIdvenda() {
        return idvenda;
    }

    public void setIdvenda(int idvenda) {
        this.idvenda = idvenda;
    }

    public DtoUsuario getUsuario() {
        return usuario;
    }

    public void setUsuario(DtoUsuario usuario) {
        this.usuario = usuario;
    }

    public DtoProduto getProduto() {
        return produto;
    }

    public void setProduto(DtoProduto produto) {
        this.produto = produto;
    }

    public double getVlvenda() {
        return vlvenda;
    }

    public void setVlvenda(double vlvenda) {
        this.vlvenda = vlvenda;
    }
    
    
    
}
