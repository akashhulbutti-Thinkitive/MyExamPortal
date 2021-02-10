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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Akash
 */
@Entity
@Table(name = "teacher", catalog = "practicetest", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Teacher.findAll", query = "SELECT t FROM Teacher t")
    , @NamedQuery(name = "Teacher.findByTid", query = "SELECT t FROM Teacher t WHERE t.tid = :tid")
    , @NamedQuery(name = "Teacher.findByFirstname", query = "SELECT t FROM Teacher t WHERE t.firstname = :firstname")
    , @NamedQuery(name = "Teacher.findByLastname", query = "SELECT t FROM Teacher t WHERE t.lastname = :lastname")
    , @NamedQuery(name = "Teacher.findByStandard", query = "SELECT t FROM Teacher t WHERE t.standard = :standard")})
public class Teacher implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tid")
    private Integer tid;
    @Size(max = 255)
    @Column(name = "firstname")
    private String firstname;
    @Size(max = 255)
    @Column(name = "lastname")
    private String lastname;
    @Column(name = "standard")
    private Integer standard;
    @Lob
    @Column(name = "subject")
    private byte[] subject;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "uid")
    private Commonuser user;

    public Teacher() {
    }

    public Teacher(Integer tid) {
        this.tid = tid;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
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

    public Integer getStandard() {
        return standard;
    }

    public void setStandard(Integer standard) {
        this.standard = standard;
    }

    public byte[] getSubject() {
        return subject;
    }

    public void setSubject(byte[] subject) {
        this.subject = subject;
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
        hash += (tid != null ? tid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Teacher)) {
            return false;
        }
        Teacher other = (Teacher) object;
        if ((this.tid == null && other.tid != null) || (this.tid != null && !this.tid.equals(other.tid))) {
            return false;
        }
        return true;
    }

	@Override
	public String toString() {
		return "Teacher [tid=" + tid + ", firstname=" + firstname + ", lastname=" + lastname + ", standard=" + standard
				+ ", subject=" + Arrays.toString(subject) + ", user=" + user + "]";
	}

}

/*
 * package com.akash.models;
 * 
 * import java.io.Serializable; import java.util.List;
 * 
 * import javax.persistence.Entity; import javax.persistence.GeneratedValue;
 * import javax.persistence.GenerationType; import javax.persistence.Id; import
 * javax.persistence.Table;
 * 
 * @Entity
 * 
 * @Table(name = "teacher") public class Teacher implements Serializable{
 * 
 * @Id
 * 
 * @GeneratedValue(strategy = GenerationType.AUTO) private int tid; private
 * String firstname; private String lastname; private int standard; private
 * String subjects; private CommonUser user;
 * 
 * public Teacher() { // TODO Auto-generated constructor stub }
 * 
 * public Teacher(int tid, String firstname, String lastname, int standard,
 * String subjects, CommonUser user) { super(); this.tid = tid; this.firstname =
 * firstname; this.lastname = lastname; this.standard = standard; this.subjects
 * = subjects; this.user = user; }
 * 
 * public int getTid() { return tid; }
 * 
 * public void setTid(int tid) { this.tid = tid; }
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
 * public String getSubjects() { return subjects; }
 * 
 * public void setSubjects(String subjects) { this.subjects = subjects; }
 * 
 * public CommonUser getUser() { return user; }
 * 
 * public void setUser(CommonUser user) { this.user = user; }
 * 
 * @Override public int hashCode() { final int prime = 31; int result = 1;
 * result = prime * result + tid; return result; }
 * 
 * @Override public boolean equals(Object obj) { if (this == obj) return true;
 * if (obj == null) return false; if (getClass() != obj.getClass()) return
 * false; Teacher other = (Teacher) obj; if (tid != other.tid) return false;
 * return true; }
 * 
 * @Override public String toString() { return "Teacher [tid=" + tid +
 * ", firstname=" + firstname + ", lastname=" + lastname + ", standard=" +
 * standard + ", subjects=" + subjects + ", user=" + user + "]"; }
 * 
 * 
 * }
 */