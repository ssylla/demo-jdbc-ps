package fr.epsi.b32324c1.jdbc.dal.jdbc;

import fr.epsi.b32324c1.jdbc.dal.FournisseurDAO;
import fr.epsi.b32324c1.jdbc.entites.Fournisseur;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static fr.epsi.b32324c1.jdbc.ihm.Main.*;

public class FournisseurDAOJDBC implements FournisseurDAO {

    public static final String INSERT_QUERY = "SELECT * FROM fournisseur";

    @Override
    public List<Fournisseur> extraire() throws SQLException {
        List<Fournisseur> fournisseurs = new ArrayList<>();
        try (Connection cnx = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);
             Statement st = cnx.createStatement();
             ResultSet rs = st.executeQuery(INSERT_QUERY)) {
            while (rs.next()) {
                int id = rs.getInt(1);
                String nom = rs.getString("NOM");
                fournisseurs.add(new Fournisseur(id, nom));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw e;
        }
        return fournisseurs;
    }

    @Override
    public void insert(Fournisseur fournisseur) throws SQLException {
        try (Connection cnx = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);
             Statement st = cnx.createStatement()) {
            st.executeUpdate("INSERT INTO fournisseur (NOM) VALUES ('"+fournisseur.getNom()+"')", Statement.RETURN_GENERATED_KEYS);
            try(ResultSet rs = st.getGeneratedKeys()) {
                if (rs.next()) {
                    fournisseur.setId(rs.getInt(1));
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }
}
