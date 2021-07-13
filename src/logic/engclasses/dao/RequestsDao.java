package logic.engclasses.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import logic.model.RequestedShow;



public class RequestsDao {
	private static String user = "root";
	private static String pass = "showroome";
    private static String dbUrl = "jdbc:mysql://localhost:3306/prova?autoReconnect=true&useSSL=false";
	private static String driverClassName = "com.mysql.cj.jdbc.Driver";
	
	//string declared for code smell avoidance
	String h = "host";
    String t ="title";
    String p = "partner";
    String ar = "artist";
    String d = "description";
    String apAr = "approvedArtist";
    String apPa = "approvedPartner";
	
	public RequestedShow getQueuedShow(String username) {
		Statement stmtgq = null;
        Connection conngq = null;
        RequestedShow resultgq = null;
        try {
        	//STEP 2: loading dinamico del driver mysql
            Class.forName(driverClassName);
            
         // STEP 3: apertura connessione
            conngq = DriverManager.getConnection(dbUrl, user, pass);
            
         // STEP 4.1: creazione ed esecuzione della query
            stmtgq = conngq.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            String sql = "SELECT * FROM sponsored_shows_queue WHERE host = '" +username+"'";
            ResultSet rsgq = stmtgq.executeQuery(sql);
            
            if (!rsgq.first()) { // rs not empty
            	return null;
            }
         // riposizionamento del cursore
            rsgq.first();
            
         // lettura colonne
            String hostgq = rsgq.getString(h);
            String titlegq = rsgq.getString(t);
            String partnergq = rsgq.getString(p);
            String artistgq = rsgq.getString(ar);
            String descriptiongq = rsgq.getString(d);
            String approvedArtistgq = rsgq.getString(apAr);
            String approvedPartnergq = rsgq.getString(apPa);
            
         //create entity
            resultgq = new RequestedShow(hostgq, titlegq, partnergq, artistgq, descriptiongq, approvedArtistgq, approvedPartnergq);
            // STEP 6: Clean-up dell'ambiente
            rsgq.close();
            stmtgq.close();
            
            conngq.close();
        } catch (SQLException se) {
            // Errore durante l'apertura della connessione
            se.printStackTrace();
        } catch (Exception e) {
            // Errore nel loading del driver
            e.printStackTrace();
            
        } finally {
        	try {
                if (stmtgq != null)
                    stmtgq.close();
            } catch (SQLException se2) {
            	se2.printStackTrace();
            }
            try {
                if (conngq != null)
                    conngq.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
		
		return resultgq;
	}
	
	public RequestedShow getQueuedShowByTitle(String title) {
		Statement stmtqt = null;
        Connection connqt = null;
        RequestedShow resultqt = null;
        try {
        	//STEP 2: loading dinamico del driver mysql
            Class.forName(driverClassName);
            
         // STEP 3: apertura connessione
            connqt = DriverManager.getConnection(dbUrl, user, pass);
            
         // STEP 4.1: creazione ed esecuzione della query
            stmtqt = connqt.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            String sql = "SELECT * FROM sponsored_shows_queue WHERE title = '" +title+"'";
            ResultSet rsqt = stmtqt.executeQuery(sql);
            
            if (!rsqt.first()) { // rs not empty
            	return null;
            }
         // riposizionamento del cursore
            rsqt.first();
            
         // lettura colonne
            
            String hostqt = rsqt.getString(h);
            String partnerqt = rsqt.getString(p);
            String artistqt = rsqt.getString(ar);
            String descriptionqt = rsqt.getString(d);
            String approvedArtistqt = rsqt.getString(apAr);
            String approvedPartnerqt = rsqt.getString(apPa);
         //create entity
            resultqt = new RequestedShow(hostqt, title, partnerqt, artistqt, descriptionqt, approvedArtistqt, approvedPartnerqt);
            // STEP 6: Clean-up dell'ambiente
            rsqt.close();
            stmtqt.close();
            
            connqt.close();
        } catch (SQLException se) {
            // Errore durante l'apertura della connessione
            se.printStackTrace();
        } catch (Exception e) {
            // Errore nel loading del driver
            e.printStackTrace();
            
        } finally {
        	try {
                if (stmtqt != null)
                    stmtqt.close();
            } catch (SQLException se2) {
            	se2.printStackTrace();
            }
            try {
                if (connqt != null)
                    connqt.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
		
		return resultqt;
	}
	
	public List<RequestedShow> getRequests(String art){
		Statement stmtgr = null;
        Connection conngr = null;
        List<RequestedShow> lrs = new ArrayList<>();
        
        try {
        	//STEP 2: loading dinamico del driver mysql
            Class.forName(driverClassName);
            
         // STEP 3: apertura connessione
            conngr = DriverManager.getConnection(dbUrl, user, pass);
            
            
        	
         // STEP 4.1: creazione ed esecuzione della query
            stmtgr = conngr.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            String sql = "SELECT * FROM sponsored_shows_queue WHERE artist = '" +art+"'";
            ResultSet rsgr = stmtgr.executeQuery(sql);
            
            if (!rsgr.first()) { // rs not empty
            	return lrs;
            }
         // riposizionamento del cursore
            rsgr.first();
            do {
            	// lettura colonne
            	 String host = rsgr.getString(h);
                 String title = rsgr.getString(t);
                 String partner = rsgr.getString(p);
                 String artist = rsgr.getString(ar);
                 String description = rsgr.getString(d);
                 String approvedArtist = rsgr.getString(apAr);
                 String approvedPartner = rsgr.getString(apPa);
            	
            	RequestedShow rqsh = new RequestedShow(host, title, partner, artist, description, approvedArtist, approvedPartner);
            	lrs.add(rqsh);
            }while(rsgr.next());
            
            
            
            
         // STEP 6: Clean-up dell'ambiente
            rsgr.close();
            stmtgr.close();
            conngr.close();
            
        } catch (SQLException se) {
            // Errore durante l'apertura della connessione
            se.printStackTrace();
        } catch (Exception e) {
            // Errore nel loading del driver
            e.printStackTrace();
            
        } finally {
        	try {
                if (stmtgr != null)
                    stmtgr.close();
            } catch (SQLException se2) {
            	se2.printStackTrace();
            }
            try {
                if (conngr != null)
                    conngr.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
		return lrs;
        
	}
	
	public void updateApprovedArtist(String title, String state) {
		Statement stmtua = null;
        Connection connua = null;
        
        try {
        	// STEP 2: loading dinamico del driver mysql
            Class.forName(driverClassName);
            
         // STEP 3: apertura connessione
            connua = DriverManager.getConnection(dbUrl, user, pass); 
            
        	
         // STEP 4.1: creazione ed esecuzione della query
            stmtua = connua.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY); 
            String sql = "UPDATE sponsored_shows_queue SET approvedArtist = '" + state + "' WHERE title = '" + title + "';";
        	stmtua.executeUpdate(sql);
            
         // STEP 6: Clean-up dell'ambiente
            stmtua.close();
            connua.close();
        } catch (SQLException se) {
            // Errore durante l'apertura della connessione
            se.printStackTrace();
        } catch (Exception e) {
            // Errore nel loading del driver
            e.printStackTrace();
            
        } finally {
        	try {
                if (stmtua != null)
                    stmtua.close();
            } catch (SQLException se2) {
            	se2.printStackTrace();
            }
            try {
                if (connua != null)
                    connua.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
	
    }
	
	public void deleteRequest(String host) {
		Statement stmtdr = null;
        Connection conndr = null;
        
        try {
        	// STEP 2: loading dinamico del driver mysql
            Class.forName(driverClassName);
            
         // STEP 3: apertura connessione
            conndr = DriverManager.getConnection(dbUrl, user, pass); 
            
        	
         // STEP 4.1: creazione ed esecuzione della query
            stmtdr = conndr.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY); 
            String sql = "DELETE FROM sponsored_shows_queue WHERE host = '" +host+"'";
            stmtdr.executeUpdate(sql);
         // STEP 6: Clean-up dell'ambiente
            stmtdr.close();
            conndr.close();
        } catch (SQLException se) {
            // Errore durante l'apertura della connessione
            se.printStackTrace();
        } catch (Exception e) {
            // Errore nel loading del driver
            e.printStackTrace();
            
        } finally {
        	try {
                if (stmtdr != null)
                    stmtdr.close();
            } catch (SQLException se2) {
            	se2.printStackTrace();
            }
            try {
                if (conndr != null)
                    conndr.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
	
	}
	
}
