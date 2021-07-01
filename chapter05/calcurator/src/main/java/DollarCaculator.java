public class DollarCaculator implements ICaculator {

    private int price = 1;
    private MarketApi marketApi;

    public DollarCaculator(MarketApi marketApi){
        this.marketApi = marketApi;
    }

    public void init(){
        this.price = marketApi.connect();
    }

    @Override
    public int sum(int x, int y) {
        x *= price;
        y *= price;
        return x + y;
    }

    @Override
    public int minus(int x, int y) {
        x*=price;
        y*=price;
        return x-y;
    }
}
