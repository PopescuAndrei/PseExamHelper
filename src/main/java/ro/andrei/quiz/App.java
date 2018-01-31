package ro.andrei.quiz;

import java.util.List;

import ro.andrei.quiz.controller.MenuFrameController;
import ro.andrei.quiz.model.Section;
import ro.andrei.quiz.service.QuestionParserService;

public class App {
	
	public static void main(String[] args) {
		QuestionParserService parser = new QuestionParserService();

		List<Section> sections = parser.parseFile();

		MenuFrameController mfController = new MenuFrameController(sections);
		mfController.showMenuFrameWindow();
	}
}