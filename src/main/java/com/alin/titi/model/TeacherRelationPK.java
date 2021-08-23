package com.alin.titi.model;



import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;
import java.io.Serializable;
@Embeddable
public class TeacherRelationPK implements Serializable {

    private Integer tchNumber;
    private Integer tchYear;
    private Integer tchSemester;
    /** getters and setters **/
    public Integer getTchNumber() {
        return tchNumber;
    }

    public void setTchNumber(Integer tchNumber) {
        this.tchNumber = tchNumber;
    }

    public Integer getTchYear() {
        return tchYear;
    }

    public void setTchYear(Integer tchYear) {
        this.tchYear = tchYear;
    }

    public Integer getTchSemester() {
        return tchSemester;
    }

    public void setTchSemester(Integer tchSemester) {
        this.tchSemester = tchSemester;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TeacherRelationPK that = (TeacherRelationPK) o;

        if (!tchYear.equals(that.tchYear)) return false;
        if (!tchNumber.equals(that.tchNumber)) return false;
        return tchSemester.equals(that.tchSemester);
    }

    @Override
    public int hashCode() {
        int result = tchYear.hashCode();
        result = result + tchNumber.hashCode();
        result = 31 * result + tchSemester.hashCode();
        return result;
    }
}
