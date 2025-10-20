(define (problem MapaA_1)
    (:domain MapaA)
    (:objects 
        C0x0 C0x1 C0x2 C0x3 C0x4 C0x5 C0x6 C0x7 
        C1x0 C1x1 C1x2 C1x3 C1x4 C1x5 C1x6 C1x7  
        C2x0 C2x1 C2x2 C2x3 C2x4 C2x5 C2x6 C2x7  
        C3x0 C3x1 C3x2 C3x3 C3x4 C3x5 C3x6 C3x7 
        C4x0 C4x1 C4x2 C4x3 C4x4 C4x5 C4x6 C4x7  - TCASELLA
        A1 A2 - TAGENT
        PA - TPORTA
        CLa - TCLAU)
        
    (:init 
	    ;=================================
	    ; Estat inicial
        (EsEspai C1x2) (EsEspai C3x4)
        (EsParet C0x0) (EsParet C0x1)   (EsParet C0x2)   (EsParet C0x3) (EsParet C0x4)   (EsParet C0x5) (EsParet C0x6)   (EsParet C0x7)
        (EsParet C1x0) (EsEspai C1x1)   (EsAgent A2 C1x2)(EsEspai C1x3) (EsEspai C1x4)   (EsEspai C1x5) (EsParet C1x6)   (EsParet C1x7)
        (EsParet C2x0) (EsClau CLa C2x1)(EsEspai C2x2)   (EsEspai C2x3) (EsEspai C2x4)   (EsParet C2x5) (EsSortida C2x6) (EsParet C2x7)
        (EsParet C3x0) (EsEspai C3x1)   (EsEspai C3x2)   (EsEspai C3x3) (EsAgent A1 C3x4)(EsEspai C3x5) (EsPorta PA C3x6)(EsParet C3x7)
        (EsParet C4x0) (EsParet C4x1)   (EsParet C4x2)   (EsParet C4x3) (EsParet C4x4)   (EsParet C4x5) (EsParet C4x6)   (EsParet C4x7)
        
        (ClauDeLaPorta CLa PA)

		;=================================
		; Veinatge de caselles
		;=================================
	    ;Relacions horitzontals
		(Veina C0x0 C0x1) (Veina C0x1 C0x2) (Veina C0x2 C0x3) (Veina C0x3 C0x4) (Veina C0x4 C0x5) (Veina C0x5 C0x6) (Veina C0x6 C0x7)
        (Veina C1x0 C1x1) (Veina C1x1 C1x2) (Veina C1x2 C1x3) (Veina C1x3 C1x4) (Veina C1x4 C1x5) (Veina C1x5 C1x6) (Veina C1x6 C1x7)
        (Veina C2x0 C2x1) (Veina C2x1 C2x2) (Veina C2x2 C2x3) (Veina C2x3 C2x4) (Veina C2x4 C2x5) (Veina C2x5 C2x6) (Veina C2x6 C2x7)
        (Veina C3x0 C3x1) (Veina C3x1 C3x2) (Veina C3x2 C3x3) (Veina C3x3 C3x4) (Veina C3x4 C3x5) (Veina C3x5 C3x6) (Veina C3x6 C3x7)
        (Veina C4x0 C4x1) (Veina C4x1 C4x2) (Veina C4x2 C4x3) (Veina C4x3 C4x4) (Veina C4x4 C4x5) (Veina C4x5 C4x6) (Veina C4x6 C4x7)
		;---------------------------------
	    ;Relacions verticals
		(Veina C0x0 C1x0) (Veina C1x0 C2x0) (Veina C2x0 C3x0) (Veina C3x0 C4x0)
        (Veina C0x1 C1x1) (Veina C1x1 C2x1) (Veina C2x1 C3x1) (Veina C3x1 C4x1)
        (Veina C0x2 C1x2) (Veina C1x2 C2x2) (Veina C2x2 C3x2) (Veina C3x2 C4x2)
        (Veina C0x3 C1x3) (Veina C1x3 C2x3) (Veina C2x3 C3x3) (Veina C3x3 C4x3)
        (Veina C0x4 C1x4) (Veina C1x4 C2x4) (Veina C2x4 C3x4) (Veina C3x4 C4x4)
        (Veina C0x5 C1x5) (Veina C1x5 C2x5) (Veina C2x5 C3x5) (Veina C3x5 C4x5)
        (Veina C0x6 C1x6) (Veina C1x6 C2x6) (Veina C2x6 C3x6) (Veina C3x6 C4x6)
        (Veina C0x7 C1x7) (Veina C1x7 C2x7) (Veina C2x7 C3x7) (Veina C3x7 C4x7)
	
    )    
    (:goal 
        (or  
		    (EsAgent A1 C2x6)
			(EsAgent A2 C2x6)
		)
    )
)   