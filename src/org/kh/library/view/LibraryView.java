package org.kh.library.view;

import java.util.ArrayList;
import java.util.Scanner;

import org.kh.library.controller.*;
import org.kh.library.model.vo.Book;
import org.kh.library.model.vo.Customer;
import org.kh.library.model.vo.Library;

public class LibraryView implements LibraryViewI{

	public Scanner sc = new Scanner(System.in);
	public LibraryView() {};
	
	@Override
	public int mainMenu() {
		// TODO Auto-generated method stub
		System.out.println("메인메뉴");
		System.out.println("1. 책 관리");
		System.out.println("2. 회원 관리");
		System.out.println("3. 대여 관리");
		System.out.println("4. 프로그램 종료");
		System.out.print("메뉴 선택 : ");
		return sc.nextInt();
	}
	@Override
	public void bookMenu() {
		// TODO Auto-generated method stub
		
		BookController bCon = new BookController();
		
		while(true) {
			System.out.println("책관리 서브메뉴");
			System.out.println("1. 전체 책 조회");
			System.out.println("2. 책 코드로 조회");
			System.out.println("3. 책 추가하기");
			System.out.println("4. 책 삭제하기");
			System.out.println("5. 메인 메뉴로 이동");
			System.out.print("메뉴 선택 : ");
			int choice = sc.nextInt();
			switch(choice) {
			case 1:
				//전체 책 조회
				ArrayList<Book> allBook = bCon.selectAllBook();
				this.dispalyBookList(allBook);
				break;
			case 2:
				//책 코드로 조회
				int searchBookNo = this.inputBookNo();
				Book searchedBook = bCon.selectBookOne(searchBookNo);
				this.displayBook(searchedBook);
				break;
			case 3:
				//책 추가하기
				Book newBook = this.inputBook();
				int bookInputRes = bCon.insertBook(newBook);
				this.displaySucess(bookInputRes, "책 추가");
				break;
			case 4:
				//책 삭제하기
				int delBookNo = this.inputBookNo();
				int bookDelRes = bCon.deleteBook(delBookNo);;
				this.displaySucess(bookDelRes, "책 삭제");
				break;
			case 5:
				//메인 메뉴로 이동
				return;
			}
		}
		
	}

	@Override
	public void customerMenu() {
		// TODO Auto-generated method stub
		
		CustomerController cCon = new CustomerController();
		
		while(true) {
			System.out.println("회원관리 서브메뉴");
			System.out.println("1. 전체 회원 조회");
			System.out.println("2. 회원 이름으로 조회");
			System.out.println("3. 회원 아이디로 조회");
			System.out.println("4. 회원 가입");
			System.out.println("5. 회원 정보수정");
			System.out.println("6. 회원 탈퇴");
			System.out.println("7. 메인 메뉴로 이동");
			System.out.print("메뉴 선택 : ");
			int choice = sc.nextInt();
			switch(choice) {
			case 1:
				//1. 전체 회원 조회
				ArrayList<Customer> allCostomer = cCon.selectAllCustomer();
				this.dispalyCustomerList(allCostomer);
				break;
			case 2:
				//2. 회원 이름으로 조회
				String cName = this.inputCName();
				Customer byName = cCon.selectNameSearch(cName);
				if(byName != null)
					this.diplayCutomerOne(byName);
				break;
			case 3:
				//3. 회원 아이디로 조회
				String cId = this.inputCId();
				Customer byId = cCon.selectIdSearch(cId);
				if(byId != null)
					this.diplayCutomerOne(byId);
				break;
			case 4:
				//4. 회원 가입
				Customer newCustomer = this.inputCustomer();
				int joinRes = cCon.insertCustomer(newCustomer);
				this.displaySucess(joinRes, "회원 가입");
				break;
			case 5:
				//5. 회원 정보수정
				String changeCId = this.inputCId();
				int changeRes = 0;
				if(cCon.selectIdSearch(changeCId)!=null) {
					Customer changeById = this.modifyCustomer();
					changeById.setUSER_ID(changeCId);
					changeRes = cCon.updateCustomer(changeById);
				}
				this.displaySucess(changeRes, "회원 정보수정");
				break;
			case 6:
				//6. 회원 탈퇴
				String delCId = this.inputCId();
				int delRes = 0;
				if(cCon.selectIdSearch(delCId)!=null) {
					delRes = cCon.deleteCustomer(delCId);
				}
				this.displaySucess(delRes, "회원 탈퇴");
				break;
			case 7:
				//7. 메인 메뉴로 이동
				return;
			}
		}
	}

	@Override
	public void libraryMenu() {
		// TODO Auto-generated method stub
		
		LibraryController lCon = new LibraryController();
		
		while(true) {
			System.out.println("대여관리 서브메뉴");
			System.out.println("1. 전체 대여 조회");
			System.out.println("2. 대여 아이디로 조회");
			System.out.println("3. 대여 책이름으로 조회");
			System.out.println("4. 대여정보 추가");
			System.out.println("5. 메인 메뉴로 이동");
			System.out.print("메뉴 선택 : ");
			int choice = sc.nextInt();
			switch(choice) {
			case 1:
				ArrayList<Library> allLease = lCon.selectAll();
				this.displayLibraryList(allLease);
				break;
			case 2:
				String lUId = this.inputUserId();
				Library leaseByUId = lCon.selectOne(lUId);
				if(leaseByUId != null)
					this.displayLibraryList(leaseByUId);
				break;
			case 3:
				String lbName = this.inputBookName();
				Library leaseBybName = lCon.selectOneByName(lbName);
				if(leaseBybName != null)
					this.displayLibraryList(leaseBybName);
				break;
			case 4:
				break;
			case 5:
				return;
			}
		}
	}

	@Override
	public void displayLibraryList(ArrayList<Library> list) {
		// TODO Auto-generated method stub
		for(Library library : list) {
			this.displayLibraryList(library);
		}
	}

	@Override
	public void displayLibraryList(Library library) {
		// TODO Auto-generated method stub
		System.out.println(library.toString());
	}

	@Override
	public void displaySucess(int res, String category) {
		// TODO Auto-generated method stub
		if(res>0) {
			System.out.println("[서비스 성공] : " + category);
		}else {
			System.out.println("[서비스 실패] : " + category);
		}
	}

	@Override
	public String inputUserId() {
		Scanner sc = new Scanner(System.in);
		System.out.print("사용자 ID : ");
		return sc.next();
	}

	@Override
	public String inputBookName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int inputBookNo() {
		// TODO Auto-generated method stub
		System.out.print("책번호 : ");
		int bookNo = sc.nextInt();
		return bookNo;
	}

	@Override
	public Book inputBook() {
		// TODO Auto-generated method stub
		Book book = new Book();
		Scanner sc = new Scanner(System.in);
		System.out.print("책번호 : ");
		book.setBOOK_NO(sc.nextInt());
		System.out.print("책이름 : ");
		sc.nextLine();
		book.setBOOK_NAME(sc.nextLine());
		System.out.print("책저자 : ");
		book.setBOOK_WRITER(sc.nextLine());
		System.out.print("책가격 : ");
		book.setBOOK_PRICE(sc.nextInt());
		System.out.print("출판사 : ");
		sc.nextLine();
		book.setPUBLISHER(sc.nextLine());
		System.out.print("장  르 : ");
		book.setGENRE(sc.nextLine());
		return book;
	}

	@Override
	public Library insertLibrary() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void dispalyBookList(ArrayList<Book> list) {
		// TODO Auto-generated method stub
		if(!list.isEmpty())
		for(Book book : list) {
			System.out.println(book.toString());
		}else {
			System.out.println("책 정보가 존재하지 않습니다.");
		}
	}

	@Override
	public void displayMessage(String message) {
		// TODO Auto-generated method stub
		System.out.println(message);
	}

	@Override
	public void displayError(String message) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispalyCustomerList(ArrayList<Customer> list) {
		// TODO Auto-generated method stub
		for(Customer customer : list) {
			System.out.println(customer.toString());
		}
	}

	@Override
	public void diplayCutomerOne(Customer customer) {
		// TODO Auto-generated method stub
		System.out.println(customer.toString());
	}

	@Override
	public void displayBook(Book book) {
		// TODO Auto-generated method stub
		System.out.println(book.toString());
	}

	@Override
	public String inputCName() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("사용자 이름 : ");
		return sc.next();
	}

	@Override
	public String inputCId() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("사용자 ID : ");
		return sc.next();
	}

	@Override
	public Customer inputCustomer() {
		Customer customer = new Customer();
		Scanner sc = new Scanner(System.in);
		System.out.print("회원번호 : ");
		customer.setUSER_NO(sc.nextInt());
		System.out.print("I      D : ");
		customer.setUSER_ID(sc.next());
		System.out.print("이    름 : ");
		sc.nextLine();
		customer.setUSER_NAME(sc.nextLine());
		System.out.print("나    이 : ");
		customer.setUSER_AGE(sc.nextInt());
		System.out.print("주    소 : ");
		sc.nextLine();
		customer.setADDR(sc.nextLine());
		System.out.print("성    별 : ");
		customer.setGENDER(sc.nextLine());
		return customer;
	}

	@Override
	public Customer modifyCustomer() {
		Customer customer = new Customer();
		Scanner sc = new Scanner(System.in);
		System.out.print("이    름 : ");
		customer.setUSER_NAME(sc.nextLine());
		System.out.print("주    소 : ");
		customer.setADDR(sc.nextLine());
		return customer;
	}

}
