import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class MultipleAnswersQuestion extends Question implements VoteCheck{
    private int[] voterVotes;

    public MultipleAnswersQuestion(Moderator moderator, String questionProblem, int answerCount, List<String> answers){
        super(moderator, questionProblem, answerCount, answers);
        voterVotes = new int[answerCount];
    }

    @Override
    public void setVoterVote(Voter voter, boolean simulation){
        //pick: First a random number generator generates a random number that the voter picks from the number of answers in the problem.
        //answer: Second a random number generator generates a random integer from the first to final answer of the problem.
        if(voter == getVoter() && simulation){
            Random random = new Random();
            int pick = random.nextInt((this.getAnswerCount() - 1)) + 2;
            for(int i = 0; i < pick; i++){
                int answer = random.nextInt(this.getAnswerCount()) + 1;
                //Will keep picking a random choice, if previously chosen.
                while(voterVotes[answer-1] == 1){
                    answer = random.nextInt(this.getAnswerCount()) + 1;
                }
                voterVotes[answer-1]++;
            }
        }
        else if (voter == getVoter()){
            Scanner keyboard = new Scanner(System.in);
            System.out.println("Enter each answer on a line:");
            int answer = (int)Integer.parseInt(keyboard.nextLine());
            while(answer != -1){
                voterVotes[answer-1]++;
                answer = (int)Integer.parseInt(keyboard.nextLine());
            }
        }
        else{
            throw new RuntimeException("Unauthorized vote on quiz problem.");
        }
    }

    @Override
    public void getVoterVote(QuizStatistics quizStats){
        int[] answers = quizStats.getAnswers();
        for(int i = 0; i < voterVotes.length; i++){
            if(voterVotes[i] != 0){
                answers[i]++;
                voterVotes[i] = 0;
            }
        }
        quizStats.setAnswers(answers);
    }
}