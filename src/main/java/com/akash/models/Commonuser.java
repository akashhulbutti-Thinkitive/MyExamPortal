/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.akash.models;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Akash
 */
@Entity
@Table(name = "commonuser", catalog = "practicetest", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Commonuser.findAll", query = "SELECT c FROM Commonuser c")
    , @NamedQuery(name = "Commonuser.findByUid", query = "SELECT c FROM Commonuser c WHERE c.uid = :uid")
    , @NamedQuery(name = "Commonuser.findByUsername", query = "SELECT c FROM Commonuser c WHERE c.username = :username")
    , @NamedQuery(name = "Commonuser.findByPassword", query = "SELECT c FROM Commonuser c WHERE c.password = :password")
    , @NamedQuery(name = "Commonuser.findByRole", query = "SELECT c FROM Commonuser c WHERE c.role = :role")
    , @NamedQuery(name = "Commonuser.findBySecurityQuestion", query = "SELECT c FROM Commonuser c WHERE c.securityQuestion = :securityQuestion")
    , @NamedQuery(name = "Commonuser.findBySecurityAnswer", query = "SELECT c FROM Commonuser c WHERE c.securityAnswer = :securityAnswer")
    , @NamedQuery(name = "Commonuser.findByEnabled", query = "SELECT c FROM Commonuser c WHERE c.enabled = :enabled")})
public class Commonuser implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "uid")
    private Integer uid;
    @Size(max = 255)
    @Column(name = "username")
    private String username;
    @Size(max = 255)
    @Column(name = "password")
    private String password;
    @Size(max = 255)
    @Column(name = "role")
    private String role;
    @Size(max = 255)
    @Column(name = "security_question")
    private String securityQuestion;
    @Size(max = 255)
    @Column(name = "security_answer")
    private String securityAnswer;
    @Column(name = "enabled")
    private int enabled;
    
    @OneToOne(mappedBy = "user",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Admin admin;
    
    @OneToOne(mappedBy = "user",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Teacher teacher;
    
    @OneToOne(mappedBy = "user",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Student student;
    
   /*
    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY )
    private Collection<Teacher> teacherCollection;
    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY)
    private Collection<Student> studentCollection;
    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY)
    private Collection<Admin> adminCollection;
    */

    public Commonuser() {
    }

    
    

	public Commonuser(Integer uid, @Size(max = 255) String username, @Size(max = 255) String password,
		@Size(max = 255) String role, @Size(max = 255) String securityQuestion, @Size(max = 255) String securityAnswer,
		int enabled, Admin admin, Teacher teacher, Student student) {
	super();
	this.uid = uid;
	this.username = username;
	this.password = password;
	this.role = role;
	this.securityQuestion = securityQuestion;
	this.securityAnswer = securityAnswer;
	this.enabled = enabled;
	this.admin = admin;
	this.teacher = teacher;
	this.student = student;
}




	public Commonuser(Integer uid) {
        this.uid = uid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getSecurityQuestion() {
        return securityQuestion;
    }

    public void setSecurityQuestion(String securityQuestion) {
        this.securityQuestion = securityQuestion;
    }

    public String getSecurityAnswer() {
        return securityAnswer;
    }

    public void setSecurityAnswer(String securityAnswer) {
        this.securityAnswer = securityAnswer;
    }

    public int getEnabled() {
		return enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}

    public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (uid != null ? uid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Commonuser)) {
            return false;
        }
        Commonuser other = (Commonuser) object;
        if ((this.uid == null && other.uid != null) || (this.uid != null && !this.uid.equals(other.uid))) {
            return false;
        }
        return true;
    }



	@Override
	public String toString() {
		return "Commonuser [uid=" + uid + ", username=" + username + ", password=" + password + ", role=" + role
				+ ", securityQuestion=" + securityQuestion + ", securityAnswer=" + securityAnswer + ", enabled=" + enabled + "]";
	}


}


/*
 * package com.akash.models;
 * 
 * import java.io.Serializable;
 * 
 * import javax.persistence.Column; import javax.persistence.Entity; import
 * javax.persistence.GeneratedValue; import javax.persistence.GenerationType;
 * import javax.persistence.Id; import javax.persistence.Table;
 * 
 * @Entity
 * 
 * @Table(name = "test_user") public class CommonUser implements Serializable{
 *//**
	* 
	*//*
		 * private static final long serialVersionUID = 1L;
		 * 
		 * @Id
		 * 
		 * @GeneratedValue(strategy = GenerationType.AUTO) private int uid; private
		 * String username; private String password; private String role; private String
		 * security_question; private String security_answer;
		 * 
		 * public CommonUser() { // TODO Auto-generated constructor stub }
		 * 
		 * public int getUid() { return uid; }
		 * 
		 * public void setUid(int uid) { this.uid = uid; }
		 * 
		 * public String getUsername() { return username; }
		 * 
		 * public void setUsername(String username) { this.username = username; }
		 * 
		 * public String getPassword() { return password; }
		 * 
		 * public void setPassword(String password) { this.password = password; }
		 * 
		 * public String getRole() { return role; }
		 * 
		 * public void setRole(String role) { this.role = role; }
		 * 
		 * public String getSecurity_question() { return security_question; }
		 * 
		 * public void setSecurity_question(String security_question) {
		 * this.security_question = security_question; }
		 * 
		 * public String getSecurity_answer() { return security_answer; }
		 * 
		 * public void setSecurity_answer(String security_answer) { this.security_answer
		 * = security_answer; }
		 * 
		 * @Override public int hashCode() { final int prime = 31; int result = 1;
		 * result = prime * result + uid; return result; }
		 * 
		 * @Override public boolean equals(Object obj) { if (this == obj) return true;
		 * if (obj == null) return false; if (getClass() != obj.getClass()) return
		 * false; CommonUser other = (CommonUser) obj; if (uid != other.uid) return
		 * false; return true; }
		 * 
		 * @Override public String toString() { return "CommonUser [uid=" + uid +
		 * ", username=" + username + ", password=" + password + ", role=" + role +
		 * ", security_question=" + security_question + ", security_answer=" +
		 * security_answer + "]"; }
		 * 
		 * 
		 * 
		 * }
		 */