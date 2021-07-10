package logic.engclasses.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import logic.engclasses.exceptions.DescriptionTooLongException;
import logic.model.Event;




public class EventDao {
	//passo 0, dichiaro variabili
			private static String user = "root";
			private static String pass = "showroome";
		    private static String dbUrl = "jdbc:mysql://localhost:3306/prova?autoReconnect=true&useSSL=false";
			private static String driverClassName = "com.mysql.cj.jdbc.Driver";
			
			public List<Event> getLiveEvents() {
				Statement stmtLive = null;
		        Connection connLive = null;
		        List<Event> liveEvents = new ArrayList<>();
		        
		        try {
		        	//STEP 2: loading dinamico del driver mysql
		            Class.forName(driverClassName);
		            
		         // STEP 3: apertura connessione
		            connLive = DriverManager.getConnection(dbUrl, user, pass);
		            
		            
		        	
		         // STEP 4.1: creazione ed esecuzione della query
		            stmtLive = connLive.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
		                    ResultSet.CONCUR_READ_ONLY);
		            String sql = "SELECT * FROM events"; 
		            ResultSet rsLive = stmtLive.executeQuery(sql);
		            
		            if (!rsLive.first()) { // rs not empty
		            	
		            	return liveEvents;
		            }
		         // riposizionamento del cursore
		            rsLive.first();
		            do {
		            	// lettura colonne
		            	String name  = rsLive.getString("name");
		            	String place = rsLive.getString("place");
		            	String description = rsLive.getString("description");
		            	String artist = rsLive.getString("artist");
		            	Event liveEv = new Event(name, artist, description, place); //creates event entity
		            	liveEvents.add(liveEv);
		            	
		            }while(rsLive.next());
		            
		            
		            
		            
		         // STEP 6: Clean-up dell'ambiente
		            rsLive.close();
		            stmtLive.close();
		            connLive.close();
		            
		        } catch (SQLException se) {
		            // Errore durante l'apertura della connessione
		            se.printStackTrace();
		        } catch (Exception e) {
		            // Errore nel loading del driver
		            e.printStackTrace();
		            
		        } finally {
		        	try {
		                if (stmtLive != null)
		                    stmtLive.close();
		            } catch (SQLException se2) {
		            	se2.printStackTrace();
		            }
		            try {
		                if (connLive != null)
		                    connLive.close();
		            } catch (SQLException se) {
		                se.printStackTrace();
		            }
		        }
				return liveEvents;
		        
			}
			
			public void newEvent(String name, String artist, String description, String place) throws DescriptionTooLongException{
				Statement stmtNew = null;
		        Connection connNew = null;
		        
		        try {
		        	// STEP 2: loading dinamico del driver mysql
		            Class.forName(driverClassName);
		            
		         // STEP 3: apertura connessione
		            connNew = DriverManager.getConnection(dbUrl, user, pass); 
		            
		        	
		         // STEP 4.1: creazione ed esecuzione della query
		            stmtNew = connNew.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
		                    ResultSet.CONCUR_READ_ONLY); 
		        	
		            String sql = "INSERT INTO events (name, artist, description, place) VALUES ('" +name+"','"+artist+"','"+description+"','"+place+"')";
		            stmtNew.executeUpdate(sql);
		         // STEP 6: Clean-up dell'ambiente
		            stmtNew.close();
		            connNew.close();
		        } catch (SQLException se) {
		            throw new DescriptionTooLongException("descrizione troppo lunga");
		        } catch (Exception e) {
		            // Errore nel loading del driver
		            e.printStackTrace();
		            
		        } finally {
		        	try {
		                if (stmtNew != null)
		                    stmtNew.close();
		            } catch (SQLException se2) {
		            	se2.printStackTrace();
		            }
		            try {
		                if (connNew != null)
		                    connNew.close();
		            } catch (SQLException se) {
		                se.printStackTrace();
		            }
		        }
				
			}
			
			public void deleteLiveEvent(String title) {
				Statement stmtDel = null;
		        Connection connDel = null;
		        
		        try {
		        	// STEP 2: loading dinamico del driver mysql
		            Class.forName(driverClassName);
		            
		         // STEP 3: apertura connessione
		            connDel = DriverManager.getConnection(dbUrl, user, pass); 
		            
		        	
		         // STEP 4.1: creazione ed esecuzione della query
		            stmtDel = connDel.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
		                    ResultSet.CONCUR_READ_ONLY); 
		        	
		            String sql = "DELETE FROM events WHERE name = '" +title+"'";
		            stmtDel.executeUpdate(sql);
		         // STEP 6: Clean-up dell'ambiente
		            stmtDel.close();
		            connDel.close();
		        } catch (SQLException se) {
		            // Errore durante l'apertura della connessione
		            se.printStackTrace();
		        } catch (Exception e) {
		            // Errore nel loading del driver
		            e.printStackTrace();
		            
		        } finally {
		        	try {
		                if (stmtDel != null)
		                    stmtDel.close();
		            } catch (SQLException se2) {
		            	se2.printStackTrace();
		            }
		            try {
		                if (connDel != null)
		                    connDel.close();
		            } catch (SQLException se) {
		                se.printStackTrace();
		            }
		        }
			
			}
			
			public Event getEvent(String artist) {
				Statement evStmt = null;
		        Connection evConn = null;
		        Event e= null;
		        try {
		        	//STEP 2: loading dinamico del driver mysql
		            Class.forName(driverClassName);
		            
		         // STEP 3: apertura connessione
		            evConn = DriverManager.getConnection(dbUrl, user, pass);
		            
		         // STEP 4.1: creazione ed esecuzione della query
		            evStmt = evConn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
		                    ResultSet.CONCUR_READ_ONLY);
		            String sql = "SELECT * FROM events WHERE artist = '" +artist+"'";
		            ResultSet evRs = evStmt.executeQuery(sql);
		            
		            if (!evRs.first()) { // rs not empty
		            	return null;
		            }
		         // riposizionamento del cursore
		            evRs.first();
		            
		         // lettura colonne
		            String name  = evRs.getString("name");
	            	String place = evRs.getString("place");
	            	String description = evRs.getString("description");
	            	String art = evRs.getString("artist");
		         //create entity
		            e = new Event(name, art, description, place);
		            // STEP 6: Clean-up dell'ambiente
		            evRs.close();
		            evStmt.close();
		            evConn.close();
		        } catch (SQLException se) {
		            // Errore durante l'apertura della connessione
		            se.printStackTrace();
		        } catch (Exception e1) {
		            // Errore nel loading del driver
		            e1.printStackTrace();
		            
		        } finally {
		        	try {
		                if (evStmt != null)
		                	evStmt.close();
		            } catch (SQLException se2) {
		            	se2.printStackTrace();
		            }
		            try {
		                if (evConn != null)
		                	evConn.close();
		            } catch (SQLException se) {
		                se.printStackTrace();
		            }
		        }
				return e;
			}

}
