package engine.file_utils;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import engine.Screen;

public class FileUtils
{
	private Screen	screen;
	private File	file;

	public FileUtils(Screen screen)
	{
		this.screen = screen;
	}

	public void setFile(File file)
	{
		this.file = file;
	}

	public void loadImage()
	{
		try
		{
			BufferedImage input_image = ImageIO.read(file);

			Screen.WIDTH = input_image.getWidth();
			Screen.HEIGHT = input_image.getHeight();

			int[] input_pixels = null;
			input_pixels = input_image.getRGB(0, 0, Screen.WIDTH, Screen.HEIGHT, input_pixels, 0, Screen.WIDTH);

			screen.output_image = new BufferedImage(Screen.WIDTH, Screen.HEIGHT, BufferedImage.TYPE_INT_RGB);
			int[] output_pixels = new int[Screen.WIDTH * Screen.HEIGHT];
			output_pixels = ((DataBufferInt) screen.output_image.getRaster().getDataBuffer()).getData();

			screen.setInputPixels(input_pixels);
			screen.setOutputPixels(output_pixels);
		}
		catch (IOException e)
		{
			System.err.println("Error loading image");
		}
	}

	public void saveImage()
	{
		try
		{
			String extension = EasyFileFilter.getExtension(file);
			String path = file.getPath();
			String folder_path = path.substring(0, path.lastIndexOf('\\'));
			String output_path = folder_path + "\\" + file.getName();
			File output_file = new File(output_path);

			ImageIO.write(screen.output_image, extension, output_file);
		}
		catch (IOException e)
		{
			System.err.println("Error saving image");
		}
	}
}
