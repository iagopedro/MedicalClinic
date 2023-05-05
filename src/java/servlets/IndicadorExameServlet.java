/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import classes.IndicadorExame;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import repositories.IndicadorExameRepositorio;

/**
 *
 * @author Iago
 */

@WebServlet(name = "IndicadorExameServlet", urlPatterns = {"/IndicadorExameServlet"})
public class IndicadorExameServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int codigo = Integer.parseInt(request.getParameter("codigo"));
        String operacao = request.getParameter("op");

        if (operacao != null && operacao.equals("delete")) {
            IndicadorExameRepositorio.getCurrentInstance().delete(codigo);

            response.sendRedirect("deletarMedico_success.jsp");
            
        } else if (operacao != null && operacao.equals("update")) {
            IndicadorExame i = IndicadorExameRepositorio.getCurrentInstance().read(codigo);
            
            request.setAttribute("indicadorExame", i);
            
            getServletContext().getRequestDispatcher("/cadastroIndicadorExame.jsp").forward(request, response);
            
        } else if (operacao.equals("read")) {
            IndicadorExame i = IndicadorExameRepositorio.getCurrentInstance().read(codigo);

            // trocar por scriptlet, pois não estou conseguindo exibir a página
            request.setAttribute("indicadorExame", i);
            
            getServletContext().getRequestDispatcher("/visualizarIndicadorExame.jsp").forward(request, response);
        } 
        else {
            List<IndicadorExame> Indicadores = IndicadorExameRepositorio.getCurrentInstance().readAll();

            HttpSession session = request.getSession();
            
            session.setAttribute("indicadoresExame", Indicadores);
            
            response.sendRedirect("indicadoresExame.jsp");
        }
    }

    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int codigo = Integer.parseInt(request.getParameter("codigo"));
        String indicador = request.getParameter("nome");
        String descricao = request.getParameter("descricao");
        double minValorReferencia = Double.parseDouble(request.getParameter("minValorReferencia"));
        double maxValorReferencia = Double.parseDouble(request.getParameter("maxValorReferencia"));

        String operacao = request.getParameter("op");

        IndicadorExame i = new IndicadorExame();

        i.setCodigo(codigo);
        i.setIndicador(indicador);
        i.setDescricao(descricao);
        i.setMinValorReferencia(minValorReferencia);
        i.setMaxValorReferencia(maxValorReferencia);
        
        HttpSession session = request.getSession();

        if (operacao != null && operacao.equals("update")) {
            IndicadorExameRepositorio.getCurrentInstance().update(i);
        } else {
            IndicadorExameRepositorio.getCurrentInstance().create(i);         
        }
        
        session.setAttribute("indicadorExame", i.getIndicador());

        response.sendRedirect("cadastroIndicadorExame_success.jsp");
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
