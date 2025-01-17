package com.deveduardo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.deveduardo.dao.uteis.Conexao;
import com.deveduarteo.model.Produto;

public class ProdutoDAO {
	
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
	
	
	public void cadastrarProduto(Produto produto) {
		try {
			conn = new Conexao().getConnection();
			String sql = "INSERT INTO PRODUTO VALUES(null, ?, ?, ?, ?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, produto.getDescricao());
			ps.setDouble(2, produto.getQuantidade());
			ps.setDouble(3, produto.getPreco());
			ps.setBoolean(4, produto.isOnLine());
			ps.execute();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(ps != null)
					ps.close();
			}catch (Exception e2) {
			e2.printStackTrace();
			}
			try {
				if(conn != null)
					conn.close();
			}catch(Exception e3) {
				e3.printStackTrace();
			}
		}
	}
	
	public List<Produto> BuscarProdDesc(String descricao) {
	    String sql = "SELECT * FROM PRODUTO WHERE descricao LIKE ?";
	    List<Produto> list = new ArrayList<>();
	    Connection conn = null;
	    PreparedStatement ps = null;
	    ResultSet rs = null;

	    try {
	        conn = new Conexao().getConnection();
	        ps = conn.prepareStatement(sql);
	        ps.setString(1, "%" + descricao + "%"); // Use a variável descricao aqui

	        rs = ps.executeQuery();
	        while (rs.next()) {
	            Produto prod = new Produto();
	            prod.setIdProduto(rs.getInt("IdProduto"));
	            prod.setDescricao(rs.getString("descricao"));
	            prod.setQuantidade(rs.getDouble("quantidade"));
	            prod.setPreco(rs.getDouble("preco"));
	            prod.setOnLine(rs.getBoolean("onLine"));
	            list.add(prod);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (rs != null) rs.close(); // Fechar o ResultSet
	            if (ps != null) ps.close();
	            if (conn != null) conn.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	    return list;
	}
}
