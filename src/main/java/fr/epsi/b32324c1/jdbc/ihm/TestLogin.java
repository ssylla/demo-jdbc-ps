package fr.epsi.b32324c1.jdbc.ihm;

import fr.epsi.b32324c1.jdbc.dal.UtilisateurDAO;
import fr.epsi.b32324c1.jdbc.dal.jdbc.UtilisateurDAOJDBC;
import fr.epsi.b32324c1.jdbc.entites.Utilisateur;

import java.util.Scanner;

public class TestLogin {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UtilisateurDAO dao = new UtilisateurDAOJDBC();

        System.out.println("*************************************");
        System.out.println("*******Bienvenue dans mon App********");
        System.out.println("*************************************");
        System.out.println("* Merci de vous loguer...");
        System.out.print("* Entrer votre login : ");
        String login = sc.nextLine();
        System.out.print("* Entrer votre mot de passe : ");
        String password = sc.nextLine();
        Utilisateur utilisateurAConnecter = null;
        try {
            utilisateurAConnecter = dao.loginSecurise(login, password);
            if (null != utilisateurAConnecter) {
                System.out.println("*Bienvenue à toi : "+utilisateurAConnecter.getLogin());
            } else {
                System.out.println("Erreur d'identification...");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}
