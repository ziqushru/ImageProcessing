package engine.swing.ui.menu_items;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JMenuItem;

import engine.Screen;
import engine.swing.ui.file_choosers.ScreenFileChooser;

@SuppressWarnings("serial")
public class ScreenSaveMenuItem extends JMenuItem implements ActionListener
{
	private Screen screen;

	public ScreenSaveMenuItem(Screen screen, String name)
	{
		super(name);
		this.screen = screen;
		setFont(Screen.font);
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent action_event)
	{
		ScreenFileChooser screen_file_chooser = new ScreenFileChooser();
		int status = screen_file_chooser.showSaveDialog(null);

		if (status == JFileChooser.APPROVE_OPTION)
		{
			File selected_file = screen_file_chooser.getSelectedFile();
			screen.file_utils.setFile(selected_file);
			screen.file_utils.saveImage();
		}
	}
}
