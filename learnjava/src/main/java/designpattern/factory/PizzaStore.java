package designpattern.factory;


/**
 * @author: xiangming
 * @date: 2020/02/25 02:30
 * @describetion:客户
 */
public interface PizzaStore {

    /**
     * 制作不同类型pizza
     * @param type
     * @return
     */
    default Pizza orderPizza(String type){
        //获取pizza类型对象,使用工厂创建对象
        Pizza pizza = createPizza(type);

        pizza.cut();
        pizza.prepare();
        pizza.bake();

        return pizza;
    }

    Pizza createPizza(String type);
}