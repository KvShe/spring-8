package ru.kvshe.homework.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kvshe.homework.service.WordService;

@RestController
@RequestMapping("/words")
@RequiredArgsConstructor
public class WordController {
    private final WordService wordService;

    @GetMapping
    public ResponseEntity<?> getAllWords() {
        return ResponseEntity.ok(wordService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getWordById(@PathVariable Long id) {
        return ResponseEntity.ok(wordService.getById(id));
    }
}
