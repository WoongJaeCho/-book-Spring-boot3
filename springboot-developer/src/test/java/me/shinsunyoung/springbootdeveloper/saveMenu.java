package me.shinsunyoung.springbootdeveloper;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class saveMenu {
    @DisplayName("save new menu")
    @Test
    public void saveNewMenu(){

        // given  테스트 실행을 준비하는 단계
        final String name = "Americano";
        final int price = 4500;
        final Menu americano = new Menu(name, price);

        // when
        final long savedId = menuService.save(americano);

        // then
        final Menu savedMenu =

    }
}
