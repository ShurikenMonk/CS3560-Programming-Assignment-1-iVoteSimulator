public interface VoteInterface{
    void addQuiz(String moderatorID, Question question);
    void pickVote(String moderatorID);
    Question submitVote(String moderatorID);
    void removeQuiz(String moderatorID);
}