package engine.swing.ui.menus;

import javax.swing.JMenu;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import engine.Screen;
import engine.swing.ui.menu_items.ScreenLoadMenuItem;
import engine.swing.ui.menu_items.ScreenSaveMenuItem;

@SuppressWarnings("serial")
public class ScreenFilesMenu extends JMenu
{
	public ScreenFilesMenu(Screen screen, String name)
	{
		super(name);
		setFont(Screen.font);

		ScreenLoadMenuItem load_menu_item = new ScreenLoadMenuItem(screen, "Load Image");
		add(load_menu_item);

		ScreenSaveMenuItem save_menu_item = new ScreenSaveMenuItem(screen, "Save Image");
		add(save_menu_item);

		addChangeListener(new ChangeListener()
		{
			@Override
			public void stateChanged(ChangeEvent change_event)
			{
				if (!((ScreenFilesMenu) change_event.getSource()).isSelected()) screen.repaint();
			}
		});
	}
}
