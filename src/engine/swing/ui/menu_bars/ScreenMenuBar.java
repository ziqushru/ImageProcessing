package engine.swing.ui.menu_bars;

import javax.swing.JMenuBar;

import engine.Screen;
import engine.swing.ui.menus.ScreenFilesMenu;
import engine.swing.ui.menus.ScreenProcessesMenu;

@SuppressWarnings("serial")
public class ScreenMenuBar extends JMenuBar
{
	private ScreenFilesMenu file_menu;
	private ScreenProcessesMenu processes_menu;
	
	public ScreenMenuBar(Screen screen)
	{
		super();
		file_menu = new ScreenFilesMenu(screen, "File");
		add(file_menu);
		processes_menu = new ScreenProcessesMenu(screen, "Processes");
	}

	public void addProcesses()
	{
		if (getMenu(1) == null)
			add(processes_menu);
	}
}
