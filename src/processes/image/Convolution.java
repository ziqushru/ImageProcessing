package processes.image;

import processes.color.ColorProcessing;

public class Convolution extends ColorProcessing
{
	public Convolution(int[] pixels) {
		super(pixels);
	}

	@Override
	protected void processColor(int[] color_array)
	{		
		double[][] mask = parameter_masks;
		int n = mask.length;

//		mask[0][0] = parameter_masks[0][0];	mask[0][1] = parameter_masks[0][1];	mask[0][2] = parameter_masks[0][2];
//		mask[1][0] = parameter_masks[1][0];	mask[1][1] = parameter_masks[1][1];	mask[1][2] = parameter_masks[1][2];
//		mask[2][0] = parameter_masks[2][0];	mask[2][1] = parameter_masks[2][1];	mask[2][2] = parameter_masks[2][2];

		for (int y = n / 2; y < height - n / 2; y++)
			for (int x = n / 2; x < width - n / 2; x++)
			{
				int color = 0;

				for (int k = -n / 2; k <= n / 2; k++)
					for (int l = -n / 2; l <= n / 2; l++)
						color += (int) color_array[(x + l) + (y + k) * width] * mask[l + n / 2][k + n / 2];

				if (color > 255)	color = 255;
				if (color < 0)		color = 0;
				color_array[x + y * width] = color;
			}
	}
}
