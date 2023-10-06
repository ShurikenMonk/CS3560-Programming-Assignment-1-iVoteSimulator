import java.util.List;

public class SimulationDriver{
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

        iVoteSim.iVoteServiceStart();
        iVoteSim.registerTeacher();
        iVoteSim.registerStudents(50);
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