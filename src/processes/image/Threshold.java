package processes.image;

import processes.color.ColorProcessing;

public class Threshold extends ColorProcessing
{
	public Threshold(int[] pixels)
	{
		super(pixels);
	}

	@Override
	protected void processColor(int[] color_array)
	{
		int threshold = (int) parameters[0];

		for (int y = 0; y < height; y++)
			for (int x = 0; x < width; x++)
			{

				int color = color_array[x + y * width];

				if (color > threshold)	color = 255;
				else					color = 0;

				color_array[x + y * width] = color;
			}
	}
}
