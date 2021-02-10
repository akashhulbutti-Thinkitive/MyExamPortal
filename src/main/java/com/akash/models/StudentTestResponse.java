/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.akash.models;

import java.io.Serializable;
import java.util.Arrays;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
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
@Table(name = "student_test_response", catalog = "practicetest", schema = "")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "StudentTestResponse.findAll", query = "SELECT s FROM StudentTestResponse s"),
		@NamedQuery(name = "StudentTestResponse.findByStrid", query = "SELECT s FROM StudentTestResponse s WHERE s.strid = :strid"),
		@NamedQuery(name = "StudentTestResponse.findByRemark", query = "SELECT s FROM StudentTestResponse s WHERE s.remark = :remark") })
public class StudentTestResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "strid")
	private Integer strid;
	@Lob
	@Column(name = "answers")
	private byte[] answers;
	@Size(max = 255)
	@Column(name = "remark")
	private String remark;
	@JoinColumn(name = "student", referencedColumnName = "sid")
	@ManyToOne
	private Student student;
	@JoinColumn(name = "test", referencedColumnName = "testid")
	@ManyToOne
	private Test test;

	public StudentTestResponse() {
	}

	public StudentTestResponse(Integer strid) {
		this.strid = strid;
	}

	public Integer getStrid() {
		return strid;
	}

	public void setStrid(Integer strid) {
		this.strid = strid;
	}

	public byte[] getAnswers() {
		return answers;
	}

	public void setAnswers(byte[] answers) {
		this.answers = answers;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
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
		hash += (strid != null ? strid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof StudentTestResponse)) {
			return false;
		}
		StudentTestResponse other = (StudentTestResponse) object;
		if ((this.strid == null && other.strid != null) || (this.strid != null && !this.strid.equals(other.strid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "StudentTestResponse [strid=" + strid + ", answers=" + Arrays.toString(answers) + ", remark=" + remark
				+ ", student=" + student + ", test=" + test + "]";
	}

}

/*
 * package com.akash.models;
 * 
 * import java.io.Serializable; import java.util.Arrays; import java.util.Map;
 * 
 * import javax.persistence.ElementCollection; import javax.persistence.Entity;
 * import javax.persistence.GeneratedValue; import
 * javax.persistence.GenerationType; import javax.persistence.Id; import
 * javax.persistence.Table;
 * 
 * @Entity
 * 
 * @Table(name = "student_test_result") public class StudentTestResult
 * implements Serializable{
 * 
 * @Id
 * 
 * @GeneratedValue(strategy = GenerationType.AUTO) private int strId; private
 * String student; private String testid; private String givenAnswers[]; private
 * String status;
 * 
 * StudentTestResult(){
 * 
 * }
 * 
 * public StudentTestResult(int strId, String student, String testid, String[]
 * givenAnswers, String status) { super(); this.strId = strId; this.student =
 * student; this.testid = testid; this.givenAnswers = givenAnswers; this.status
 * = status; }
 * 
 * public int getStrId() { return strId; }
 * 
 * public void setStrId(int strId) { this.strId = strId; }
 * 
 * public String getStudent() { return student; }
 * 
 * public void setStudent(String student) { this.student = student; }
 * 
 * public String getTestid() { return testid; }
 * 
 * public void setTestid(String testid) { this.testid = testid; }
 * 
 * public String[] getGivenAnswers() { return givenAnswers; }
 * 
 * public void setGivenAnswers(String[] givenAnswers) { this.givenAnswers =
 * givenAnswers; }
 * 
 * public String getStatus() { return status; }
 * 
 * public void setStatus(String status) { this.status = status; }
 * 
 * @Override public int hashCode() { final int prime = 31; int result = 1;
 * result = prime * result + ((testid == null) ? 0 : testid.hashCode()); return
 * result; }
 * 
 * @Override public boolean equals(Object obj) { if (this == obj) return true;
 * if (obj == null) return false; if (getClass() != obj.getClass()) return
 * false; StudentTestResult other = (StudentTestResult) obj; if (testid == null)
 * { if (other.testid != null) return false; } else if
 * (!testid.equals(other.testid)) return false; return true; }
 * 
 * @Override public String toString() { return "StudentTestResult [strId=" +
 * strId + ", student=" + student + ", testid=" + testid + ", givenAnswers=" +
 * Arrays.toString(givenAnswers) + ", status=" + status + "]"; }
 * 
 * 
 * }
 */