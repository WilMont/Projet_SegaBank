package dal;

import bo.ComptePayant;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ComptePayantDAL implements IDAO<Long, ComptePayant> {

    private static final String INSERT_QUERY = "INSERT INTO compte (solde, idAgence) VALUES(?,?)";
    private static final String UPDATE_QUERY = "UPDATE compte SET solde = ?, idAgence = ? WHERE id = ?";
    private static final String REMOVE_QUERY = "DELETE FROM compte WHERE id = ?";
    private static final String FIND_QUERY = "SELECT * FROM compte WHERE id = ?";
    private static final String FIND_ALL_QUERY = "SELECT * FROM compte";
    private static final String FIND_LAST_INSERTED_QUERY = "SELECT * FROM compte ORDER BY id DESC LIMIT 1";

    @Override
    public void create( ComptePayant comptePayant ) throws SQLException, IOException, ClassNotFoundException {
        Connection connection = PersistenceManager.getConnection();
        if ( connection != null ) {
            try ( PreparedStatement ps = connection
                    .prepareStatement( INSERT_QUERY, Statement.RETURN_GENERATED_KEYS ) ) {
                ps.setDouble( 1, comptePayant.getSolde() );
                ps.setInt( 2, comptePayant.getAgenceID() );
                ps.executeUpdate();
                try ( ResultSet rs = ps.getGeneratedKeys() ) {
                    if ( rs.next() ) {
                        comptePayant.setId( rs.getInt( 1 ) );
                    }
                }
            }
        }
    }

    @Override
    public void update( ComptePayant comptePayant ) throws SQLException, IOException, ClassNotFoundException {
        Connection connection = PersistenceManager.getConnection();
        if ( connection != null ) {
            try ( PreparedStatement ps = connection.prepareStatement( UPDATE_QUERY ) ) {
                ps.setDouble( 1, comptePayant.getSolde() );
                ps.setInt( 2, comptePayant.getAgenceID() );
                ps.setInt( 3, comptePayant.getId() );
                ps.executeUpdate();
            }
        }
    }

    @Override
    public void remove( ComptePayant comptePayant ) throws SQLException, IOException, ClassNotFoundException {
        Connection connection = PersistenceManager.getConnection();
        if ( connection != null ) {
            try ( PreparedStatement ps = connection.prepareStatement( REMOVE_QUERY ) ) {
                ps.setInt( 1, comptePayant.getId() );
                ps.executeUpdate();
            }
        }
    }

    @Override
    public ComptePayant findById( Long id ) throws SQLException, IOException, ClassNotFoundException {
        ComptePayant comptePayant = null;
        Connection connection = PersistenceManager.getConnection();
        if ( connection != null ) {
            try ( PreparedStatement ps = connection.prepareStatement( FIND_QUERY ) ) {
                ps.setLong( 1, id );
                try ( ResultSet rs = ps.executeQuery() ) {
                    if ( rs.next() ) {
                        comptePayant = new ComptePayant();
                        comptePayant.setId( rs.getInt( "id" ) );
                        comptePayant.setSolde( rs.getDouble( "solde" ) );
                        comptePayant.setAgenceID( rs.getInt( "idAgence" ) );
                    }
                }
            }
        }
        return comptePayant;
    }

    @Override
    public List<ComptePayant> findAll() throws SQLException, IOException, ClassNotFoundException {
        List<ComptePayant> list = new ArrayList<>();
        Connection connection = PersistenceManager.getConnection();
        if ( connection != null ) {
            try ( PreparedStatement ps = connection.prepareStatement( FIND_ALL_QUERY ) ) {
                try ( ResultSet rs = ps.executeQuery() ) {
                    while ( rs.next() ) {
                        ComptePayant comptePayant = new ComptePayant();
                        comptePayant.setId( rs.getInt( "id" ) );
                        comptePayant.setSolde( rs.getDouble( "solde" ) );
                        comptePayant.setAgenceID( rs.getInt( "idAgence" ) );
                        list.add( comptePayant );
                    }
                }
            }
        }
        return list;
    }

    public ComptePayant findLastInserted() throws SQLException, IOException, ClassNotFoundException {
        ComptePayant comptePayant = null;
        Connection connection = PersistenceManager.getConnection();
        if ( connection != null ) {
            try ( PreparedStatement ps = connection.prepareStatement( FIND_LAST_INSERTED_QUERY ) ) {
                try ( ResultSet rs = ps.executeQuery() ) {
                    while ( rs.next() ) {
                        comptePayant = new ComptePayant();
                        comptePayant.setId( rs.getInt( "id" ) );
                        comptePayant.setSolde( rs.getDouble( "solde" ) );
                        comptePayant.setAgenceID( rs.getInt( "idAgence" ) );
                    }
                }
            }
        }
        return comptePayant;
    }
}

