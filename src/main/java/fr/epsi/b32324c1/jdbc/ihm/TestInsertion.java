package fr.epsi.b32324c1.jdbc.ihm;

import java.sql.*;

import static fr.epsi.b32324c1.jdbc.ihm.Main.*;

public class TestInsertion {

    public static void main(String[] args) {
        try (Connection cnx = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);
        Statement st = cnx.createStatement()) {
            int nb = st.executeUpdate("INSERT INTO fournisseur (NOM) VALUES ('EPSI NTE')", Statement.RETURN_GENERATED_KEYS);
            System.out.printf("Le nombre de ligne(s) créé(s) est : %d%n", nb);
            try(ResultSet rs = st.getGeneratedKeys()) {
                if (rs.next()) {
                    System.out.printf("La clé générée est : %d%n", rs.getInt(1));
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
