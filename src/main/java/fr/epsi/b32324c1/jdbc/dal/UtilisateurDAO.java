package fr.epsi.b32324c1.jdbc.dal;

import fr.epsi.b32324c1.jdbc.entites.Utilisateur;

public interface UtilisateurDAO {

    Utilisateur login(String login, String pwd) throws Exception;
    Utilisateur loginSecurise(String login, String pwd) throws Exception;
}
