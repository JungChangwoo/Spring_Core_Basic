package hello.core.singleton;

/**
 * 이 Class는 Singleton을 직접 코딩한 것이지만 스프링 컨테이너를 이용하면 자동으로 Singleton이 된다.
 */
public class SingletonService {

    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance(){
        return instance;
    }
    // 생성자 private 하게 해서 다른 곳에서 생성을 하지 못함
    private SingletonService(){
    }
    public void logic(){
        System.out.println("싱글톤 객체 로직 호출");
    }

}
