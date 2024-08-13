package com.limaTaylor.listaTudo.Repositories;

import com.limaTaylor.listaTudo.Models.ListModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListRepository extends JpaRepository<ListModel, Integer> {
}
