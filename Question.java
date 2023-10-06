import java.util.List;

public class Question{
    private Moderator moderator;
    private Voter voter;
    private String questionProblem;
    private List<String> answers;
    private int answerCount;

    public Question(Moderator moderator, String questionProblem, int answerCount, List<String>answers){
        setModerator(moderator);
        setQuestionProblem(questionProblem);
        setAnswerCount(answerCount);
        setAnswers(answers);
    }

    private void setModerator(Moderator moderator) {
        this.moderator = moderator;
    }

    public Moderator getModerator(){
        return moderator;
    }

    public void setVoter(Voter voter){
        if(getVoter() == null || getVoter() == voter){
            this.voter = voter;
        }
        else{
            throw new RuntimeException("Voter of the question cannot be modified.");
        }
    }
    
    public Voter getVoter(){
        return voter;
    }

    private void setAnswers(List<String> answers){
        this.answers = answers;
    }

    public List<String> getAnswers(){
        return answers;
    }

    private void setAnswerCount(int answerCount){
        this.answerCount = answerCount;
    }

    public int getAnswerCount(){
        return answerCount;
    }

    private void setQuestionProblem(String questionProblem){
        this.questionProblem = questionProblem;
    }

    public String getQuestionProblem(){
        return questionProblem;
    }
}