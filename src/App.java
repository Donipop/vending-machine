import java.util.Scanner;

public class App {
    Drink[] dirnk = new Drink[8];
    public static void main(String[] args){
        App app = new App();
        app.SetPrice();
        while(true){

        
        Scanner scanner = new Scanner(System.in);
        System.out.println("음료선택");
        System.out.println("따뜻한 음료 0.아메리카노 1.카페라떼 2.모카치노 3.핫 초코");
        System.out.println("시원한 음료: 4.아이스 아메리카노 5.아이스 초코 6.아이스 카페라떼 7.복숭아 아이스티");
        System.out.print("음료번호 입력: ");
        int dnum = scanner.nextInt(); //음료선택
        if(app.Gopay(dnum)){
            System.out.println("결제완료");
            app.GoDrink(dnum);
        }else{
            System.out.println("결제실패");
        } //결제
        //scanner.close();
        //continue;
    }
    }

    private Boolean Gopay(int dnum){
        Scanner scanner = new Scanner(System.in);
        Pay pay = new Pay();
        Boolean result = false;
        System.out.println("결제방식을 선택해 주세요");
        System.out.println("1.현금 2.신용카드 3.온라인 페이");
        int num = scanner.nextInt();

        switch(num){
            case 1: 
            System.out.print("현금투입 : ");
            int money = scanner.nextInt();
            pay.setPayType(ModelType.PayType.Cash);
            pay.setAmount(money);
            pay.setPrice(dirnk[dnum].getPrice());
            //결제하고 거스름돈
            result = pay.Pay_Cash();
            break;
            case 2: 
            System.out.println("카드결제");
            pay.setPayType(ModelType.PayType.Card);
            int money2 = 100000;
            pay.setAmount(money2);
            pay.setPrice(dirnk[dnum].getPrice());
            //결제하고 거스름돈
            result = pay.Pay_Card();
            break;
            case 3: 
            System.out.println("온라인 결제");
            int money3 = 100000;
            pay.setPayType(ModelType.PayType.Online);
            pay.setAmount(money3);
            pay.setPrice(dirnk[dnum].getPrice());
            //결제하고 거스름돈
            result = pay.Pay_Online();
            break;
            default: System.out.println("결제방식을 다시 선택해 주세요");
            break;
        }
        return result;
    }

    private void GoDrink(int dnum){
        Cup cup = new Cup();
        if(dirnk[dnum].getDrinkType() == ModelType.DrinkType.HOT){//따뜻한음료

            cup.setCupType(ModelType.CupType.Paper);//종이컵
            //음료추출
            System.out.println(dirnk[dnum].getDrinkName() + "/" + cup.getCupType() + "/" + dirnk[dnum].getDrinkType());

        }else if(dirnk[dnum].getDrinkType() == ModelType.DrinkType.ICE){//시원한음료

            cup.setCupType(ModelType.CupType.Plastic);//플라스틱컵
            System.out.println(Ice());
            System.out.println(dirnk[dnum].getDrinkName() + "/" + cup.getCupType()+ "/" + dirnk[dnum].getDrinkType());
        }
    }

    private String Ice(){
        return "얼음추가";
    }
    private void SetPrice(){

        for(int i=0; i<dirnk.length; i++){
            dirnk[i] = new Drink(); //배열 인스턴스화
        }

        dirnk[0].setDrinknum(0);
        dirnk[0].setDrinkType(ModelType.DrinkType.HOT);
        dirnk[0].setPrice(1000);
        dirnk[0].setDrinkName("아메리카노");

        dirnk[1].setDrinknum(1);
        dirnk[1].setDrinkType(ModelType.DrinkType.HOT);
        dirnk[1].setPrice(1530);
        dirnk[1].setDrinkName("카페라떼");

        dirnk[2].setDrinknum(2);
        dirnk[2].setDrinkType(ModelType.DrinkType.HOT);
        dirnk[2].setPrice(1270);
        dirnk[2].setDrinkName("모카치노");

        dirnk[3].setDrinknum(3);
        dirnk[3].setDrinkType(ModelType.DrinkType.HOT);
        dirnk[3].setPrice(760);
        dirnk[3].setDrinkName("핫 초코");

        dirnk[4].setDrinknum(4);
        dirnk[4].setDrinkType(ModelType.DrinkType.ICE);
        dirnk[4].setPrice(1120);
        dirnk[4].setDrinkName("아이스 아메리카노");

        dirnk[5].setDrinknum(5);
        dirnk[5].setDrinkType(ModelType.DrinkType.ICE);
        dirnk[5].setPrice(1610);
        dirnk[5].setDrinkName("아이스 초코");

        dirnk[6].setDrinknum(6);
        dirnk[6].setDrinkType(ModelType.DrinkType.ICE);
        dirnk[6].setPrice(1800);
        dirnk[6].setDrinkName("아이스 카페라떼");

        dirnk[7].setDrinknum(7);
        dirnk[7].setDrinkType(ModelType.DrinkType.ICE);
        dirnk[7].setPrice(2200);
        dirnk[7].setDrinkName("복숭아 아이스티");
    }
}
