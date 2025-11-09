package edu.epsevg.prop.ac1.cerca;


import edu.epsevg.prop.ac1.model.*;
import edu.epsevg.prop.ac1.resultat.ResultatCerca;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;


public class CercaIDS extends CercaTunejada {
    public CercaIDS(boolean usarLNT) { super(usarLNT); }

    @Override
    public void ferCerca(Mapa inicial, ResultatCerca rc) {
        int i = 0;
        boolean solucio = false;
        while (!solucio && i<20) {
            Stack<Node> LNO = new Stack<>();
            Node primerNode = new Node (inicial, null, null, 0, 0);
            LNO.add(primerNode);
            HashMap<Mapa, Node> LNT = new HashMap<>();
            //Al rc, fer el setCami utilitzant la classe node. Te pare->un cop tenim el resultat és facil pujar
            // Al rc afegir inc nodes explorats, i nodes tallats. Tambe inc updateMemoria. No faran res en el codi
            while (!LNO.isEmpty()){
                boolean investiguem = true;
                Node NodeActual = LNO.pop();
            
                rc.incNodesExplorats();
                if (usarLNT == true){
                    investiguem = EstaALaLNT(NodeActual, LNT, rc); // Todo en Java són punteros, no le pasas la hashMap entera
                }  
                if ((usarLNT && investiguem) || (!usarLNT && !ComprobarCicle(NodeActual, rc))){
                    if (NodeActual.estat.esMeta()) {
                        List<Moviment> moviments = ReconstruirCami(NodeActual); 
                        rc.setCami(moviments);
                        solucio=true;
                        break;
                    }
                    if (NodeActual.depth < i){
                        LNT.put(NodeActual.estat, NodeActual);
                        List<Moviment> LlistaMoviments = NodeActual.estat.getAccionsPossibles();
                        for (Moviment mov: LlistaMoviments){
                            Node nouNode = new Node (NodeActual.estat.mou(mov), NodeActual, mov, NodeActual.depth+1, 0);
                            LNO.add(nouNode);
                        }
                    } else {
                        rc.incNodesTallats();
                    }
                }
                rc.updateMemoria(LNO.size()+LNT.size());
            }
            ++i;
        }
    }
}
