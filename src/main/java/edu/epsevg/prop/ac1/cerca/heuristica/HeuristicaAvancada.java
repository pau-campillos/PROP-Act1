package edu.epsevg.prop.ac1.cerca.heuristica;

import edu.epsevg.prop.ac1.model.Mapa;
import edu.epsevg.prop.ac1.model.Posicio;
import static java.lang.Integer.min;

import java.util.*;

/**
 * Heuristica avançada: Al vostre gust ;-)
 */
public class HeuristicaAvancada implements Heuristica {
    
    @Override
    public int h(Mapa estat) {
        //@TODO: reemplaceu tot el codi per la vostra heurística.
        int minimClaus = Integer.MAX_VALUE;
        int DistSordira = Integer.MAX_VALUE;
        int minim = Integer.MAX_VALUE;
        int clausFaltants = estat.getSizeClaus();

        if (!estat.tenimTotesLesClaus()) {
            for (Posicio p : estat.getAgents()){
                int clauPropera = estat.clauMesPropera(p);
                minim = min (minim, clauPropera);
            }
        }        
        else {
            for (Posicio p : estat.getAgents()){
                int distanciaSortidaActual = Math.abs(p.x - estat.getSortida().x) + Math.abs(p.y - estat.getSortida().y);
                minim = min (minim, distanciaSortidaActual);
            }    
        }

            /*for (Posicio p : estat.getClaus()){
                int minimaDistanciaAClau = Integer.MAX_VALUE;
                for (Posicio a : estat.getAgents()){
                    int distanciaClauAgent = Math.abs(p.x - a.x) + Math.abs(p.y - a.y);
                    minimaDistanciaAClau = min (minimaDistanciaAClau, distanciaClauAgent);
                }
                minimClaus += minimaDistanciaAClau;
            }*/
        minim *= (clausFaltants*100+1);
        //if (minimClaus == Integer.MAX_VALUE) minimClaus = 0;
        //if (DistSordira == Integer.MAX_VALUE) DistSordira = 0;
        //minim = minimClaus+DistSordira
        return minim;
    }
}
