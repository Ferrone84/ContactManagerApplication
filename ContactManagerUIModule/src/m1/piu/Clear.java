/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m1.piu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
		// TODO implement action body
	}
}
