package controlador;

import dao.GatoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import modelo.Gato;

@WebServlet(name = "ControladorGatos", urlPatterns = {"/ControladorGatos"})
public class ControladorGatos extends HttpServlet {

    GatoDAO dao = new GatoDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //ejecuta la consulta para traer los gatos y los envia al index.jsp
        List<Gato> lista = dao.listar();
        request.setAttribute("listaGatos", lista);
        request.getRequestDispatcher("tienda.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //toma los datos del formulario web
        String raza = request.getParameter("raza");
        String nombre = request.getParameter("nombre");
        int precio = Integer.parseInt(request.getParameter("precio"));
        
        //crea el objeto y lo guarda en la bd
        Gato gato = new Gato(0, raza, nombre, precio);
        dao.agregar(gato);
        
        //redirige al método doGet para recargar la pag con el new cat
        response.sendRedirect("ControladorGatos");
    }
}