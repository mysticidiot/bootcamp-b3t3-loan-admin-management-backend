package com.b3t3.loanAdminManagement.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="employee_card_details")
public class Employee_Card_Details {

    @Id
    String employee_id;

    @Column
    String loan_id;

    @Column
    Date card_issue_date;

    @ManyToOne
    @JoinColumn(name="employee_id")
    Employee_Master employeeMaster;

    @ManyToOne
    @JoinColumn(name="loan_id")
    Loan_Card_Master loanCardMaster;

    public String getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(String employee_id) {
        this.employee_id = employee_id;
    }

    public String getLoan_id() {
        return loan_id;
    }

    public void setLoan_id(String loan_id) {
        this.loan_id = loan_id;
    }

    public Date getCard_issue_date() {
        return card_issue_date;
    }

    public void setCard_issue_date(Date card_issue_date) {
        this.card_issue_date = card_issue_date;
    }

    public Employee_Master getEmployeeMaster() {
        return employeeMaster;
    }

    public void setEmployeeMaster(Employee_Master employeeMaster) {
        this.employeeMaster = employeeMaster;
    }

    public Loan_Card_Master getLoanCardMaster() {
        return loanCardMaster;
    }

    public void setLoanCardMaster(Loan_Card_Master loanCardMaster) {
        this.loanCardMaster = loanCardMaster;
    }

    public Employee_Card_Details(String employee_id, String loan_id, Date card_issue_date) {
        this.employee_id = employee_id;
        this.loan_id = loan_id;
        this.card_issue_date = card_issue_date;
    }

    public Employee_Card_Details(String employee_id, String loan_id, Date card_issue_date, Employee_Master employeeMaster) {
        this.employee_id = employee_id;
        this.loan_id = loan_id;
        this.card_issue_date = card_issue_date;
        this.employeeMaster = employeeMaster;
    }

    public Employee_Card_Details(String employee_id, String loan_id, Date card_issue_date, Loan_Card_Master loanCardMaster) {
        this.employee_id = employee_id;
        this.loan_id = loan_id;
        this.card_issue_date = card_issue_date;
        this.loanCardMaster = loanCardMaster;
    }

    public Employee_Card_Details(String employee_id, String loan_id, Date card_issue_date, Employee_Master employeeMaster, Loan_Card_Master loanCardMaster) {
        this.employee_id = employee_id;
        this.loan_id = loan_id;
        this.card_issue_date = card_issue_date;
        this.employeeMaster = employeeMaster;
        this.loanCardMaster = loanCardMaster;
    }
}
