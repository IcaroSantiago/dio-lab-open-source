package jsp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jsp.model.Cliente;

public class ClienteDao {
	
	private Connection getConnection() throws SQLException, ClassNotFoundException {
        String url = "jdbc:mysql://localhost:3306/cadastro?useTimezone=true&serverTimezone=UTC";
        String usuario = "root";
        String senha = "root";
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection(url, usuario, senha);
    }
	
	public int resgistraCliente(Cliente cliente) throws ClassNotFoundException{
		
		String INSERT_CLIENTES = "INSERT INTO cliente(nome,sobrenome,login,senha,endereco,contato)"
				              + 	"VALUES(?,?,?, ?,?,?);";
		
		int resultado = 0;
				
		try(Connection connection = getConnection();
				java.sql.PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CLIENTES)){
					preparedStatement.setString(1,cliente.getNome());
					preparedStatement.setString(2,cliente.getSobrenome());
					preparedStatement.setString(3,cliente.getLogin());
					preparedStatement.setString(4,cliente.getSenha());
					preparedStatement.setString(5,cliente.getEndereco());
					preparedStatement.setString(6,cliente.getContato());
					
					System.out.println(preparedStatement);
					
					resultado = preparedStatement.executeUpdate();
				} catch(SQLException e) {
					e.getStackTrace(); 
				}return resultado;													
	}
	
	// Método para listar todos os clientes
    public List<Cliente> listaClientes() throws ClassNotFoundException {
    	String SELECT_ALL_CLIENTES = "SELECT * FROM cadastro.cliente";
        List<Cliente> clientes = new ArrayList<>();     
		
        try (Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CLIENTES);
                ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
            	int id = resultSet.getInt("id");
                String nome = resultSet.getString("nome");
                String sobrenome = resultSet.getString("sobrenome");
                String login = resultSet.getString("login");
                String senhaCliente = resultSet.getString("senha");
                String endereco = resultSet.getString("endereco");
                String contato = resultSet.getString("contato");

                Cliente cliente = new Cliente(id, nome, sobrenome, login, senhaCliente, endereco, contato);
                clientes.add(cliente);

               
                System.out.println("Cliente recuperado: " + cliente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
           
        return clientes;
    }
    
    // Método para excluir um cliente
    public int excluiCliente(int id) throws ClassNotFoundException {
        String DELETE_CLIENTE = "DELETE FROM cliente WHERE id=?";
        
        int resultado = 0;
		
        try (Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CLIENTE)) {
            preparedStatement.setInt(1, id);

            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return resultado; 
        }
    }
	
 // Método para atualizar as informações de um cliente
    public int atualizarCliente(Cliente cliente) throws ClassNotFoundException {
        String UPDATE_CLIENTE = "UPDATE cliente SET nome=?, sobrenome=?, login=?, senha=?, endereco=?, contato=? WHERE id=?";

        try (Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CLIENTE)) {
            preparedStatement.setString(1, cliente.getNome());
            preparedStatement.setString(2, cliente.getSobrenome());
            preparedStatement.setString(3, cliente.getLogin());
            preparedStatement.setString(4, cliente.getSenha());
            preparedStatement.setString(5, cliente.getEndereco());
            preparedStatement.setString(6, cliente.getContato());
            preparedStatement.setInt(7, cliente.getId());

            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0; 
        }
    }
    
    public Cliente autenticarCliente(String login, String senhaCliente) {
        String SELECT_CLIENTE = "SELECT * FROM cliente WHERE login = ? AND senha = ?";
        Cliente cliente = null;

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CLIENTE)) {
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, senhaCliente);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nome = resultSet.getString("nome");
                String sobrenome = resultSet.getString("sobrenome");
                String endereco = resultSet.getString("endereco");
                String contato = resultSet.getString("contato");

                cliente = new Cliente(id, nome, sobrenome, login, senhaCliente, endereco, contato);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            // Ou lance uma exceção personalizada aqui
        }
        return cliente;
    }

    
    

}
