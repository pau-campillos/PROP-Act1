package edu.epsevg.prop.ac1.cerca;

import edu.epsevg.prop.ac1.model.*;
import edu.epsevg.prop.ac1.resultat.ResultatCerca;


public class CercaBFS extends Cerca {
    public CercaBFS(boolean usarLNT) { super(usarLNT); }

    @Override
    public void ferCerca(Mapa inicial, ResultatCerca rc) {
        ArrayDeque<Mapa> LNO;
        LNO.addLast(inicial);
        //HashMap<Mapa> LNT;
        //Map <Mapa, Mapa> wordsMap = new HashMap;

        //Al rc, fer el setCami utilitzant la classe node. Te pare->un cop tenim el resultat és facil pujar
    // Al rc afegir inc nodes explorats, i nodes tallats. TAmbe inc updateMemoria. No faran res en el codi
        while (! LNO.isEmpty()){
            for (Posicio posAgent : LNO.peek().getAgents()){
                if (LNO.peek().esSortida(posAgent)){
                    //Hem Trobat la solució
                    break;
                }
            }
    }
   
}
