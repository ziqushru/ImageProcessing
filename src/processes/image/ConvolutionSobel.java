package processes.image;

import processes.color.ColorProcessing;

public class ConvolutionSobel extends ColorProcessing
{
	public ConvolutionSobel(int[] pixels) {
		super(pixels);
	}

	@Override
	protected void processColor(int[] color_array)
	{
		double[][] x_mask = parameter_masks;
		double[][] y_mask = parameter_masks;
		
		int n = parameter_masks.length;

//		x_mask[0][0] = parameter_masks[0][0];	x_mask[0][1] = parameter_masks[0][1];	x_mask[0][2] = parameter_masks[0][2];
//		x_mask[1][0] = parameter_masks[1][0];	x_mask[1][1] = parameter_masks[0][1];	x_mask[1][2] = parameter_masks[1][2];
//		x_mask[2][0] = parameter_masks[2][0];	x_mask[2][1] = parameter_masks[0][1];	x_mask[2][2] = parameter_masks[2][2];
		
//		y_mask[0][0] = parameter_masks[0][0];	y_mask[0][1] = parameter_masks[0][1];	y_mask[0][2] = parameter_masks[0][2];
//		y_mask[1][0] = parameter_masks[1][0];	y_mask[1][1] = parameter_masks[1][1];	y_mask[1][2] = parameter_masks[1][2];
//		y_mask[2][0] = parameter_masks[2][0];	y_mask[2][1] = parameter_masks[2][1];	y_mask[2][2] = parameter_masks[2][2];

		for (int y = n / 2; y < height - n / 2; y++)
			for (int x = n / 2; x < width - n / 2; x++)
			{	
				int x_color = 0;
				int y_color = 0;
				
				for (int k = - n / 2; k < n / 2; k++)
					for (int l = - n / 2; l < n / 2; l++)
					{
						x_color += color_array[x + l + (y + k) * width] * x_mask[k + n / 2][l + n / 2];
						y_color += color_array[x + l + (y + k) * width] * y_mask[k + n / 2][l + n / 2];
					}

				int color = (int) Math.sqrt(x_color * x_color + y_color * y_color);
				if (color > 255)	color = 255;
				if (color < 0)		color = 0;
				color_array[x + y * width] = color;
			}
	}
}
