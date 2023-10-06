public interface VoteInterface{
    //interface for the main vote methods
    void addQuiz(String moderatorID, Question question);
    void pickVote(String moderatorID);
    Question submitVote(String moderatorID);
    void removeQuiz(String moderatorID);
}