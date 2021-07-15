package logic.engclasses.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import logic.engclasses.exceptions.DescriptionTooLongException;
import logic.model.SponsoredShow;




public class SponsoredShowDao {
	
	private static String user = "root";
	private static String pass = "showroome";
    private static String dbUrl = "jdbc:mysql://localhost:3306/prova?autoReconnect=true&useSSL=false";
	private static String driverClassName = "com.mysql.cj.jdbc.Driver";
	
	public SponsoredShow getSponsoredShow(String title) {
		Statement stmtgss = null;
        Connection conngss = null;
        SponsoredShow result = null;
        try {
        	//STEP 2: loading dinamico del driver mysql
            Class.forName(driverClassName);
            
         // STEP 3: apertura connessione
            conngss = DriverManager.getConnection(dbUrl, user, pass);
            
         // STEP 4.1: creazione ed esecuzione della query
            stmtgss = conngss.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            String sql = "SELECT * FROM sponsored_shows WHERE title = '" +title+"'";
            ResultSet rsgss = stmtgss.executeQuery(sql);
            
            if (!rsgss.first()) { // rs not empty
            	return null;
            }
         // riposizionamento del cursore
            rsgss.first();
            
         // lettura colonne
            String sponsor = rsgss.getString("sponsor");
            String partner = rsgss.getString("partner");
            String artist = rsgss.getString("artist");
            String description = rsgss.getString("description");
            String location = rsgss.getString("location");
            String capacity = rsgss.getString("capacity");
            
         //create entity
            result = new SponsoredShow(title, artist, sponsor, location, capacity, partner, description);
            // STEP 6: Clean-up dell'ambiente
            rsgss.close();
            stmtgss.close();
            conngss.close();
        } catch (SQLException se) {
            // Errore durante l'apertura della connessione
            se.printStackTrace();
        } catch (Exception e) {
            // Errore nel loading del driver
            e.printStackTrace();
            
        } finally {
        	try {
                if (stmtgss != null)
                    stmtgss.close();
            } catch (SQLException se2) {
            	se2.printStackTrace();
            }
            try {
                if (conngss != null)
                    conngss.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
		
		return result;
	}
		
	public void hostSponsoredShow(SponsoredShow ss) throws DescriptionTooLongException {
		Statement stmthss = null;
        Connection connhss = null;
        
        try {
        	// STEP 2: loading dinamico del driver mysql
            Class.forName(driverClassName);
            
         // STEP 3: apertura connessione
            connhss = DriverManager.getConnection(dbUrl, user, pass); 
            
        	
         // STEP 4.1: creazione ed esecuzione della query
            stmthss = connhss.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY); 
        	
            String sql = "INSERT INTO sponsored_shows (title, artist, sponsor, location, capacity, partner, description) VALUES ('" +ss.getTitle()+"','"+ss.getArtist()+"','"+ss.getSponsor()+"','"+ss.getLocation()+"','"+ss.getCapacity()+"','"+ss.getPartner()+"','"+ss.getDescription()+"')";
            stmthss.executeUpdate(sql);
         // STEP 6: Clean-up dell'ambiente
            stmthss.close();
            connhss.close();
        } catch (SQLException se) {
        	throw new DescriptionTooLongException("descrizione troppo lunga");
        } catch (Exception e) {
            // Errore nel loading del driver
            e.printStackTrace();
            
        } finally {
        	try {
                if (stmthss != null)
                    stmthss.close();
            } catch (SQLException se2) {
            	se2.printStackTrace();
            }
            try {
                if (connhss != null)
                    connhss.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
		
	}
	
	public void dismissShow(String host) {
		Statement stmtdss = null;
        Connection conndss = null;
        
        try {
        	// STEP 2: loading dinamico del driver mysql
            Class.forName(driverClassName);
            
         // STEP 3: apertura connessione
            conndss = DriverManager.getConnection(dbUrl, user, pass); 
            
        	
         // STEP 4.1: creazione ed esecuzione della query
            stmtdss = conndss.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY); 
           
            String sql = "DELETE FROM sponsored_shows WHERE sponsor = '" +host+"'";
            stmtdss.executeUpdate(sql);
         // STEP 6: Clean-up dell'ambiente
            stmtdss.close();
            conndss.close();
        } catch (SQLException se) {
            // Errore durante l'apertura della connessione
            se.printStackTrace();
        } catch (Exception e) {
            // Errore nel loading del driver
            e.printStackTrace();
            
        } finally {
        	try {
                if (stmtdss != null)
                    stmtdss.close();
            } catch (SQLException se2) {
            	se2.printStackTrace();
            }
            try {
                if (conndss != null)
                    conndss.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
	
	}
	
	public List<SponsoredShow> getSponsoredShows(){
		Statement stmtSponsored = null;
        Connection connSponsored = null;
        List<SponsoredShow> shows = new ArrayList<>();
        
        try {
        	//STEP 2: loading dinamico del driver mysql
            Class.forName(driverClassName);
            
         // STEP 3: apertura connessione
            connSponsored = DriverManager.getConnection(dbUrl, user, pass);
            
            
        	
         // STEP 4.1: creazione ed esecuzione della query
            stmtSponsored = connSponsored.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            String sql = "SELECT * FROM sponsored_shows";
            ResultSet rsSponsored = stmtSponsored.executeQuery(sql);
            
            if (!rsSponsored.first()) { // rs not empty
            	return shows;
            }
         // riposizionamento del cursore
            rsSponsored.first();
            do {
            	// lettura colonne
            	String title  = rsSponsored.getString("title");
            	String artist = rsSponsored.getString("artist");
            	String sponsor = rsSponsored.getString("sponsor");
            	String location = rsSponsored.getString("location");
            	String capacity = rsSponsored.getString("capacity");
            	String partner = rsSponsored.getString("partner");
            	String description = rsSponsored.getString("description");
            	
            	SponsoredShow ss = new SponsoredShow(title, artist, sponsor, location, capacity, partner, description);
            	shows.add(ss);
            }while(rsSponsored.next());
            
            
            
            
         // STEP 6: Clean-up dell'ambiente
            rsSponsored.close();
            stmtSponsored.close();
            connSponsored.close();
            
        } catch (SQLException se) {
            // Errore durante l'apertura della connessione
            se.printStackTrace();
        } catch (Exception e) {
            // Errore nel loading del driver
            e.printStackTrace();
            
        } finally {
        	try {
                if (stmtSponsored != null)
                    stmtSponsored.close();
            } catch (SQLException se2) {
            	se2.printStackTrace();
            }
            try {
                if (connSponsored != null)
                    connSponsored.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
		return shows;
        
	}

}
