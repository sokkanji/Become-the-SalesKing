
class Menu {
	public static void main(String[] args) {

		String menu_name[]= {"눈알네개쉐이크","베리베리블루베리마카롱","치키치키초코마카롱","아빠는 외계인 라떼","삐립삐립지구행성맛 에이드",
				"슈스스토리베리 쉐이크","룩앳마이노즈아메리카노","씨쁠씨쁠사람이아니무이다쿠키","매쉬핫솟포테이토 쿠키"};
		
		int menu_number[]=new int[9];
		
		int found, input_number=0;
		
		System.out.println("손님이 주문하신 메뉴는?");
		for (int i = 0; i < 9;){
			while (true){
				menu_number[i] = (int)(Math.random()*10);
				found = 0;
				for (int j = 0; j < i; ++j) {
					if (menu_number[j] == menu_number[i]){
						found = 1;
						break;
					}
					if (found==0) 	
						break;
				}
			}
		}

			for (int k = 0; k < 9; k++) {
				input_number = menu_number[k];
				if (k % 3 == 0) {
					System.out.println("");
					System.out.println("");
					System.out.println("------------------------------------------------------------------------------------------");
					System.out.println("");
				}
				System.out.println("    "+menu_name[input_number]+"	");
			}
			System.out.println("");
			System.out.println("");
			System.out.println("------------------------------------------------------------------------------------------");		
			}
	}
