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
public class FXMLContactFrameController extends JFXPanel implements Initializable {
  
	@FXML
	private TextField contactFirstName;
	
	@FXML
	private TextField contactLastName;
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
    }
	
	@Override
	public String getName() {
		return "FXML JFXPanel";
	}
    
    public TextField getFirstName() {
        return contactFirstName;
    }
    
    public TextField getLastName() {
        return contactLastName;
    }
}
