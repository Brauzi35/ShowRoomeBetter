package logic.engclasses.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import logic.model.Place;




public class PlaceDao {
	//passo 0, dichiaro variabili
		private static String user = "root";
		private static String pass = "showroome";
	    private static String dbUrl = "jdbc:mysql://localhost:3306/prova?autoReconnect=true&useSSL=false";
		private static String driverClassName = "com.mysql.cj.jdbc.Driver";
		
		public List<Place> getFreePlacesDao() {
			Statement stmtFrPl = null;
	        Connection connFrPl = null;
	        List<Place> freePlaces = new ArrayList<>();
	        
	        try {
	        	//STEP 2: loading dinamico del driver mysql
	            Class.forName(driverClassName);
	            
	         // STEP 3: apertura connessione
	            connFrPl = DriverManager.getConnection(dbUrl, user, pass);
	            
	            
	        	
	         // STEP 4.1: creazione ed esecuzione della query
	            stmtFrPl = connFrPl.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
	                    ResultSet.CONCUR_READ_ONLY);
	            String sql = "SELECT * FROM places WHERE free = '" +""+"'";
	            ResultSet rsFrPl = stmtFrPl.executeQuery(sql);
	            
	            if (!rsFrPl.first()) { // rs not empty
	            	return freePlaces;
	            }
	         // riposizionamento del cursore
	            rsFrPl.first();
	            do {
	            	// lettura colonne
	            	String name  = rsFrPl.getString("name");
	            	String address = rsFrPl.getString("address");
	            	int capacity = rsFrPl.getInt("capacity");
	            	
	            	Place fPlace = new Place(name, capacity, address, null); //creates place entity
	            	freePlaces.add(fPlace);
	            }while(rsFrPl.next());
	            
	            
	            
	            
	         // STEP 6: Clean-up dell'ambiente
	            rsFrPl.close();
	            stmtFrPl.close();
	            connFrPl.close();
	            
	        } catch (SQLException se) {
	            // Errore durante l'apertura della connessione
	            se.printStackTrace();
	        } catch (Exception e) {
	            // Errore nel loading del driver
	            e.printStackTrace();
	            
	        } finally {
	        	try {
	                if (stmtFrPl != null)
	                    stmtFrPl.close();
	            } catch (SQLException se2) {
	            	se2.printStackTrace();
	            }
	            try {
	                if (connFrPl != null)
	                    connFrPl.close();
	            } catch (SQLException se) {
	                se.printStackTrace();
	            }
	        }
			return freePlaces;
	        
		}
		
		public Place getPlace(String name) {
			Statement stmtgp = null;
	        Connection conngp = null;
	        Place p= null;
	        try {
	        	//STEP 2: loading dinamico del driver mysql
	            Class.forName(driverClassName);
	            
	         // STEP 3: apertura connessione
	            conngp = DriverManager.getConnection(dbUrl, user, pass);
	            
	         // STEP 4.1: creazione ed esecuzione della query
	            stmtgp = conngp.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
	                    ResultSet.CONCUR_READ_ONLY);
	            String sql = "SELECT * FROM places WHERE name = '" +name+"'";
	            ResultSet rsgp = stmtgp.executeQuery(sql);
	            
	            if (!rsgp.first()) { // rs not empty
	            	return null;
	            }
	         // riposizionamento del cursore
	            rsgp.first();
	            
	         // lettura colonne
	            int capacity = rsgp.getInt("capacity");
	            String address = rsgp.getString("address");
	            String free = rsgp.getString("free");
	         //create entity
	            p = new Place(name, capacity, address, free);
	            // STEP 6: Clean-up dell'ambiente
	            rsgp.close();
	            stmtgp.close();
	            conngp.close();
	        } catch (SQLException se) {
	            // Errore durante l'apertura della connessione
	            se.printStackTrace();
	        } catch (Exception e) {
	            // Errore nel loading del driver
	            e.printStackTrace();
	            
	        } finally {
	        	try {
	                if (stmtgp != null)
	                    stmtgp.close();
	            } catch (SQLException se2) {
	            	se2.printStackTrace();
	            }
	            try {
	                if (conngp != null)
	                    conngp.close();
	            } catch (SQLException se) {
	                se.printStackTrace();
	            }
	        }
			return p;
	        	
		}
	        
	    public void setBooked(String place, String artist) {
	    	Statement stmtsb = null;
	        Connection connsb = null;
	        
	        try {
	        	// STEP 2: loading dinamico del driver mysql
	            Class.forName(driverClassName);
	            
	         // STEP 3: apertura connessione
	            connsb = DriverManager.getConnection(dbUrl, user, pass); 
	            
	        	
	         // STEP 4.1: creazione ed esecuzione della query
	            stmtsb = connsb.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
	                    ResultSet.CONCUR_READ_ONLY); 
	            String sql = null;
	            String vuota = "";
	            if (artist.equals("")) {
	            	sql = "UPDATE Places SET free = '" + vuota + "' WHERE name = '" + place + "';";
	            }
	            else {
	            	sql = "UPDATE Places SET free = '" + artist + "' WHERE name = '" + place + "';";
	            }
	            stmtsb.executeUpdate(sql);
	         // STEP 6: Clean-up dell'ambiente
	            stmtsb.close();
	            connsb.close();
	        } catch (SQLException se) {
	            // Errore durante l'apertura della connessione
	            se.printStackTrace();
	        } catch (Exception e) {
	            // Errore nel loading del driver
	            e.printStackTrace();
	            
	        } finally {
	        	try {
	                if (stmtsb != null)
	                    stmtsb.close();
	            } catch (SQLException se2) {
	            	se2.printStackTrace();
	            }
	            try {
	                if (connsb != null)
	                    connsb.close();
	            } catch (SQLException se) {
	                se.printStackTrace();
	            }
	        }
		
	    }
	        
}
		

