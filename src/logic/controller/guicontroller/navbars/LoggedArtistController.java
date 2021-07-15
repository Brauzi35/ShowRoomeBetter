package logic.controller.guicontroller.navbars;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import logic.controller.guicontroller.bookplaceandcreateevent.ControllerGuiBookAPlaceAndCreateAnEvent;
import logic.controller.guicontroller.checkpersonalmessages.GuiControllerCheckPersonalMessages;
import logic.controller.guicontroller.login.GuiControllerLogin;
import logic.controller.guicontroller.viewprofile.GuiControllerViewYourProfile;
import logic.controller.guicontroller.viewreviews.GuiControllerViewReviews;
import logic.engclasses.bean.LoggedBean;
import logic.engclasses.utils.Session;


public class LoggedArtistController implements Initializable{
    
	protected Session bs2;
	protected LoggedBean lb2;
	 public LoggedArtistController(Session bs2){
	 	this.bs2 = bs2;
	 	lb2=bs2.getLoggedBean();
	 }
	
	@FXML
    private Button logoutArtist;
    
    @FXML
    private AnchorPane rootpane;

    @FXML
    private ScrollPane scroll;

    @FXML
    private AnchorPane rootpane3;
    
    @FXML
    private AnchorPane longPane;

    @FXML
    private AnchorPane rootpane0;

    @FXML
    void homepageClick(MouseEvent event) throws IOException {
    	//home button action
    	
 		
 		FXMLLoader loader01=new FXMLLoader(getClass().getResource("/logic/view/viewprofile/ViewYourProfile.fxml"));
		GuiControllerViewYourProfile gvp1 = new GuiControllerViewYourProfile(bs2);
 		loader01.setController(gvp1);
 		AnchorPane ap = loader01.load();
		longPane.setMaxHeight(ap.getHeight());
		longPane.setPrefHeight(ap.getHeight());
		longPane.setMinHeight(ap.getHeight());
		rootpane3.getChildren().setAll(ap);
    }

    @FXML
    void mapClick(MouseEvent event) {
    	//map button action
    	try {
    		FXMLLoader loader02=new FXMLLoader(getClass().getResource("/logic/view/bookplaceandcreateevent/BookPlaceAndCreateEvent.fxml"));
    		ControllerGuiBookAPlaceAndCreateAnEvent cgbp = new ControllerGuiBookAPlaceAndCreateAnEvent(bs2);
    		loader02.setController(cgbp);
	 		AnchorPane ap = loader02.load();		
	 		longPane.setMaxHeight(1000);
			longPane.setPrefHeight(1000);
			longPane.setMinHeight(1000);
	 		rootpane3.getChildren().setAll(ap);
		}catch (IOException e1) {
	 		e1.printStackTrace();
		}
    }

    @FXML
    void logoutArtistClick(ActionEvent event) throws IOException {
    	GuiControllerLogin g = new GuiControllerLogin();
    	FXMLLoader ldr=new FXMLLoader(getClass().getResource("/logic/view/login/Login.fxml"));
		ldr.setController(g);
		Scene scn=new Scene(ldr.load());
		Stage stg = (Stage)((Node) event.getSource()).getScene().getWindow();
		stg.setScene(scn);
		stg.show();
    }

    
    @FXML
    void reviewClick(MouseEvent event) {
    	//review button action
    	try {
    		FXMLLoader loader03=new FXMLLoader(getClass().getResource("/logic/view/viewreviews/ViewReviews.fxml"));
    		GuiControllerViewReviews gcvr = new GuiControllerViewReviews(bs2);
    		loader03.setController(gcvr);
	 		AnchorPane ap = loader03.load();
	 		longPane.setMaxHeight(ap.getHeight());
			longPane.setPrefHeight(ap.getHeight());
			longPane.setMinHeight(ap.getHeight());
	 		rootpane3.getChildren().setAll(ap);
		}catch (IOException e1) {
	 		e1.printStackTrace();
		}
    }

    @FXML
    void settingsClick(MouseEvent event) {
    	//settings is the wrong name , this loads the request page
    	try {
    		FXMLLoader loader04=new FXMLLoader(getClass().getResource("/logic/view/checkpersonalmessages/CheckPersonalMessages.fxml"));
    		GuiControllerCheckPersonalMessages gcpm = new GuiControllerCheckPersonalMessages(bs2);
    		loader04.setController(gcpm);
	 		AnchorPane ap = loader04.load();		
	 		longPane.setMaxHeight(ap.getHeight());
			longPane.setPrefHeight(ap.getHeight());
			longPane.setMinHeight(ap.getHeight());
	 		rootpane3.getChildren().setAll(ap);
		}catch (IOException e1) {
	 		e1.printStackTrace();
		}
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
   	 rootpane0.setVisible(true);
		
			try {
				FXMLLoader loader0=new FXMLLoader(getClass().getResource("/logic/view/viewprofile/ViewYourProfile.fxml"));
	    		GuiControllerViewYourProfile gvp = new GuiControllerViewYourProfile(bs2);
		 		loader0.setController(gvp);
		 		Parent root = loader0.load();
				rootpane3.getChildren().setAll(root);
			} catch (IOException e) {
				e.printStackTrace();
			}			
		
	}

	
}
