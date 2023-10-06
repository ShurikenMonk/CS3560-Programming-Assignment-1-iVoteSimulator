import java.util.List;

public class QuizStatistics{
    //class for displaying the results of the quiz
    private boolean multipleAnswers;
    private int answersQ[];

    public QuizStatistics(Question question){
        setQuestion(question);
    }

    private void setQuestion(Question question){
        if(question instanceof OneAnswerQuestion){
            setOneAnswerQuestion(question);
        }
        else if(question instanceof MultipleAnswersQuestion){
            setMultipleAnswersQuestion(question);
        }
    }
    private void setOneAnswerQuestion(Question question){
        setManyAnswers(false);
        answersQ = new int[question.getAnswerCount()];
        setAnswers(answersQ);
    }

    private void setMultipleAnswersQuestion(Question question){
        setManyAnswers(true);
        answersQ = new int[question.getAnswerCount()];
        setAnswers(answersQ);
    }

    public void countAnswers(String voterID, Voter voter){
        if(isManyAnswers()){
            MultipleAnswersQuestion question = (MultipleAnswersQuestion)voter.submitVote(voterID);
            question.getVoterVote(this);
        }
        else{
            OneAnswerQuestion question = (OneAnswerQuestion)voter.submitVote(voterID);
            question.getVoterVote(this);
        }
    }

    public void displayStats(Question question){
        System.out.println("Question: \n" + question.getQuestionProblem());
        
        List<String> answers = question.getAnswers();
        for (int i = 0; i < question.getAnswerCount(); i++){
            System.out.printf("%3d votes: %2s\n", answersQ[i], answers.get(i));
        }
    }

    public boolean isManyAnswers(){
        return multipleAnswers;
    }

    public void setManyAnswers(boolean multipleAnswers){
        this.multipleAnswers = multipleAnswers;
    }

    public int[] getAnswers(){
        return answersQ;
    }

    public void setAnswers(int[] answers){
        this.answersQ = answers;
    }
}