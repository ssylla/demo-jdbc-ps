package fr.epsi.b32324c1.jdbc.ihm;

import fr.epsi.b32324c1.jdbc.dal.jdbc.FournisseurDAOJDBC;
import fr.epsi.b32324c1.jdbc.entites.Fournisseur;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static fr.epsi.b32324c1.jdbc.ihm.Main.*;

public class TestSelect {

    public static void main(String[] args) {
        try {
            List<Fournisseur> fournisseurs = new FournisseurDAOJDBC().extraire();
            fournisseurs.forEach(System.out::println);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
