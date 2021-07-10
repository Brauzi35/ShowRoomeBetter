package logic.engclasses.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import logic.engclasses.exceptions.PendingRequestException;
import logic.engclasses.utils.SessionSponsor;
import logic.model.Sponsor;




public class SponsorDao {
	private static String user = "root";
	private static String pass = "showroome";
    private static String dbUrl = "jdbc:mysql://localhost:3306/prova?autoReconnect=true&useSSL=false";
	private static String driverClassName = "com.mysql.cj.jdbc.Driver";
	
	//strings declared for code smell avoidance
	String u = "username";
    String p = "password";
    String a = "activity";
    String c = "capacity";
    String d = "description";
	
	public Sponsor getSponsor(String username) {
		Statement stmtgs = null;
        Connection conngs = null;
        Sponsor s = null;
        try {
        	//STEP 2: loading dinamico del driver mysql
            Class.forName(driverClassName);
            
         // STEP 3: apertura connessione
            conngs = DriverManager.getConnection(dbUrl, user, pass);
            
         // STEP 4.1: creazione ed esecuzione della query
            stmtgs = conngs.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            String sql = "SELECT * FROM sponsors WHERE username = '" +username+"'";
            ResultSet rsgs = stmtgs.executeQuery(sql);
            
            if (!rsgs.first()) { // rs not empty
            	return null;
            }
         // riposizionamento del cursore
            rsgs.first();
            
         // lettura colonne
            String usrnm = rsgs.getString(u);
            String psswrd = rsgs.getString(p);
            String activity = rsgs.getString(a);
            String capacity = rsgs.getString(c);
            String description = rsgs.getString(d);
            
         //create entity
            s = new Sponsor(usrnm, psswrd, activity, capacity, description);
            // STEP 6: Clean-up dell'ambiente
            rsgs.close();
            stmtgs.close();
            
            conngs.close();
        } catch (SQLException se) {
            // Errore durante l'apertura della connessione
            se.printStackTrace();
        } catch (Exception e) {
            // Errore nel loading del driver
            e.printStackTrace();
            
        } finally {
        	try {
                if (stmtgs != null)
                    stmtgs.close();
            } catch (SQLException se2) {
            	se2.printStackTrace();
            }
            try {
                if (conngs != null)
                    conngs.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
		return s;
        	
	}
	
	public Sponsor loginSponsor(String username, String password) {
		Statement stmtls = null;
        Connection connls = null;
        Sponsor spon = null;
        try {
        	//STEP 2: loading dinamico del driver mysql
            Class.forName(driverClassName);
            
         // STEP 3: apertura connessione
            connls = DriverManager.getConnection(dbUrl, user, pass);
            
        	
         // STEP 4.1: creazione ed esecuzione della query
            stmtls = connls.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            String sql = "SELECT * FROM sponsors WHERE username = '" +username+"'";
            ResultSet rsls = stmtls.executeQuery(sql);
            
            if (!rsls.first()) { // rs not empty
            	return null;
            }
         // riposizionamento del cursore
            rsls.first();
            
         // lettura colonne
            String usrnm = rsls.getString(u);
            String psswrd = rsls.getString(p);
            String activity = rsls.getString(a);
            String capacity = rsls.getString(c);
            String description = rsls.getString(d);
            if (!usrnm.equals(username)|| !psswrd.equals(password)) {
            	//controllo 
            	return null;
            }
         //create entity
            spon = new Sponsor(usrnm, psswrd, activity, capacity, description);
            // STEP 6: Clean-up dell'ambiente
            rsls.close();
            stmtls.close();
            
            connls.close();
        } catch (SQLException se) {
            // Errore durante l'apertura della connessione
            se.printStackTrace();
        } catch (Exception e) {
            // Errore nel loading del driver
            e.printStackTrace();
            
        } finally {
        	try {
                if (stmtls != null)
                    stmtls.close();
            } catch (SQLException se2) {
            	se2.printStackTrace();
            }
            try {
                if (connls != null)
                    connls.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
		return spon;
        	
	}
	
	public List<Sponsor> getSponsors(){
		Statement stmtGetSs = null;
        Connection connGetSs = null;
        List<Sponsor> sponsors = new ArrayList<>();
        
        try {
        	//STEP 2: loading dinamico del driver mysql
            Class.forName(driverClassName);
            
         // STEP 3: apertura connessione
            connGetSs = DriverManager.getConnection(dbUrl, user, pass);
            
            
        	
         // STEP 4.1: creazione ed esecuzione della query
            stmtGetSs = connGetSs.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            String sql = "SELECT * FROM sponsors";
            ResultSet rsGetSs = stmtGetSs.executeQuery(sql);
            
            if (!rsGetSs.first()) { // rs not empty
            	return sponsors;
            }
         // riposizionamento del cursore
            rsGetSs.first();
            do {
            	// lettura colonne
            	String name  = rsGetSs.getString("username");
            	String password = rsGetSs.getString("password");
            	String activity = rsGetSs.getString("activity");
            	String description = rsGetSs.getString("description");
            	String capacity = rsGetSs.getString("capacity");
            	
            	Sponsor spo = new Sponsor(name, password, activity, capacity, description);
            	sponsors.add(spo);
            }while(rsGetSs.next());
            
            
            
            
         // STEP 6: Clean-up dell'ambiente
            rsGetSs.close();
            stmtGetSs.close();
            connGetSs.close();
            
        } catch (SQLException se) {
            // Errore durante l'apertura della connessione
            se.printStackTrace();
        } catch (Exception e) {
            // Errore nel loading del driver
            e.printStackTrace();
            
        } finally {
        	try {
                if (stmtGetSs != null)
                    stmtGetSs.close();
            } catch (SQLException se2) {
            	se2.printStackTrace();
            }
            try {
                if (connGetSs != null)
                    connGetSs.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
		return sponsors;
        
	}
	
	public void createSSQueue(String title, String artist, String partner, String description) throws PendingRequestException {
		Statement stmtsqueue = null;
        Connection connsqueue = null;
        
        try {
        	// STEP 2: loading dinamico del driver mysql
            Class.forName(driverClassName);
            
         // STEP 3: apertura connessione
            connsqueue = DriverManager.getConnection(dbUrl, user, pass); 
            
        	
         // STEP 4.1: creazione ed esecuzione della query
            stmtsqueue = connsqueue.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY); 
        	SessionSponsor ss = SessionSponsor.getInstance();
            String host = ss.getUsername();
            String no = "no";
        	String yes ="yes";
            if(partner.equals("")) {
            	String sql = "INSERT INTO sponsored_shows_queue (host, title, partner, artist, description, approvedArtist, approvedPartner) VALUES ('" +host+"','"+title+"','"+no+"','"+artist+"','"+description+"','"+no+"','"+yes+"')";
            	stmtsqueue.executeUpdate(sql);
            }
            else {
            	String sql = "INSERT INTO sponsored_shows_queue (host, title, partner, artist, description, approvedArtist, approvedPartner) VALUES ('" +host+"','"+title+"','"+partner+"','"+artist+"','"+description+"','"+no+"','"+no+"')";
            	stmtsqueue.executeUpdate(sql);
            }
         // STEP 6: Clean-up dell'ambiente
            stmtsqueue.close();
            connsqueue.close();
        } catch (SQLException se) {
            throw new PendingRequestException("stai già contattando un artista");
        } catch (Exception e) {
            // Errore nel loading del driver
            e.printStackTrace();
            
        } finally {
        	try {
                if (stmtsqueue != null)
                    stmtsqueue.close();
            } catch (SQLException se2) {
            	se2.printStackTrace();
            }
            try {
                if (connsqueue != null)
                    connsqueue.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
		
	}
}
