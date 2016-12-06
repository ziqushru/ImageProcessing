package engine.swing.frames;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import engine.Screen;
import processes.color.ColorProcessing;

@SuppressWarnings("serial")
public class ParameterMaskScreen extends PopupScreen
{
	public ParameterMaskScreen(Screen screen, ColorProcessing process, String process_name, String[][] parameter_mask_names)
	{
		super(screen, process_name, 360, 100 * parameter_mask_names.length, process, parameter_mask_names);
	}

	protected void setUI()
	{
		JPanel panel = new JPanel(new BorderLayout());

		JPanel parameter_panel = new JPanel(new GridLayout(parameter_mask_names.length, parameter_mask_names.length));

		JLabel[][] parameter_labels = new JLabel[parameter_mask_names.length][parameter_mask_names.length];
		JTextField[][] parameter_text_fields = new JTextField[parameter_mask_names.length][parameter_mask_names.length];

		for (int y = 0; y < parameter_mask_names.length; y++)
		{
			for (int x = 0; x < parameter_mask_names.length; x++)
			{
				parameter_labels[y][x] = new JLabel(parameter_mask_names[y][x]);
				parameter_labels[y][x].setHorizontalAlignment(SwingConstants.CENTER);

				parameter_text_fields[y][x] = new JTextField();
				parameter_text_fields[y][x].setHorizontalAlignment(SwingConstants.CENTER);

				parameter_panel.add(parameter_labels[y][x]);
				parameter_panel.add(parameter_text_fields[y][x]);
			}
		}

		panel.add(parameter_panel, BorderLayout.CENTER);

		JButton confirm_button = new JButton("Confirm");
		confirm_button.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				double[][] parameters = new double[parameter_mask_names.length][parameter_mask_names.length];

				for (int y = 0; y < parameter_mask_names.length; y++)
					for (int x = 0; x < parameter_mask_names.length; x++)
						parameters[y][x] = Double.parseDouble(parameter_text_fields[y][x].getText());

				process.setParameterMask(parameters);
				process.process();

				screen.repaint();

				dispose();
			}
		});
		panel.add(confirm_button, BorderLayout.SOUTH);

		add(panel);
	}
}
