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

        int minCamiTotal = Integer.MAX_VALUE;
        Posicio primeraLlave = null;

        // 1. Buscar la llave más cercana a cualquier agente
        for (Posicio c : estat.getClaus()) { 
            for (Posicio a : estat.getAgents()) {
                int dist = Math.abs(c.x - a.x) + Math.abs(c.y - a.y);
                if (dist < minCamiTotal) {
                    minCamiTotal = dist;
                    primeraLlave = c;
                }
            }
        }

        // 2. Calcular distancia desde la primera llave a las demás llaves
        int camiLlavesRestantes = 0;
        for (Posicio c : estat.getClaus()) {
            if (!c.equals(primeraLlave)) {
                int dist = Math.abs(c.x - primeraLlave.x) + Math.abs(c.y - primeraLlave.y);
                camiLlavesRestantes += dist;
            }
        }

        int minim = minCamiTotal + camiLlavesRestantes + distSordira;

        return minim;
    }
}