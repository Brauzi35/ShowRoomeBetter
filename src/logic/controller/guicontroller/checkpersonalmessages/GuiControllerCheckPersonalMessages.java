package logic.controller.guicontroller.checkpersonalmessages;

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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import logic.controller.appcontroller.CheckPersonalMessages;
import logic.engclasses.bean.LoggedBean;
import logic.engclasses.bean.RequestedShowBean;
import logic.engclasses.bean.SponsorBean;
import logic.engclasses.utils.Session;

public class GuiControllerCheckPersonalMessages implements Initializable{

	protected Session bspm;
	protected LoggedBean lbpm;
	 public GuiControllerCheckPersonalMessages(Session bspm){
	 	this.bspm = bspm;
	 	lbpm=bspm.getLoggedBean();
	 }
	
	@FXML
    private AnchorPane rootpane7;

    @FXML
    private ListView<String> listViewRequests;

    @FXML
    private Label titleLabel;

    @FXML
    private Label sponsorLabel;

    @FXML
    private Label descriptionShowLabel;

    @FXML
    private Label descriptionSponsorLabel;

    @FXML
    private Pane acceptedPane;

    @FXML
    private Pane refusedPane;
    
    @FXML
    private Button declineButton;

    @FXML
    private Button acceptButton;

    @FXML
    private Label acivityLabel;

    @FXML
    private Label capacityLabel;
    
    @FXML
    private Pane norequestsPane;

    
    public void setInvisible() {
    	titleLabel.setVisible(false);
		sponsorLabel.setVisible(false);
		descriptionShowLabel.setVisible(false);
		descriptionSponsorLabel.setVisible(false);
		declineButton.setVisible(false);
		acceptButton.setVisible(false);
		acivityLabel.setVisible(false);
		capacityLabel.setVisible(false);
		acceptedPane.setVisible(false);
		refusedPane.setVisible(false);
		norequestsPane.setVisible(false);
    }

    @FXML
    void accept(ActionEvent event) {
    	CheckPersonalMessages rac = new CheckPersonalMessages();
    	rac.acceptRequest(titleLabel.getText(), "yes");
    	this.setInvisible();
    	acceptedPane.setVisible(true);
    	
    }

    @FXML
    void decline(ActionEvent event) {
    	CheckPersonalMessages rac = new CheckPersonalMessages();
    	rac.acceptRequest(titleLabel.getText(), "refused");
    	this.setInvisible();
    	refusedPane.setVisible(true);
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		//every label and button is hidden at the very beginning
		
		this.setInvisible();
		//initialize the listview
		CheckPersonalMessages rac = new CheckPersonalMessages();
		if(rac.buildRequestsStringArray(lbpm.getUsername()).isEmpty()) {
			//if there are no requests
			norequestsPane.setVisible(true);
		}
		else {
			listViewRequests.getItems().addAll(rac.buildRequestsStringArray(lbpm.getUsername()));
			listViewRequests.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {

				@Override
				public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
					//this listener method make the parameters of the selected request appear in the appropiate panes
				
					CheckPersonalMessages rac = new CheckPersonalMessages();
					RequestedShowBean rsb = rac.getRequestedShowBean(listViewRequests.getSelectionModel().getSelectedItem());
					SponsorBean sb = rac.getSponsor(rsb.getHost());
				
					if(rsb.getApprovedArtist().equals("refused")) {
					refusedPane.setVisible(true);
					}
				
					else if(rsb.getApprovedArtist().equals("yes")) {
					acceptedPane.setVisible(true);
					}
					else if(rsb.getApprovedArtist().equals("no")) {
						titleLabel.setVisible(true);
						sponsorLabel.setVisible(true);
						descriptionShowLabel.setVisible(true);
						descriptionSponsorLabel.setVisible(true);
						declineButton.setVisible(true);
						acceptButton.setVisible(true);
						acivityLabel.setVisible(true);
						capacityLabel.setVisible(true);
				
						titleLabel.setText(rsb.getTitle());
						sponsorLabel.setText(rsb.getHost());
						descriptionShowLabel.setText(rsb.getDescription());
						descriptionSponsorLabel.setText(sb.getDescription());
						acivityLabel.setText(sb.getActivity());
						capacityLabel.setText(sb.getCapacity());
				}
				
			}
		
		});
	}
  }
	
}
