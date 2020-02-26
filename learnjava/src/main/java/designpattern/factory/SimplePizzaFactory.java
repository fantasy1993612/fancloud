package designpattern.factory;

/**
 * @author: xiangming
 * @date: 2020/02/25 02:26
 * @describetion: 创建对象
 */
public class SimplePizzaFactory {


    public Pizza createPizza(String type){
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
