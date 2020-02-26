package designpattern.factory;

/**
 * @author: xiangming
 * @date: 2020/02/25 02:45
 * @describetion: 提供不同风味pizza
 */
public class NYStylePizzaStore implements PizzaStore {

    @Override
    public Pizza createPizza(String type) {
        Pizza pizza = null;
        if(type.equals("chesse")){
            pizza = new ChessePizza();
        }

        if(type.equals("clamPizza")){
            pizza = new ClamPizza();
        }
        return pizza;
    }
}
