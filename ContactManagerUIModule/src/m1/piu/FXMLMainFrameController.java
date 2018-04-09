/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m1.piu;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.openide.DialogDisplayer;
import org.openide.NotifyDescriptor;

/**
 *
 * @author uapv1502017
 */
public class FXMLMainFrameController extends JFXPanel implements Initializable {
    
    @FXML
    private MenuButton contactType;
    
    @FXML
    private Button identify;
    
    @FXML
    private Button phones;
    
    @FXML
    private Button address;
    
    @FXML
    private Button addPhoneNumber;
    
    @FXML
    private Button closeButton;
    
    @FXML
    private Pane contentPaneContact;
	
	@FXML
	private TextField contactFirstName;
	
	@FXML
	private TextField contactLastName;
	
	
	@FXML
	private void handleValidContact(ActionEvent event) {
		String message = "";
		
		if (contentPaneContact == null)
			System.out.println("LELELELLE"); //TODO ici
		
		
        if (contactFirstName.getText().isEmpty()) {
			message = "Le champ 'First Name' est vide.";
		}
		if (contactLastName.getText().isEmpty()) {
			message = "Le champ 'Last Name' est vide.";
		}
		if (contactFirstName.getText().isEmpty() && contactLastName.getText().isEmpty()) {
			message = "Les champs 'First Name' et 'Last Name' sont vide.";
		}
		DialogDisplayer.getDefault().notify(new NotifyDescriptor.Message(message, NotifyDescriptor.INFORMATION_MESSAGE));
	}
	
	@FXML
	private void handleAddContact(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXMLNewContact.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
			stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(root1));
            stage.setTitle("New Contact");
			stage.setResizable(false);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(FXMLMainFrameController.class.getName()).log(Level.SEVERE, null, ex);
        }
	}
    
    @FXML
    private void handleContactTypePrivate(ActionEvent event) {
        contactType.setText("Private");
    }
    
    @FXML
    private void handleContactTypePublic(ActionEvent event) {
        contactType.setText("Public");
    }
    
    @FXML
    private void closeWindow(ActionEvent event) {
        Stage stg = (Stage) contactType.getScene().getWindow();
        stg.close();
    }
    
    @FXML
    private void closeNewPhoneNumberWindow(ActionEvent event) {
        Stage stg = (Stage) closeButton.getScene().getWindow();
        stg.close();
    }
    
    @FXML
    private void handleIdentify(ActionEvent event) {
        identify.setStyle("");
        phones.setStyle("-fx-background-color: gray");
        address.setStyle("-fx-background-color: gray");
        
        try {
            contentPaneContact.getChildren().setAll((Pane) FXMLLoader.load(getClass().getResource("FXMLIdentify.fxml")));
        } catch (IOException ex) {
            Logger.getLogger(FXMLMainFrameController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void handlePhones(ActionEvent event) {
        identify.setStyle("-fx-background-color: gray");
        phones.setStyle("");
        address.setStyle("-fx-background-color: gray");
        
        try {
            contentPaneContact.getChildren().setAll((Pane) FXMLLoader.load(getClass().getResource("FXMLPhones.fxml")));
        } catch (IOException ex) {
            Logger.getLogger(FXMLMainFrameController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void handleAddress(ActionEvent event) {
        identify.setStyle("-fx-background-color: gray");
        phones.setStyle("-fx-background-color: gray");
        address.setStyle("");
        
        try {
            contentPaneContact.getChildren().setAll((Pane) FXMLLoader.load(getClass().getResource("FXMLAddress.fxml")));
        } catch (IOException ex) {
            Logger.getLogger(FXMLMainFrameController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void handleAddPhoneNumber(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXMLNewPhoneNumber.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
			stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(root1));
            stage.setTitle("New Phone Number");
			stage.setResizable(false);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(FXMLMainFrameController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
    }
	
	@Override
	public String getName() {
		return "FXML JFXPanel";
	}
}
