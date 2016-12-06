package processes.image;

import processes.color.ColorProcessing;

public class SquareRoute extends ColorProcessing
{
	public SquareRoute(int[] pixels)
	{
		super(pixels);
	}

	@Override
	protected void processColor(int[] color_array)
	{
		for (int y = 0; y < height; y++)
			for (int x = 0; x < width; x++)
			{
				int color = color_array[x + y * width];
				color *= 255;
				color = (int) Math.sqrt(color);
				color_array[x + y * width] = color;
			}
	}
}
