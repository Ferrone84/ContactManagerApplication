/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m1.piu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import org.openide.DialogDisplayer;
import org.openide.NotifyDescriptor;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionRegistration;
import org.openide.util.NbBundle.Messages;

@ActionID(
	category = "File",
	id = "m1.piu.Clear"
)
@ActionRegistration(
	displayName = "#CTL_Clear"
)
@ActionReference(path = "Menu/Vue", position = 3333)
@Messages("CTL_Clear=clear")
public final class Clear implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		String okValue = "Ok";
		String cancelValue = "Cancel";
		String[] options = new String[]{okValue, cancelValue};
		
		
		NotifyDescriptor nd = new NotifyDescriptor(
            "Voulez vous vraiment clear ?",
            "Confirmation",
            NotifyDescriptor.YES_NO_OPTION,
            NotifyDescriptor.QUESTION_MESSAGE,
            options,
            okValue
		);
		String selectedValue = (String)DialogDisplayer.getDefault().notify(nd);
		if (selectedValue.equals(okValue)) {
			DialogDisplayer.getDefault().notify(new NotifyDescriptor.Message("Vous avez bien clear.", NotifyDescriptor.INFORMATION_MESSAGE));
		}
	}
}
