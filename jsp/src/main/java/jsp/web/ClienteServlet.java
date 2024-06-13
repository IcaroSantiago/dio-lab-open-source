package jsp.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jsp.dao.ClienteDao;
import jsp.model.Cliente;

@WebServlet("/cliente")
public class ClienteServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private ClienteDao clienteDao;

    public void init() {
        clienteDao = new ClienteDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action.equals("registrar")) {
            registrarCliente(request, response);
        } else if (action.equals("atualizar")) {
            atualizarCliente(request, response);
        } else if (action.equals("excluir")) {
            excluirCliente(request, response);
        } else {
            response.sendRedirect("consultacliente.jsp");
        }
    }

    protected void registrarCliente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nome = request.getParameter("nome");
        String sobrenome = request.getParameter("sobrenome");
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        String endereco = request.getParameter("endereco");
        String contato = request.getParameter("contato");

        Cliente cliente = new Cliente();
        cliente.setNome(nome);
        cliente.setSobrenome(sobrenome);
        cliente.setLogin(login);
        cliente.setSenha(senha);
        cliente.setEndereco(endereco);
        cliente.setContato(contato);

        try {
            clienteDao.resgistraCliente(cliente);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        response.sendRedirect("clientedetalhes.jsp");
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Cliente> clientes = null;
        try {
            clientes = clienteDao.listaClientes();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        request.setAttribute("clientes", clientes);
        request.getRequestDispatcher("consultacliente.jsp").forward(request, response);
    }

    protected void atualizarCliente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int clienteId = Integer.parseInt(request.getParameter("id"));
        String nome = request.getParameter("nome");
        String sobrenome = request.getParameter("sobrenome");
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        String endereco = request.getParameter("endereco");
        String contato = request.getParameter("contato");

        Cliente cliente = new Cliente(clienteId, nome, sobrenome, login, senha, endereco, contato);
        try {
            clienteDao.atualizarCliente(cliente);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        response.sendRedirect("consultacliente.jsp");
    }

    protected void excluirCliente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int clienteId = Integer.parseInt(request.getParameter("id"));
        try {
            clienteDao.excluiCliente(clienteId);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        response.sendRedirect("consultacliente.jsp");
    }
}
