/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Factory;

/**
 *
 * @author marcos.figueiredo
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionFactory {

    public static Connection con = null;

    public static void Conectar() {
        System.out.println("Conectando ao banco...");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/sicoordb", "root", "");
            System.out.println("Conectado.");
        } catch (ClassNotFoundException ex) {
            System.out.println("Classe não encontrada, adicione o driver nas bibliotecas.");
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException e) {
            System.out.println(e);
            throw new RuntimeException(e);
        }
    }
    
    //Dados para a conexão com o banco
	private static final String USUARIO = "root";
	private static final String SENHA = "";
	private static final String DATABASE = "sicoordb";
	private static final String DRIVER_CONEXAO = "com.mysql.jdbc.Driver";
	private static final String STR_CONEXAO =  "jdbc:mysql://localhost:3306/";

	public static Connection getConexao() throws SQLException,
	ClassNotFoundException {

		Connection conn ;
		try {
			Class.forName(DRIVER_CONEXAO);
			conn = DriverManager.getConnection(STR_CONEXAO
			+ DATABASE, USUARIO, SENHA);

			return conn;

		} catch (ClassNotFoundException e) {
			throw new ClassNotFoundException(
					"Driver MySql não foi encontrado "
					+ e.getMessage());

		} catch (SQLException e) {
			throw new SQLException("Erro ao conectar "
					+ "com a base de dados" +
					e.getMessage());
		}
	}

	public static void fechaConexao(Connection conn) {

		try {
			if (conn != null) {
				conn.close();
				System.out.println("Fechada a conexão com o banco de dados");
			}

		} catch (Exception e) {
			System.out.println("Não foi possível fechar a conexão com o banco de dados " + e.getMessage());
		}
	}

	public static void fechaConexao(Connection conn,
	PreparedStatement stmt) {

		try {
			if (conn != null) {
				fechaConexao(conn);
			}
			if (stmt != null) {
				stmt.close();
				System.out.println("Statement fechado com sucesso");
			}


		} catch (Exception e) {
			System.out.println("Não foi possível fechar o statement " + e.getMessage());
		}
	}

	public static void fechaConexao(Connection conn,
	PreparedStatement stmt, ResultSet rs) {

		try {
			if (conn != null || stmt != null) {
				fechaConexao(conn, stmt);
			}
			if (rs != null) {
				rs.close();
				System.out.println("ResultSet fechado com sucesso");
			}


		} catch (Exception e) {
			System.out.println("Não foi possível fechar o ResultSet " + e.getMessage());
		}
	}

}
