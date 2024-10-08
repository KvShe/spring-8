package ru.kvshe.homework.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kvshe.homework.model.Word;

public interface WordRepository extends JpaRepository<Word, Long> {
}
