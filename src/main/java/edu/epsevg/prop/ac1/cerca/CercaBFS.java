package edu.epsevg.prop.ac1.cerca;

import edu.epsevg.prop.ac1.model.*;
import edu.epsevg.prop.ac1.resultat.ResultatCerca;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.List;


public class CercaBFS extends CercaTunejada {
    public CercaBFS(boolean usarLNT) { super(usarLNT); }

    @Override
    public void ferCerca(Mapa inicial, ResultatCerca rc) {
        //ArrayDeque<Node> LNO; Mal
        ArrayDeque<Node> LNO = new ArrayDeque<>();
        Node primerNode = new Node (inicial, null, null, 0, 0);
        LNO.addLast(primerNode);
        //HashMap<Node> LNT = new HashMap; Mal
        HashMap<Node, Node> LNT = new HashMap<>();
        //Map <Mapa, Mapa> wordsMap = new HashMap;

        //Al rc, fer el setCami utilitzant la classe node. Te pare->un cop tenim el resultat és facil pujar
        // Al rc afegir inc nodes explorats, i nodes tallats. TAmbe inc updateMemoria. No faran res en el codi
        while (!LNO.isEmpty()){
            boolean investiguem = true;
            Node NodeActual = LNO.pop();
            if (usarLNT == true){
                investiguem = EstaALaLNT(NodeActual, LNT); // Todo en Java són punteros, no le pasas la hashMap entera
            } 
            if (investiguem) {
                
                if (NodeActual.estat.esMeta()) {
                    List<Moviment> moviments = ReconstruirCami(NodeActual); 
                    rc.setCami(moviments);
                    break;
                }
                else {
                    LNT.put(NodeActual, NodeActual);
                    List<Moviment> LlistaMoviments = NodeActual.estat.getAccionsPossibles();
                    for (Moviment mov: LlistaMoviments){
                        Node nouNode = new Node (NodeActual.estat.mou(mov), NodeActual, mov, NodeActual.depth+1, 0);
                        if (!ComprobarCicle(nouNode)) LNO.addLast(nouNode);
                    }
                }
            }    
        }
    }
}
