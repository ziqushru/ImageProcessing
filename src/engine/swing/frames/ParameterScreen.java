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
public class ParameterScreen extends PopupScreen
{
	public ParameterScreen(Screen screen, ColorProcessing process, String process_name, String[] parameter_names)
	{
		super(screen, process_name, 360, 100 * parameter_names.length, process, parameter_names);
	}

	protected void setUI()
	{
		JPanel panel = new JPanel(new BorderLayout());

		JPanel parameter_panel = new JPanel(new GridLayout(parameter_names.length, 2));

		JLabel[] parameter_labels = new JLabel[parameter_names.length];
		JTextField[] parameter_text_fields = new JTextField[parameter_names.length];

		for (int i = 0; i < parameter_names.length; i++)
		{
			parameter_labels[i] = new JLabel(parameter_names[i]);
			parameter_labels[i].setHorizontalAlignment(SwingConstants.CENTER);

			parameter_text_fields[i] = new JTextField();
			parameter_text_fields[i].setHorizontalAlignment(SwingConstants.CENTER);

			parameter_panel.add(parameter_labels[i]);
			parameter_panel.add(parameter_text_fields[i]);
		}

		panel.add(parameter_panel, BorderLayout.CENTER);

		JButton confirm_button = new JButton("Confirm");
		confirm_button.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				double[] parameters = new double[parameter_names.length];

				for (int i = 0; i < parameter_names.length; i++)
					parameters[i] = Double.parseDouble(parameter_text_fields[i].getText());

				process.setParameter(parameters);
				process.process();

				screen.repaint();

				dispose();
			}
		});
		panel.add(confirm_button, BorderLayout.SOUTH);

		add(panel);
	}
}
