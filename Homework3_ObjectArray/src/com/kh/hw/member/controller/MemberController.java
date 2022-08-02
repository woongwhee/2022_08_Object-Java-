package com.kh.hw.member.controller;

import com.kh.hw.member.model.vo.Member;

public class MemberController {
	private Member[] m = new Member[10];

	public int existMemberNum() {
		for (int i = 0; i < m.length; i++) {
			if (m[i] == null) {
				return i;
			}
		}
		return m.length;
		//null값을 반환하는 인덱스값이 없으면 길이를 반환
	}

	public Boolean checkId(String inputId) {
		boolean result = false;
		for (int i = 0; i < m.length; i++) {
			if(m[i]==null) {
				return result;
			}
			if (m[i]!=null||m[i].getName().equals(inputId)) {
				result = false;
				break;
			}
			;
		}
		return result;
	}

	public void insertMember(String id, String name, String password, String email, char gender, int age) {
		int index = existMemberNum();
		m[index] = new Member(id, name, password, email, gender, age);

	}

//	+ searchId(id:String) : String
//	+ searchName(name:String) : Member[]
//	+ searchEmail(email:String) : Member[]
	public String searchId(String id) {
		String result = "";
		for (int i = 0; i < m.length; i++) {
			if (m[i].getId().equals(id)) {
				result = "찾으신 회원 검색 결과입니다.\n" + m[i].getId();
			} else {
				result = "검색 결과가 없습니다.";
			}

		}

		return result;
	}

	public String searchName(String name) {
		String result = "";
		for (int i = 0; i < m.length; i++) {
			if (m[i].getName().equals(name)) {
				result = "찾으신 회원 검색 결과입니다.\n" + m[i].getName();
			} else {
				result = "검색 결과가 없습니다.";
			}

		}

		return result;
	}

	public String searchEmail(String email) {
		String result = "";
		for (int i = 0; i < m.length; i++) {
			if (m[i].getEmail().equals(email)) {
				result = "찾으신 회원 검색 결과입니다.\n" + m[i].getEmail();
			} else {
				result = "검색 결과가 없습니다.";
			}

		}

		return result;
	}

	public boolean updatePassword(String id, String password) {
		boolean result = false;
		for (int i = 0; i < m.length; i++) {
			if (m[i].getId().equals(id)) {
				result = true;
				m[i].setPassword(password);
			}
		}

		return result;
	}

	public boolean updateEmail(String id, String email) {
		boolean result = false;
		for (int i = 0; i < m.length; i++) {
			if (m[i].getId().equals(id)) {
				result = true;
				m[i].setEmail(email);
			}
		}

		return result;
	}

	public boolean updateName(String id, String name) {
		boolean result = false;
		for (int i = 0; i < m.length; i++) {
			if (m[i].getId().equals(id)) {
				result = true;
				m[i].setName(name);
			}
		}
		return result;
	}

	public boolean delete(String id) {
		boolean result = false;
		for (int i = 0; i < m.length; i++) {
			if (m[i].getName().equals(id)) {
				for (int j = i; j < m.length; j++) {
					if(m[j+1]!=null) {
					m[j] = m[j + 1];
					}
				}
				m[m.length - 1] = null;
				result = true;
				break;
			}
		}
		return result;

	}

	public void delete() {
		m = new Member[10];
	}

	public void printAll() {
		if (!(m[0] == null)) {
			System.out.println("저장된 회원이 없습니다.");
		}
		for (int i = 0; i < m.length; i++) {
			if (m[i] == null) {
				break;
			}
			System.out.println(m[i].info());
		}

	}

}
