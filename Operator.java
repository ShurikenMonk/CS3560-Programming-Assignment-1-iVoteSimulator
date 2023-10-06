public class Operator{
    //base class for students and teacher
    private String ID = null;

    public Operator(String ID){
        setID(ID);
    }

    public void setID(String ID){
        if(this.ID == null){
            this.ID = ID;
        }
        else{
            throw new RuntimeException("ID already taken. Please use another.");
        }
    }

    public String getID(){
        return this.ID;
    }
}