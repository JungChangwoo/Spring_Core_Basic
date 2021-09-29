package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor // final 이 붙은 변수들의 생성자를 자동으로 만들어 줌
public class OrderServiceImpl implements OrderService {
    // 아래는 추상에도 의존하고 있고 구현체에도 의존하고 있음 > DIP 위반 >> OCP 위반 (클라이언트 단계에서 코드를 변경함)
//    private final MemberRepository memberRepository = new MemoryMemberRepository();
//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
//    private final MemberRepository memberRepository;
//    private final DiscountPolicy discountPolicy;
    private final MemberRepository memberRepository; // final >> 생성과 동시에 바로 초기화를 하는 게 아니라면 생성자로만 값을 넣어줄 수 있음
    private final DiscountPolicy discountPolicy;     // >> 생성자로 값을 초기화하지 않았을 때 컴파일 오류를 알려줌
//    //수정자 주입 << 선택적이고 변경가능성이 있는 의존관계 주입에 사용됨,,
//    @Autowired
//    public void setMemberRepository(MemberRepository memberRepository){
//        this.memberRepository = memberRepository;
//    }
//    @Autowired
//    public  void setDiscountPolicy(DiscountPolicy discountPolicy){
//        this.discountPolicy = discountPolicy;
//    }
//    @Autowired // 생성자 주입을 쓰는 것이 좋음, 다른 개발자가 실수로 값을 넣을 수도 있고 테스트를 할 때 보면 알지만, 오류를 범하는 것을 줄여줌
//    public OrderServiceImpl(MemberRepository memberRepository, @mainDiscountPolicy DiscountPolicy discountPolicy) {
//        this.memberRepository = memberRepository;
//        this.discountPolicy = discountPolicy;
//    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
