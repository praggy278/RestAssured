package nestedPOJO;

import java.util.List;

public class Company {

	private String companyName;
	private String companyHOCity;
	private String companyCEO;
	private List<String> supportedSalaryBanks;
	private List<Integer> pincodesOfCityOffice;
	List<Employee> employee;
	List<Contractor> contractors;
	CompanyPFDetails companyPFDeails;
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCompanyHOCity() {
		return companyHOCity;
	}
	public void setCompanyHOCity(String companyHOCity) {
		this.companyHOCity = companyHOCity;
	}
	public String getCompanyCEO() {
		return companyCEO;
	}
	public void setCompanyCEO(String companyCEO) {
		this.companyCEO = companyCEO;
	}
	public List<String> getSupportedSalaryBanks() {
		return supportedSalaryBanks;
	}
	public void setSupportedSalaryBanks(List<String> supportedSalaryBanks) {
		this.supportedSalaryBanks = supportedSalaryBanks;
	}
	public List<Integer> getPincodesOfCityOffice() {
		return pincodesOfCityOffice;
	}
	public void setPincodesOfCityOffice(List<Integer> pincodesOfCityOffice) {
		this.pincodesOfCityOffice = pincodesOfCityOffice;
	}
	public List<Employee> getEmployee() {
		return employee;
	}
	public void setEmployee(List<Employee> employee) {
		this.employee = employee;
	}
	public List<Contractor> getContractors() {
		return contractors;
	}
	public void setContractors(List<Contractor> contractors) {
		this.contractors = contractors;
	}
	public CompanyPFDetails getCompanyPFDeails() {
		return companyPFDeails;
	}
	public void setCompanyPFDeails(CompanyPFDetails companyPFDeails) {
		this.companyPFDeails = companyPFDeails;
	}
	
	
}
