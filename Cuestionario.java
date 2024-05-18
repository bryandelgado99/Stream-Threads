public class Cuestionario {

    final private String Question;
    final private String Answer;

    public Cuestionario(String Question, String Answer) {
        this.Question = Question;
        this.Answer = Answer;
    }

    public String getQuestion() {
        return Question;
    }

    public String getAnswer() {
        return Answer;
    }

    public boolean _isCorrectAnswer(String Answer) {
        return Answer.equalsIgnoreCase(Answer);
    }
}
