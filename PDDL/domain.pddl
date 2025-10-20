(define (domain MapaA)
	(:requirements :strips :equality :typing)
	(:types TCASELLA TCLAU TPORTA TAGENT)
	(:predicates
		(EsClau ?clau - TCLAU ?casella - TCASELLA)
		(Veina ?casella ?casella - TCASELLA)
		(EsParet ?casella - TCASELLA)
		(EsEspai ?casella - TCASELLA)

		(EsPorta ?porta - TPORTA ?casella - TCASELLA) 
		(ClauDeLaPorta ?clau - TCLAU ?porta - TPORTA)

		(EsSortida ?casella - TCASELLA)
		(EsAgent ?agent - TAGENT ?casella - TCASELLA)
		(ClauAgafada ?clau - TCLAU)
    )
	(:action Moure
        :parameters (?agent - TAGENT ?deCasella ?aCasella - TCASELLA)
        :precondition (and 
			(EsEspai ?aCasella) 
			(EsAgent ?agent ?deCasella)
			(or 
				(Veina ?aCasella ?deCasella)
				(Veina ?deCasella ?aCasella)
			) 
		)
        :effect (and 
			(not (EsAgent ?agent ?deCasella))
			(EsAgent ?agent ?aCasella)
        )
    )
	(:action MoureiAgafarClau
        :parameters (?agent - TAGENT ?deCasella ?aCasella - TCASELLA ?clau - TCLAU)
        :precondition (and 
			(EsClau ?clau ?aCasella) 
			(EsAgent ?agent ?deCasella)
			(or 
				(Veina ?aCasella ?deCasella)
				(Veina ?deCasella ?aCasella)
			) 
		)
        :effect (and 
			(not (EsAgent ?agent ?deCasella))
			(EsAgent ?agent ?aCasella)
			(ClauAgafada ?clau)
        )
    )
	(:action MoureObrintPorta
        :parameters (?agent - TAGENT ?deCasella ?aCasella - TCASELLA ?porta - TPORTA ?clau - TCLAU)
        :precondition (and
			(EsAgent ?agent ?deCasella)
			(EsPorta ?porta ?aCasella)
			(ClauDeLaPorta ?clau ?porta)
			(ClauAgafada ?clau)
			(or 
				(Veina ?aCasella ?deCasella)
				(Veina ?deCasella ?aCasella)
			) 
		)
        :effect (and 
			(not (EsAgent ?agent ?deCasella))
			(EsAgent ?agent ?aCasella)
        )
    )
	(:action MoureASortida
        :parameters (?agent - TAGENT ?deCasella ?aCasella - TCASELLA)
        :precondition (and 
			(EsSortida ?aCasella)
			(EsAgent ?agent ?deCasella)
			(or 
				(Veina ?aCasella ?deCasella)
				(Veina ?deCasella ?aCasella)
			) 
		)
        :effect (and 
			(not (EsAgent ?agent ?deCasella))
			(EsAgent ?agent ?aCasella)
        )
    )
)
