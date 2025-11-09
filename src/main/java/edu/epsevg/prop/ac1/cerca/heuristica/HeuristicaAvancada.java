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
        int distSordira = Integer.MAX_VALUE;
        
        Posicio posClau = null;
        for (Posicio p : estat.getAgents()){
            int distanciaSortidaActual = Math.abs(p.x - estat.getSortida().x) + Math.abs(p.y - estat.getSortida().y);
            distSordira = min (distSordira, distanciaSortidaActual);
        }

        int camiClaus = 0;
        if (!estat.tenimTotesLesClaus()) {
            for (Posicio c : estat.getClaus()) { 
                int minCami = Integer.MAX_VALUE;
                for (Posicio a : estat.getAgents()) {
                    int dist = Math.abs(c.x - a.x) + Math.abs(c.y - a.y);
                    minCami = min(minCami, dist); 
                }    
                camiClaus += minCami;  
            }
        }    

        int minim = camiClaus + distSordira;
        return minim;
    }
}