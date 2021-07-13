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
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import logic.controller.guicontroller.editcommercialactivity.GuiControllerEditCommercialActivity;
import logic.controller.guicontroller.hostprivateshow.GuiControllerHostPrivateShow;
import logic.controller.guicontroller.hostprivateshow.GuiControllerRequestsSponsor;
import logic.controller.guicontroller.login.GuiControllerLogin;
import logic.engclasses.bean.LoggedBean;
import logic.engclasses.utils.Session;

public class LoggedSponsorController implements Initializable{

	protected Session bs3;
	protected LoggedBean lb3;
	 public LoggedSponsorController(Session bs3){
	 	this.bs3 = bs3;
	 	lb3=bs3.getLoggedBean();
	 }
	
	@FXML
    private AnchorPane rootpane;

	@FXML
    private Button logoutSponsor;
	
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
			FXMLLoader loader12=new FXMLLoader(getClass().getResource("/logic/view/editcommercialactivity/EditCommercialActivity.fxml"));
			GuiControllerEditCommercialActivity gcea = new GuiControllerEditCommercialActivity(bs3);
			loader12.setController(gcea);
			ap = loader12.load();
			rootpane3.getChildren().setAll(ap);
		} catch (IOException e) {
			// Auto-generated catch block
			e.printStackTrace();
		}				
 		
    }

    
    @FXML
    void logoutSponsorClick(ActionEvent event) throws IOException {
    	GuiControllerLogin gc = new GuiControllerLogin();
    	FXMLLoader load=new FXMLLoader(getClass().getResource("/logic/view/login/Login.fxml"));
		load.setController(gc);
		Scene sc=new Scene(load.load());
		Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
		stage.setScene(sc);
		stage.show();
    	
    	
    }
    
    @FXML
    void hostClick(MouseEvent event) {
    	//hostAShow click
    	try {
    		FXMLLoader loader13=new FXMLLoader(getClass().getResource("/logic/view/hostprivateshow/HostPrivateShow.fxml"));
    		GuiControllerHostPrivateShow gcps = new GuiControllerHostPrivateShow(bs3);
			loader13.setController(gcps);
	 		AnchorPane barrafiltra = loader13.load();				
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
    		FXMLLoader loader14=new FXMLLoader(getClass().getResource("/logic/view/hostprivateshow/RequestsSponsor.fxml"));
    		GuiControllerRequestsSponsor gcrs = new GuiControllerRequestsSponsor(bs3);
			loader14.setController(gcrs);
	 		AnchorPane barrafiltra = loader14.load();				
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
				FXMLLoader loader11=new FXMLLoader(getClass().getResource("/logic/view/editcommercialactivity/EditCommercialActivity.fxml"));
				GuiControllerEditCommercialActivity gcea = new GuiControllerEditCommercialActivity(bs3);
				loader11.setController(gcea);
				homepageview = loader11.load();
				rootpane3.getChildren().setAll(homepageview);
				rootpane3.setLayoutY(126);
			} catch (IOException e) {
				e.printStackTrace();
			}		
		
	}
}
