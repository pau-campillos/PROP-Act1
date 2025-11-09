package edu.epsevg.prop.ac1.cerca.heuristica;

import edu.epsevg.prop.ac1.model.Mapa;
import edu.epsevg.prop.ac1.model.Posicio;
import static java.lang.Integer.min;
import java.util.Map;
/** 
 * Distància de Manhattan a la clau més propera 
 * (si queden per recollir) o a la sortida.
 */
public class HeuristicaBasica implements Heuristica {
    @Override
    public int h(Mapa estat) {
        //@TODO: reemplaceu tot el codi per la vostra heurística.
        int minim = Integer.MAX_VALUE;
        
        if (!estat.tenimTotesLesClaus()) {
            for (Posicio p : estat.getAgents()){
                Posicio posClau = estat.clauMesPropera(p);
                int clauPropera = Math.abs(posClau.x - p.x) + Math.abs(posClau.y - p.y);
                minim = min (minim, clauPropera);
            }
        }        
        else {
            for (Posicio p : estat.getAgents()){
                int distanciaSortidaActual = Math.abs(p.x - estat.getSortida().x) + Math.abs(p.y - estat.getSortida().y);
                minim = min (minim, distanciaSortidaActual);
            }    
        }
        return minim;
    }
}
