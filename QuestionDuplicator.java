public class QuestionDuplicator{
    public QuestionDuplicator(){

    }

    public Question dupe(Question question){
        Question dupeQuestion;
        if(question instanceof OneAnswerQuestion){
            dupeQuestion = new OneAnswerQuestion(question.getModerator(),
            question.getQuestionProblem(), question.getAnswerCount(), question.getAnswers());
        }
        else{
            dupeQuestion = new MultipleAnswersQuestion(question.getModerator(),
            question.getQuestionProblem(), question.getAnswerCount(), question.getAnswers());
        }
        return dupeQuestion;
    }
}