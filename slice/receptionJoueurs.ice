module receptionJoueurs {
	sequence<string> listeJoueurs;
	interface threadReceptionJoueurs {
       	string inscriptionJoueur(listeJoueurs maListe);
    };
};

module envoiScores {
    interface threadEnvoiScores {
        string getScores(int identifiantEquipe);
    };
};