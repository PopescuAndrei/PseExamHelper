package ro.andrei.quiz.model;

import java.util.List;
import java.util.Objects;

public class Question {
	private String type;
	private String path;
	private List<Answer> answers;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Question question = (Question) o;
		return Objects.equals(type, question.type) &&
				Objects.equals(path, question.path) &&
				Objects.equals(answers, question.answers);
	}

	@Override
	public int hashCode() {

		return Objects.hash(type, path, answers);
	}

	@Override
	public String toString() {
		return "Question [type=" + type + ", path=" + path + ", answers=" + answers + "]";
	}
}
