package hello.core.order;

import hello.core.discount.DiscoutPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;

// OrderService의 구현체 OrderServiceImpl 생성

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository;  // 뭐가 들어올 지 얘는 모름
    private final DiscoutPolicy discountPolicy; // 뭐가 들어올 지 얘는 모름

    public OrderServiceImpl(MemberRepository memberRepository, DiscoutPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    // OrderService의 메서드 구현
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId); // memberRepo에서 member 찾아오고
        int discountPrice = discountPolicy.discount(member, itemPrice); // 할인 정책(정액 할인)에 member 정보와 item 가격 정보 넘겨서(Grade 확인 후) 할인 가격 리턴 받기

        return new Order(memberId, itemName, itemPrice, discountPrice); // 새로운 주문 생성
    }
}
