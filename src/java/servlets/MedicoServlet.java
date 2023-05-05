/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import classes.Medico;
import repositories.MedicoRepositorio;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ALUNO
 */
@WebServlet(name = "MedicoServlet", urlPatterns = {"/MedicoServlet"})

public class MedicoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String crm = request.getParameter("crm");
        String operacao = request.getParameter("op");

        if (operacao != null && operacao.equals("delete")) {
            MedicoRepositorio.getCurrentInstance().delete(crm);

            response.sendRedirect("deletarMedico_success.jsp");
            
        } else if (operacao != null && operacao.equals("update")) {
            Medico m = MedicoRepositorio.getCurrentInstance().read(crm);
            
            request.setAttribute("medico", m);
            
            getServletContext().getRequestDispatcher("/cadastroMedico.jsp").forward(request, response);
            
        } else if (crm != null) {
            Medico m = MedicoRepositorio.getCurrentInstance().read(crm);

            // trocar por scriptlet, pois não estou conseguindo exibir a página
            request.setAttribute("medico", m);
            
            getServletContext().getRequestDispatcher("/visualizarMedico.jsp").forward(request, response);
        } 
        else {
            List<Medico> Medicos = MedicoRepositorio.getCurrentInstance().readAll();

            HttpSession session = request.getSession();
            
            session.setAttribute("medicos", Medicos);
            
            response.sendRedirect("medicos.jsp");
        }
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String crm = request.getParameter("crm");
        String nome = request.getParameter("nome");
        String especialidade = request.getParameter("especialidade");
        String contato = request.getParameter("contato");

        String operacao = request.getParameter("op");

        Medico m = new Medico();

        m.setCrm(crm);
        m.setNome(nome);
        m.setEspecialidade(especialidade);
        m.setContato(contato);
        
        HttpSession session = request.getSession();

        if (operacao != null && operacao.equals("update")) {
            MedicoRepositorio.getCurrentInstance().update(m);
        } else {
            MedicoRepositorio.getCurrentInstance().create(m);         
        }
        
        session.setAttribute("nome", m.getNome());

        response.sendRedirect("cadastroMedico_success.jsp");
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
