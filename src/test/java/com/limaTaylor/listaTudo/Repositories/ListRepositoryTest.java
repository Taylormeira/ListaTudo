package com.limaTaylor.listaTudo.Repositories;

import com.limaTaylor.listaTudo.Dtos.ListDto;
import com.limaTaylor.listaTudo.Models.ListModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("TestLits")
public class ListRepositoryTest {
    @Autowired
    ListRepository listRepository;

    @Test
    @DisplayName("Should list crated off processing test")
    void findyListByIdcase1() {
        int listId = 1;
        ListDto list = new ListDto(listId, 1, "Lista teste", 1, 0, 10.5F);
        this.crateList(list);
        Optional<ListModel> newList = listRepository.findById(listId);

        assertThat(newList.isPresent());
    }

    @Test
    @DisplayName("Shearch a not created List")
    void findyListByIdcase2() {
        int listId = 1;
        Optional<ListModel> newList = listRepository.findById(listId);

        assertThat(newList.isEmpty());
    }

    private ListModel crateList(ListDto listDto) {
        ListModel list = new ListModel(listDto);
        return list;
    }
}
