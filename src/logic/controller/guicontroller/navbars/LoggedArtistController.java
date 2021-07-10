package logic.controller.guicontroller.navbars;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;


public class LoggedArtistController implements Initializable{

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
    	AnchorPane ap = FXMLLoader.load(getClass().getResource("/logic/view/viewprofile/ViewYourProfile.fxml"));
    	longPane.setMaxHeight(ap.getHeight());
		longPane.setPrefHeight(ap.getHeight());
		longPane.setMinHeight(ap.getHeight());
 		rootpane3.getChildren().setAll(ap);
    }

    @FXML
    void mapClick(MouseEvent event) {
    	//map button action
    	try {
	 		AnchorPane ap = FXMLLoader.load(getClass().getResource("/logic/view/bookplaceandcreateevent/BookPlaceAndCreateEvent.fxml"));		
	 		longPane.setMaxHeight(1000);
			longPane.setPrefHeight(1000);
			longPane.setMinHeight(1000);
	 		rootpane3.getChildren().setAll(ap);
		}catch (IOException e1) {
	 		e1.printStackTrace();
		}
    }

    @FXML
    void reviewClick(MouseEvent event) {
    	//review button action
    	try {
	 		AnchorPane ap = FXMLLoader.load(getClass().getResource("/logic/view/viewreviews/ViewReviews.fxml"));			
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
	 		AnchorPane ap = FXMLLoader.load(getClass().getResource("/logic/view/checkpersonalmessages/CheckPersonalMessages.fxml"));		
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
		 AnchorPane homepageview;
			try {
				homepageview = FXMLLoader.load(getClass().getResource("/logic/view/viewprofile/ViewYourProfile.fxml"));
				longPane.setMaxHeight(homepageview.getHeight());
				longPane.setPrefHeight(homepageview.getHeight());
				longPane.setMinHeight(homepageview.getHeight());
				rootpane3.getChildren().setAll(homepageview);
				rootpane3.setLayoutY(126);
			} catch (IOException e) {
				e.printStackTrace();
			}			
		
	}

	
}
