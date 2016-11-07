package Model;

import Dto.DtoProduto;
import Dto.DtoUsuario;
import Dto.DtoVenda;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class VendaDao extends DaoUtil{
    
    public VendaDao() {
        super();
    }
        public boolean setAdcionar(DtoVenda venda) throws ClassNotFoundException, SQLException{
            String sql = "INSERT INTO tbVenda (idProduto, idUsuario, vlVenda) values (?,?,?)";
            PreparedStatement ps = super.getPreparedStatement(sql);
            ps.setInt(1, venda.getProduto().getIdproduto());
            ps.setInt(2, venda.getUsuario().getId());
            ps.setDouble(3, venda.getVlvenda());

            int ret = ps.executeUpdate();
            ps.close();
            return ret > 0;
        }
        
        
        
        public boolean setAlterar(DtoVenda venda) throws ClassNotFoundException, SQLException{
            String sql = "UPDATE tbVenda SET "+
                         "idProduto = ?, idUsuario = ?" + 
                         "WHERE idVenda = ?";

             PreparedStatement ps = super.getPreparedStatement(sql);
             ps.setInt(1,venda.getProduto().getIdproduto());
             ps.setInt(2, venda.getUsuario().getId());
             ps.setDouble (3, venda.getVlvenda());

             int ret = ps.executeUpdate();
             ps.close();

             return ret > 0; // retorna se foi sucesso ou não a incersão de objeto 
         }
        
        
        public boolean setDeletar(DtoVenda venda) throws ClassNotFoundException, SQLException{
            String sql = "DELETE FROM tbVenda "+
                         "WHERE idVenda = ?";

             PreparedStatement ps = super.getPreparedStatement(sql);
             ps.setInt (1, venda.getIdvenda());
             int ret = ps.executeUpdate();
             ps.close();

             return ret > 0; // retanar se foi sucesso ou não a incesão de ob 
    }
    
        
        public List<DtoVenda> getRetornaTodos() throws ClassNotFoundException, SQLException{
            List<DtoVenda> lstVenda = new LinkedList<DtoVenda>();
            String sql = "SELECT idVenda, idProduto, idUsuario, vlVenda FROM tbVenda";

            ResultSet rs = super.getStatement().executeQuery(sql);
            ProdutoDao prodDAO = new ProdutoDao();
            UsuarioDao usuDAO = new UsuarioDao();
                    
            while(rs.next()){
                DtoVenda vendaAux = new DtoVenda();
                vendaAux.setIdvenda(rs.getInt("idVenda"));
                vendaAux.setVlvenda(rs.getDouble("vlVenda"));
                DtoProduto prodAux = new DtoProduto();
                prodAux.setIdproduto(rs.getInt("idProduto"));
                vendaAux.setProduto(prodDAO.getPorId(prodAux));
                DtoUsuario usuAux = new DtoUsuario();
                usuAux.setId(rs.getInt("idUsuario"));
                vendaAux.setUsuario(usuDAO.getPorId(usuAux));
                lstVenda.add(vendaAux);
                
            }
            rs.close();
            super.getFechaTudo();
            return lstVenda;
    }
        
        
    }
