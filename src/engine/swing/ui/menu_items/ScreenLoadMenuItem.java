package engine.swing.ui.menu_items;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JMenuItem;

import engine.Screen;
import engine.swing.ui.file_choosers.ScreenFileChooser;
import engine.swing.ui.menu_bars.ScreenMenuBar;

@SuppressWarnings("serial")
public class ScreenLoadMenuItem extends JMenuItem implements ActionListener
{
	private Screen				screen;
	private static final int	WINDOW_LEFT_BOUND	= 3;
	private static final int	WINDOW_RIGHT_BOUND	= 3;
	private static final int	WINDOW_TOP_BOUND	= 43;
	private static final int	WINDOW_BOTTOM_BOUND	= 3;

	public ScreenLoadMenuItem(Screen screen, String name)
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
		int status = screen_file_chooser.showOpenDialog(null);
	
		if (status == JFileChooser.APPROVE_OPTION)
		{
			File selected_file = screen_file_chooser.getSelectedFile();

			screen.file_utils.setFile(selected_file);

			screen.file_utils.loadImage();

			screen.copyArrays();

			Dimension dimension = new Dimension(Screen.WIDTH + WINDOW_LEFT_BOUND + WINDOW_RIGHT_BOUND, Screen.HEIGHT + WINDOW_TOP_BOUND + WINDOW_BOTTOM_BOUND);
			screen.setSize(dimension);
			screen.setLocationRelativeTo(null);

			((ScreenMenuBar) screen.getJMenuBar()).addProcesses();

			screen.repaint();
		}
	}
}
