import java.util.ArrayList;
import java.util.List;

public class iVoteService{
    private static int moderatorCount = 1;
    private static int voterCount = 1;
    //Keeps track of the students and teachers involved.
    private List<Moderator> moderators = new ArrayList<Moderator>();
    private List<Voter> voters = new ArrayList<Voter>();

    public String nextModeratorID(){
        String moderatorID = 'm' + Integer.toString(moderatorCount);
        moderatorCount++;
        return moderatorID;
    }

    public String nextVoterID(){
        String voterID = 'v' + Integer.toString(voterCount);
        voterCount++;
        return voterID;
    }

    public void register(Operator operator){
        String ID = operator.getID();
        if(ID.charAt(0) == 'm'){
            registerModerator(operator);
        }
        if(ID.charAt(0) == 'v'){
            registerVoter(operator);
        }
    }

    private void registerModerator(Operator operator){
        this.moderators.add((Moderator)operator);
    }

    private void registerVoter(Operator operator){
        this.voters.add((Voter)operator);
    }

    public void submitVote(String moderatorID, Question question){
        QuestionDuplicator duplicator = new QuestionDuplicator();
        for(Voter voter : voters){
            Question dupeQuestion = duplicator.dupe(question);
            voter.addQuiz(moderatorID, dupeQuestion);
        }
    }

    public void getQuizStatistics(String moderatorID, Question question){
        QuizStatistics quizStats = new QuizStatistics(question);
        for(Voter voter: voters){
            quizStats.countAnswers(moderatorID, voter);
        }
        quizStats.displayStats(question);
    }

    public void endVote(String moderatorID){
        for(Voter voter : voters){
            voter.removeQuiz(moderatorID);
        }
    }

    public List<Voter> getVoters(){
        return voters;
    }
}