package processes.image;

import processes.color.ColorProcessing;

public class Negative extends ColorProcessing
{
	public Negative(int[] pixels)
	{
		super(pixels);
	}

	@Override
	protected void processColor(int[] color_array)
	{
		for (int y = 0; y < height; y++)
			for (int x = 0; x < width; x++)
				color_array[x + y * width] = 255 - color_array[x + y * width];
	}
}
