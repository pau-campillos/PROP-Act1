package edu.epsevg.prop.ac1.cerca;
 
import edu.epsevg.prop.ac1.model.*;
import edu.epsevg.prop.ac1.resultat.ResultatCerca;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class CercaDFS extends CercaTunejada {
    public CercaDFS(boolean usarLNT) { super(usarLNT); }

    @Override
    public void ferCerca(Mapa inicial, ResultatCerca rc) {

        int limit = 50; //LIMIT PROFUNDITAT

        Stack<Node> LNO = new Stack<>();
        Node primerNode = new Node (inicial, null, null, 0, 0);
        LNO.add(primerNode);
        HashMap<Mapa, Node> LNT = new HashMap<>();

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
                   break;
                }

                if (NodeActual.depth < limit){ 
                    LNT.put(NodeActual.estat, NodeActual);
                    List<Moviment> LlistaMoviments = NodeActual.estat.getAccionsPossibles();
                    for (Moviment mov: LlistaMoviments){
                        Node nouNode = new Node (NodeActual.estat.mou(mov), NodeActual, mov, NodeActual.depth+1, 0);
                        LNO.add(nouNode);
                    }
                }
            }
            rc.updateMemoria(LNO.size()+LNT.size());
        }
    }
}
