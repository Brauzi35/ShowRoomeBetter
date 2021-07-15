package logic.controller.guicontroller.navbars;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import logic.controller.guicontroller.login.GuiControllerLogin;
import logic.controller.guicontroller.reviewanartist.GuiControllerReviewAnArtist;
import logic.engclasses.bean.LoggedBean;
import logic.engclasses.utils.Session;



public class LoggedUserController implements Initializable{
	
	protected Session bs;
	protected LoggedBean lb;
	 public LoggedUserController(Session bs){
	 	this.bs = bs;
	 	lb=bs.getLoggedBean();
	 }
	 
	

	@FXML
	private AnchorPane rootpaneLong;

	@FXML
    private AnchorPane rootpane;

    @FXML
    private ScrollPane scroll;

    @FXML
    private AnchorPane rootpane2;

    @FXML
    private AnchorPane rootpane3;

    @FXML
    private AnchorPane rootpane0;
    
    @FXML
    private Label usernameLabel;

    @FXML
    private Button logoutButton;

    @FXML
    void cariHome(MouseEvent event){
    	//home button action
    	AnchorPane barrafiltra;
		try {
			barrafiltra = FXMLLoader.load(getClass().getResource("/logic/boundary/Homepage.fxml"));
			rootpane3.getChildren().setAll(barrafiltra);
	 		rootpaneLong.setMaxHeight(barrafiltra.getHeight());
			rootpaneLong.setPrefHeight(barrafiltra.getHeight());
			rootpaneLong.setMinHeight(barrafiltra.getHeight());
		} catch (IOException e) {
			
			e.printStackTrace();
		}	
 		
    }

    @FXML
    void caricafiltra(MouseEvent event) {
    	//filter  bar
    	if(!rootpane2.isVisible()) {
    		 try {
    			//when not visible
    			AnchorPane barrafiltra = FXMLLoader.load(getClass().getResource("/logic/boundary/filtra.fxml"));				
    	 		rootpane2.getChildren().setAll(barrafiltra);
    	 			rootpane2.setVisible(true);
    	 			rootpane3.setLayoutY(195);
    		}catch (IOException e1) {
    	 		e1.printStackTrace();
    	 				
    	 		}
    	 }
    		 else {
    			 //when visible
    			 rootpane2.setVisible(false);
    				rootpane3.setLayoutY(126);
    		 
    		 }
    }

    @FXML
    void caricamappa(MouseEvent event) {
    	//map button action
    	try {
    		FXMLLoader loader0=new FXMLLoader(getClass().getResource("/logic/view/findliveevent/FindLiveEvent.fxml"));
    		AnchorPane mappa = loader0.load();
	 		rootpane3.getChildren().setAll(mappa);
	 		rootpaneLong.setMaxHeight(1000);
			rootpaneLong.setPrefHeight(1000);
			rootpaneLong.setMinHeight(1000);
		}catch (IOException e1) {
	 		e1.printStackTrace();
		}
    }

    @FXML
    void carirecensioni(MouseEvent event) {
    	//reviews button action
    	try {
    		FXMLLoader loader1=new FXMLLoader(getClass().getResource("/logic/view/reviewanartist/ReviewAnArtist.fxml"));
    		GuiControllerReviewAnArtist gra = new GuiControllerReviewAnArtist(bs);
	 		loader1.setController(gra);
	 		AnchorPane barrafiltra = loader1.load();
	 		rootpane3.getChildren().setAll(barrafiltra);
	 		rootpaneLong.setMaxHeight(barrafiltra.getHeight());
			rootpaneLong.setPrefHeight(barrafiltra.getHeight());
			rootpaneLong.setMinHeight(barrafiltra.getHeight());
		}catch (IOException e1) {
	 		e1.printStackTrace();
		}
    }

    @FXML
    void carisettings(MouseEvent event) {
    	//setting button action
    	try {
    		
	 		AnchorPane barrafiltra = FXMLLoader.load(getClass().getResource("/logic/boundary/SponsoredShowsUser.fxml"));
	 		rootpane3.getChildren().setAll(barrafiltra);
	 		rootpaneLong.setMaxHeight(barrafiltra.getHeight());
			rootpaneLong.setPrefHeight(barrafiltra.getHeight());
			rootpaneLong.setMinHeight(barrafiltra.getHeight());
		}catch (IOException e1) {
	 		e1.printStackTrace();
		}
    }

    
    @FXML
    void logoutClick(ActionEvent event) throws IOException {
    	GuiControllerLogin gcl = new GuiControllerLogin();
    	FXMLLoader loader=new FXMLLoader(getClass().getResource("/logic/view/login/Login.fxml"));
		loader.setController(gcl);
		Scene scene=new Scene(loader.load());
		Stage st = (Stage)((Node) event.getSource()).getScene().getWindow();
		st.setScene(scene);
		st.show();
    }
    
    @FXML
    void loadlogin(MouseEvent event) {
    	//
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		usernameLabel.setText(lb.getUsername());
		//gianmattia
    	 rootpane0.setVisible(false);
    	 rootpane2.setVisible(false);
    	 rootpane0.setVisible(true);
		 AnchorPane homepageview;
			try {
				homepageview = FXMLLoader.load(getClass().getResource("/logic/view/findliveevent/FindLiveEvent.fxml"));
				rootpaneLong.setMaxHeight(1000);
				rootpaneLong.setPrefHeight(1000);
				rootpaneLong.setMinHeight(1000);
				rootpane3.getChildren().setAll(homepageview);
				rootpane3.setLayoutY(126);
			} catch (IOException e) {
				e.printStackTrace();
			}				
			
		
	}

}
