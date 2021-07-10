package logic.engclasses.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import logic.engclasses.exceptions.DuplicateReviewException;
import logic.model.Review;




public class ReviewDao {
	
	private static String user = "root";
	private static String pass = "showroome";
    private static String dbUrl = "jdbc:mysql://localhost:3306/prova?autoReconnect=true&useSSL=false";
	private static String driverClassName = "com.mysql.cj.jdbc.Driver";
	
	public List<Review> getReview(String artist) {
		Statement stmtRev = null;
        Connection connRev = null;
        List<Review> r= new ArrayList<>();
        try {
        	//STEP 2: loading dinamico del driver mysql
            Class.forName(driverClassName);
            
         // STEP 3: apertura connessione
            connRev = DriverManager.getConnection(dbUrl, user, pass);
            
         // STEP 4.1: creazione ed esecuzione della query
            stmtRev = connRev.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            String sql = "SELECT * FROM reviews WHERE artist = '" +artist+"'";
            ResultSet rsRev = stmtRev.executeQuery(sql);
            
            if (!rsRev.first()) { // rs not empty
            	return r;
            }
         // riposizionamento del cursore
            rsRev.first();
            do {
            	// lettura colonne
            	String author  = rsRev.getString("author");
            	String art = rsRev.getString("artist");
            	String review = rsRev.getString("review");
            	
            	Review rev = new Review(author, art, review); //creates review entity
            	r.add(rev);
            }while(rsRev.next());
            
         // STEP 6: Clean-up dell'ambiente
            rsRev.close();
            stmtRev.close();
            connRev.close();
            
        } catch (SQLException se) {
            // Errore durante l'apertura della connessione
            se.printStackTrace();
        } catch (Exception e) {
            // Errore nel loading del driver
            e.printStackTrace();
            
        } finally {
        	try {
                if (stmtRev != null)
                    stmtRev.close();
            } catch (SQLException se2) {
            	se2.printStackTrace();
            }
            try {
                if (connRev != null)
                    connRev.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
		return r;
             
            
	}
	
	public void submitReview(String author, String artist, String review) throws DuplicateReviewException {
		// STEP 1: dichiarazioni
        Statement stmtsr = null;
        Connection connsr = null;
        
        try {
        	// STEP 2: loading dinamico del driver mysql
            Class.forName(driverClassName);
            
         // STEP 3: apertura connessione
            connsr = DriverManager.getConnection(dbUrl, user, pass); 
            
         // STEP 4.1: creazione ed esecuzione della query
            stmtsr = connsr.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY); 
        	
            String sql = "INSERT INTO reviews (author, artist, review) VALUES ('" +author+"','"+artist+"','"+review+"')";
            stmtsr.executeUpdate(sql);
         // STEP 6: Clean-up dell'ambiente
            stmtsr.close();
            connsr.close();
        } catch (SQLException se) {
            throw new DuplicateReviewException("artist already reviewed");
        } catch (Exception e) {
            // Errore nel loading del driver
            e.printStackTrace();
            
        } finally {
        	try {
                if (stmtsr != null)
                    stmtsr.close();
            } catch (SQLException se2) {
            	se2.printStackTrace();
            }
            try {
                if (connsr != null)
                    connsr.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
		
	}
}

