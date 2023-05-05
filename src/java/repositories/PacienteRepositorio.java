/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import classes.Paciente;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Iago
 */
public class PacienteRepositorio {
    private static PacienteRepositorio myself = null;

    private List<Paciente> pacientes = null;

    private PacienteRepositorio() {
        this.pacientes = new ArrayList<>();
    }

    public static PacienteRepositorio getCurrentInstance() {
        if (myself == null) {
            myself = new PacienteRepositorio();
        }

        return myself;
    }

    public void create(Paciente p) {
        this.pacientes.add(p);
    }

    public Paciente read(String cpf) {
        for (Paciente aux : this.pacientes) {
            if (aux.getCpf().equals(cpf)) {
                return aux;
            }
        }
        return null;
    }

    public void update(Paciente p) {
        for (Paciente aux : this.pacientes) {
            if (aux.getCpf().equals(p.getCpf())) {
                
                aux.setCpf(p.getCpf());
                aux.setContato(p.getContato());
                aux.setEndereco(p.getEndereco());
                aux.setNome(p.getNome());
                aux.setPlanoSaude(p.getPlanoSaude());

                return;
            }
        }
    }

    public void delete(String crm) {
        for (int i = 0; i < this.pacientes.size(); i++) {

            if (this.pacientes.get(i).getCpf().equals(crm)) {
                this.pacientes.remove(i);
            }

            return;
        }
    }
    
    public List<Paciente> readAll(){
        return this.pacientes;
    }
}
