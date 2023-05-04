/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tags;

import classes.Medico;
import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author ALUNO
 */
public class Tag3 extends SimpleTagSupport {
    
    private String attr1;
    private int attr2;
    private Medico attr3;

    @Override
    public void doTag() throws JspException, IOException {
        super.doTag(); //To change body of generated methods, choose Tools | Templates.
        
        getJspContext().getOut().write("Atributo 1: " + this.getAttr1() + "<br>");
        getJspContext().getOut().write("Atributo 2: " + this.getAttr2());
        getJspContext().getOut().write("Atributo 3: " + this.getAttr3().getNome());
    }

    public String getAttr1() {
        return attr1;
    }

    public void setAttr1(String attr1) {
        this.attr1 = attr1;
    }

    public int getAttr2() {
        return attr2;
    }

    public void setAttr2(int attr2) {
        this.attr2 = attr2;
    }

    public Medico getAttr3() {
        return attr3;
    }

    public void setAttr3(Medico attr3) {
        this.attr3 = attr3;
    }
 
}
