package fr.epsi.b32324c1.jdbc.dal.jdbc;

import fr.epsi.b32324c1.jdbc.dal.UtilisateurDAO;
import fr.epsi.b32324c1.jdbc.entites.Utilisateur;

import java.sql.*;

import static fr.epsi.b32324c1.jdbc.ihm.Main.*;

public class UtilisateurDAOJDBC implements UtilisateurDAO {

    private static final String LOGIN_QUERY = "SELECT ID, LOGIN FROM utilisateur WHERE LOGIN='%s' AND MDP='%s'";

    private static final String SECURED_LOGIN_QUERY = "SELECT ID, LOGIN FROM utilisateur WHERE LOGIN=? AND MDP=?";
    @Override
    public Utilisateur login(String login, String pwd) throws Exception {

        Utilisateur user = null;
        try(Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(String.format(LOGIN_QUERY, login, pwd))) {
            System.out.println(String.format(LOGIN_QUERY, login, pwd));
            if(rs.next()) {
                user = new Utilisateur(rs.getInt("ID"), rs.getString("LOGIN"), "");
            }
        }
        return user;
    }

    @Override
    public Utilisateur loginSecurise(String login, String pwd) throws Exception {
        Utilisateur user = null;
        try(Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);
            PreparedStatement statement = connection.prepareStatement(SECURED_LOGIN_QUERY)) {
            statement.setString(1, login);
            statement.setString(2, pwd);
            try(ResultSet rs = statement.executeQuery()) {
                System.out.println(String.format(LOGIN_QUERY, login, pwd));
                if(rs.next()) {
                    user = new Utilisateur(rs.getInt("ID"), rs.getString("LOGIN"), "");
                }
            }
        }
        return user;
    }
}
