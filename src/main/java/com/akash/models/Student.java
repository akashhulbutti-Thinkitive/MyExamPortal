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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "student", catalog = "practicetest", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Student.findAll", query = "SELECT s FROM Student s")
    , @NamedQuery(name = "Student.findBySid", query = "SELECT s FROM Student s WHERE s.sid = :sid")
    , @NamedQuery(name = "Student.findByRollno", query = "SELECT s FROM Student s WHERE s.rollno = :rollno")
    , @NamedQuery(name = "Student.findByFirstname", query = "SELECT s FROM Student s WHERE s.firstname = :firstname")
    , @NamedQuery(name = "Student.findByLastname", query = "SELECT s FROM Student s WHERE s.lastname = :lastname")
    , @NamedQuery(name = "Student.findByStandard", query = "SELECT s FROM Student s WHERE s.standard = :standard")})
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "sid")
    private Integer sid;
    @Size(max = 255)
    @Column(name = "rollno")
    private String rollno;
    @Size(max = 255)
    @Column(name = "firstname")
    private String firstname;
    @Size(max = 255)
    @Column(name = "lastname")
    private String lastname;
    @Size(max = 255)
    @Column(name = "standard")
    private String standard;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "uid")
    private Commonuser user;

    public Student() {
    }

    public Student(Integer sid) {
        this.sid = sid;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getRollno() {
        return rollno;
    }

    public void setRollno(String rollno) {
        this.rollno = rollno;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public Commonuser getUser() {
        return user;
    }

    public void setUser(Commonuser user) {
        this.user = user;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sid != null ? sid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Student)) {
            return false;
        }
        Student other = (Student) object;
        if ((this.sid == null && other.sid != null) || (this.sid != null && !this.sid.equals(other.sid))) {
            return false;
        }
        return true;
    }

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", rollno=" + rollno + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", standard=" + standard + ", user=" + user + "]";
	}

	
    
}


/*
 * package com.akash.models;
 * 
 * import java.io.Serializable;
 * 
 * import javax.persistence.Entity; import javax.persistence.GeneratedValue;
 * import javax.persistence.GenerationType; import javax.persistence.Id; import
 * javax.persistence.Table;
 * 
 * @Entity
 * 
 * @Table(name = "student") public class Student implements Serializable {
 * 
 * @Id
 * 
 * @GeneratedValue(strategy = GenerationType.AUTO) private int sid; private int
 * rollno; private String firstname; private String lastname; private int
 * standard; private Commonuser user;
 * 
 * public Student() { // TODO Auto-generated constructor stub }
 * 
 * public Student(int sid, int rollno, String firstname, String lastname, int
 * standard, CommonUser user) { super(); this.sid = sid; this.rollno = rollno;
 * this.firstname = firstname; this.lastname = lastname; this.standard =
 * standard; this.user = user; }
 * 
 * public int getSid() { return sid; }
 * 
 * public void setSid(int sid) { this.sid = sid; }
 * 
 * public int getRollno() { return rollno; }
 * 
 * public void setRollno(int rollno) { this.rollno = rollno; }
 * 
 * public String getFirstname() { return firstname; }
 * 
 * public void setFirstname(String firstname) { this.firstname = firstname; }
 * 
 * public String getLastname() { return lastname; }
 * 
 * public void setLastname(String lastname) { this.lastname = lastname; }
 * 
 * public int getStandard() { return standard; }
 * 
 * public void setStandard(int standard) { this.standard = standard; }
 * 
 * public CommonUser getUser() { return user; }
 * 
 * public void setUser(CommonUser user) { this.user = user; }
 * 
 * @Override public int hashCode() { final int prime = 31; int result = 1;
 * result = prime * result + sid; return result; }
 * 
 * @Override public boolean equals(Object obj) { if (this == obj) return true;
 * if (obj == null) return false; if (getClass() != obj.getClass()) return
 * false; Student other = (Student) obj; if (sid != other.sid) return false;
 * return true; }
 * 
 * @Override public String toString() { return "Student [sid=" + sid +
 * ", rollno=" + rollno + ", firstname=" + firstname + ", lastname=" + lastname
 * + ", standard=" + standard + ", user=" + user + "]"; }
 * 
 * 
 * }
 */