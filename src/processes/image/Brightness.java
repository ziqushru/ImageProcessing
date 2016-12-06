package processes.image;

import processes.color.ColorProcessing;

public class Brightness extends ColorProcessing
{
	public Brightness(int[] pixels)
	{
		super(pixels);
	}

	@Override
	protected void processColor(int[] color_array)
	{
		int brightness = (int) parameters[0];

		for (int y = 0; y < height; y++)
			for (int x = 0; x < width; x++)
			{
				int color = color_array[x + y * width];
				color += brightness;
				color = normalizeColor(color);
				color_array[x + y * width] = color;
			}
	}
}
