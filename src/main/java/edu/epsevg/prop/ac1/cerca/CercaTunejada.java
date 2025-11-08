package edu.epsevg.prop.ac1.cerca;

import edu.epsevg.prop.ac1.model.Mapa;
import edu.epsevg.prop.ac1.model.Moviment;
import edu.epsevg.prop.ac1.resultat.ResultatCerca;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public abstract class CercaTunejada extends Cerca {
    
    public CercaTunejada(boolean usarLNT) {
        super(usarLNT);
    }

    public List<Moviment> ReconstruirCami(Node cami){
        Node actual = cami;
        //List<Moviment> res <>(); Mal
        List<Moviment> res = new LinkedList<>();
        while (actual!=null) {
            res.addLast(actual.accio);
            actual = actual.pare;
        }    
        return res;
    }

    public boolean ComprobarCicle(Node cami){
        boolean esUnCicle = false;
        Node actual = cami;
        Mapa aComparar = cami.estat;
        while (actual.pare!=null) {
            actual = actual.pare;
            if ((actual.estat).equals(aComparar)) {
                esUnCicle = true;
                break;
            }    
        }
        return esUnCicle;
    }

    public boolean EstaALaLNT(Node NodeActual, HashMap<Node, Node> LNT){
        boolean investiguem = true;
        if (!LNT.containsKey(NodeActual)){
            //COMPROBEM, SI TENIM ALTURA MENYS PROFUNDA, HO FEM IGUALMENT
            int profunditatLNT = LNT.get(NodeActual).depth;
            if (NodeActual.depth >= profunditatLNT){
                investiguem = false;
            }
        }
        return investiguem;
    }
}
