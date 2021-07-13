package logic.controller.guicontroller.hostprivateshow;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import logic.controller.appcontroller.HostPrivateShow;
import logic.engclasses.bean.LoggedBean;
import logic.engclasses.dao.SponsorDao;
import logic.engclasses.exceptions.ExceptionView;
import logic.engclasses.exceptions.PendingRequestException;
import logic.engclasses.utils.ExceptionFactory;
import logic.engclasses.utils.Session;
import logic.engclasses.utils.TypeException;


public class GuiControllerHostPrivateShow implements Initializable {
	
	protected Session bsps;
	protected LoggedBean lbps;
	 public GuiControllerHostPrivateShow(Session bsps){
	 	this.bsps = bsps;
	 	lbps=bsps.getLoggedBean();
	 }
	
	@FXML
    private AnchorPane rootpane5;

    @FXML
    private AnchorPane mainPane;

    @FXML
    private ListView<String> listViewArtists; //cambiato ? con String

    @FXML
    private AnchorPane artistPane;

    @FXML
    private Label descriptionArtistlabel;

    @FXML
    private ListView<String> listViewSponsor;

    @FXML
    private Button sendRequestButton;

    @FXML
    private Label partnerLabel;
    
    @FXML
    private TextField titleTextBox;

    @FXML
    private TextArea descriptionTextBox;

    @FXML
    void sendRequest(ActionEvent event) throws IOException {
   	 //this sends a request to the partner and to the artist selected, that when approved becomes a SponsoredShow
   	 String artist = listViewArtists.getSelectionModel().getSelectedItem();
   	 String title = titleTextBox.getText();
   	 String description = descriptionTextBox.getText();
   	 String partner = partnerLabel.getText();
   	 SponsorDao sd = new SponsorDao();
   	 try {
			sd.createSSQueue(lbps.getUsername(), title, artist, partner, description);
		} catch (PendingRequestException e) {
			ExceptionFactory exf = ExceptionFactory.getInstance();
			ExceptionView ev;
			ev = exf.createView(TypeException.SSQUEUE);
			rootpane5.getChildren().setAll(ev.getRoot());
		}
	    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		//fill listViewArtists
		HostPrivateShow hssc = new HostPrivateShow();
		listViewArtists.getItems().addAll(hssc.buildArtistStringArray());
		listViewArtists.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
				//this listener method makes the description of the selected artist appear in the description pane
				String description;
				description=hssc.getDescription(listViewArtists.getSelectionModel().getSelectedItem());
				descriptionArtistlabel.setText(description);
				
			}
			
		});
		//fill listViewSponsor
		listViewSponsor.getItems().addAll(hssc.buildSponsorStringArray(lbps.getUsername()));
		listViewSponsor.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
				partnerLabel.setText(listViewSponsor.getSelectionModel().getSelectedItem());
				
			}
			
		});
	}	
}
