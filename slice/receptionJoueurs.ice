module receptionJoueurs {
	sequence<string> listeJoueurs;
    interface threadReceptionJoueurs {
        int inscriptionJoueur(listeJoueurs maListe);
    };
};