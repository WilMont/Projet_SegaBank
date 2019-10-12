package dal;

package dal;

import bo.Agence;
import bo.Compte;
import dal.IDAO;
import dal.PersistenceManager;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CompteDAL implements IDAO<Long, Compte> {

    private static final String INSERT_QUERY = "INSERT INTO compte (code, adresse, idAgence, decouvert, tauxInteret) VALUES(?,?,?,?)";
    private static final String UPDATE_QUERY = "UPDATE agence SET code = ?, adresse = ? WHERE id = ?";
    private static final String REMOVE_QUERY = "DELETE FROM agence WHERE id = ?";
    private static final String FIND_QUERY = "SELECT * FROM agence WHERE id = ?";
    private static final String FIND_ALL_QUERY = "SELECT * FROM agence";

    @Override
    public void create( Compte compte ) throws SQLException, IOException, ClassNotFoundException {

        Connection connection = PersistenceManager.getConnection();
        if ( connection != null ) {
            try ( PreparedStatement ps = connection
                    .prepareStatement( INSERT_QUERY, Statement.RETURN_GENERATED_KEYS ) ) {
                ps.setDouble( 1, compte.getSolde() );
                ps.setInt( 2, compte.getAgence() );
                ps.executeUpdate();
                try ( ResultSet rs = ps.getGeneratedKeys() ) {
                    if ( rs.next() ) {
                        agence.setId( rs.getInt( 1 ) );
                    }
                }
            }
        }
    }

    @Override
    public void update( Agence agence ) throws SQLException, IOException, ClassNotFoundException {

        Connection connection = PersistenceManager.getConnection();
        if ( connection != null ) {
            try ( PreparedStatement ps = connection.prepareStatement( UPDATE_QUERY ) ) {
                ps.setString( 1, agence.getAdresse() );
                ps.setInt( 2, agence.getCode() );
                ps.setInt( 3, agence.getId() );
                ps.executeUpdate();
            }
        }
    }

    @Override
    public void remove( Agence agence ) throws SQLException, IOException, ClassNotFoundException {
        Connection connection = PersistenceManager.getConnection();
        if ( connection != null ) {
            try ( PreparedStatement ps = connection.prepareStatement( REMOVE_QUERY ) ) {
                ps.setInt( 1, agence.getId() );
                ps.executeUpdate();
            }
        }
    }

    @Override
    public Agence findById( Long id ) throws SQLException, IOException, ClassNotFoundException {
        Agence agence = null;
        Connection connection = PersistenceManager.getConnection();
        if ( connection != null ) {
            try ( PreparedStatement ps = connection.prepareStatement( FIND_QUERY ) ) {
                ps.setLong( 1, id );
                try ( ResultSet rs = ps.executeQuery() ) {
                    if ( rs.next() ) {
                        agence = new Agence();
                        agence.setId( rs.getInt( "id" ) );
                        agence.setCode( rs.getInt( "code" ) );
                        agence.setAdresse( rs.getString( "adresse" ) );
                    }
                }
            }
        }
        return agence;
    }

    @Override
    public List<Agence> findAll() throws SQLException, IOException, ClassNotFoundException {
        List<Agence> list = new ArrayList<>();
        Connection connection = PersistenceManager.getConnection();
        if ( connection != null ) {
            try ( PreparedStatement ps = connection.prepareStatement( FIND_ALL_QUERY ) ) {
                try ( ResultSet rs = ps.executeQuery() ) {
                    while ( rs.next() ) {
                        Agence agence = new Agence();
                        agence.setId( rs.getInt( "id" ) );
                        agence.setCode( rs.getInt( "code" ) );
                        agence.setAdresse( rs.getString( "adresse" ) );
                        list.add( agence );
                    }
                }
            }
        }
        return list;
    }
}

