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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "admin", catalog = "practicetest", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Admin.findAll", query = "SELECT a FROM Admin a")
    , @NamedQuery(name = "Admin.findByAid", query = "SELECT a FROM Admin a WHERE a.aid = :aid")
    , @NamedQuery(name = "Admin.findByFirstname", query = "SELECT a FROM Admin a WHERE a.firstname = :firstname")
    , @NamedQuery(name = "Admin.findByLastname", query = "SELECT a FROM Admin a WHERE a.lastname = :lastname")})
public class Admin implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "aid")
    private Integer aid;
    @Size(max = 255)
    @Column(name = "firstname")
    private String firstname;
    @Size(max = 255)
    @Column(name = "lastname")
    private String lastname;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "uid")
    private Commonuser user;

    public Admin() {
    }
    
    

    public Admin(Integer aid, @Size(max = 255) String firstname, @Size(max = 255) String lastname, Commonuser user) {
		super();
		this.aid = aid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.user = user;
	}



	public Admin(Integer aid) {
        this.aid = aid;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
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

    public Commonuser getUser() {
        return user;
    }

    public void setUser(Commonuser user) {
        this.user = user;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (aid != null ? aid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Admin)) {
            return false;
        }
        Admin other = (Admin) object;
        if ((this.aid == null && other.aid != null) || (this.aid != null && !this.aid.equals(other.aid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Admin{" + "aid=" + aid + ", firstname=" + firstname + ", lastname=" + lastname + ", user=" + user + '}';
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
 * @Table(name = "admin") public class Admin implements Serializable{
 * 
 * @Id
 * 
 * @GeneratedValue(strategy = GenerationType.AUTO) public int aid; public String
 * firstname; public String lastname; public CommonUser user;
 * 
 * public Admin() { // TODO Auto-generated constructor stub }
 * 
 * public Admin(int aid, String firstname, String lastname, CommonUser user) {
 * super(); this.aid = aid; this.firstname = firstname; this.lastname =
 * lastname; this.user = user; }
 * 
 * @Override public int hashCode() { final int prime = 31; int result = 1;
 * result = prime * result + aid; result = prime * result + ((firstname == null)
 * ? 0 : firstname.hashCode()); result = prime * result + ((lastname == null) ?
 * 0 : lastname.hashCode()); result = prime * result + ((user == null) ? 0 :
 * user.hashCode()); return result; }
 * 
 * public int getAid() { return aid; }
 * 
 * public void setAid(int aid) { this.aid = aid; }
 * 
 * 
 * public String getFirstname() { return firstname; }
 * 
 * public void setFirstname(String firstname) { this.firstname = firstname; }
 * 
 * public String getLastname() { return lastname; }
 * 
 * public void setLastname(String lastname) { this.lastname = lastname; }
 * 
 * public CommonUser getUser() { return user; }
 * 
 * public void setUser(CommonUser user) { this.user = user; }
 * 
 * @Override public boolean equals(Object obj) { if (this == obj) return true;
 * if (obj == null) return false; if (getClass() != obj.getClass()) return
 * false; Admin other = (Admin) obj; if (aid != other.aid) return false; if
 * (firstname == null) { if (other.firstname != null) return false; } else if
 * (!firstname.equals(other.firstname)) return false; if (lastname == null) { if
 * (other.lastname != null) return false; } else if
 * (!lastname.equals(other.lastname)) return false; if (user == null) { if
 * (other.user != null) return false; } else if (!user.equals(other.user))
 * return false; return true; }
 * 
 * @Override public String toString() { return "Admin [aid=" + aid +
 * ", firstname=" + firstname + ", lastname=" + lastname + ", user=" + user +
 * "]"; }
 * 
 * 
 * 
 * 
 * }
 */