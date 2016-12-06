package engine.swing.frames;

import java.awt.Dimension;

import javax.swing.JFrame;

import engine.Screen;
import processes.color.ColorProcessing;

@SuppressWarnings("serial")
public abstract class PopupScreen extends JFrame
{
	private int					WIDTH;
	private int					HEIGHT;

	protected Screen			screen;
	protected ColorProcessing	process;

	protected String[]			parameter_names;
	protected String[][]		parameter_mask_names;

	public PopupScreen(Screen screen, String title, int width, int height, ColorProcessing process, String[] parameter_names)
	{
		this(screen, title, width, height, process);
		this.parameter_names = parameter_names;
		setUI();
		setFrame();
	}

	public PopupScreen(Screen screen, String title, int width, int height, ColorProcessing process, String[][] parameter_mask_names)
	{
		this(screen, title, width, height, process);
		this.parameter_mask_names = parameter_mask_names;
		setUI();
		setFrame();
	}

	private PopupScreen(Screen screen, String title, int width, int height, ColorProcessing process)
	{
		super(title);
		this.WIDTH = width;
		this.HEIGHT = height;
		this.screen = screen;
		this.process = process;
	}

	protected abstract void setUI();

	protected void setFrame()
	{
		Dimension dimension = new Dimension(WIDTH, HEIGHT);
		setMinimumSize(dimension);
		setMaximumSize(dimension);
		setPreferredSize(dimension);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
	}
}
