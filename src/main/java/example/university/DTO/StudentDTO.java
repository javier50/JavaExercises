package example.university.DTO;

public class StudentDTO extends PersonDTO{
    private String professorId;

    public String getProfessorId(){
        return professorId;
    }
    public void setProfessorId(String professorId){
        this.professorId = professorId;
    }
}
