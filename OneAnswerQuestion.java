import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class OneAnswerQuestion extends Question implements VoteCheck{
    private OneAnswerQuestion dupe;
    private int voterVote;

    public OneAnswerQuestion(Moderator moderator, String questionProblem, int answerCount, List<String> answers){
        super(moderator, questionProblem, answerCount, answers);
    }

    @Override
    public void setVoterVote(Voter voter, boolean simulation){
        //voterVote: A randomly generated integer ranging from the first to final answer of the problem.
        if(voter == getVoter() && simulation){
            Random random = new Random();
            this.voterVote = random.nextInt(this.getAnswerCount()) + 1;
        }
        else if (voter == getVoter()){
            Scanner keyboard = new Scanner(System.in);
            System.out.println("Enter the # of your desired answer: ");
            this.voterVote =  (int) Integer.parseInt(keyboard.nextLine());
        }
        else{
            throw new RuntimeException("Unauthorized vote on quiz problem.");
        }
    }

    @Override
    public void getVoterVote(QuizStatistics quizStats){
        int[] answers = quizStats.getAnswers();
        answers[voterVote-1]++;
        quizStats.setAnswers(answers);
    }
}