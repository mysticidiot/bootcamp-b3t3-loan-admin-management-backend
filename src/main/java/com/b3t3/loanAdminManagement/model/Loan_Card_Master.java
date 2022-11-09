package com.b3t3.loanAdminManagement.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="loan_card_master")
public class Loan_Card_Master {

    @Id
    @NotBlank(message = "Id cant be blank")
    String loan_id;

    @Column
    @NotBlank(message = "type cant be blank")
    String loan_type;

    @Column
    @NotBlank(message = "duration cant be blank")
    int duration_in_years;

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
    
    public Loan_Card_Master() {}

    public Loan_Card_Master(String loan_id, String loan_type, int duration_in_years) {
        this.loan_id = loan_id;
        this.loan_type = loan_type;
        this.duration_in_years = duration_in_years;
    }


}
