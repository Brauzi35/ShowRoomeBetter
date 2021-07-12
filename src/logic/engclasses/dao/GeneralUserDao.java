package logic.engclasses.dao;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import logic.engclasses.exceptions.DuplicateUsernameException;
import logic.engclasses.exceptions.LoginException;
import logic.model.GeneralUser;




public class GeneralUserDao {
	/*
	 * 1) Caricare il Driver
	 * 2) Aprire una Connessione al Database
	 * 3) Creare un Oggetto Statement
	 * 4) Interagire con il Database
	 * 5) Gestire e visualizzare i risultati ottenuti dalle ResultSet.
	 */
	//passo 0, dichiaro variabili
	private static String user = "root";
	private static String pass = "showroome";
    private static String dbUrl = "jdbc:mysql://localhost:3306/prova?autoReconnect=true&useSSL=false";
	private static String driverClassName = "com.mysql.cj.jdbc.Driver";
	
	
	
	public GeneralUser login(String username1, String password) throws LoginException{
		// STEP 1: dichiarazioni
        Statement stmtLog = null;
        Connection connLog = null;
        GeneralUser u= null;
        
        try {
        	//STEP 2: loading dinamico del driver mysql
            Class.forName(driverClassName);
            
         // STEP 3: apertura connessione
            connLog = DriverManager.getConnection(dbUrl, user, pass);
            
         // STEP 4.1: creazione ed esecuzione della query
            stmtLog = connLog.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            String sql = "SELECT * FROM users WHERE username = '" +username1+"'";
            ResultSet rsLog = stmtLog.executeQuery(sql);
            
            if (!rsLog.first()) { // rs not empty
            	throw new LoginException("errore nel login (dao)");
            }
            
         // riposizionamento del cursore
            rsLog.first();
                        
         // lettura colonne
            String usrnm = rsLog.getString("username");
            String psswrd = rsLog.getString("password");
            int id = rsLog.getInt("idusers");
            
            if (!usrnm.equals(username1)|| !psswrd.equals(password)) {
            	return null;
            }
            
            u = new GeneralUser(usrnm, psswrd, id);
         // STEP 6: Clean-up dell'ambiente
            rsLog.close();
            stmtLog.close();
            connLog.close();
        } catch (SQLException se) {
            // Errore durante l'apertura della connessione
        	se.printStackTrace();
        } catch (Exception e) {
            // Errore nel loading del driver
            e.printStackTrace();
            
        } finally {
        	try {
                if (stmtLog != null)
                    stmtLog.close();
            } catch (SQLException se2) {
            	se2.printStackTrace();
            }
            try {
                if (connLog != null)
                    connLog.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
		return u;
        
	}
	
	public void register(int iduser, String username, String password) throws DuplicateUsernameException {
		
		// STEP 1: dichiarazioni
        Statement stmtRegUs = null;
        Connection connRegUs = null;
        
        try {
        	// STEP 2: loading dinamico del driver mysql
            Class.forName(driverClassName);
            
         // STEP 3: apertura connessione
            connRegUs = DriverManager.getConnection(dbUrl, user, pass); 
            
        	
         // STEP 4.1: creazione ed esecuzione della query
            stmtRegUs = connRegUs.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY); 
        	
            String sql = "INSERT INTO users (idusers, username, password) VALUES ('" +iduser+"','"+username+"','"+password+"')";
            stmtRegUs.executeUpdate(sql);
         // STEP 6: Clean-up dell'ambiente
            stmtRegUs.close();
            connRegUs.close();
        } catch (SQLException se) {
        	throw new DuplicateUsernameException("username gia' in uso");
        } catch (Exception e) {
            // Errore nel loading del driver
            e.printStackTrace();
            
        } finally {
        	try {
                if (stmtRegUs != null)
                    stmtRegUs.close();
            } catch (SQLException se2) {
            	se2.printStackTrace();
            }
            try {
                if (connRegUs != null)
                    connRegUs.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
		
	}
	
	public int getMaxId() {
		// STEP 1: dichiarazioni
        Statement stmtMax = null;
        Connection connMax = null;
        Random rand;
        int i=9999;
		try {
			rand = SecureRandom.getInstanceStrong();
			i = rand.nextInt(9000);
		} catch (NoSuchAlgorithmException e1) {
			e1.printStackTrace();
		}  
        
        try {
        	//STEP 2: loading dinamico del driver mysql
            Class.forName(driverClassName);
            
         // STEP 3: apertura connessione
            connMax = DriverManager.getConnection(dbUrl, user, pass);
            
         // STEP 4.1: creazione ed esecuzione della query
            stmtMax = connMax.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            String sql = "SELECT MAX(idusers) FROM users";
            ResultSet rsMax = stmtMax.executeQuery(sql);
            
            if (!rsMax.first()) { // rs not empty
            	//i starts randomized so that if anything happens it's probable that there won't be any double
            	return i;
            }
         // riposizionamento del cursore
            rsMax.first();
                        
         // lettura colonne
            
            i = rsMax.getInt(1);
            
         // STEP 6: Clean-up dell'ambiente
            rsMax.close();
            stmtMax.close();
            connMax.close();
        } catch (SQLException se) {
            // Errore durante l'apertura della connessione
            se.printStackTrace();
        } catch (Exception e) {
            // Errore nel loading del driver
            e.printStackTrace();
            
        } finally {
        	try {
                if (stmtMax != null)
                    stmtMax.close();
            } catch (SQLException se2) {
            	se2.printStackTrace();
            }
            try {
                if (connMax != null)
                    connMax.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
		return i;
        
	}
}
