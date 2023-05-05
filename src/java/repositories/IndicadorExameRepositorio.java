/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import classes.IndicadorExame;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Iago
 */
public class IndicadorExameRepositorio {
    private static IndicadorExameRepositorio myself = null;

    private List<IndicadorExame> indicadoresExame = null;

    private IndicadorExameRepositorio() {
        this.indicadoresExame = new ArrayList<>();
    }

    public static IndicadorExameRepositorio getCurrentInstance() {
        if (myself == null) {
            myself = new IndicadorExameRepositorio();
        }

        return myself;
    }

    public void create(IndicadorExame i) {
        this.indicadoresExame.add(i);
    }

    public IndicadorExame read(int codigo) {
        for (IndicadorExame aux : this.indicadoresExame) {
            if (aux.getCodigo() == codigo) {
                return aux;
            }
        }
        return null;
    }

    public void update(IndicadorExame i) {
        for (IndicadorExame aux : this.indicadoresExame) {
            if (aux.getCodigo() == i.getCodigo()) {
                
                aux.setCodigo(i.getCodigo());
                aux.setDescricao(i.getDescricao());
                aux.setIndicador(i.getIndicador());
                aux.setMinValorReferencia(i.getMinValorReferencia());
                aux.setMaxValorReferencia(i.getMaxValorReferencia());

                return;
            }
        }
    }

    public void delete(int codigo) {
        for (int i = 0; i < this.indicadoresExame.size(); i++) {

            if (this.indicadoresExame.get(i).getCodigo() == codigo) {
                this.indicadoresExame.remove(i);
            }

            return;
        }
    }
    
    public List<IndicadorExame> readAll(){
        return this.indicadoresExame;
    }
}
