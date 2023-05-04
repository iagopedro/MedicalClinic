/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import classes.Medico;
import repositories.MedicoRepositorio;

import java.io.IOException;
import java.io.PrintWriter;
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
            
            response.setContentType("text/html;charset=UTF-8");
            
            try (PrintWriter out = response.getWriter()) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Medical Clinic</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Alterar cadastro</h1>");
                out.println("<a href='MedicoServlet'>Voltar para lista de médicos</a><br/>");
                out.println("<form action='MedicoServlet' method='post'>");
                out.println("<input type='hidden' name='crm' value='" + m.getCrm() + "'/><br/>");
                out.println("Nome: <input type='text' name='nome' value='" + m.getNome() + "'/><br/>");
                out.println("Especialidade: <input type='text' name='especialidade' value='" + m.getEspecialidade() + "'/><br/>");
                out.println("Contato: <input type='text' name='contato' value='" + m.getContato() + "'/><br/>");
                out.println("<input type='submit' value='update'/>");
                out.println("</form>");
                out.println("</body>");
                out.println("</html>");
            }
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
            
            /*
                try (PrintWriter out = response.getWriter()) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Medical Clinic</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Medicos Cadastrados</h1>");
                out.println("<table border='1'>");
                out.println("<tr><th>Crm</th><th>Nome</th><th>Especialidade</th>"
                        + "<th>Contato</th></tr>");

                for(Medico m: Medicos) {
                    out.println("<tr>");
                    out.println("<td >" + m.getCrm() + "</td>");
                    out.println("<td>" + m.getNome() + "</td>");
                    out.println("<td>" + m.getEspecialidade() + "</td>");
                    out.println("<td>" + m.getContato() + "</td>");
                    out.println("<td><a href='MedicoServlet?crm="+ m.getCrm() + "'>read</a>" + " <a href= MedicoServlet?crm=" + m.getCrm() + "&op=update>update<a/>" + " <a href= MedicoServlet?crm=" + m.getCrm() + "&op=delete>delete</a></td>");
                    out.println("</tr>");
                }

                out.println("</table>");
                out.println("<a href=index.html>Home</a><br/>");
                out.println("</body>");
                out.println("</html>");
            }
            */
          
        }
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try (PrintWriter out = response.getWriter()) {

            String crm = request.getParameter("crm");
            String nome = request.getParameter("nome");
            String especialidade = request.getParameter("especialidade");
            String contato = request.getParameter("contato");

            Medico m = new Medico();

            m.setCrm(crm);
            m.setNome(nome);
            m.setEspecialidade(especialidade);
            m.setContato(contato);

            MedicoRepositorio.getCurrentInstance().create(m);
            
            HttpSession session = request.getSession();
            
            session.setAttribute("nome", m.getNome());
            
            /*
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Medical Center</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Médico " + m.getNome() + " cadastrado com sucesso!</h1>");
            out.println("<a href=\"index.html\">Voltar a página inicial</a>");
            out.println("</body>");
            out.println("</html>");
            
            */
            
            response.sendRedirect("cadastroMedico_success.jsp");

        }
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
