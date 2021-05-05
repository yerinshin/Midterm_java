import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;


public class UserUtil implements UserInterface{
	
	Scanner sc = new Scanner(System.in);
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	ArrayList<User> userList = new ArrayList<User>();
	
	private String loginedId; //현재 로그인 된 아이디
	private String loginedPwd; //현재 로그인 된 pwd
	
	public String getLoginedId() {
		return loginedId;
	}
	public void setLoginedId(String loginedId) {
		this.loginedId = loginedId;
	}
	
	@Override
	public void signUp() {
		System.out.println("========= 회원 가입 =========");
		
		FileReader fr;
	
		try {
			User user = new User();
			
			System.out.print("아이디 :");
			String id = sc.nextLine();
	
			fr = new FileReader("iodata\\userlist.txt");
			br = new BufferedReader(fr);
					
			String line = "";
			boolean registered = false;
			
			while((line = br.readLine()) != null) {
				String[] temp = line.split(",");
				if(temp.length != 4) {
					break;
				}
				if(id.equals(temp[0])) {
					System.out.println("이미 등록된 아이디입니다.");
					registered = true;
					break;
				}
				
				
			}
			
			if(!registered) {
				System.out.print("패스워드 : ");
				String password = sc.nextLine();
				System.out.print("이름 : ");
				String name = sc.nextLine();
				System.out.print("휴대폰 연락처 : ");
				String phone = sc.nextLine();
				
				user.setId(id);
				user.setPwd(password);
				user.setName(name);
				user.setPhone(phone);
				
				userList.add(user);
				writeFile();
				
				System.out.println("회원 가입이 완료되었습니다. 로그인 해주세요.");
			}
			
		br.close();	
		} catch(Exception e) {
			 e.printStackTrace();
		 }
		
	}
	@Override
	public void signIn() {
		FileReader fr;
		
		try {
			
		System.out.println("==== 로그인 ====");	
		System.out.println("아이디 : ");
		String id = sc.nextLine();
		System.out.println("비밀번호 : ");
		String password = sc.nextLine();
		
		fr = new FileReader("iodata\\userlist.txt");
		br = new BufferedReader(fr);
		String line = "";
		boolean registered = false;
		
		while((line = br.readLine()) != null) {
			String[] temp = line.split(",");
			if(id.equals(temp[0]) && password.equals(temp[1])) {
				loginedId = id;
				loginedPwd = password;
				registered = true;
				
				break;
			
			}
		}
		
		if(!registered) {
			System.out.println("등록된 아이디가 아닙니다.");
			loginedId = "";
		}
		
		}catch(Exception e){
			
		}
	}
	
	
	@Override
	public void signOut() {
		// TODO Auto-generated method stub
		
	}
	

	
	
	public void writeFile() {
		
		FileWriter fw;
		
		try {
			
			fw = new FileWriter("iodata\\userlist.txt", true);//true =>파일이 있을경우 이어쓰기
			
			for(int i =0; i < userList.size(); i++) {
				fw.write(userList.get(i).getId() + "," + userList.get(i).getPwd() + ","+ userList.get(i).getName() + "," + userList.get(i).getPhone() +"\r\n");	
			}
			
			fw.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
//		System.out.println("iodata/userlist.txt 에 저장완료");
	}
	


	
}
