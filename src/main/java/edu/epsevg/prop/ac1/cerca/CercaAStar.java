package edu.epsevg.prop.ac1.cerca;

import edu.epsevg.prop.ac1.cerca.heuristica.Heuristica;
import edu.epsevg.prop.ac1.model.*;
import edu.epsevg.prop.ac1.resultat.ResultatCerca;

import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class CercaAStar extends CercaTunejada {

    private final Heuristica heur;

    public CercaAStar(boolean usarLNT, Heuristica heur) { 
        super(usarLNT); 
        this.heur = heur; 
    }

    @Override
    public  void ferCerca(Mapa inicial, ResultatCerca rc) {
         
        //ProrityQueue<Node> LNO = new ProrityQueue<>();
        PriorityQueue<Node> LNO = new PriorityQueue<>((n1, n2) -> Integer.compare(n1.g, n2.g));
        Node primerNode = new Node (inicial, null, null, 0, heur.h(inicial));
        LNO.add(primerNode);
        HashMap<Mapa, Node> LNT = new HashMap<>();

        //Al rc, fer el setCami utilitzant la classe node. Te pare->un cop tenim el resultat és facil pujar
        // Al rc afegir inc nodes explorats, i nodes tallats. TAmbe inc updateMemoria. No faran res en el codi
        while (!LNO.isEmpty()){
            boolean investiguem = true;
            Node NodeActual = LNO.poll();
            rc.incNodesExplorats();
            if (usarLNT == true){
                investiguem = EstaALaLNT(NodeActual, LNT, rc); // Todo en Java són punteros, no le pasas la hashMap entera
            }  
            if ((usarLNT && investiguem) || (!usarLNT && !ComprobarCicle(NodeActual, rc))){
                if (NodeActual.estat.esMeta()) {
                   List<Moviment> moviments = ReconstruirCami(NodeActual); 
                   rc.setCami(moviments);
                   break;
                }
                LNT.put(NodeActual.estat, NodeActual);
      
                List<Moviment> LlistaMoviments = NodeActual.estat.getAccionsPossibles();
                for (Moviment mov: LlistaMoviments){
                    int fh = heur.h(NodeActual.estat.mou(mov));
                    int fhPare = 0;
                    if (NodeActual.pare != null) {
                        fhPare = heur.h(NodeActual.pare.estat);
                    }
                    Node nouNode = new Node (NodeActual.estat.mou(mov), NodeActual, mov, NodeActual.depth+1, fh+NodeActual.g+1-fhPare);
                    LNO.add(nouNode);
                }
            }
            rc.updateMemoria(LNO.size()+LNT.size());
        }



    }

}
