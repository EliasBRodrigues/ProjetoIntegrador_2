package school.model.binding;

import school.model.BaseModel;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

public class StudentBindingModel extends BaseModel {

    private String firstName;
    private String middleName;
    private String lastName;
    private Long classroomId;
    private String userEmail;

    public StudentBindingModel() {
    }

    @Pattern(regexp = "^[А-Я][а-я]{2,19}$", message = "The name must be between 2 and 12 letters and start with a capital letter.")
    public String getFirstName() {
        return firstName;
    }

    public StudentBindingModel setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    @Pattern(regexp = "^[А-Я][а-я]{2,19}$", message = "The last name must be between 2 and 12 letters long and start with a capital letter.")
    public String getMiddleName() {
        return middleName;
    }

    public StudentBindingModel setMiddleName(String middleName) {
        this.middleName = middleName;
        return this;
    }

    @Pattern(regexp = "^[А-Я][а-я]{2,19}$", message = "Last name must be between 2 and 12 letters long and start with a capital letter.")
    public String getLastName() {
        return lastName;
    }

    public StudentBindingModel setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Long getClassroomId() {
        return classroomId;
    }

    public StudentBindingModel setClassroomId(Long classroomId) {
        this.classroomId = classroomId;
        return this;
    }

    @Email
    public String getUserEmail() {
        return userEmail;
    }

    public StudentBindingModel setUserEmail(String userEmail) {
        this.userEmail = userEmail;
        return this;
    }
}
