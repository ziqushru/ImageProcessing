package engine;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JMenuBar;

import engine.file_utils.FileUtils;
import engine.swing.ui.menu_bars.ScreenMenuBar;

@SuppressWarnings("serial")
public class Screen extends JFrame
{
	public static final String	TITLE	= "Image Processing";
	public static int			WIDTH;
	public static int			HEIGHT;
	public BufferedImage		output_image;
	private int[]				input_pixels;
	private int[]				output_pixels;
	public FileUtils			file_utils;
	private ScreenMenuBar		menu_bar;
	public static final Font	font	= new Font("Alcubierre", Font.BOLD, 14);

	public Screen(String title)
	{
		super(title);
		WIDTH = 360;
		HEIGHT = WIDTH / 16 * 9;
		file_utils = new FileUtils(this);
		menu_bar = new ScreenMenuBar(this);
		setJMenuBar(menu_bar);
	}

	public void setInputPixels(int[] input_pixels)
	{
		this.input_pixels = input_pixels;
	}

	public void setOutputPixels(int[] output_pixels)
	{
		this.output_pixels = output_pixels;
	}

	public int[] getInputPixels()
	{
		return input_pixels;
	}

	public int[] getOutputPixels()
	{
		return output_pixels;
	}

	public void copyArrays()
	{
		for (int y = 0; y < Screen.HEIGHT; y++)
			for (int x = 0; x < Screen.WIDTH; x++)
				output_pixels[x + y * Screen.WIDTH] = input_pixels[x + y * Screen.WIDTH];
	}

	@Override
	public void paint(Graphics graphics)
	{
		super.paint(graphics);
		graphics = getContentPane().getGraphics();
		graphics.drawImage(output_image, 0, 0, WIDTH, HEIGHT, null);
	}

	@Override
	public JMenuBar getJMenuBar()
	{
		return menu_bar;
	}

	public static void main(String[] args)
	{
		Screen screen = new Screen(Screen.TITLE);

		Dimension dimension = new Dimension(Screen.WIDTH, Screen.HEIGHT);
		screen.setMinimumSize(dimension);
		screen.setMaximumSize(dimension);
		screen.setPreferredSize(dimension);
		screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		screen.setLocationRelativeTo(null);
		screen.setResizable(false);
		screen.setVisible(true);
	}
}
