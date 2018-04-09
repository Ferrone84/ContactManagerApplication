/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m1.piu;

import java.io.IOException;
import java.net.URL;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javax.swing.event.ChangeListener;
import org.openide.WizardDescriptor;
import org.openide.util.Exceptions;
import org.openide.util.HelpCtx;

public class ContactFormWizardPanel implements WizardDescriptor.Panel<WizardDescriptor> {

	/**
	 * The visual component that displays this panel. If you need to access the
	 * component from this class, just use getComponent().
	 */
	//private ContactFormVisualPanel component;
	public FXMLMainFrameController component;

	// Get the visual component for the panel. In this template, the component
	// is kept separate. This can be more efficient: if the wizard is created
	// but never displayed, or not all panels are displayed, it is better to
	// create only those which really need to be visible.
	@Override
	public FXMLMainFrameController getComponent() {
		if (component == null) {
			component = new FXMLMainFrameController();
			Platform.setImplicitExit(false);
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    createScene();  //standard Swing Interop Pattern
                }
            });
		}
		return component;
	}
	
	private void createScene() {
        try {
            URL location = getClass().getResource("FXMLToolBar.fxml"); //same FXML copied from JavaFX app
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(location);
            fxmlLoader.setBuilderFactory(new JavaFXBuilderFactory());
            Parent root = (Parent) fxmlLoader.load(location.openStream());
            Scene scene = new Scene(root);
            component.setScene(scene);    
            component = (FXMLMainFrameController) fxmlLoader.getController();    
        } catch (IOException ex) {
            Exceptions.printStackTrace(ex);
        }
    }

	@Override
	public HelpCtx getHelp() {
		// Show no Help button for this panel:
		return HelpCtx.DEFAULT_HELP;
		// If you have context help:
		// return new HelpCtx("help.key.here");
	}

	@Override
	public boolean isValid() {
		// If it is always OK to press Next or Finish, then:
		return true;
		// If it depends on some condition (form filled out...) and
		// this condition changes (last form field filled in...) then
		// use ChangeSupport to implement add/removeChangeListener below.
		// WizardDescriptor.ERROR/WARNING/INFORMATION_MESSAGE will also be useful.
	}

	@Override
	public void addChangeListener(ChangeListener l) {
	}

	@Override
	public void removeChangeListener(ChangeListener l) {
	}

	@Override
	public void readSettings(WizardDescriptor wiz) {
		// use wiz.getProperty to retrieve previous panel state
	}

	@Override
	public void storeSettings(WizardDescriptor wiz) {
		// use wiz.putProperty to remember current panel state
	}

}
