package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component // appConfig 에서는 @Bean 으로 직접 설정정보를 입력하고 의존관계도 명시했으나
           // 이제는 이런 설정정보가 없기 때문에 의존관계 주입도 이 클래스 안에서 해결해야 한다.
public class MemberServiceImpl implements MemberService {
    // 역할 = 구현체 << 다형성에 의해서 구현체만 끼워맞추면 되기 때문에 변경 및 수정에 매우 용이함
    private final MemberRepository memberRepository;
    // 생성자 주입 = 생성자 호출 시점에 딱 1번만 호출되는 것이 보장된다. (불변이면서 필수,,,)
    @Autowired // 의존 관계 주입
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
