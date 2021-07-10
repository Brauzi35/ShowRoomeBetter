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

public class LoggedSponsorController implements Initializable{

	@FXML
    private AnchorPane rootpane;

    @FXML
    private ScrollPane scroll;

    @FXML
    private AnchorPane rootpane3;

    @FXML
    private AnchorPane rootpane0;

    @FXML
    void homepageClick(MouseEvent event) {
    	//home button action
    	AnchorPane ap;
		try {
			ap = FXMLLoader.load(getClass().getResource("/logic/view/editcommercialactivity/EditCommercialActivity.fxml"));
			rootpane3.getChildren().setAll(ap);
		} catch (IOException e) {
			// Auto-generated catch block
			e.printStackTrace();
		}				
 		
    }

    @FXML
    void hostClick(MouseEvent event) {
    	//hostAShow click
    	try {
	 		AnchorPane barrafiltra = FXMLLoader.load(getClass().getResource("/logic/view/hostprivateshow/HostPrivateShow.fxml"));				
	 		rootpane3.getChildren().setAll(barrafiltra);
		}catch (IOException e1) {
	 		e1.printStackTrace();
		}
    }

    @FXML
    void reviewClick(MouseEvent event) {
    	//reviews button action
    	try {
	 		AnchorPane barrafiltra = FXMLLoader.load(getClass().getResource("/logic/boundary/Recensioni.fxml"));				
	 		rootpane3.getChildren().setAll(barrafiltra);
		}catch (IOException e1) {
	 		e1.printStackTrace();
		}
    }

    @FXML
    void settingsClick(MouseEvent event) {
    	//this shows the request info, not the setting panel
    	try {
	 		AnchorPane barrafiltra = FXMLLoader.load(getClass().getResource("/logic/view/hostprivateshow/RequestsSponsor.fxml"));				
	 		rootpane3.getChildren().setAll(barrafiltra);
		}catch (IOException e1) {
	 		e1.printStackTrace();
		}
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		rootpane0.setVisible(true);
		 AnchorPane homepageview;
			try {
				homepageview = FXMLLoader.load(getClass().getResource("/logic/view/editcommercialactivity/EditCommercialActivity.fxml"));
				rootpane3.getChildren().setAll(homepageview);
				rootpane3.setLayoutY(126);
			} catch (IOException e) {
				e.printStackTrace();
			}		
		
	}
}
