package com.kh.hw.member.view;

import java.util.Scanner;

import com.kh.hw.member.controller.MemberController;

public class MemberMenu {

	private Scanner sc = new Scanner(System.in);
	private MemberController mc = new MemberController();

	public MemberMenu() {

	};

	public void mainMenu() {
		int num = mc.existMemberNum();
		System.out.printf("최대 등록 가능한 회원수는 10명입니다.\n현재 등록된 회원수는 %d명입니다.\n", num);
		if (num == 10) {
			System.out.println("회원 수가 모두 꽉찾기 때문에 일부 메뉴만 오픈됩니다.");
		} else {
			System.out.println("1. 새 회원 등록");
		}

		System.out.println("2. 회원 검색");
		System.out.println("3. 회원 정보 수정");
		System.out.println("4. 회원 삭제");
		System.out.println("5. 모두 출력");
		System.out.println("9. 끝내기");
		System.out.print("메뉴번호 : ");

		//입력할 값이 많아 오타가 많이나서 에러 위해 문자열로 이렇게 입력받음 
		String str = sc.nextLine().replaceAll("[^\\d]", "");
		int select = str.equals("") ? 0 : Integer.parseInt(str);

		switch (select) {
		case 1:
			if (num == 10) {
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
				mainMenu();
				return;
			} else {
				System.out.println("새 회원을 등록합니다.");
				insertMember();
			}
			break;
		case 2:
			searchMember();
			break;
		case 3:
			updateMember();
			break;
		case 4:
			deleteMember();
			break;
		case 5:
			printAll();
			break;
		case 9:
			System.out.println("프로그램을 종료합니다.");
			break;
		default:
			System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			mainMenu();

		}
	}

	public void insertMember() {

		System.out.print("아이디 : ");
		String id = sc.nextLine();
		if (mc.checkId(id)) {
			System.out.println("중복된 아이디입니다. 다시 입력해주세요.");
			insertMember();
			return;
		}
		System.out.print("이름 : ");
		String name = sc.nextLine();
		System.out.print("비밀번호 : ");
		String password = sc.nextLine();
		System.out.print("email : ");
		String email = sc.nextLine();
		System.out.print("성별(M/F) : ");
		char gender = sc.nextLine().charAt(0);
		while (true) {
			if (gender == 'm' || gender == 'M' || gender == 'F' || gender == 'f') {
				break;
			}
			System.out.println("성별을 다시 입력하세요.");
			System.out.print("성별(M/F) : ");
			gender = sc.nextLine().charAt(0);
		}
		System.out.print("나이 : ");
		int age = sc.nextInt();
		sc.nextLine();
		mc.insertMember(id, name, password, email, gender, age);
		mainMenu();
	}

	public void searchMember() {

		System.out.println("1. 아이디로 검색하기");
		System.out.println("2. 이름으로 검색하기");
		System.out.println("3. 이메일로 검색하기");
		System.out.println("9. 메인으로 돌아가기");
		System.out.print("메뉴 번호 : ");
		String str = sc.nextLine().replaceAll("[^\\d]", "");
		int select = str.equals("") ? 0 : Integer.parseInt(str);
		switch (select) {
		case 1:
			searchId();
			break;
		case 2:
			searchName();
			break;
		case 3:
			searchEmail();
			break;
		case 9:
			mainMenu();
			break;
		default:
			System.out.println("잘못 입력하셨습니다.");
			mainMenu();
		}
	}

	public void searchId() {
		System.out.print("검색할 아이디 : ");
		System.out.println(mc.searchId(sc.nextLine()));
		mainMenu();
	}

	public void searchName() {
		System.out.print("검색할 이름 : ");
		System.out.println(mc.searchId(sc.nextLine()));
		mainMenu();
	}

	public void searchEmail() {
		System.out.print("검색할 이메일 : ");
		System.out.println(mc.searchEmail(sc.nextLine()));
		mainMenu();
	}

	public void updateMember() {

		System.out.println("1. 비밀번호 수정하기");
		System.out.println("2. 이름 수정하기");
		System.out.println("3. 이메일 수정하기");
		System.out.println("9. 메인으로 돌아가기");
		System.out.print("메뉴 번호 : ");
		String str = sc.nextLine().replaceAll("[^\\d]", "");
		int select = str.equals("") ? 0 : Integer.parseInt(str);
		switch (select) {
		case 1:
			updatePassword();
			break;
		case 2:
			updateName();
			break;
		case 3:
			updateEmail();
			break;
		case 9:
			System.out.println("메인으로 돌아갑니다.");
			mainMenu();
			break;
		default:
			System.out.println("잘못 입력하셨습니다.");
			mainMenu();
			return;
		}
	}

	public void updatePassword() {
		System.out.print("수정할 회원의 아이디 : ");
		String id = sc.nextLine();
		System.out.print("수정할 비밀번호 : ");
		String password = sc.nextLine();
		mc.updatePassword(id, password);
		mainMenu();
	}

	public void updateName() {
		System.out.print("수정할 회원의 아이디 : ");
		String id = sc.nextLine();
		System.out.print("수정할 이름 : ");
		String name = sc.nextLine();
		mc.updateName(id, name);
		mainMenu();
	}

	public void updateEmail() {
		System.out.print("수정할 회원의 아이디 : ");
		String id = sc.nextLine();
		System.out.print("수정할 이메일 : ");
		String email = sc.nextLine();
		mc.updateEmail(id, email);
		mainMenu();
	}

	public void deleteMember() {
		System.out.println("1. 특정 회원 삭제하기");
		System.out.println("2. 모든 회원 삭제하기");
		System.out.println("9. 메인으로 돌아가기");
		System.out.print("메뉴 번호 : ");
		String str = sc.nextLine().replaceAll("[^\\d]", "");
		int select = str.equals("") ? 0 : Integer.parseInt(str);
		switch (select) {
		case 1:
			deleteOne();
			break;
		case 2:
			deleteAll();
			break;
		case 9:
			System.out.println("메인으로 돌아갑니다.");
			mainMenu();
			break;
		default:
			System.out.println("잘못 입력하셨습니다.");
			mainMenu();
			return;
		}
		
	}

	public void deleteOne() {
		System.out.print("삭제할 아이디 : ");
		String id = sc.nextLine();
		System.out.println("정말로 삭제하시겠습니까? (Y/N): ");
		char yN = sc.nextLine().charAt(0);
		if (yN == 'Y' || yN == 'y') {
			mc.delete(id);
		}
		mainMenu();
	}

	public void deleteAll() {
		System.out.println("정말로 삭제하시겠습니까? (Y/N): ");
		char yN = sc.nextLine().charAt(0);
		if (yN == 'Y' || yN == 'y') {
			mc.delete();
		}
		mainMenu();
	}

	public void printAll() {
		mc.printAll();
		mainMenu();
	}
//			- MemberController mc
//			= new MemberController
//			+ MemberMenu ()
//			+ mainMenu() : void
//			+ insertMember() : void
//			+ searchMember() : void
//			+ searchId() : void
//			+ searchName() : void
//			+ searchEmail() : void
//			+ updateMember() : void
//			+ updatePassword() : void
//			+ updateName() : void
//			+ updateEmail() : void
//			+ deleteMember() : void
//			+ deleteOne() : void
//			+ deleteAll() : void
//			+ printAll() : void

}
