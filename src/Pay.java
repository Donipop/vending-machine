public class Pay {
    private int Amount;
    private ModelType.PayType payType;
    private int Price;

    public int getAmount() {
        return this.Amount;
    }

    public void setAmount(int Amount) {
        this.Amount = Amount;
    }

    public ModelType.PayType getPayType() {
        return this.payType;
    }

    public void setPayType(ModelType.PayType payType) {
        this.payType = payType;
    }

    public int getPrice() {
        return this.Price;
    }

    public void setPrice(int Price) {
        this.Price = Price;
    }

    public boolean Pay_Cash(){
        boolean result = false;
        //System.out.println(this.Amount + "/" + this.Price + "/" + this.payType);

        if(this.payType == ModelType.PayType.Cash){
            if(this.Amount>=this.Price){//자판기에 넣은 금액이 물건 가격보다 큰 경우 결제시작
                int Change = (this.Amount-this.Price);
                int M = 0;
                int OT_won = Math.floorDiv(Change, 1000); //1000원 개수
                M = Change - (OT_won*1000);
                int F_H_Won = Math.floorDiv(M, 500); //500원 개수
                M = M - (F_H_Won*500);
                int O_H_Won = Math.floorDiv(M, 100); //100원 개수
                M = M - (O_H_Won*100);
                int F_T_Won = Math.floorDiv(M, 50); //50원 개수
                M = M - (F_T_Won*50);
                int O_T_Won = Math.floorDiv(M, 10); //10원 개수

                System.out.printf("거스름돈 1000: %d, 500: %d, 100: %d, 50: %d, 10: %d",OT_won,F_H_Won,O_H_Won,F_T_Won,O_T_Won);
                result = true;
            }
        }
        return result;
    }

    public boolean Pay_Card(){
        boolean result = false;
        if(this.payType == ModelType.PayType.Card){
            if(this.Amount>this.Price){
                result = true;
            }
        }
        return result;
    }

    public boolean Pay_Online(){
        boolean result = false;
        if(this.payType == ModelType.PayType.Online){
            if(this.Amount>this.Price){
                result = true;
            }
        }
        return result;
    }
}
