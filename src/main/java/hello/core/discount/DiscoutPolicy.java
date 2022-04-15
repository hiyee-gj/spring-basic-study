package hello.core.discount;

import hello.core.member.Member;

// 할인 정책 interface 생성
public interface DiscoutPolicy {

    /**
     * @return 할인 대상 금액
     */
    int discount(Member member, int price);
}
