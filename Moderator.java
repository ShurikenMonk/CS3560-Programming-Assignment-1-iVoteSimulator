public class Moderator extends Operator implements QuizInterface{
    private Quiz quiz;

    public Moderator(String moderatorID){
        super(moderatorID);
        quiz = new Quiz();
    }

    @Override
    public Question createQuestion(){
        Question question = quiz.getQuestion(this);
        return question;
    }
}