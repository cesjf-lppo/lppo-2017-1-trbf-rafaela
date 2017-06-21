/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cesjf.servlets;

import br.cesjf.DAO.TarefaJPAController;
import br.cesjf.DAO.UsuarioJPAController;
import br.cesjf.lp3.Tarefa;
import br.cesjf.lp3.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
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

/**
 *
 * @author RafaelaEmília
 */
@WebServlet(name = "TarefaServlet", urlPatterns = {"/criarTarefa.html"})
public class TarefaServlet extends HttpServlet {
@PersistenceUnit(unitName = "lppo-2017-1-jpa2PU")
    EntityManagerFactory emf;
    
    @Resource(name = "java:comp/UserTransaction")
    UserTransaction ut;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         if (request.getServletPath().contains("/editarTarefa.html")){
             
             doEditarGet(request, response);
         } else if (request.getServletPath().contains("/excluirTarefa.html")){
             doExcluirGet(request, response);
       } else if (request.getServletPath().contains("/listarTarefa.html")){
             doListarGet(request, response);
       }  else if (request.getServletPath().contains("/criarTarefa.html")){
             doCriarGet(request, response);
       }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
           if (request.getServletPath().contains("/editarTarefa.html")){
             
             doEditarPost (request, response);
         } else if (request.getServletPath().contains("/criarTarefa.html")){
            
             doCriarPost(request, response);
       }
    }
    
    private void doEditarGet(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
        try {
        TarefaJPAController dao = new TarefaJPAController(ut, emf);
        
        Long id = Long.parseLong(request.getParameter("id"));
        Tarefa tarefa = dao.findTarefa(id);
        request.setAttribute("tarefa", tarefa);
        request.getRequestDispatcher("WEB-INF/editar-tarefa.jsp").forward(request, response);
    } catch (Exception e) {
        response.sendRedirect("listarTarefa.html");
    }
        
  }
     private void doEditarPost(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
        try {
        TarefaJPAController dao = new TarefaJPAController(ut, emf);
        
        Long id = Long.parseLong(request.getParameter("id"));
        Tarefa tarefa = dao.findTarefa(id);
        tarefa.setTitulo(request.getParameter("titulo"));
        tarefa.setDescricao(request.getParameter("descricao"));
        tarefa.setDataConcluir(Date(request.getParameter("dataConcluir")));
        tarefa.setDataConclusao(Date(request.getParameter("dataConclusao")));
        
        dao.edit(tarefa);
        response.sendRedirect("listarTarefa.html");
       
    } catch (Exception e) {
        response.sendRedirect("listarTarefa.html");
    }
        
  }

    private void doExcluirGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        try {
            TarefaJPAController dao = new TarefaJPAController(ut, emf);
        
            Long id = Long.parseLong(request.getParameter("id"));
            dao.destroy(id);
        } catch (Exception ex) {
        }
        response.sendRedirect("listar.html");
    }

    private void doListarGet(HttpServletRequest request, HttpServletResponse response) 
       throws ServletException, IOException { 
          List<Tarefa> tarefas;
        
        TarefaJPAController dao = new TarefaJPAController(ut, emf);
        tarefas = dao.findTarefaEntities();
        
        request.setAttribute("tarefas", tarefas);
        request.getRequestDispatcher("WEB-INF/listar-tarefas.jsp").forward(request, response);
    }

    private void doCriarGet(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException{
         request.getRequestDispatcher("WEB-INF/novo-tarefa.jsp").forward(request, response);
        
    }

    private void doCriarPost(HttpServletRequest request, HttpServletResponse response) 
       throws ServletException, IOException{
        Tarefa tarefa1 = new Tarefa();
        tarefa1.setTitulo(request.getParameter("titulo"));
        tarefa1.setDescricao(request.getParameter("descricao"));
        tarefa1.setDataConcluir(Date(request.getParameter("dataConcluir")));
        tarefa1.setDataConclusao(Date(request.getParameter("dataConclusao")));

        TarefaJPAController dao = new TarefaJPAController(ut, emf);
        try {
            dao.create(tarefa1);
            response.sendRedirect("listar.html");
        } catch (Exception ex) {
            Logger.getLogger(UsuarioServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    private Date Date(String parameter) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    


    
   
}
