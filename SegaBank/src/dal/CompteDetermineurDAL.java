package dal;

import bo.Compte;
import bo.CompteDetermineur;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CompteDetermineurDAL implements IDAO<Long, CompteDetermineur> {

    private static final String INSERT_QUERY = "INSERT INTO compte (solde, idAgence, decouvert, tauxInteret) VALUES(?,?,?,?)";
    private static final String UPDATE_QUERY = "UPDATE compte SET idAgence = , decouvert = ?, tauxInteret = ? WHERE id = ?";
    private static final String REMOVE_QUERY = "DELETE FROM compte WHERE id = ?";
    private static final String FIND_QUERY = "SELECT * FROM compte WHERE id = ?";
    private static final String FIND_ALL_QUERY = "SELECT * FROM compte";
    private static final String FIND_LAST_INSERTED_QUERY = "SELECT * FROM compte ORDER BY id DESC LIMIT 1";

    @Override
    public void create( CompteDetermineur compteDetermineur ) throws SQLException, IOException, ClassNotFoundException {
        Connection connection = PersistenceManager.getConnection();
        if ( connection != null ) {
            try ( PreparedStatement ps = connection
                    .prepareStatement( INSERT_QUERY, Statement.RETURN_GENERATED_KEYS ) ) {
                ps.setDouble( 1, compteDetermineur.getSolde() );
                ps.setInt( 2, compteDetermineur.getAgenceID() );
                ps.setDouble( 3, compteDetermineur.getDecouvert() );
                ps.setDouble( 4, compteDetermineur.getTauxInteret() );
                ps.executeUpdate();
                try ( ResultSet rs = ps.getGeneratedKeys() ) {
                    if ( rs.next() ) {
                        compteDetermineur.setId( rs.getInt( 1 ) );
                    }
                }
            }
        }
    }

    @Override
    public void update( CompteDetermineur compteDetermineur ) throws SQLException, IOException, ClassNotFoundException {
        Connection connection = PersistenceManager.getConnection();
        if ( connection != null ) {
            try ( PreparedStatement ps = connection.prepareStatement( UPDATE_QUERY ) ) {
                ps.setDouble( 1, compteDetermineur.getTauxInteret() );
                ps.setDouble( 2, compteDetermineur.getDecouvert() );
                ps.setInt( 3, compteDetermineur.getAgenceID() );
                ps.setDouble( 4, compteDetermineur.getSolde() );
                ps.setInt( 5, compteDetermineur.getId() );
                ps.executeUpdate();
            }
        }
    }

    @Override
    public void remove( CompteDetermineur compteDetermineur ) throws SQLException, IOException, ClassNotFoundException {
        Connection connection = PersistenceManager.getConnection();
        if ( connection != null ) {
            try ( PreparedStatement ps = connection.prepareStatement( REMOVE_QUERY ) ) {
                ps.setInt( 1, compteDetermineur.getId() );
                ps.executeUpdate();
            }
        }
    }

    @Override
    public CompteDetermineur findById( Long id ) throws SQLException, IOException, ClassNotFoundException {
        CompteDetermineur compteDetermineur = null;
        Connection connection = PersistenceManager.getConnection();
        if ( connection != null ) {
            try ( PreparedStatement ps = connection.prepareStatement( FIND_QUERY ) ) {
                ps.setLong( 1, id );
                try ( ResultSet rs = ps.executeQuery() ) {
                    if ( rs.next() ) {
                        compteDetermineur = new CompteDetermineur();
                        compteDetermineur.setId( rs.getInt( "id" ) );
                        compteDetermineur.setSolde( rs.getDouble( "solde" ) );
                        compteDetermineur.setAgenceID( rs.getInt( "idAgence" ) );
                        compteDetermineur.setDecouvert( rs.getDouble( "decouvert" ) );
                        compteDetermineur.setTauxInteret( rs.getDouble( "tauxInteret" ) );
                    }
                }
            }
        }
        return compteDetermineur;
    }

    @Override
    public List<CompteDetermineur> findAll() throws SQLException, IOException, ClassNotFoundException {
        List<CompteDetermineur> list = new ArrayList<>();
        Connection connection = PersistenceManager.getConnection();
        if ( connection != null ) {
            try ( PreparedStatement ps = connection.prepareStatement( FIND_ALL_QUERY ) ) {
                try ( ResultSet rs = ps.executeQuery() ) {
                    while ( rs.next() ) {
                        CompteDetermineur compteDetermineur = new CompteDetermineur();
                        compteDetermineur.setId( rs.getInt( "id" ) );
                        compteDetermineur.setSolde( rs.getDouble( "solde" ) );
                        compteDetermineur.setAgenceID( rs.getInt( "idAgence" ) );
                        compteDetermineur.setDecouvert( rs.getDouble( "decouvert" ) );
                        compteDetermineur.setTauxInteret( rs.getDouble( "tauxInteret" ) );
                        list.add( compteDetermineur );
                    }
                }
            }
        }
        return list;
    }

    public CompteDetermineur findLastInserted() throws SQLException, IOException, ClassNotFoundException {
        CompteDetermineur compteDetermineur = null;
        Connection connection = PersistenceManager.getConnection();
        if ( connection != null ) {
            try ( PreparedStatement ps = connection.prepareStatement( FIND_LAST_INSERTED_QUERY ) ) {
                try ( ResultSet rs = ps.executeQuery() ) {
                    while ( rs.next() ) {
                        compteDetermineur = new CompteDetermineur();
                        compteDetermineur.setId( rs.getInt( "id" ) );
                        compteDetermineur.setSolde( rs.getDouble( "solde" ) );
                        compteDetermineur.setAgenceID( rs.getInt( "idAgence" ) );
                        compteDetermineur.setDecouvert( rs.getDouble( "decouvert" ) );
                        compteDetermineur.setTauxInteret( rs.getDouble( "tauxInteret" ) );
                    }
                }
            }
        }
        return compteDetermineur;
    }
    
}
