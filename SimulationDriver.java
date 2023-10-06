import java.util.List;

public class SimulationDriver{
    //contains the main class where the program simulation is executed
    private iVoteService iV;
    private Moderator teacher;
    private Question question;

    public void iVoteServiceStart(){
        iV = new iVoteService();
    }

    public void registerTeacher(){
        teacher = new Teacher(iV.nextModeratorID());
        iV.register(teacher);
    }

    public void registerStudents(int count){
        for(int i = 0; i < count; i++){
            Voter student = new Student(iV.nextVoterID());
            iV.register(student);
        }
    }

    public void createNSubmitQ(){
        question = teacher.createQuestion();
        iV.submitVote(teacher.getID(), question);
    }

    public void votingSection(int section){
        System.out.println("\nVoting Section: " + section);
        List<Voter> voters = iV.getVoters();
        for(Voter voter: voters){
            voter.pickVote(teacher.getID());
        }
    }

    public void getQuizStatistics(){
        System.out.println("\nQuiz Statistics: ");
        iV.getQuizStatistics(teacher.getID(), question);
    }

    public void endVoting(){
        iV.endVote(teacher.getID());
    }

    public static void main(String[] args){
        SimulationDriver iVoteSim = new SimulationDriver();

        System.out.println("Welcome to the iVoteSimulator!"); 
        
        iVoteSim.iVoteServiceStart();
        iVoteSim.registerTeacher();
        System.out.println("registering Teacher/Host...");
        iVoteSim.registerStudents(50);
        System.out.println("registering Students...");
        
        iVoteSim.createNSubmitQ();
        iVoteSim.votingSection(1);
        iVoteSim.getQuizStatistics();
        System.out.println();
        iVoteSim.createNSubmitQ();
        iVoteSim.votingSection(2);
        iVoteSim.getQuizStatistics();
        iVoteSim.endVoting();
    }
}