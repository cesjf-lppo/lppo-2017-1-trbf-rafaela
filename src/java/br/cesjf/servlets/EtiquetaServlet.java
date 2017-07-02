
package br.cesjf.servlets;

import br.cesjf.lp3.Etiqueta;
import br.cesjf.lp3.Tarefa;
import br.cesjf.lp3.Usuario;
import br.cesjf.DAO.EtiquetaJpaController;
import br.cesjf.DAO.TarefaJpaController;
import br.cesjf.DAO.UsuarioJpaController;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.UserTransaction;


@WebServlet(name = "EtiquetaServlet", urlPatterns = {"/criarEtiqueta.html","/listar-etiqueta.html","/editar-etiqueta.html","/excluir-etiqueta.html"})
public class EtiquetaServlet extends HttpServlet {

    @PersistenceUnit(unitName = "trbflppo-2017-1PU")
    EntityManagerFactory emf;
    
    @Resource(name = "java:comp/UserTransaction")
    UserTransaction ut;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        if (request.getServletPath().contains("/criarEtiqueta.html")) {
            doCriarGet(request,response);
        } else if (request.getServletPath().contains("/listar-etiqueta.html")) {
            doListarGet(request,response);
        } else if (request.getServletPath().contains("/editar-etiqueta.html")) {
            doEditarGet(request,response);
        } else if (request.getServletPath().contains("/excluir-etiqueta.html")) {
            doExcluirGet(request,response);
        } 
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getServletPath().contains("/criarEtiqueta.html")) {
            doCriarPost(request,response);
        } else if (request.getServletPath().contains("/editar-etiqueta.html")) {
            doEditarPost(request,response);
        } 
    }

    
    
    
    private void doCriarGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        List<Usuario> usuarios;
        List<Tarefa> tarefas;
        UsuarioJpaController usuarioDao = new UsuarioJpaController(ut,emf);
        TarefaJpaController tarefaDao = new TarefaJpaController(ut, emf);
        usuarios = usuarioDao.findUsuarioEntities();
        tarefas = tarefaDao.findTarefaEntities();
        
        request.setAttribute("usuarios", usuarios);
        request.setAttribute("tarefas",tarefas);
        
       request.getRequestDispatcher("WEB-INF/nova-etiqueta.jsp").forward(request, response);
    }

    private void doCriarPost(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {        
        Etiqueta etiqueta = new Etiqueta();
        etiqueta.setTitulo(request.getParameter("titulo"));
        Long idUsuario = Long.parseLong(request.getParameter("idUsuario"));
        Long idTarefa = Long.parseLong(request.getParameter("idTarefa"));
        
        Usuario usuario = new Usuario();
        UsuarioJpaController daoUsuario = new UsuarioJpaController(ut, emf);
        usuario = daoUsuario.findUsuario(idUsuario);
        
        Tarefa tarefa = new Tarefa();
        TarefaJpaController daoTarefa = new TarefaJpaController(ut, emf);
        tarefa = daoTarefa.findTarefa(idTarefa);
                
        etiqueta.setUsuario(usuario);
        etiqueta.setTarefa(tarefa);
        
        EtiquetaJpaController dao = new EtiquetaJpaController(ut, emf);
        try {
            dao.create(etiqueta);
            response.sendRedirect("listar-etiqueta.html");
        } catch (Exception ex) {
            response.sendRedirect("erro.html");
        }
        
    }

    private void doListarGet(HttpServletRequest request, HttpServletResponse response) 
       throws ServletException, IOException { 
        List<Etiqueta> etiquetas;        
        EtiquetaJpaController dao = new EtiquetaJpaController(ut, emf);
        
        
        if (request.getParameter("idAutor")!=null) {
            Long idAutor = Long.parseLong(request.getParameter("idAutor"));
            etiquetas = dao.getEtiquetaByAutor(idAutor);
        } else if (request.getParameter("titulo") != null) {
            String titulo = request.getParameter("titulo");
            etiquetas = dao.getEtiquetaByTitulo(titulo);
        } else {
            etiquetas = dao.findEtiquetaEntities();
        }
               
        request.setAttribute("etiquetas", etiquetas);
        
        
        request.getRequestDispatcher("WEB-INF/listar-etiquetas.jsp").forward(request, response);
        
    }

    

    private void doEditarGet(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException{
        Long id = Long.parseLong(request.getParameter("id"));
        Etiqueta etiqueta;
        
        EtiquetaJpaController dao = new EtiquetaJpaController(ut, emf);
        etiqueta = dao.findEtiqueta(id);
        
        request.setAttribute("etiqueta",etiqueta);
        request.getRequestDispatcher("WEB-INF/editar-etiqueta.jsp").forward(request, response);
    }

    private void doEditarPost(HttpServletRequest request, HttpServletResponse response)
             throws ServletException, IOException {
        try {
            EtiquetaJpaController dao = new EtiquetaJpaController(ut, emf);
            
            Long id = Long.parseLong(request.getParameter("id"));
            Etiqueta etiqueta = dao.findEtiqueta(id);
            etiqueta.setTitulo(request.getParameter("titulo"));
            dao.edit(etiqueta);   
            response.sendRedirect("listar-etiqueta.html");
        } catch (Exception ex) {
            Logger.getLogger(EtiquetaServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void doExcluirGet(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException{
                try {
            EtiquetaJpaController dao = new EtiquetaJpaController(ut, emf);        
            Long id = Long.parseLong(request.getParameter("id"));
            dao.destroy(id);
        } catch (Exception ex) {
            response.sendRedirect("WEB-INF/erro.jsp");
        }
        response.sendRedirect("listar-etiqueta.html");
    }

    

}
