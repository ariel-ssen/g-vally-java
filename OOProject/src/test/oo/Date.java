package test.oo;

public class Date {
	private int year;
	private int month;	// 1 ~ 12
	private int day;
	// public �� ������ ������ private (���м�)
	private int[] lastDayOfMonth = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	
	public Date(int year, int month, int day) {
		super();
		this.setYear(year);
		this.month = month;
		this.day = day;
	}

	public Date() {
		// default �����ڴ� �ڵ����� �������
		// �����ڰ� �ƿ� ������ default �����ڰ� �ڵ����� �����������
		// �����ڸ� ����� default �����ڰ� �ȸ�������� ������
		// ������ ��(���� Date ������ ���ΰ� �� Date ������ ����� ������)
		
		// ������ ���� ����ϴ� �ͺ���
		// �����ڿ��� ���� ����ϴ°� �� ������
		this(0, 1, 1);
	}

	@Override
	public String toString() {
		 return new String(new StringBuilder().append("Date::").append(year).append(".")
				 .append(month).append(".").append(day).append("."));
		
//		return getYear() + "." + month + "." + day + ".";
	}
	
	
	/**
	 * @return the year
	 */
	public int getYear() {
		return year;
	}
	
	/**
	 * ���� �Ⱥ��̰� ��
	 * block = "*"
	 * return year ��� block 4��
	 * y = yourBirth.getYear("*");
	 * syso(u) -> "****"
	 * 
	 * @param block
	 * @return
	 */
	public String getYear(String block) {
		// String�� �����ؼ� ����ؾ� �� ���
		// ���� �����ʹ� StringBuffer ��
		// ���ο� �����ʹ� StringBuilder�� ����� ����Ѵ�.
		return new String(new StringBuilder(block).append(block).append(block).append(block));
	}

	/**
	 * @param year the year to set
	 */
	public void setYear(int year) {
		this.year = year;
		setDay(day);
	}

	/**
	 * month�� ���� : 1~12
	 * �� ���� ���� exception�� ������ ��
	 * �� ������� 
	 * 0���ϰ� ������ 1�� ġȯ
	 * 13�̻��� ������ 12�� ġȯ
	 * @param month
	 */
	void setMonth(int month){
//		this.month = month;
		
		if (month < 1) {
			month = 1;
		} else if (month > 12) {
			month = 12;
		} 
			
		this.month = month;		
		setDay(this.day);		// ���� �ٲٰ� ���� �ȹٲ� ��쿡 ����ؼ�
	}

	/**
	 * @param day the day to set
	 */
	public void setDay(int day) {
		if (month == 2) {
			setLeapYear();
		}
		
		if (day < 1) {
			day = 1;
		} else if (day > lastDayOfMonth[month - 1]) {
			day = lastDayOfMonth[month - 1];
		}
		
		this.day = day;
	}
	
	
	/**
	 * ���� ����
	 * 0. 2���� 28��
	 * 1. 4�⸶�� 29��
	 * 2. 100�⸶�� 28��
	 * 3. 400�⸶�� 29��
	 */
	private void setLeapYear() {
		int last = 28; 
		
//		if (getYear() % 4 == 0) {
//			last = 29;
//			if (getYear() % 100 == 0) {
//				last = 28;
//				if (getYear() % 400 == 0) {
//					last = 29;
//				} 
//			}
//		}
		
		// TODO
		// ���� : !, &&, || �� �̿��Ͽ� ���ǹ��� ���̱�
//		last = (year % 4 == 0 || year % 400 == 0) ? 29 : 28;
	
//		if ((year % 4 == 0 && year % != 100) || year % 400 == 0){
//			last = 29;
//		} else {
//			last = 28;
//		}

		// ��� ������ ���� -> last�� ����
		
		System.out.println(this + "|| last = " + last);
		lastDayOfMonth[1] = last;
	}
	
	// �θ𿡸� ���� �Ǿ� �ִ� �Լ�
	public void print() {
		System.out.println(this);
	}
}
