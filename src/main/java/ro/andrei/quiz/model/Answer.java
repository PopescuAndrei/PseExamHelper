package ro.andrei.quiz.model;

import java.util.Objects;

public class Answer {
	private String type;
	private String value;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Answer answer = (Answer) o;
		return Objects.equals(type, answer.type) &&
				Objects.equals(value, answer.value);
	}

        public Boolean isRight() {
            return type.equals("right");
        }
        
        public Boolean isWrong() {
            return type.equals("wrong");
        }
        
	@Override
	public int hashCode() {
		return Objects.hash(type, value);
	}

	@Override
	public String toString() {
		return "Answer [type=" + type + ", value=" + value + "]";
	}
}