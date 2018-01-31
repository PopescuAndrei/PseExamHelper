package ro.andrei.quiz.controller;

import ro.andrei.quiz.model.Section;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import ro.andrei.quiz.view.MenuFrame;
import ro.andrei.quiz.view.QuizFrame;

public class MenuFrameController {

	private MenuFrame menuFrame;
	private JButton exitButton;
	private JList sectionList;

	private List<Section> sections;
	private DefaultListModel<String> sectionListModel;

	public MenuFrameController(List<Section> sections) {
		this.sections = sections;

		sectionListModel = new DefaultListModel<String>();
		sections.forEach(s -> sectionListModel.addElement(s.getTitle()));

		initComponents();
		initListeners();
	}

	public void showMenuFrameWindow() {
		menuFrame.setVisible(true);
	}

	private void initComponents() {
		menuFrame = new MenuFrame();

		exitButton = menuFrame.getExitButton();
		sectionList = menuFrame.getSectionList();
		sectionList.setModel(sectionListModel);
		sectionList.setSelectedIndex(0);

	}

	private void initListeners() {

		exitButton.addActionListener(e -> System.exit(0));

		sectionList.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				QuizFrame qf = new QuizFrame(sections.get(sectionList.getSelectedIndex()));
				qf.setVisible(true);
			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {

			}
		});
	}
}
