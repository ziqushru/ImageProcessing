package engine.swing.action_listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import engine.Screen;
import engine.swing.frames.ParameterMaskScreen;
import engine.swing.frames.ParameterScreen;
import processes.image.ArithmeticMean;
import processes.image.Brightness;
import processes.image.Convolution;
import processes.image.ConvolutionSobel;
import processes.image.Linear;
import processes.image.Median;
import processes.image.Threshold;

public class ParameterMenuItemActionListener implements ActionListener
{
	private Screen	screen;
	private String	process_name;

	public ParameterMenuItemActionListener(Screen screen, String process_name)
	{
		this.screen = screen;
		this.process_name = process_name;
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		screen.copyArrays();

		if (process_name.equals("Brightness"))
		{
			Brightness brightness = new Brightness(screen.getOutputPixels());
			new ParameterScreen(screen, brightness, process_name, new String[] { "Brightness" });
		}
		else if (process_name.equals("Linear"))
		{
			Linear linear = new Linear(screen.getOutputPixels());
			new ParameterScreen(screen, linear, process_name, new String[] { "Brightness", "Contrast" });
		}
		else if (process_name.equals("Threshold"))
		{
			Threshold threshold = new Threshold(screen.getOutputPixels());
			new ParameterScreen(screen, threshold, process_name, new String[] { "Threshold" });
		}
		else if (process_name.equals("ArithmeticMean"))
		{
			ArithmeticMean arithmetic_mean = new ArithmeticMean(screen.getOutputPixels());
			new ParameterScreen(screen, arithmetic_mean, process_name, new String[] { "Sub-Array Length" });
		}
		else if (process_name.equals("Convolution"))
		{
			Convolution convolution = new Convolution(screen.getOutputPixels());
			new ParameterMaskScreen(screen, convolution, process_name, new String[][] { { "w11", "w12", "w13" }, { "w21", "w22", "w23" }, { "w31", "w32", "w33" } });
		}
		else if (process_name.equals("ConvolutionSobel"))
		{
			ConvolutionSobel convolution_sobel = new ConvolutionSobel(screen.getOutputPixels());
			new ParameterMaskScreen(screen, convolution_sobel, process_name, new String[][] { { "w11", "w12", "w13" }, { "w21", "w22", "w23" }, { "w31", "w32", "w33" } });
		}
		else if (process_name.equals("Median"))
		{
			Median median = new Median(screen.getOutputPixels());
			new ParameterScreen(screen, median, process_name, new String[] { "Sub-Array Length" });
		}

		screen.repaint();
	}
}
