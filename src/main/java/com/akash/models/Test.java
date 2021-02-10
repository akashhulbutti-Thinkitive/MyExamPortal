/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.akash.models;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Akash
 */
@Entity
@Table(name = "test", catalog = "practicetest", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Test.findAll", query = "SELECT t FROM Test t")
    , @NamedQuery(name = "Test.findByTestid", query = "SELECT t FROM Test t WHERE t.testid = :testid")

    , @NamedQuery(name = "Test.findByStandard", query = "SELECT t FROM Test t WHERE t.standard = :standard")
    , @NamedQuery(name = "Test.findBySubject", query = "SELECT t FROM Test t WHERE t.subject = :subject")
    , @NamedQuery(name = "Test.findByStatus", query = "SELECT t FROM Test t WHERE t.status = :status")})
public class Test implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "testid")
    private Integer testid;
    @Column(name = "standard")
    private Integer standard;
    @Size(max = 255)
    @Column(name = "subject")
    private String subject;
    @Size(max = 6)
    @Column(name = "status")
    private String status;
    @OneToMany(mappedBy = "test")
    private Collection<StudentTestResponse> studentTestResponseCollection;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="test")
    private Collection<Questions> questions;

    public Test() {
    }

    
    
    public Test(Integer testid, Integer standard, @Size(max = 255) String subject,
			@Size(max = 6) String status, Collection<StudentTestResponse> studentTestResponseCollection,
			Set<Questions> questions) {
		super();
		this.testid = testid;
		this.standard = standard;
		this.subject = subject;
		this.status = status;
		this.studentTestResponseCollection = studentTestResponseCollection;
		this.questions = questions;
	}



	public Test(Integer testid) {
        this.testid = testid;
    }

    public Integer getTestid() {
        return testid;
    }

    public void setTestid(Integer testid) {
        this.testid = testid;
    }

    public Integer getStandard() {
        return standard;
    }

    public void setStandard(Integer standard) {
        this.standard = standard;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    

	public Collection<Questions> getQuestions() {
		return questions;
	}

	public void setQuestions(Collection<Questions> questions) {
		this.questions = questions;
	}

	@XmlTransient
    public Collection<StudentTestResponse> getStudentTestResponseCollection() {
        return studentTestResponseCollection;
    }

    public void setStudentTestResponseCollection(Collection<StudentTestResponse> studentTestResponseCollection) {
        this.studentTestResponseCollection = studentTestResponseCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (testid != null ? testid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Test)) {
            return false;
        }
        Test other = (Test) object;
        if ((this.testid == null && other.testid != null) || (this.testid != null && !this.testid.equals(other.testid))) {
            return false;
        }
        return true;
    }

    
    
    @Override
	public String toString() {
		return "Test [testid=" + testid + ", standard=" + standard + ", subject=" + subject
				+ ", status=" + status + ", studentTestResponseCollection=" + studentTestResponseCollection
				+ ", questions=" + questions + "]";
	}
}

/*
 * package com.akash.models;
 * 
 * import java.io.Serializable; import java.util.List;
 * 
 * import javax.persistence.ElementCollection; import javax.persistence.Entity;
 * import javax.persistence.GeneratedValue; import
 * javax.persistence.GenerationType; import javax.persistence.Id; import
 * javax.persistence.OneToMany; import javax.persistence.Table;
 * 
 * @Entity
 * 
 * @Table(name = "test") public class Test implements Serializable{
 * 
 * @Id
 * 
 * @GeneratedValue(strategy = GenerationType.AUTO) private int testid; private
 * int standard; private String subject; private String status;
 * 
 * @OneToMany private List<Questions> questions;
 * 
 * public Test() { // TODO Auto-generated constructor stub }
 * 
 * public Test(int testid, int standard, String subject, String status,
 * List<Questions> questions) { super(); this.testid = testid; this.standard =
 * standard; this.subject = subject; this.status = status; this.questions =
 * questions; }
 * 
 * public int getTestid() { return testid; }
 * 
 * public void setTestid(int testid) { this.testid = testid; }
 * 
 * public int getStandard() { return standard; }
 * 
 * public void setStandard(int standard) { this.standard = standard; }
 * 
 * public String getSubject() { return subject; }
 * 
 * public void setSubject(String subject) { this.subject = subject; }
 * 
 * public String getStatus() { return status; }
 * 
 * public void setStatus(String status) { this.status = status; }
 * 
 * public List<Questions> getQuestions() { return questions; }
 * 
 * public void setQuestions(List<Questions> questions) { this.questions =
 * questions; }
 * 
 * @Override public int hashCode() { final int prime = 31; int result = 1;
 * result = prime * result + testid; return result; }
 * 
 * @Override public boolean equals(Object obj) { if (this == obj) return true;
 * if (obj == null) return false; if (getClass() != obj.getClass()) return
 * false; Test other = (Test) obj; if (testid != other.testid) return false;
 * return true; }
 * 
 * @Override public String toString() { return "Test [testid=" + testid +
 * ", standard=" + standard + ", subject=" + subject + ", status=" + status +
 * ", questions=" + questions + "]"; }
 * 
 * 
 * 
 * }
 */