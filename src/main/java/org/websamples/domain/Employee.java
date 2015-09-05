package org.websamples.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the employees database table.
 * 
 */
@Entity
@Table(name="employees")
//@NamedQuery(name="Employee.findAll", query="SELECT e FROM Employee e")


@NamedQueries({
	@NamedQuery(name="Employee.findAll", query="SELECT c FROM Employee c"),
	@NamedQuery(name="Employee.findById", query="SELECT c FROM Employee c where c.employeenumber = :id ")
})


public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Integer employeenumber;

	@Column(length=100)
	private String email;

	@Column(length=10)
	private String extension;

	@Column(length=50)
	private String firstname;

	@Column(length=50)
	private String jobtitle;

	@Column(length=50)
	private String lastname;

	private Integer reportsto;

	//bi-directional many-to-one association to Customer
	@OneToMany(mappedBy="employee")
	private List<Customer> customers;

	//bi-directional many-to-one association to Office
	@ManyToOne
	@JoinColumn(name="officecode")
	private Office office;

	public Employee() {
	}

	public Integer getEmployeenumber() {
		return this.employeenumber;
	}

	public void setEmployeenumber(Integer employeenumber) {
		this.employeenumber = employeenumber;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getExtension() {
		return this.extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getJobtitle() {
		return this.jobtitle;
	}

	public void setJobtitle(String jobtitle) {
		this.jobtitle = jobtitle;
	}

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Integer getReportsto() {
		return this.reportsto;
	}

	public void setReportsto(Integer reportsto) {
		this.reportsto = reportsto;
	}

	public List<Customer> getCustomers() {
		return this.customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	public Customer addCustomer(Customer customer) {
		getCustomers().add(customer);
		customer.setEmployee(this);

		return customer;
	}

	public Customer removeCustomer(Customer customer) {
		getCustomers().remove(customer);
		customer.setEmployee(null);

		return customer;
	}

	public Office getOffice() {
		return this.office;
	}

	public void setOffice(Office office) {
		this.office = office;
	}

}