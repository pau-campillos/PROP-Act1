PROP-Act1

link al github del projecte: https://github.com/pau-campillos/PROP-Act1.git

Classes afegides: 
    - CercaTunejada:
        Extensió de la classe Cerca, on hem creat funcions que seran iguals i necessàries per a les diferents cerques.

Classes modificades (a part del TO DO):
    - Mapa:
        Hem afegit una llista de posicions "claus" que guarda les posicions de les claus que encara no hem recollit. Es llegeix juntament amb el mapa, i cada cop que recollim una clau s'elimina aquesta de la llista. 

        A més, hem afegit funcions que interaccionen amb aquesta nova llista, les quals ens permeten, entre altres, trobar la clau més propera a un punt, saber si ens falten claus per trobar, etc.

        Finalment, hem afegit una funció per a saber si hi ha un agent en una posició en concret.