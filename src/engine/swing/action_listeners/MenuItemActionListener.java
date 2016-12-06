package engine.swing.action_listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import engine.Screen;
import processes.image.AutoThreshold;
import processes.image.Negative;
import processes.image.SquareRoute;

public class MenuItemActionListener implements ActionListener
{
	private Screen	screen;
	private String	process_name;

	public MenuItemActionListener(Screen screen, String process_name)
	{
		this.screen = screen;
		this.process_name = process_name;
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		screen.copyArrays();

		if (process_name.equals("Negative"))
		{
			Negative negative = new Negative(screen.getOutputPixels());
			negative.process();
		}
		else if (process_name.equals("AutoThreshold"))
		{
			AutoThreshold auto_threshold = new AutoThreshold(screen.getOutputPixels());
			auto_threshold.process();
		}
		else if (process_name.equals("SquareRoute"))
		{
			SquareRoute squareroute = new SquareRoute(screen.getOutputPixels());
			squareroute.process();
		}
		screen.repaint();
	}
}
