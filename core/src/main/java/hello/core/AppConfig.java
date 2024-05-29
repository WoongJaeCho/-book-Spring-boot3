package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    //@Bean memberService() -> new MemoryMemberRepository();
    //@Bean orderService() -> new MemoryMemberRepository();
    // MemoryMemberRepository() 두번 호출 싱글톤이 깨지는 것이 아닌가? -> test
    // MemoryMemberRepository 인스턴스는 모두 같은 인스턴스가 공유되어 사용된다.
    // @Configuration를 사용함으로써 싱글톤을 보장

    @Bean
    public MemberService memberService(){
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }
    @Bean
    public MemoryMemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }
    @Bean
    public OrderService orderService(){
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
//        return null;
    }
    @Bean
    public DiscountPolicy discountPolicy() {

//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }


}
