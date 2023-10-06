public interface VoteCheck{
    //interface which sets the voter's answer and returns it
    void setVoterVote(Voter voter, boolean simulation);
    void getVoterVote(QuizStatistics quizStatistics);
}