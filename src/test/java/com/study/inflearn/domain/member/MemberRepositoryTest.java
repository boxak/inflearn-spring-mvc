package com.study.inflearn.domain.member;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.study.inflearn.member.domain.Member;
import com.study.inflearn.member.domain.MemberRepository;

public class MemberRepositoryTest {
	MemberRepository memberRepository = MemberRepository.getInstance();

	@AfterEach
	void afterEach() {
		memberRepository.clearStore();
	}

	@Test
	@DisplayName("save test")
	void test1() {
		// given

		Member member = new Member("hello", 20);

		// when

		Member savedMember = memberRepository.save(member);

		// then
		Member foundMember = memberRepository.findById(savedMember.getId());
		assertThat(foundMember).isEqualTo(savedMember);
	}

	@Test
	@DisplayName("findAll test")
	void test2() {
		// given

		Member member1 = new Member("member1", 20);
		Member member2 = new Member("member2", 30);

		// when

		memberRepository.save(member1);
		memberRepository.save(member2);
		List<Member> result = memberRepository.findAll();

		// then
		assertThat(result).hasSize(2);
		assertThat(result).contains(member1, member2);
	}

}
