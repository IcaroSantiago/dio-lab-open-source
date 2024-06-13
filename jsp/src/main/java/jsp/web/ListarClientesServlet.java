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

@WebServlet("/listarClientes")
public class ListarClientesServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ClienteDao clienteDao;

    public void init() {
        clienteDao = new ClienteDao();
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
}
