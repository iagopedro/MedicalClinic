/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import java.util.ArrayList;
import java.util.List;

import classes.Medico;

/**
 *
 * @author ALUNO
 */
public class MedicoRepositorio {

    private static MedicoRepositorio myself = null;

    private List<Medico> medicos = null;

    private MedicoRepositorio() {
        this.medicos = new ArrayList<>();
    }

    public static MedicoRepositorio getCurrentInstance() {
        if (myself == null) {
            myself = new MedicoRepositorio();
        }

        return myself;
    }

    public void create(Medico m) {
        System.out.println("criar");
        this.medicos.add(m);
    }

    public Medico read(String crm) {
        for (Medico aux : this.medicos) {
            if (aux.getCrm().equals(crm)) {
                return aux;
            }
        }
        return null;
    }

    public void update(Medico m) {
        System.out.println("oi");
        for (Medico aux : this.medicos) {
            if (aux.getCrm().equals(m.getCrm())) {
                
                aux.setNome(m.getNome());
                aux.setContato(m.getContato());
                aux.setEspecialidade(m.getEspecialidade());

                return;
            }
        }
    }

    public void delete(String crm) {
        for (int i = 0; i < this.medicos.size(); i++) {

            if (this.medicos.get(i).getCrm().equals(crm)) {
                this.medicos.remove(i);
            }

            return;
        }
    }
    
    public List<Medico> readAll(){
        return this.medicos;
    }

}
