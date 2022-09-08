package example.university.DTO;

public class ProfessorDTO extends PersonDTO{
    // encapsulation
    // private - only in the class
    // public - all project
    // protected - only in the package

    private String professorId;

    public String getProfessorId(){
        return professorId;
    }
    public void setProfessorId(String professorId){
        this.professorId = professorId;
    }
}
