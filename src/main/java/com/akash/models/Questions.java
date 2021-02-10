/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.akash.models;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Akash
 */
@Entity
@Table(name = "questions", catalog = "practicetest", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Questions.findAll", query = "SELECT q FROM Questions q")
    , @NamedQuery(name = "Questions.findByQid", query = "SELECT q FROM Questions q WHERE q.qid = :qid")
    , @NamedQuery(name = "Questions.findByQuestion", query = "SELECT q FROM Questions q WHERE q.question = :question")
    , @NamedQuery(name = "Questions.findByMarks", query = "SELECT q FROM Questions q WHERE q.marks = :marks")
    , @NamedQuery(name = "Questions.findByMcq1", query = "SELECT q FROM Questions q WHERE q.mcq1 = :mcq1")
    , @NamedQuery(name = "Questions.findByMcq2", query = "SELECT q FROM Questions q WHERE q.mcq2 = :mcq2")
    , @NamedQuery(name = "Questions.findByMcq3", query = "SELECT q FROM Questions q WHERE q.mcq3 = :mcq3")
    , @NamedQuery(name = "Questions.findByMcq4", query = "SELECT q FROM Questions q WHERE q.mcq4 = :mcq4")
    , @NamedQuery(name = "Questions.findByAnswer", query = "SELECT q FROM Questions q WHERE q.answer = :answer")})
public class Questions implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "qid")
    private Integer qid;
    @Size(max = 255)
    @Column(name = "question")
    private String question;
    @Column(name = "marks")
    private Integer marks;
    @Size(max = 128)
    @Column(name = "mcq1")
    private String mcq1;
    @Size(max = 128)
    @Column(name = "mcq2")
    private String mcq2;
    @Size(max = 128)
    @Column(name = "mcq3")
    private String mcq3;
    @Size(max = 128)
    @Column(name = "mcq4")
    private String mcq4;
    @Size(max = 255)
    @Column(name = "answer")
    private String answer;
    @ManyToOne
    private Test test;

    public Questions() {
    }
    
    

    public Questions(Integer qid, @Size(max = 255) String question, Integer marks, @Size(max = 128) String mcq1,
			@Size(max = 128) String mcq2, @Size(max = 128) String mcq3, @Size(max = 128) String mcq4,
			@Size(max = 255) String answer, Test test) {
		super();
		this.qid = qid;
		this.question = question;
		this.marks = marks;
		this.mcq1 = mcq1;
		this.mcq2 = mcq2;
		this.mcq3 = mcq3;
		this.mcq4 = mcq4;
		this.answer = answer;
		this.test = test;
	}



	public Questions(Integer qid) {
        this.qid = qid;
    }

    public Integer getQid() {
        return qid;
    }

    public void setQid(Integer qid) {
        this.qid = qid;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Integer getMarks() {
        return marks;
    }

    public void setMarks(Integer marks) {
        this.marks = marks;
    }

    public String getMcq1() {
        return mcq1;
    }

    public void setMcq1(String mcq1) {
        this.mcq1 = mcq1;
    }

    public String getMcq2() {
        return mcq2;
    }

    public void setMcq2(String mcq2) {
        this.mcq2 = mcq2;
    }

    public String getMcq3() {
        return mcq3;
    }

    public void setMcq3(String mcq3) {
        this.mcq3 = mcq3;
    }

    public String getMcq4() {
        return mcq4;
    }

    public void setMcq4(String mcq4) {
        this.mcq4 = mcq4;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
    
    

    public Test getTest() {
		return test;
	}

	public void setTest(Test test) {
		this.test = test;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (qid != null ? qid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Questions)) {
            return false;
        }
        Questions other = (Questions) object;
        if ((this.qid == null && other.qid != null) || (this.qid != null && !this.qid.equals(other.qid))) {
            return false;
        }
        return true;
    }



	@Override
	public String toString() {
		return "Questions [qid=" + qid + ", question=" + question + ", marks=" + marks + ", mcq1=" + mcq1 + ", mcq2="
				+ mcq2 + ", mcq3=" + mcq3 + ", mcq4=" + mcq4 + ", answer=" + answer + ", test=" + test + "]";
	}


    
}


/*
 * package com.akash.models;
 * 
 * import java.util.Arrays;
 * 
 * import javax.persistence.Column; import javax.persistence.Entity; import
 * javax.persistence.GeneratedValue; import javax.persistence.GenerationType;
 * import javax.persistence.Id; import javax.persistence.Table;
 * 
 * @Entity
 * 
 * @Table(name="question") public class Questions {
 * 
 * @Id
 * 
 * @GeneratedValue(strategy = GenerationType.AUTO) private int qid; private
 * String question; private int marks; private String mcq1; private String mcq2;
 * private String mcq3; private String mcq4; private String answer;
 * 
 * public Questions() { }
 * 
 * public Questions(int qid, String question, int marks, String mcq1, String
 * mcq2, String mcq3, String mcq4, String answer) { super(); this.qid = qid;
 * this.question = question; this.marks = marks; this.mcq1 = mcq1; this.mcq2 =
 * mcq2; this.mcq3 = mcq3; this.mcq4 = mcq4; this.answer = answer; }
 * 
 * public int getQid() { return qid; }
 * 
 * public void setQid(int qid) { this.qid = qid; }
 * 
 * public String getQuestion() { return question; }
 * 
 * public void setQuestion(String question) { this.question = question; }
 * 
 * public int getMarks() { return marks; }
 * 
 * public void setMarks(int marks) { this.marks = marks; }
 * 
 * public String getMcq1() { return mcq1; }
 * 
 * public void setMcq1(String mcq1) { this.mcq1 = mcq1; }
 * 
 * public String getMcq2() { return mcq2; }
 * 
 * public void setMcq2(String mcq2) { this.mcq2 = mcq2; }
 * 
 * public String getMcq3() { return mcq3; }
 * 
 * public void setMcq3(String mcq3) { this.mcq3 = mcq3; }
 * 
 * public String getMcq4() { return mcq4; }
 * 
 * public void setMcq4(String mcq4) { this.mcq4 = mcq4; }
 * 
 * public String getAnswer() { return answer; }
 * 
 * public void setAnswer(String answer) { this.answer = answer; }
 * 
 * @Override public int hashCode() { final int prime = 31; int result = 1;
 * result = prime * result + qid; return result; }
 * 
 * @Override public boolean equals(Object obj) { if (this == obj) return true;
 * if (obj == null) return false; if (getClass() != obj.getClass()) return
 * false; Questions other = (Questions) obj; if (qid != other.qid) return false;
 * return true; }
 * 
 * @Override public String toString() { return "Questions [qid=" + qid +
 * ", question=" + question + ", marks=" + marks + ", mcq1=" + mcq1 + ", mcq2="
 * + mcq2 + ", mcq3=" + mcq3 + ", mcq4=" + mcq4 + ", answer=" + answer + "]"; }
 * 
 * }
 */