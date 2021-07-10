package logic.engclasses.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import logic.model.Artist;



public class ArtistDao {
	private static String user = "root";
	private static String pass = "showroome";
    private static String dbUrl = "jdbc:mysql://localhost:3306/prova?autoReconnect=true&useSSL=false";
	private static String driverClassName = "com.mysql.cj.jdbc.Driver";
	//defined for code smell purposes
	String un = "username";
    String ps = "password";
    String em = "email";
    String ds = "description";
    String tl = "talent";
	
	public Artist getArtist(String name) {
		Statement stmt = null;
        Connection conn = null;
        Artist art= null;
        
        try {
        	//STEP 2: loading dinamico del driver mysql
            Class.forName(driverClassName);
            
         // STEP 3: apertura connessione
            conn = DriverManager.getConnection(dbUrl, user, pass);
            
        	
         // STEP 4.1: creazione ed esecuzione della query
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            String sql = "SELECT * FROM artists WHERE username = '" +name+"'";
            ResultSet rset = stmt.executeQuery(sql);
            
            if (!rset.first()) { // rs not empty
            	return null;
            }
         // riposizionamento del cursore
            rset.first();
            
         // lettura colonne
            String usrnm = rset.getString(un);
            String psswrd = rset.getString(ps);
            String email = rset.getString(em);
            String description = rset.getString(ds);
            String talent = rset.getString(tl);
         //create entity
            art = new Artist(usrnm, psswrd, email, description, talent);
            // STEP 6: Clean-up dell'ambiente
            rset.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            // Errore durante l'apertura della connessione
            se.printStackTrace();
        } catch (Exception e) {
            // Errore nel loading del driver
            e.printStackTrace();
            
        } finally {
        	try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            	se2.printStackTrace();
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
		return art;
        	
	}
	
	public Artist artistLogin(String username, String password) {
		Statement stm = null;
        Connection con = null;
        Artist artist= null;
        try {
        	//STEP 2: loading dinamico del driver mysql
            Class.forName(driverClassName);
            
         // STEP 3: apertura connessione
            con = DriverManager.getConnection(dbUrl, user, pass);
            
         // STEP 4.1: creazione ed esecuzione della query
            stm = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            String sql = "SELECT * FROM artists WHERE username = '" +username+"'";
            ResultSet rslt = stm.executeQuery(sql);
            
            if (!rslt.first()) { // rs not empty
            	return null;
            }
         // riposizionamento del cursore
            rslt.first();
            
         // lettura colonne
            String usrnm = rslt.getString(un);
            String psswrd = rslt.getString(ps);
            String email = rslt.getString(em);
            String description = rslt.getString(ds);
            String talent = rslt.getString(tl);
            
            if (!usrnm.equals(username)|| !psswrd.equals(password)) {
            	//controllo 
            	return null;
            }
         //create entity
            artist = new Artist(usrnm, psswrd, email, description, talent);
            // STEP 6: Clean-up dell'ambiente
            rslt.close();
            stm.close();
            con.close();
        } catch (SQLException se) {
            // Errore durante l'apertura della connessione
            se.printStackTrace();
        } catch (Exception e) {
            // Errore nel loading del driver
            e.printStackTrace();
            
        } finally {
        	try {
                if (stm != null)
                    stm.close();
            } catch (SQLException se2) {
            	se2.printStackTrace();
            }
            try {
                if (con != null)
                    con.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
		return artist;
	}
	
	public void updateArtist(String artist, String email, String talent, String description) {
		Statement stmtn = null;
        Connection connect = null;
        
        try {
        	// STEP 2: loading dinamico del driver mysql
            Class.forName(driverClassName);
            
         // STEP 3: apertura connessione
            connect = DriverManager.getConnection(dbUrl, user, pass); 
            
        	
         // STEP 4.1: creazione ed esecuzione della query
            stmtn = connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY); 
            String where = "' WHERE username = '";
            
            if(!email.equals("")) {
            	String sql = "UPDATE artists SET email = '" + email + where + artist + "';";
            	stmtn.executeUpdate(sql);
            }
            if(!talent.equals("")) {
            	String sql1 = "UPDATE artists SET talent = '" + talent + where + artist + "';";
            	stmtn.executeUpdate(sql1);
            }
            if(!description.equals("")) {
            	String sql2 = "UPDATE artists SET description = '" + description + where + artist + "';";
            	stmtn.executeUpdate(sql2);
            }
            
         // STEP 6: Clean-up dell'ambiente
            stmtn.close();
            connect.close();
        } catch (SQLException se) {
            // Errore durante l'apertura della connessione
            se.printStackTrace();
        } catch (Exception e) {
            // Errore nel loading del driver
            e.printStackTrace();
            
        } finally {
        	try {
                if (stmtn != null)
                    stmtn.close();
            } catch (SQLException se2) {
            	se2.printStackTrace();
            }
            try {
                if (connect != null)
                    connect.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
	
    }
	
	public List<Artist> getArtists(){
		Statement s = null;
        Connection c = null;
        List<Artist> artists = new ArrayList<>();
        
        try {
        	//STEP 2: loading dinamico del driver mysql
            Class.forName(driverClassName);
            
         // STEP 3: apertura connessione
            c = DriverManager.getConnection(dbUrl, user, pass);
            
            
        	
         // STEP 4.1: creazione ed esecuzione della query
            s = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            String sql = "SELECT * FROM artists";
            ResultSet resset = s.executeQuery(sql);
            
            if (!resset.first()) { // rs not empty
            	return artists;
            }
         // riposizionamento del cursore
            resset.first();
            do {
            	// lettura colonne
            	String name  = resset.getString("username");
            	String password = resset.getString("password");
            	String email = resset.getString("email");
            	String description = resset.getString("description");
            	String talent = resset.getString("talent");
            	
            	Artist art = new Artist(name, password, email, description, talent);
            	artists.add(art);
            }while(resset.next());
            
            
            
            
         // STEP 6: Clean-up dell'ambiente
            resset.close();
            s.close();
            c.close();
            
        } catch (SQLException se) {
            // Errore durante l'apertura della connessione
            se.printStackTrace();
        } catch (Exception e) {
            // Errore nel loading del driver
            e.printStackTrace();
            
        } finally {
        	try {
                if (s != null)
                    s.close();
            } catch (SQLException se2) {
            	se2.printStackTrace();
            }
            try {
                if (c != null)
                    c.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
		return artists;
        
	}
	
public void registerArtist(String username, String password, String email, String description, String talent) {
		
		// STEP 1: dichiarazioni
        Statement stmtReg = null;
        Connection connReg = null;
        
        try {
        	// STEP 2: loading dinamico del driver mysql
            Class.forName(driverClassName);
            
         // STEP 3: apertura connessione
            connReg = DriverManager.getConnection(dbUrl, user, pass); 
            
        	
         // STEP 4.1: creazione ed esecuzione della query
            stmtReg = connReg.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY); 
        	
            String sql = "INSERT INTO artists (username, password, email, description, talent) VALUES ('" +username+"','"+password+"','"+email+"','"+description+"','"+talent+"')";
            stmtReg.executeUpdate(sql);
         // STEP 6: Clean-up dell'ambiente
            stmtReg.close();
            connReg.close();
        } catch (SQLException se) {
            // Errore durante l'apertura della connessione
            se.printStackTrace();
        } catch (Exception e) {
            // Errore nel loading del driver
            e.printStackTrace();
            
        } finally {
        	try {
                if (stmtReg != null)
                    stmtReg.close();
            } catch (SQLException se2) {
            	se2.printStackTrace();
            }
            try {
                if (connReg != null)
                    connReg.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
		
	}
}

