package hello.core.singleton;

/**
 * 싱글톤 객체 사용시 매우 주의해야 할 점 // 내가 값을 사용하기 전에 다른 사용자가 값을 바꾼다면?
 * 무상태의 중요성
 */
public class StatefulService {
//    private int price; //상태를 유지하는 필드 << 문제
    
    public int order(String name, int price) {
        System.out.println("name = " + name + " price = " + price);
//        this.price = price; //여기가 문제!
        return price;
    }
//    public int getPrice() {
//        return price;
//    }
}