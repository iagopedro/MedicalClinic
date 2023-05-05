/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import classes.Medicamento;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Iago
 */
public class MedicamentoRepositorio {
    private static MedicamentoRepositorio myself = null;

    private List<Medicamento> medicamentos = null;

    private MedicamentoRepositorio() {
        this.medicamentos = new ArrayList<>();
    }

    public static MedicamentoRepositorio getCurrentInstance() {
        if (myself == null) {
            myself = new MedicamentoRepositorio();
        }

        return myself;
    }

    public void create(Medicamento m) {
        this.medicamentos.add(m);
    }

    public Medicamento read(int codigo) {
        for (Medicamento aux : this.medicamentos) {
            if (aux.getCodigo() == codigo) {
                return aux;
            }
        }
        return null;
    }

    public void update(Medicamento m) {
        for (Medicamento aux : this.medicamentos) {
            if (aux.getCodigo() == m.getCodigo()) {
                
                aux.setCodigo(m.getCodigo());
                aux.setDosagem(m.getDosagem());
                aux.setNome(m.getNome());
                aux.setDescricao(m.getDescricao());
                aux.setObservacao(m.getObservacao());
                aux.setTipoDosagem(m.getTipoDosagem());

                return;
            }
        }
    }

    public void delete(int codigo) {
        for (int i = 0; i < this.medicamentos.size(); i++) {

            if (this.medicamentos.get(i).getCodigo() == codigo) {
                this.medicamentos.remove(i);
            }

            return;
        }
    }
    
    public List<Medicamento> readAll(){
        return this.medicamentos;
    }
}
