package ru.kvshe.homework.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kvshe.homework.model.Word;
import ru.kvshe.homework.repository.WordRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WordService {
    private final WordRepository wordRepository;

    public Word getById(Long id) {
        return wordRepository.findById(id).orElseThrow();
    }

    public List<Word> getAll() {
        return wordRepository.findAll();
    }
}
