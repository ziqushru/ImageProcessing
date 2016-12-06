package processes.image;

import processes.color.ColorProcessing;

public class AutoThreshold extends ColorProcessing
{
	public AutoThreshold(int[] pixels)
	{
		super(pixels);
	}

	@Override
	protected void processColor(int[] color_array)
	{
		int[] hist = new int[256];
		int[] hist_sort = new int[256];
		int[] pos = new int[256];
		int threshold = 0;

		for (int i = 0; i <= 255; i++)
		{
			hist[i] = 0;
			hist_sort[i] = 0;
			pos[i] = i;
		}

		for (int y = 0; y < height; y++)
			for (int x = 0; x < width; x++)
			{
				hist[color_array[x + y * width]] += 1;
				hist_sort[color_array[x + y * width]] += 1;
			}
		
		for (int k = 1; k < 256; k++)
			for (int l = 255; l >= k; l--)
				if (hist_sort[l - 1] < hist_sort[l])
				{
					int tmp = hist_sort[l - 1];
					hist_sort[l - 1] = hist_sort[l];
					hist_sort[l] = tmp;
					tmp = pos[l - 1];
					pos[l - 1] = pos[l];
					pos[l] = tmp;
				}
		
		int z1 = hist_sort[0];
		int p_z1 = pos[0];
		int z2 = 0;
		int p_z2 = 0;

		for (int i = 1; i < 256; i++)
		{
			int dist = 0;
			if ((Math.abs(pos[i] - p_z1)) > dist)
			{
				z2 = hist_sort[i];
				p_z2 = pos[i];
				break;
			}
		}
		double z;

		if (p_z1 < p_z2)
		{
			z = hist[p_z1 + 1] * 1. / z2;

			for (int i = p_z1 + 1; i < p_z2; i++)
				if ((hist[i] * 1. / z2) < z)
				{
					z = hist[i] * 1. / z2;
					threshold = i;
				}
		}
		else
		{
			z = hist[p_z2 + 1] * 1. / z1;

			for (int i = p_z2 + 1; i < p_z1; i++)
				if ((hist[i] * 1. / z1) < z)
				{
					z = hist[i] * 1. / z1;
					threshold = i;
				}
		}

		for (int y = 0; y < height; y++)
			for (int x = 0; x < width; x++)
			{
				int color = color_array[x + y * width];
				if (color > threshold)		color = 255;
				else						color = 0;
				color_array[x + y * width] = color;
			}
	}
}
