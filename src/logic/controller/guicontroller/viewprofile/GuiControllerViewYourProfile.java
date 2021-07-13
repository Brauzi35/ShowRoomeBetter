package logic.controller.guicontroller.viewprofile;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import logic.controller.appcontroller.ViewProfile;
import logic.engclasses.bean.EventBean;
import logic.engclasses.bean.LoggedBean;
import logic.engclasses.utils.Session;


public class GuiControllerViewYourProfile implements Initializable {
	
	protected Session bs1;
	protected LoggedBean lb1;
	 public GuiControllerViewYourProfile(Session bs1){
	 	this.bs1 = bs1;
	 	lb1=bs1.getLoggedBean();
	 }
	
	@FXML
    private AnchorPane rootpane7;

    @FXML
    private Button dismissButton;

    @FXML
    private Label titleLabel;

    @FXML
    private Button editButton;

    @FXML
    private Label username;

    @FXML
    private Label email;

    @FXML
    private Label talent;

    @FXML
    private Label description;

    @FXML
    private TextField usernameEditbox;

    @FXML
    private TextField passwordEditbox1;

    @FXML
    private MenuButton talentMenubar;

    @FXML
    private MenuItem singerButton;

    @FXML
    private MenuItem dancerButton;

    @FXML
    private Button saveButton;

    @FXML
    private TextArea descriptionTexrBar;
    
    String changeTalent; 

    @FXML
    void dancerClick(ActionEvent event) {
    	changeTalent = "dancer";
    	talentMenubar.setText("dancer");
    }

    @FXML
    void dismissShow(ActionEvent event) {
    	//by clicking this button an artist can dismiss the hosted show
    	ViewProfile hac = new ViewProfile();
    	hac.dismissLiveShow(lb1.getUsername());
    }

    @FXML
    void editClick(ActionEvent event) {
    	//this method simply make the "edit" objects visible
    	if(usernameEditbox.isVisible()) {
    		usernameEditbox.setVisible(false);
			passwordEditbox1.setVisible(false);
			talentMenubar.setVisible(false);
			saveButton.setVisible(false);
			descriptionTexrBar.setVisible(false);
    	}
    	else {
    		usernameEditbox.setVisible(true);
    		passwordEditbox1.setVisible(true);
    		talentMenubar.setVisible(true);
    		saveButton.setVisible(true);
    		descriptionTexrBar.setVisible(true);}
    }

    @FXML
    void saveClick(ActionEvent event) {
    	//this method calls the update 
    	ViewProfile hac = new ViewProfile();
    	hac.updateProfile(lb1.getUsername() , passwordEditbox1.getText(), changeTalent, descriptionTexrBar.getText());
    	
    }

    @FXML
    void singerClick(ActionEvent event) {
    	changeTalent = "singer";
    	talentMenubar.setText("singer");
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		//hide every "edit" object
		usernameEditbox.setVisible(false);
		passwordEditbox1.setVisible(false);
		talentMenubar.setVisible(false);
		saveButton.setVisible(false);
		descriptionTexrBar.setVisible(false);
		username.setText(lb1.getUsername());
		email.setText(lb1.getEmail());
		talent.setText(lb1.getTalent());
		description.setText(lb1.getDescription());
		//the following lines manage the live event section
		ViewProfile hac = new ViewProfile();
		EventBean eb = hac.getLiveEvent(lb1.getUsername()); // if the current artist is hosting any show eb won't be null
		if (eb!=null) {
			titleLabel.setText(eb.getName());
		}
		else {
			titleLabel.setText("you are not hosting any show!");
			dismissButton.setVisible(false);
		}
	}

}
