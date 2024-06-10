package school.model.binding;

import school.model.BaseModel;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

public class TeacherBindingModel extends BaseModel {

    private String firstName;
    private String middleName;
    private String lastName;
    private String userEmail;

    public TeacherBindingModel() {
    }

    @Pattern(regexp = "^[А-Я][а-я]{2,19}$",message = "The name must be between 3 and 12 letters long and start with a capital letter.")
    public String getFirstName() {
        return firstName;
    }

    public TeacherBindingModel setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    @Pattern(regexp = "^[А-Я][а-я]{2,19}$",message = "Last name must be between 3 and 12 letters long and start with a capital letter.")
    public String getMiddleName() {
        return middleName;
    }

    public TeacherBindingModel setMiddleName(String middleName) {
        this.middleName = middleName;
        return this;
    }

    @Pattern(regexp = "^[А-Я][а-я]{2,19}$",message = "The last name must be between 3 and 12 letters long and begin with a capital letter.")
    public String getLastName() {
        return lastName;
    }

    public TeacherBindingModel setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    @Email
    public String getUserEmail() {
        return userEmail;
    }

    public TeacherBindingModel setUserEmail(String userEmail) {
        this.userEmail = userEmail;
        return this;
    }
}
