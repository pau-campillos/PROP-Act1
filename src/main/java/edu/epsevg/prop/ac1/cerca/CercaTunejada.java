package edu.epsevg.prop.ac1.cerca;

import edu.epsevg.prop.ac1.model.Mapa;
import edu.epsevg.prop.ac1.resultat.ResultatCerca;

public abstract class CercaTunejada {
    
    public CercaTunejada(boolean usarLNT) {
        super(usarLNT);
    }

    public List<Moviment> ReconstruirCami(Node cami){
        Node actual = cami;
        List<Moviment> res<>();
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
            if (actual.estat.equals(aComparar.estat)) {
                esUnCicle = true;
                break;
            }    
        }
        return esUnCicle;
    }

    public boolean EstaALaLNT(Node NodeActual){
        
        if (!LNT.containsKey(NodeActual)){
            //COMPROBEM, SI TENIM ALTURA MENYS PROFUNDA, HO FEM IGUALMENT
            int profunditatLNT = LNT.get(NodeActual).depth();
            if (NodeActual.depth() >= profunditatLNT){
                investiguem = false;
            }
        }
    }
}
