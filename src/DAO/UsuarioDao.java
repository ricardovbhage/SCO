/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Factory.ConnectionFactory;
import Model.UsuarioModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author marcos.figueiredo
 */
public class UsuarioDao {

    private Connection conexao;

    private final String INSERT = "Insert into Usuario (Nome, Login, CEP, Endereco, Bairro, Cidade, Estado, Telefone, Email, Senha) Values(?,?,?,?,?,?,?,?,?,?)";
    private final String UPDATE = "UPDATE Usuario SET Nome=?, Login=?, CEP=?, Endereco=?, Bairro=?, Cidade=?, Estado=?, Telefone=?, Email=?, Senha=? WHERE ID=?";
    private final String DELETE = "DELETE FROM Usuario WHERE ID =?";
    private final String LIST   = "SELECT * FROM Usuario";
    private final String LISTBYID = "SELECT * FROM Usuario WHERE ID=?";

    public UsuarioDao() throws SQLException, ClassNotFoundException {
        this.conexao = ConnectionFactory.getConexao();
    }

    public void inserir(UsuarioModel usuario) {
        if (usuario != null) {
            Connection conn = null;
            try {
                conn = ConnectionFactory.getConexao();
                PreparedStatement pstm;
                pstm = conn.prepareStatement(INSERT);

                pstm.setString(1, usuario.getNome());
                pstm.setString(2, usuario.getCPF());
                pstm.setString(3, usuario.getCEP());
                pstm.setString(4, usuario.getEndereco());
                pstm.setString(5, usuario.getBairro());
                pstm.setString(6, usuario.getCidade());
                pstm.setString(7, usuario.getEstado());
                pstm.setString(8, usuario.getTelefone());
                pstm.setString(9, usuario.getEmail());
                pstm.setString(10, usuario.getSenha());

                pstm.execute();
                JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso");
                ConnectionFactory.fechaConexao(conn, pstm);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao inserir usuário no banco de"
                        + "dados " + e.getMessage());
            }
        } else {
            System.out.println("O usuário enviado por parâmetro está vazio");
        }
    }

    public void remover(int id) {
        Connection conn = null;
        try {
            conn = ConnectionFactory.getConexao();
            PreparedStatement pstm;
            pstm = conn.prepareStatement(DELETE);

            pstm.setInt(1, id);

            pstm.execute();
            ConnectionFactory.fechaConexao(conn, pstm);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir contato do banco de"
                    + "dados " + e.getMessage());
        }
    }

    public List<UsuarioModel> getUsuarios() {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<UsuarioModel> usuarios = new ArrayList<UsuarioModel>();
        try {
            conn = ConnectionFactory.getConexao();
            pstm = conn.prepareStatement(LIST);
            rs = pstm.executeQuery();
            while (rs.next()) {
                UsuarioModel usuario = new UsuarioModel();
                usuario.setId(rs.getInt("id"));
                usuario.setNome(rs.getString("nome"));
                usuario.setCPF(rs.getString("login"));
                usuario.setTelefone(rs.getString("telefone"));
                usuario.setCEP(rs.getString("cep"));
                usuario.setEndereco(rs.getString("endereco"));
                usuario.setBairro(rs.getString("bairro"));
                usuario.setCidade(rs.getString("cidade"));
                usuario.setEstado(rs.getString("estado"));
                usuario.setEmail(rs.getString("email"));
                
                usuarios.add(usuario);
            }
            ConnectionFactory.fechaConexao(conn, pstm, rs);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar contatos" + e.getMessage());
        }
        return usuarios;
    }

    public UsuarioModel getUsuarioById(int id) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        UsuarioModel usuario = new UsuarioModel();
        try {
            conn = ConnectionFactory.getConexao();
            pstm = conn.prepareStatement(LISTBYID);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            while (rs.next()) {
                usuario.setId(rs.getInt("id"));
                usuario.setNome(rs.getString("nome"));
                usuario.setTelefone(rs.getString("telefone"));
                usuario.setEmail(rs.getString("email"));
            }
            ConnectionFactory.fechaConexao(conn, pstm, rs);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar contatos" + e.getMessage());
        }
        return usuario;
    }
}
