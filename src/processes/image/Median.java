package processes.image;

import processes.color.ColorProcessing;

public class Median extends ColorProcessing
{
	public Median(int[] pixels)
	{
		super(pixels);
	}

	public void processColor(int[] color_array)
	{
		int n = (int) parameters[0];
		int[] new_array = new int[n * n];

		for (int y = n / 2; y < height - n / 2; y++)
			for (int x = n / 2; x < width - n / 2; x++)
			{
				int counter = 0;

				for (int k = -n / 2; k <= n / 2; k++)
					for (int l = -n / 2; l <= n / 2; l++)
						new_array[counter++] = color_array[x + l + (y + k) * width];
		
				for (int k = 1; k <= n * n - 1; k++)
				{
					int key = new_array[k];
					int l = k - 1;

					while (l >= 0 && new_array[l] > key)
						new_array[l + 1] = new_array[l--];
					
					new_array[l + 1] = key;
				}
				color_array[x + y * width] = new_array[n * n / 2];
			}
	}
}
