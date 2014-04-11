module receptionJoueurs {
	class JoueurSlice {};
	sequence<JoueurSlice> listeJoueurs;
    interface threadReceptionJoueurs {
        string inscriptionJoueur(listeJoueurs maListe);
    };
};