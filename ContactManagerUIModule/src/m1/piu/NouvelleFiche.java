/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m1.piu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionRegistration;
import org.openide.util.Exceptions;
import org.openide.util.NbBundle.Messages;

@ActionID(
	category = "File",
	id = "m1.piu.NouvelleFiche"
)
@ActionRegistration(
	displayName = "#CTL_NouvelleFiche"
)
@ActionReference(path = "Menu/File", position = 2300)
@Messages("CTL_NouvelleFiche=Nouvelle Fiche")
public final class NouvelleFiche extends JFXPanel implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		final URL location = NouvelleFiche.class.getResource("FXMLNewContact.fxml");
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				FXMLLoader fxmlLoader = new FXMLLoader(location);
				Parent root = null;
				try {
					root = (Parent) fxmlLoader.load();
				} catch (IOException ex) {
					Exceptions.printStackTrace(ex);
				}
				Stage stage = new Stage();
				stage.initModality(Modality.APPLICATION_MODAL);
				stage.setTitle("New contact");
				stage.setResizable(false);
				stage.setScene(new Scene(root));  
				stage.show();
			}
		});
	}
}
