package crudcolegio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Clayton Garcia
 * Mat: 2016101697
 */
public class Dao {
    
    private int id;
    private String Nome;
    private String Mat;
    private final String sqlUrl = "jdbc:mysql://localhost:3306/colegio";
    private final String sqlUsuario = "root";
    private final String sqlSenha = "root";
    //Strings SQL para todos os metodos
    private final String sqlCadastrar = "INSERT INTO aluno (id,nome,cpf) VALUES (?,?,?)";
    private final String sqlAtualizar = "UPDATE aluno SET id = ? , nome = ? , cpf = ? WHERE id = ?";
    private final String sqlExcluir = "DELETE FROM aluno WHERE id = ?";
    private final String sqlConsultar = "SELECT * FROM aluno WHERE nome like ?";
    private final String sqlListarTodos = "SELECT * FROM aluno";
            
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getMat() {
        return Mat;
    }

    public void setMat(String Mat) {
        this.Mat = Mat;
    }
    //Meteodo para estabelecer a conexão com o banco de dados
    public Connection conexao() throws SQLException{
        Connection conn = DriverManager.getConnection(sqlUrl,sqlUsuario, sqlSenha );
        return conn;
    }
    //Metodo para cadastrar alunos
    public void cadastrar(int id, String nome, String CPF) throws SQLException{
        conexao();//estabelece conexão com DB
        PreparedStatement stmt = conexao().prepareStatement(sqlCadastrar);//Pega a String Sql de cadastro e joga em um Prepared Statement
        stmt.setInt(1 , id );//Prepara os dados de Id
        stmt.setString(2 , nome );//Nome
        stmt.setString(3 ,  CPF ); // e CPF
        stmt.executeUpdate();// e Colocar  no banco de dados
    }
    
    
    public void atualizar(int id, String nome, String CPF) throws SQLException{
        conexao();
        PreparedStatement stmt = conexao().prepareStatement(sqlAtualizar);//Pega a String Sql de atualização e joga em um Prepared Statement
        stmt.setInt(1, id);
        stmt.setString(2, nome);
        stmt.setString(3, CPF);
        stmt.setInt(4, id);
        stmt.executeUpdate();  
    }
    
    public void excluir (int id) throws SQLException{
        conexao();
        PreparedStatement stmt = conexao().prepareStatement(sqlExcluir);
        stmt.setInt(1, id);
        stmt.executeUpdate();     
    }
    
   public ResultSet consultar(String nome)throws SQLException{
       conexao();
       PreparedStatement stmt = conexao().prepareStatement(sqlConsultar);//Pega a String Sql de consulta e joga em um Prepared Statement
       stmt.setString(1, "%" + nome + "%");//Passa os paramentros da busca
       stmt.executeQuery();// Executa a busca no banco
       ResultSet rs = stmt.getResultSet();// Passa o resultado da da busca e passa pra um ResultSet
       return rs;//Retorna o ResultSet   
   }
   
   public ResultSet listarTodos() throws SQLException{
       java.sql.Statement st = conexao().createStatement();//Cria um Statement
       ResultSet rs = st.executeQuery(sqlListarTodos);// Executa a busca no banco assa o resultado da da busca e passa pra um ResultSet
       return rs;  
   }
    
    
    
    
    
    
    
    
}
