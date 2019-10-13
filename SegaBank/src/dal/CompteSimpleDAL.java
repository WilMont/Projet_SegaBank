package dal;

import bo.CompteSimple;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CompteSimpleDAL implements IDAO<Long, CompteSimple> {

    private static final String INSERT_QUERY = "INSERT INTO compte (solde, idAgence, decouvert) VALUES(?,?,?)";
    private static final String UPDATE_QUERY = "UPDATE compte SET solde = ?, idAgence = ?, decouvert = ? WHERE id = ?";
    private static final String REMOVE_QUERY = "DELETE FROM compte WHERE id = ?";
    private static final String FIND_QUERY = "SELECT * FROM compte WHERE id = ?";
    private static final String FIND_ALL_QUERY = "SELECT * FROM compte";
    private static final String FIND_LAST_INSERTED_QUERY = "SELECT * FROM compte ORDER BY id DESC LIMIT 1";

    @Override
    public void create( CompteSimple compteSimple ) throws SQLException, IOException, ClassNotFoundException {
        Connection connection = PersistenceManager.getConnection();
        if ( connection != null ) {
            try ( PreparedStatement ps = connection
                    .prepareStatement( INSERT_QUERY, Statement.RETURN_GENERATED_KEYS ) ) {
                ps.setDouble( 1, compteSimple.getSolde() );
                ps.setInt( 2, compteSimple.getAgenceID() );
                ps.setDouble( 3, compteSimple.getDecouvert() );
                ps.executeUpdate();
                try ( ResultSet rs = ps.getGeneratedKeys() ) {
                    if ( rs.next() ) {
                        compteSimple.setId( rs.getInt( 1 ) );
                    }
                }
            }
        }
    }

    @Override
    public void update( CompteSimple compteSimple ) throws SQLException, IOException, ClassNotFoundException {
        Connection connection = PersistenceManager.getConnection();
        if ( connection != null ) {
            try ( PreparedStatement ps = connection.prepareStatement( UPDATE_QUERY ) ) {
                ps.setDouble( 1, compteSimple.getSolde() );
                ps.setInt( 2, compteSimple.getAgenceID() );
                ps.setDouble( 3, compteSimple.getDecouvert() );
                ps.setInt( 4, compteSimple.getId() );
                ps.executeUpdate();
            }
        }
    }

    @Override
    public void remove( CompteSimple compteSimple ) throws SQLException, IOException, ClassNotFoundException {
        Connection connection = PersistenceManager.getConnection();
        if ( connection != null ) {
            try ( PreparedStatement ps = connection.prepareStatement( REMOVE_QUERY ) ) {
                ps.setInt( 1, compteSimple.getId() );
                ps.executeUpdate();
            }
        }
    }

    public void removeById( int id ) throws SQLException, IOException, ClassNotFoundException {
        Connection connection = PersistenceManager.getConnection();
        if ( connection != null ) {
            try ( PreparedStatement ps = connection.prepareStatement( REMOVE_QUERY ) ) {
                ps.setInt( 1, id );
                ps.executeUpdate();
            }
        }
    }

    @Override
    public CompteSimple findById( Long id ) throws SQLException, IOException, ClassNotFoundException {
        CompteSimple compteSimple = null;
        Connection connection = PersistenceManager.getConnection();
        if ( connection != null ) {
            try ( PreparedStatement ps = connection.prepareStatement( FIND_QUERY ) ) {
                ps.setLong( 1, id );
                try ( ResultSet rs = ps.executeQuery() ) {
                    if ( rs.next() ) {
                        compteSimple = new CompteSimple();
                        compteSimple.setId( rs.getInt( "id" ) );
                        compteSimple.setSolde( rs.getDouble( "solde" ) );
                        compteSimple.setAgenceID( rs.getInt( "idAgence" ) );
                        compteSimple.setDecouvert( rs.getDouble( "decouvert" ) );
                    }
                }
            }
        }
        return compteSimple;
    }

    @Override
    public List<CompteSimple> findAll() throws SQLException, IOException, ClassNotFoundException {
        List<CompteSimple> list = new ArrayList<>();
        Connection connection = PersistenceManager.getConnection();
        if ( connection != null ) {
            try ( PreparedStatement ps = connection.prepareStatement( FIND_ALL_QUERY ) ) {
                try ( ResultSet rs = ps.executeQuery() ) {
                    while ( rs.next() ) {
                        CompteSimple compteSimple = new CompteSimple();
                        compteSimple.setId( rs.getInt( "id" ) );
                        compteSimple.setSolde( rs.getDouble( "solde" ) );
                        compteSimple.setAgenceID( rs.getInt( "idAgence" ) );
                        compteSimple.setDecouvert( rs.getDouble( "decouvert" ) );
                        list.add( compteSimple );
                    }
                }
            }
        }
        return list;
    }

    public CompteSimple findLastInserted() throws SQLException, IOException, ClassNotFoundException {
        CompteSimple compteSimple = null;
        Connection connection = PersistenceManager.getConnection();
        if ( connection != null ) {
            try ( PreparedStatement ps = connection.prepareStatement( FIND_LAST_INSERTED_QUERY ) ) {
                try ( ResultSet rs = ps.executeQuery() ) {
                    while ( rs.next() ) {
                        compteSimple = new CompteSimple();
                        compteSimple.setId( rs.getInt( "id" ) );
                        compteSimple.setSolde( rs.getDouble( "solde" ) );
                        compteSimple.setAgenceID( rs.getInt( "idAgence" ) );
                        compteSimple.setDecouvert( rs.getDouble( "decouvert" ) );
                    }
                }
            }
        }
        return compteSimple;
    }

}

