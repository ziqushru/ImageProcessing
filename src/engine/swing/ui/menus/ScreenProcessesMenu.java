package engine.swing.ui.menus;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import engine.Screen;
import engine.swing.action_listeners.MenuItemActionListener;
import engine.swing.action_listeners.ParameterMenuItemActionListener;

@SuppressWarnings("serial")
public class ScreenProcessesMenu extends JMenu
{
	private Screen screen;

	public ScreenProcessesMenu(Screen screen, String name)
	{
		super(name);
		this.screen = screen;
		setFont(Screen.font);
		setMenu();
		addChangeListener(new ChangeListener()
		{
			@Override
			public void stateChanged(ChangeEvent change_event)
			{
				if (!((ScreenProcessesMenu) change_event.getSource()).isSelected()) screen.repaint();
			}
		});
	}

	private void setMenu()
	{
		JMenuItem original_menu_item = new JMenuItem("Original");
		original_menu_item.setFont(Screen.font);
		original_menu_item.addActionListener(new MenuItemActionListener(screen, "Original"));
		add(original_menu_item);

		JMenuItem brightness_menu_item = new JMenuItem("Brightness");
		brightness_menu_item.setFont(Screen.font);
		brightness_menu_item.addActionListener(new ParameterMenuItemActionListener(screen, "Brightness"));
		add(brightness_menu_item);

		JMenuItem linear_menu_item = new JMenuItem("Linear");
		linear_menu_item.setFont(Screen.font);
		linear_menu_item.addActionListener(new ParameterMenuItemActionListener(screen, "Linear"));
		add(linear_menu_item);

		JMenuItem negative_menu_item = new JMenuItem("Negative");
		negative_menu_item.setFont(Screen.font);
		negative_menu_item.addActionListener(new MenuItemActionListener(screen, "Negative"));
		add(negative_menu_item);

		JMenuItem threshold_menu_item = new JMenuItem("Threshold");
		threshold_menu_item.setFont(Screen.font);
		threshold_menu_item.addActionListener(new ParameterMenuItemActionListener(screen, "Threshold"));
		add(threshold_menu_item);

		JMenuItem auto_threshold_menu_item = new JMenuItem("Auto Threshold");
		auto_threshold_menu_item.setFont(Screen.font);
		auto_threshold_menu_item.addActionListener(new MenuItemActionListener(screen, "AutoThreshold"));
		add(auto_threshold_menu_item);

		JMenuItem squareroute_menu_item = new JMenuItem("Square Route");
		squareroute_menu_item.setFont(Screen.font);
		squareroute_menu_item.addActionListener(new MenuItemActionListener(screen, "SquareRoute"));
		add(squareroute_menu_item);

		JMenuItem arithmetic_mean_menu_item = new JMenuItem("Arithmetic Mean");
		arithmetic_mean_menu_item.setFont(Screen.font);
		arithmetic_mean_menu_item.addActionListener(new ParameterMenuItemActionListener(screen, "ArithmeticMean"));
		add(arithmetic_mean_menu_item);

		JMenuItem convolution_menu_item = new JMenuItem("Convolution");
		convolution_menu_item.setFont(Screen.font);
		convolution_menu_item.addActionListener(new ParameterMenuItemActionListener(screen, "Convolution"));
		add(convolution_menu_item);

		JMenuItem convolution_sobel_menu_item = new JMenuItem("Convolution Sobel");
		convolution_sobel_menu_item.setFont(Screen.font);
		convolution_sobel_menu_item.addActionListener(new ParameterMenuItemActionListener(screen, "ConvolutionSobel"));
		add(convolution_sobel_menu_item);

		JMenuItem median_menu_item = new JMenuItem("Median");
		median_menu_item.setFont(Screen.font);
		median_menu_item.addActionListener(new ParameterMenuItemActionListener(screen, "Median"));
		add(median_menu_item);
	}
}
