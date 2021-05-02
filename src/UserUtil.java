import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class UserUtil implements UserInterface{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	ArrayList<User> userList = new ArrayList<User>();
	private String loginedId;
	private String loginedPwd;
	
	@Override
	public void SignUp() {
		System.out.println("========= 회원 가입 =========");
		
//		FileReader fr;
	
		try {
			User user = new User();
//	
//			fr = new FileReader("C:\\Users\\dpfls\\Desktop\\kopo_java\\Midterm_java\\src\\iodata\\userlist.txt");
//			br = new BufferedReader(fr);
			
			System.out.print("아이디 :");
			String id = br.readLine();
			
			String line = "";
			
//			while((line = br.readLine()) != null) {
//				String[] temp = line.split(",");
//				if(id.equals(temp[0])) {
//					System.out.println("이미 등록된 아이디입니다.");
//					break;
//				}else{
//					System.out.println("패스워드 : ");
//					String password = br.readLine();
//					System.out.println("이름 : ");
//					String name = br.readLine();
//					System.out.println("휴대폰 연락처 : ");
//					String phone = br.readLine();
//					
//					user.setId(id);
//					user.setPwd(password);
//					user.setName(name);
//					user.setPhone(phone);
//					
//					userList.add(user);
//					writeFile();
//					
//					System.out.println("회원 가입이 완료되었습니다. 로그인 해주세요.");
//					break;
//				}
//				
//			}
			
			for(int i =0; i < userList.size(); i++) {
				if(id.contentEquals(userList.get(i).getId())) {
					System.out.println("등록된 아이디입니다.");
					return;
				}
			}
			
			System.out.println("패스워드 : ");
			String password = br.readLine();
			System.out.println("이름 : ");
			String name = br.readLine();
			System.out.println("휴대폰 연락처 : ");
			String phone = br.readLine();
			
			user.setId(id);
			user.setPwd(password);
			user.setName(name);
			user.setPhone(phone);
			
			userList.add(user);
			writeFile();
			
			System.out.println("회원 가입이 완료되었습니다. 로그인 해주세요.");
		br.close();	
		} catch(Exception e) {
			 e.printStackTrace();
		 }
		
	}
	@Override
	public void SignIn() {
		FileReader fr;
		
		
		try {
			
		System.out.println("==== 로그인 ====");	
		System.out.println("아이디 : ");
		String id = br.readLine();
		System.out.println("비밀번호 : ");
		String password = br.readLine();
		
		fr = new FileReader("C:\\Users\\dpfls\\Desktop\\kopo_java\\Midterm_java\\src\\iodata\\userlist.txt");
		br = new BufferedReader(fr);
		String line = "";
		
		while((line = br.readLine()) != null) {
			String[] temp = line.split(",");
			if(id.equals(temp[0]) && password.equals(temp[1])) {
				loginedId = id;
				loginedPwd = password;
				
				System.out.println("[ "+ loginedId +" ] 님 로그인 되었습니다.");
				break;
			}else if(!(id.equals(temp[0]) && password.equals(temp[1]))){
				System.out.println("등록된 아이디가 없습니다. 회원가입을 해주세요.");
			}
			
			
		}
		
		}catch(Exception e){
			
		}
	}
	@Override
	public void SignOut() {
		// TODO Auto-generated method stub
		
	}
	
//	public void readFile() {
//		FileReader fr;
//		
//	
//	}
	
	
	public void writeFile() {
		
		FileWriter fw;
		
		try {
			fw = new FileWriter("C:\\Users\\dpfls\\Desktop\\kopo_java\\Midterm_java\\src\\iodata\\userlist.txt", true); // true =>파일이 있을경우 이어쓰기
			
			for(int i =0; i < userList.size(); i++) {
				fw.write(userList.get(i).getId() + "," + userList.get(i).getPwd() + ","+ userList.get(i).getName() + "," + userList.get(i).getPhone() +"\r\n");	
			}
			
			fw.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		System.out.println("iodata/userlist.txt 에 저장완료");
	}
	
	
//	
//	public void writeFile() {
//		
//		FileOutputStream fos = null;
//		DataOutputStream dos = null;
//		
//		
//		try {
//			fos = new FileOutputStream("C:\\Users\\dpfls\\Desktop\\kopo_java\\Midterm_java\\src\\iodata\\userlist.txt");
//			dos = new DataOutputStream(fos);
//			
//			for(int i =0; i < userList.size(); i ++) {
//				dos.writeUTF(userList.get(i).getId() + "," + userList.get(i).getPwd() + ","+ userList.get(i).getName() + "," + userList.get(i).getPhone());
//				
//			}
//			
//		}catch(Exception e) {
//			e.printStackTrace();
//		}finally {
//			FileClose.close(dos,fos);
//		}
//	}

	
}
