package processes.image;

import processes.color.ColorProcessing;

public class ArithmeticMean extends ColorProcessing
{
	public ArithmeticMean(int[] pixels)
	{
		super(pixels);
	}

	@Override
	protected void processColor(int[] color_array)
	{
		int n = (int) parameters[0];

		for (int y = n / 2; y < height - n / 2; y++)
			for (int x = n / 2; x < width - n / 2; x++)
			{
				int sum = 0;

				for (int k = -n / 2; k <= n / 2; k++)
					for (int l = -n / 2; l <= n / 2; l++)
						sum += color_array[x + l + (y + k) * width];
		
				int color = sum / (n * n);
				color_array[x + y * width] = color;
			}
	}
}
