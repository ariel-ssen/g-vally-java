package test.jdbc.oracle;
/**
 * Employee DataModel class
 * OracleDBMS EmpTBL의 레코드 하나와 일치되는 내용으로
 * 기본 데이터 클래스임
 * 
 * @author user04
 *
 */
public class Employee {

	private String id;
	private String pwd;
	private String name;
	private String phone;
	private String email;
	private String hireDT;
	
	public Employee(String id, String pwd, String name, String phone, String email, String hireDT) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.hireDT = hireDT;
	}

	@Override
	public String toString() {
		return "Employee \n"
				+ "[id=" + id + ", \tpwd=" + pwd + ", \n"
				+ "name=" + name + ", \tphone=" + phone + ", \n"
				+ "email=" + email + ", \thireDT=" + hireDT + "]";
	}
	
	// public interface : 외부의 필요한 자원과 내부의 자원을 연결(보안의 이유 때문에 : 객체 지향의 특성)
	public String getId() {
		return id;
	}
	public String getPwd() {
		return pwd;
	}
	public String getName() {
		return name;
	}
	public String getPhone() {
		return phone;
	}
	public String getEmail() {
		return email;
	}
	public String getHireDT() {
		return hireDT;
	}
	
	
	public void setId(String id) {
		this.id = id;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setHireDT(String hireDT) {
		this.hireDT = hireDT;
	}
	
	


	
}
