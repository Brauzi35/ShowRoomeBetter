package logic.controller.guicontroller.editcommercialactivity;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import logic.controller.appcontroller.EditCommercialActivity;
import logic.engclasses.bean.LoggedBean;
import logic.engclasses.utils.Session;



public class GuiControllerEditCommercialActivity implements Initializable{
	 	
		
	protected Session bsea;
	protected LoggedBean lbea;
	 public GuiControllerEditCommercialActivity(Session bsea){
	 	this.bsea = bsea;
	 	lbea=bsea.getLoggedBean();
	 }
		
		@FXML
	    private AnchorPane rootpaneHPS;
	    
	    @FXML
	    private Button dismissButtonHPS;

	    @FXML
	    private Label titleLabelHPS;
	    
	    @FXML
	    private Button editButtonHPS;

	    @FXML
	    private Label usernameHPS;

	    @FXML
	    private Label activity;

	    @FXML
	    private Label capacity;

	    @FXML
	    private Label description;

	    @FXML
	    private TextField usernameEditbox;

	    @FXML
	    private TextField passwordEditbox1;

	    @FXML
	    private Button saveButton;

	    @FXML
	    private TextArea descriptionTexrBar;

	    @FXML
	    private TextField capacityEditbox;

	    @FXML
	    void dismissShow(ActionEvent event) {
	    	//add dismiss show
	    	EditCommercialActivity eca = new EditCommercialActivity();
	    	eca.delete(lbea.getUsername());
	    }

	    @FXML
	    void editClick(ActionEvent event) {
	    	if(!usernameEditbox.isVisible()) {
	    		usernameEditbox.setVisible(true);
	    		passwordEditbox1.setVisible(true);
	    		saveButton.setVisible(true);
	    		descriptionTexrBar.setVisible(true);
	    		capacityEditbox.setVisible(true);
	    	}
	    	else {
	    		usernameEditbox.setVisible(false);
	    		passwordEditbox1.setVisible(false);
	    		saveButton.setVisible(false);
	    		descriptionTexrBar.setVisible(false);
	    		capacityEditbox.setVisible(false);
	    	}
	    }

	    @FXML
	    void saveClick(ActionEvent event) {
	    	//dummy
	    }

		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			//hide edit section
			usernameEditbox.setVisible(false);
			passwordEditbox1.setVisible(false);
			saveButton.setVisible(false);
			descriptionTexrBar.setVisible(false);
			capacityEditbox.setVisible(false);
			
			usernameHPS.setText(lbea.getUsername());
			activity.setText(lbea.getActivity());
			capacity.setText(lbea.getCapacity());
			description.setText(lbea.getDescription());
		}
}
