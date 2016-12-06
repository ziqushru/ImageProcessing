package processes.image;

import processes.color.ColorProcessing;

public class Linear extends ColorProcessing
{
	public Linear(int[] pixels)
	{
		super(pixels);
	}

	@Override
	protected void processColor(int[] color_array)
	{
		int brightness = (int) parameters[0];
		double contrast = parameters[1];

		for (int y = 0; y < height; y++)
			for (int x = 0; x < width; x++)
			{
				int color = (int) ((color_array[x + y * width] + brightness) * contrast);
				if (color > 255) 	color = 255;
				if (color < 0) 		color = 0;
				color_array[x + y * width] = color;
			}
	}
}
