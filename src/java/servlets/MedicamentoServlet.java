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
import repositories.MedicamentoRepositorio;
import classes.Medicamento;
import java.util.List;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Iago
 */

@WebServlet(name = "MedicamentoServlet", urlPatterns = {"/MedicamentoServlet"})
public class MedicamentoServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int codigo = Integer.parseInt(request.getParameter("codigo"));
        String operacao = request.getParameter("op");

        if (operacao != null && operacao.equals("delete")) {
            MedicamentoRepositorio.getCurrentInstance().delete(codigo);

            response.sendRedirect("deletarMedicamento_success.jsp");
            
        } else if (operacao != null && operacao.equals("update")) {
            Medicamento m = MedicamentoRepositorio.getCurrentInstance().read(codigo);
            
            request.setAttribute("medicamento", m);
            
            getServletContext().getRequestDispatcher("/cadastroMedicamento.jsp").forward(request, response);
            
        } else if (operacao.equals("read")) {
            Medicamento m = MedicamentoRepositorio.getCurrentInstance().read(codigo);

            request.setAttribute("medicamento", m);
            
            getServletContext().getRequestDispatcher("/visualizarMedicamento.jsp").forward(request, response);
        } 
        else {
            List<Medicamento> Medicamentos = MedicamentoRepositorio.getCurrentInstance().readAll();

            HttpSession session = request.getSession();
            
            session.setAttribute("medicamentos", Medicamentos);
            
            response.sendRedirect("medicamentos.jsp");
        }
    }

    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int codigo = Integer.parseInt(request.getParameter("codigo"));
        String nome = request.getParameter("nome");
        int dosagem = Integer.parseInt(request.getParameter("dosagem"));
        String tipoDosagem = request.getParameter("tipoDosagem");
        String descricao = request.getParameter("minValorReferencia");
        String observacao = request.getParameter("maxValorReferencia");

        String operacao = request.getParameter("op");

        Medicamento m = new Medicamento();

        m.setCodigo(codigo);
        m.setNome(nome);
        m.setDosagem(dosagem);
        m.setTipoDosagem(tipoDosagem);
        m.setDescricao(descricao);
        m.setObservacao(observacao);
        
        HttpSession session = request.getSession();

        if (operacao != null && operacao.equals("update")) {
            MedicamentoRepositorio.getCurrentInstance().update(m);
        } else {
            MedicamentoRepositorio.getCurrentInstance().create(m);         
        }
        
        session.setAttribute("nome", m.getNome());

        response.sendRedirect("cadastroMedicamento_success.jsp");
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
