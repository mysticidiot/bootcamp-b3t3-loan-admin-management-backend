package com.b3t3.loanAdminManagement.model;

import javax.persistence.*;

@Entity
@Table(name="loan_card_master")
public class Loan_Card_Master {

    @Id
    String loan_id;

    @Column
    String loan_type;

    @Column
    int duration_in_years;

    @OneToMany
    @JoinColumn(name="loan_id")
    Employee_Card_Details empCardDetails;

    public String getLoan_id() {
        return loan_id;
    }

    public void setLoan_id(String loan_id) {
        this.loan_id = loan_id;
    }

    public String getLoan_type() {
        return loan_type;
    }

    public void setLoan_type(String loan_type) {
        this.loan_type = loan_type;
    }

    public int getDuration_in_years() {
        return duration_in_years;
    }

    public void setDuration_in_years(int duration_in_years) {
        this.duration_in_years = duration_in_years;
    }

    public Employee_Card_Details getEmpCardDetails() {
        return empCardDetails;
    }

    public void setEmpCardDetails(Employee_Card_Details empCardDetails) {
        this.empCardDetails = empCardDetails;
    }

    public Loan_Card_Master(String loan_id, String loan_type, int duration_in_years) {
        this.loan_id = loan_id;
        this.loan_type = loan_type;
        this.duration_in_years = duration_in_years;
    }

    public Loan_Card_Master(String loan_id, String loan_type, int duration_in_years, Employee_Card_Details empCardDetails) {
        this.loan_id = loan_id;
        this.loan_type = loan_type;
        this.duration_in_years = duration_in_years;
        this.empCardDetails = empCardDetails;
    }
}
