package jsp.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jsp.dao.ClienteDao;
import jsp.model.Cliente;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String login = request.getParameter("login");
        String senhaCliente = request.getParameter("senha");

        
        ClienteDao clienteDao = new ClienteDao();
        Cliente cliente = clienteDao.autenticarCliente(login, senhaCliente);

        
        if (cliente != null) {
            
            request.getSession().setAttribute("cliente", cliente);
            response.sendRedirect("registracliente.jsp");
        } else {
            request.setAttribute("error", "Login ou Senha Invalidos. Tente novamente.");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}
