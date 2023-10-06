import java.util.Map;
import java.util.HashMap;

public class Voter extends Operator implements VoteInterface {
    private Map<String, Question> questions = new HashMap<String, Question>();

    public Voter(String voterID){
        super(voterID);
    }

    @Override
    public void addQuiz(String moderatorID, Question question){
        question.setVoter(this);
        questions.put(moderatorID, question);
    }

    @Override
    public void pickVote(String moderatorID){
        VoteCheck question = (VoteCheck)questions.get(moderatorID);
        question.setVoterVote(this,true);
        questions.put(moderatorID, (Question) question);
    }

    @Override
    public Question submitVote(String moderatorID){
        return questions.get(moderatorID);
    }

    @Override
    public void removeQuiz(String moderatorID){
        questions.remove(moderatorID);
    }
} 