/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import repositories.PacienteRepositorio;
import classes.Paciente;

/**
 *
 * @author Iago
 */

import java.util.List;
import javax.servlet.http.HttpSession;
@WebServlet(name = "PacienteServlet", urlPatterns = {"/PacienteServlet"})
public class PacienteServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String cpf = request.getParameter("cpf");
        String operacao = request.getParameter("op");

        if (operacao != null && operacao.equals("delete")) {
            PacienteRepositorio.getCurrentInstance().delete(cpf);

            response.sendRedirect("deletarPaciente_success.jsp");
            
        } else if (operacao != null && operacao.equals("update")) {
            Paciente m = PacienteRepositorio.getCurrentInstance().read(cpf);
            
            request.setAttribute("paciente", m);
            
            getServletContext().getRequestDispatcher("/cadastroPaciente.jsp").forward(request, response);
            
        } else if (cpf != null) {
            Paciente m = PacienteRepositorio.getCurrentInstance().read(cpf);

            // trocar por scriptlet, pois não estou conseguindo exibir a página
            request.setAttribute("paciente", m);
            
            getServletContext().getRequestDispatcher("/visualizarPaciente.jsp").forward(request, response);
        } 
        else {
            List<Paciente> Pacientes = PacienteRepositorio.getCurrentInstance().readAll();

            HttpSession session = request.getSession();
            
            session.setAttribute("pacientes", Pacientes);
            
            response.sendRedirect("pacientes.jsp");
        }
    }

    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String cpf = request.getParameter("cpf");
        String nome = request.getParameter("nome");
        String endereco = request.getParameter("endereco");
        String contato = request.getParameter("contato");
        String planoSaude = request.getParameter("planoSaude");

        String operacao = request.getParameter("op");

        Paciente p = new Paciente();

        p.setCpf(cpf);
        p.setNome(nome);
        p.setEndereco(endereco);
        p.setContato(contato);
        p.setPlanoSaude(planoSaude);
        
        HttpSession session = request.getSession();

        if (operacao != null && operacao.equals("update")) {
            PacienteRepositorio.getCurrentInstance().update(p);
        } else {
            PacienteRepositorio.getCurrentInstance().create(p);         
        }
        
        session.setAttribute("nome", p.getNome());

        response.sendRedirect("cadastroPaciente_success.jsp");
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
