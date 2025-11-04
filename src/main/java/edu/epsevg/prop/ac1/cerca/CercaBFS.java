package edu.epsevg.prop.ac1.cerca;

import edu.epsevg.prop.ac1.model.*;
import edu.epsevg.prop.ac1.resultat.ResultatCerca;


public class CercaBFS extends Cerca {
    public CercaBFS(boolean usarLNT) { super(usarLNT); }

    @Override
    public void ferCerca(Mapa inicial, ResultatCerca rc) {
        ArrayDeque<Node> LNO;
        Node primerNode = new Node (inicial, null, null, 0, 0);
        LNO.addLast(primerNode);
        HashMap<Node> LNT = new HashMap;
        //Map <Mapa, Mapa> wordsMap = new HashMap;

        //Al rc, fer el setCami utilitzant la classe node. Te pare->un cop tenim el resultat és facil pujar
        // Al rc afegir inc nodes explorats, i nodes tallats. TAmbe inc updateMemoria. No faran res en el codi
        while (!LNO.isEmpty()){
            bool investiguem = true;
            Node NodeActual = LNO.pop();
            if (usarLNT == true){
                investiguem = EstaALaLNT(NodeActual);
            } 
            if (investiguem) {
                
                if (NodeActual.estat().esMeta()) {
                    List<Moviment> moviments = ReconstruirCami(NodeActual); 
                    rc.setCami(moviments);
                    break;
                }
                else {
                    LNT.put(NodeActual);
                    List<Moviment> LlistaMoviments = estatActual.getAccionsPossibles();
                    for (Moviment mov: LlistaMoviments){
                        Node nouNode = new Node (NodeActual.mou(mov), NodeActual, mov, NodeActual.depth()+1, 0);
                        if (!esUnCicle(nouNode)) LNO.addLast(nouNode);
                    }
                }
            }    
        }
    }
}
