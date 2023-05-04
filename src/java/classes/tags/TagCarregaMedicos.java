/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes.tags;

import classes.Medico;
import java.io.IOException;
import java.util.List;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import repositories.MedicoRepositorio;

/**
 *
 * @author ALUNO
 */
public class TagCarregaMedicos extends SimpleTagSupport {

    @Override
    public void doTag() throws JspException, IOException {
        super.doTag(); //To change body of generated methods, choose Tools | Templates.
        
        List<Medico> medicos = MedicoRepositorio.getCurrentInstance().readAll();
        
        getJspContext().setAttribute("medicos", medicos, PageContext.PAGE_SCOPE);
    }
    
}
