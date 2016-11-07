/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dto.DtoProduto;
import Dto.DtoUsuario;
import Dto.DtoVenda;
import Model.VendaDao;
import java.sql.SQLException;
import java.util.List;

public class VendaFaces {
    private VendaDao vendaDao = new VendaDao();
    private DtoVenda vendaselecionada;
    private List<DtoVenda> vendas = null;
   
    public VendaFaces() {
    }

    public DtoVenda getVendaselecionada() {
        return vendaselecionada;
    }

    public void setVendaselecionada(DtoVenda vendaselecionada) {
        this.vendaselecionada = vendaselecionada;
    }

    public List<DtoVenda> getVendas() {
        return vendas;
    }

    public void setVendas(List<DtoVenda> vendas) {
        this.vendas = vendas;
    }

    public List<DtoVenda> getvendas() throws ClassNotFoundException, SQLException {
        if (this.vendas == null) {
            this.vendas = vendaDao.getRetornaTodos();
        }
        return this.vendas;
    }

    public void setVendaDao(VendaDao vendaDao) {
        this.vendaDao = vendaDao;
    }
    
      public String PreparaInclusao(){
          vendaselecionada = new DtoVenda();
          vendaselecionada.setUsuario(new DtoUsuario());
          vendaselecionada.setProduto(new DtoProduto());
          
          return "VaiParaNovaVenda";
      }
    public String finalizarVenda() throws ClassNotFoundException, SQLException{
     vendaDao.setAdcionar(vendaselecionada);
     vendaselecionada  = null;
     return "VoltarParaListagem";
    }
}
