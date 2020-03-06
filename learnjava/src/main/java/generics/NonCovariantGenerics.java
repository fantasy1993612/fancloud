package generics;

/**
 * @Auther: xiangming
 * @Date: 2020/2/26 18:09
 * @Description:
 */
// generics/NonCovariantGenerics.java
// {WillNotCompile}

public class NonCovariantGenerics {
    // Compile Error: incompatible types:
    //List<Fruit> flist = new ArrayList<Apple>();
}

