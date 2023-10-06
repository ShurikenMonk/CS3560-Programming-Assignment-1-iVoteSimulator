import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Quiz{
    private Scanner keyboard;

    public Quiz(){
        
    }

    public Question getQuestion(Moderator moderator){
        keyboard = new Scanner(System.in);
        String  questionProblem = questionProblem();
        int type = questionType();
        int answerCount = numberOfAnswers();
        List<String> answers = questionAnswers(answerCount);
        Question question = getQuestion(moderator, questionProblem, type, answerCount, answers);
        return question;
    }

    private String questionProblem(){
        System.out.println("\nPlease input the question:\n");
        String questionProblem = keyboard.nextLine();
        return questionProblem;
    }

    private int questionType(){
        System.out.println("\n1. One Answer\n" +
                            "2. Multiple Answers\n" +
                            "Choose type of question: ");
        int type = Character.getNumericValue(keyboard.nextLine().charAt(0));
        if(type != 1 && type != 2){
            throw new RuntimeException(type + "is not a valid input for type of question.");
        }
        return type;
    }

    private int numberOfAnswers(){
        System.out.println("\nEnter the number of answers:");
        int answerCount = (int)Integer.parseInt(keyboard.nextLine());
        if(answerCount < 2 || answerCount > 7){
            throw new RuntimeException(answerCount + "is not a valid number of answers.");
        }
        return answerCount;
    }

    private List<String> questionAnswers(int answerCount){
        List<String> answers = new ArrayList<String>(answerCount);
        for (int i = 0; i < answerCount; i++){
            System.out.println("Enter answer #" + (i+1));
            String answer = keyboard.nextLine();
            answers.add(answer);
        }
        return answers;
    }

    public Question getQuestion(Moderator moderator, String questionProblem, int type, int answerCount, List<String> answers){
        Question question;
        if(type == 1){
            question = new OneAnswerQuestion(moderator, questionProblem, answerCount, answers);
        }
        else{
            question = new MultipleAnswersQuestion(moderator, questionProblem, answerCount, answers);
        }
        return question;
    }
}

