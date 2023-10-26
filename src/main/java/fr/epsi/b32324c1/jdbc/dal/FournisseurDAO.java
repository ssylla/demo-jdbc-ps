package fr.epsi.b32324c1.jdbc.dal;

import fr.epsi.b32324c1.jdbc.entites.Fournisseur;

import java.util.List;

public interface FournisseurDAO {

    List<Fournisseur> extraire() throws Exception;
    void insert(Fournisseur fournisseur) throws Exception;
}
