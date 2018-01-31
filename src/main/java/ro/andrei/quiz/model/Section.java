package ro.andrei.quiz.model;

import java.util.List;
import java.util.Objects;

public class Section {

	private String title;
	private List<Question> questionList;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Question> getQuestionList() {
		return questionList;
	}

	public void setQuestionList(List<Question> questionList) {
		this.questionList = questionList;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Section section = (Section) o;
		return Objects.equals(title, section.title) &&
				Objects.equals(questionList, section.questionList);
	}

	@Override
	public int hashCode() {
		return Objects.hash(title, questionList);
	}

	@Override
	public String toString() {
		return "Section [title=" + title + ", questionList=" + questionList + "]";
	}
}
