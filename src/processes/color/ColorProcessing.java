package processes.color;

import java.awt.Color;

import engine.Screen;

public abstract class ColorProcessing
{

	private int[]			pixels;

	protected int			height	= Screen.HEIGHT;
	protected int			width	= Screen.WIDTH;

	protected int[]			red;
	protected int[]			green;
	protected int[]			blue;

	protected double[]		parameters;

	protected double[][]	parameter_masks;

	public ColorProcessing(int[] pixels)
	{
		this.pixels = pixels;

		red = new int[width * height];
		green = new int[width * height];
		blue = new int[width * height];

		for (int y = 0; y < height; y++)
		{
			for (int x = 0; x < width; x++)
			{
				Color c = new Color(pixels[x + y * width]);

				red[x + y * width] = c.getRed();
				green[x + y * width] = c.getGreen();
				blue[x + y * width] = c.getBlue();
			}
		}
	}

	public int normalizeColor(int color)
	{
		if (color < 0) color = 0;
		if (color > 255) color = 255;
		return color;
	}

	protected void setColorPixel(int x, int y, int red, int green, int blue)
	{
		Color newColor = new Color(red, green, blue);
		pixels[x + y * width] = newColor.getRGB();
	}

	public void process()
	{
		processColor(red);
		processColor(green);
		processColor(blue);

		for (int y = 0; y < height; y++)
		{
			for (int x = 0; x < width; x++)
			{
				int red = this.red[x + y * width];
				int green = this.green[x + y * width];
				int blue = this.blue[x + y * width];
				setColorPixel(x, y, red, green, blue);
			}
		}
	}

	public void setParameter(double[] parameter)
	{
		this.parameters = parameter;
	}

	public void setParameterMask(double[][] parameter_mask)
	{
		this.parameter_masks = parameter_mask;
	}

	protected abstract void processColor(int[] color_array);

}
