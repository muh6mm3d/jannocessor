/**
 * Copyright 2011 Nikolche Mihajlovski
 *
 * This file is part of JAnnocessor.
 *
 * JAnnocessor is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * JAnnocessor is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with JAnnocessor.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.jannocessor.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.Box;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import jsyntaxpane.DefaultSyntaxKit;

import org.apache.commons.io.FileUtils;
import org.jannocessor.JannocessorException;
import org.jannocessor.processor.api.RenderData;
import org.jannocessor.processor.api.RenderRegister;
import org.jannocessor.service.api.Configurator;
import org.jannocessor.service.api.JavaRepresenter;
import org.jannocessor.service.api.MultiContentSplitter;
import org.jannocessor.service.api.TemplateRenderer;
import org.jannocessor.service.render.VelocityTemplateRenderer;
import org.jannocessor.service.splitter.MultiContentSplitterImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RenderPreviewDialog extends JDialog {

	private static final long serialVersionUID = 1L;

	private final Logger logger = LoggerFactory.getLogger("UI");

	private final TemplateRenderer renderer;

	private final String templatesPath;

	private final RenderRegister renderRegister;

	private int index = 0;

	private KeyListener keyListener;

	private Box output;

	private JEditorPane input;

	private Collection<File> files;

	private JComboBox combo;

	private String activeTemplate;

	private final MultiContentSplitter splitter;

	private JScrollPane scroll2;

	private JEditorPane editor;

	public RenderPreviewDialog(String templatesPath, RenderRegister renderRegister, Configurator configurator,
			JavaRepresenter representer) throws JannocessorException {
		this.templatesPath = templatesPath;
		this.renderRegister = renderRegister;

		renderer = new VelocityTemplateRenderer(configurator, representer);
		renderer.configure(templatesPath, true);

		splitter = new MultiContentSplitterImpl();

		initialize();
	}

	private void initialize() {
		logger.debug("Initializing UI...");
		DefaultSyntaxKit.initKit();

		JEditorPane.registerEditorKitForContentType("text/java_template",
				"org.jannocessor.syntax.JavaTemplateKit", getClass().getClassLoader());

		JEditorPane.registerEditorKitForContentType("text/java_output",
				"org.jannocessor.syntax.JavaOutputKit", getClass().getClassLoader());

		setTitle("JAnnocessor - Java Annotation Processor");
		setLayout(new BorderLayout(5, 5));

		listFiles();

		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screenSize = tk.getScreenSize();
		double width = screenSize.getWidth() * 0.9;
		double height = screenSize.getHeight() * 0.8;

		// Font font = new Font("Courier New", Font.PLAIN, 14);

		input = createInput();
		JScrollPane scroll1 = new JScrollPane(input, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		input.setContentType("text/java_template");

		input.setText("");

		scroll1.setMinimumSize(new Dimension(200, 200));
		scroll1.setPreferredSize(new Dimension((int) (width * 0.5), (int) height));
		add(scroll1, BorderLayout.CENTER);

		output = Box.createVerticalBox();

		scroll2 = new JScrollPane(output, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll2.setMinimumSize(new Dimension(200, 200));
		scroll2.setPreferredSize(new Dimension((int) (width * 0.5), (int) height));
		add(scroll2, BorderLayout.EAST);

		combo = createCombo();

		combo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				load((File) combo.getSelectedItem());
			}
		});

		add(combo, BorderLayout.NORTH);
		JLabel help = new JLabel(
				" Choose a template from the drop-down box to edit it. Navigation: Alt + Left & Alt + Right; Refresh = F5, Close = Esc",
				JLabel.CENTER);

		help.setForeground(Color.WHITE);
		help.setBackground(Color.BLACK);
		help.setOpaque(true);
		help.setFont(new Font("Courier New", Font.BOLD, 14));
		add(help, BorderLayout.SOUTH);

		keyListener = new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_F5) {
					e.consume();
					processElements();
					refresh();
				} else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
					e.consume();
					dispose();
				} else if (e.getKeyCode() == KeyEvent.VK_LEFT && e.isAltDown()) {
					e.consume();
					moveBackward();
				} else if (e.getKeyCode() == KeyEvent.VK_RIGHT && e.isAltDown()) {
					e.consume();
					moveForward();
				} else if (e.getKeyCode() == KeyEvent.VK_S && e.isControlDown()) {
					e.consume();
					save();
				} else if (e.getKeyCode() == KeyEvent.VK_I && e.isControlDown()) {
					e.consume();
					increase();
				} else if (e.getKeyCode() == KeyEvent.VK_D && e.isControlDown()) {
					e.consume();
					decrease();
				}
			}
		};

		input.addKeyListener(keyListener);
		combo.addKeyListener(keyListener);

		setActive(0);

		pack();
		setModal(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

		input.requestFocus();
		logger.debug("Initialized UI.");
	}

	protected void decrease() {
		logger.info("Decreasing font size");
		input.setFont(new Font("Courier New", Font.BOLD, Math.max(input.getFont().getSize() - 1, 8)));
		editor.setFont(new Font("Courier New", Font.BOLD, Math.max(editor.getFont().getSize() - 1, 8)));
	}

	protected void increase() {
		logger.info("Increasing font size");
		input.setFont(new Font("Courier New", Font.BOLD, input.getFont().getSize() + 1));
		editor.setFont(new Font("Courier New", Font.BOLD, editor.getFont().getSize() + 1));
	}

	protected void processElements() {
		try {
			renderRegister.refresh();
		} catch (JannocessorException e) {
			throw new RuntimeException(e);
		}
	}

	private JComboBox createCombo() {
		JComboBox combo = new JComboBox(files.toArray());

		return combo;
	}

	private void setActive(int i) {
		index = i;
		refresh();
	}

	private void moveForward() {
		if (index < renderRegister.getRenderings().size() - 1) {
			setActive(index + 1);
		}
	}

	private void moveBackward() {
		if (index > 0) {
			setActive(index - 1);
		}
	}

	private JEditorPane createInput() {
		final JEditorPane editor = new JEditorPane();
		return editor;
	}

	private JComponent createOutput(String title, String content) {
		editor = new JEditorPane();

		JScrollPane scroll = new JScrollPane(editor, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setMinimumSize(new Dimension(100, 100));

		editor.setContentType("text/java_output");
		editor.setEditable(false);
		editor.setText(content);
		editor.addKeyListener(keyListener);

		JLabel header = new JLabel(title);

		Box box = Box.createVerticalBox();
		box.add(header);
		box.add(scroll);

		return box;
	}

	private String readTemplate(String templateName) {
		String template = "";
		if (!templateName.endsWith(".vm")) {
			templateName = fullTemplateName(templateName);
		}
		template = readFile(templateName);
		activeTemplate = templateName;
		return template;
	}

	private String readFile(String fileName) {
		try {
			return FileUtils.readFileToString(new File(fileName));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	private String fullTemplateName(String templateName) {
		return templatesPath + "/" + templateName + ".vm";
	}

	private void save() {
		String content = input.getText();
		logger.debug("Saving: %", activeTemplate);

		try {
			FileUtils.writeStringToFile(new File(activeTemplate), content);
		} catch (Exception e1) {
			e1.printStackTrace();
		}

	}

	private void refresh() {
		output.removeAll();
		try {
			RenderData current = current();
			String text = render(current.getAttributes());
			Map<String, String> contents = splitter.split(text);
			if (!contents.isEmpty()) {
				for (Entry<String, String> a : contents.entrySet()) {
					output.add(createOutput(a.getKey(), a.getValue()));
				}
			} else {
				output.add(createOutput("FILE NAME NOT SPECIFIED!", text));
			}
		} catch (Exception e) {
			logger.warn("Rendering error occured!", e);

			Throwable cause = e;
			String message = "";

			while (cause != null) {
				message += cause.getMessage() + "\n\n";
				cause = cause.getCause();
			}

			output.add(createOutput("RENDERING ERROR OCCURED!", message));
		}
		output.revalidate();
		repaint();
	}

	private String render(Map<String, Object> attributes) throws JannocessorException {
		return renderer.renderMacro("main", attributes, new String[] {});
	}

	private void load(File file) {
		try {
			input.setText(readTemplate(file.getCanonicalPath()));
			refresh();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private RenderData current() {
		RenderData current = renderRegister.getRenderings().get(index);
		return current;
	}

	private void listFiles() {
		try {
			files = FileUtils.listFiles(new File(templatesPath), new String[] { "vm" }, true);
		} catch (Exception e) {
			files = new ArrayList<File>();
		}
	}
}
