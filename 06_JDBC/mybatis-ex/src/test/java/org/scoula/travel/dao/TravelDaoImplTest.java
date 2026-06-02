package org.scoula.travel.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.scoula.travel.domain.TravelVO;

import java.util.List;

class TravelDaoImplTest {
    TravelDao dao = new TravelDaoImpl();

    @Test
    void getTotalCount() {
        int count = dao.getTotalCount();

        System.out.println(count);
        Assertions.assertTrue(count > 0);
    }

    @Test
    void getDistricts() {
        List<String> list = dao.getDistricts();

        list.forEach(System.out::println);
        Assertions.assertTrue(list.size() > 0);
    }

    @Test
    void getTravelsByDistrict() {
        List<TravelVO> list = dao.getTravelsByDistrict("강원권");

        list.forEach(System.out::println);
    }

    @Test
    void insert() {
        TravelVO vo = TravelVO.builder()
                .district("강원권")
                .title("두물머리")
                .description("경치좋음")
                .address("남양주")
                .phone("111-222-3333")
                .build();

        dao.insert(vo);
    }

    @Test
    void update() {
        TravelVO travel = TravelVO.builder()
                .no(116L)
                .district("수도권")
                .title("해너미 명소___")
                .description("해너미 명소로 유명해요___")
                .address("인천 광역시 서해바다")
                .phone("111-222-3333")
                .build();

        dao.update(travel);
    }

    @Test
    void remove() {
        Long no = 116L;
        dao.remove(no);
    }
}