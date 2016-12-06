package engine.swing.ui.file_choosers;

import javax.swing.JFileChooser;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import engine.file_utils.EasyFileFilter;

@SuppressWarnings("serial")
public class ScreenFileChooser extends JFileChooser
{
	public ScreenFileChooser()
	{
		super(System.getProperty("user.home") + System.getProperty("file.separator") + "Desktop");
		setFileFilter(new EasyFileFilter(new String[] { "jpg", "png" }));
		try
		{
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			SwingUtilities.updateComponentTreeUI(this);
		}
		catch (Exception exception)	{ System.err.println("Error in File Chooser"); }
	}
}
