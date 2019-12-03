package kr.kosmo.jobkorea.join.dto;

public class JoinDTO {

	private String userId;//일반회원 아이디
	private String password;//비밀번호
	private String name;//일반회원 이름
	private String email;//이메일
	private String email2;//이메일2
	private String email_domain;//이메일도메인
	private String gender;//성별
	private String grade;//등급
	private String join_in;//참여 구분(콤보박스)
	private String birth;//생년월일
	private String area;//거주지역
	private String phone1;//연락처1
	private String phone2;//연락처2
	private String phone3;//연락처3
	private String worktitle;//경력정보 제목
	private String workarea1;//희망근무지1
	private String workarea2;//희망근무지2
	private String workarea3;//희망근무지3
	private String salary;//희망연봉
	private String consult_yn;//협의가능여부
	private String career_year;//경력기간 년
	private String career_mm;//경력기간 월
	private String skill_check;//전문기술(콤보박스)
	private String add_tech;//추가기술
	private String career_text;//경력내용
	private String significant;//특이사항
	private String fileup;//프로파일 업로드
	
	//생성자
	public JoinDTO(String userId, String password, String name, String email, String email2, String email_domain,
			String gender, String grade, String join_in, String birth, String area, String phone1, String phone2,
			String phone3, String worktitle, String workarea1, String workarea2, String workarea3, String salary,
			String consult_yn, String career_year, String career_mm, String skill_check, String add_tech,
			String career_text, String significant, String fileup) {
		super();
		this.userId = userId;
		this.password = password;
		this.name = name;
		this.email = email;
		this.email2 = email2;
		this.email_domain = email_domain;
		this.gender = gender;
		this.grade = grade;
		this.join_in = join_in;
		this.birth = birth;
		this.area = area;
		this.phone1 = phone1;
		this.phone2 = phone2;
		this.phone3 = phone3;
		this.worktitle = worktitle;
		this.workarea1 = workarea1;
		this.workarea2 = workarea2;
		this.workarea3 = workarea3;
		this.salary = salary;
		this.consult_yn = consult_yn;
		this.career_year = career_year;
		this.career_mm = career_mm;
		this.skill_check = skill_check;
		this.add_tech = add_tech;
		this.career_text = career_text;
		this.significant = significant;
		this.fileup = fileup;
	}
	
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmail2() {
		return email2;
	}
	public void setEmail2(String email2) {
		this.email2 = email2;
	}
	public String getEmail_domain() {
		return email_domain;
	}
	public void setEmail_domain(String email_domain) {
		this.email_domain = email_domain;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getJoin_in() {
		return join_in;
	}
	public void setJoin_in(String join_in) {
		this.join_in = join_in;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getPhone1() {
		return phone1;
	}
	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}
	public String getPhone2() {
		return phone2;
	}
	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}
	public String getPhone3() {
		return phone3;
	}
	public void setPhone3(String phone3) {
		this.phone3 = phone3;
	}
	public String getWorktitle() {
		return worktitle;
	}
	public void setWorktitle(String worktitle) {
		this.worktitle = worktitle;
	}
	public String getWorkarea1() {
		return workarea1;
	}
	public void setWorkarea1(String workarea1) {
		this.workarea1 = workarea1;
	}
	public String getWorkarea2() {
		return workarea2;
	}
	public void setWorkarea2(String workarea2) {
		this.workarea2 = workarea2;
	}
	public String getWorkarea3() {
		return workarea3;
	}
	public void setWorkarea3(String workarea3) {
		this.workarea3 = workarea3;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public String getConsult_yn() {
		return consult_yn;
	}
	public void setConsult_yn(String consult_yn) {
		this.consult_yn = consult_yn;
	}
	public String getCareer_year() {
		return career_year;
	}
	public void setCareer_year(String career_year) {
		this.career_year = career_year;
	}
	public String getCareer_mm() {
		return career_mm;
	}
	public void setCareer_mm(String career_mm) {
		this.career_mm = career_mm;
	}
	public String getSkill_check() {
		return skill_check;
	}
	public void setSkill_check(String skill_check) {
		this.skill_check = skill_check;
	}
	public String getAdd_tech() {
		return add_tech;
	}
	public void setAdd_tech(String add_tech) {
		this.add_tech = add_tech;
	}
	public String getCareer_text() {
		return career_text;
	}
	public void setCareer_text(String career_text) {
		this.career_text = career_text;
	}
	public String getSignificant() {
		return significant;
	}
	public void setSignificant(String significant) {
		this.significant = significant;
	}
	public String getFileup() {
		return fileup;
	}
	public void setFileup(String fileup) {
		this.fileup = fileup;
	}
	
	
	
}