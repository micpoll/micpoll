package com.example.DB;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
interface ZamowienieRepo extends JpaRepository<Zamowienie, Integer> {

    List<Zamowienie> findAllBydate(String wyszukaj);
}

