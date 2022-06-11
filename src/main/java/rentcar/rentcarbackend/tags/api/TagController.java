package rentcar.rentcarbackend.tags.api;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rentcar.rentcarbackend.tags.domain.model.entity.Tag;
import rentcar.rentcarbackend.tags.shared.exception.NotFoundException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tags")
@AllArgsConstructor
public class TagController {

    private final rentcar.rentcarbackend.tags.domain.service.TagService tagService;

    @GetMapping
    public List<Tag> getAll() {
        List<Tag> tags = tagService.getAll();
        tags.forEach(System.out::println);
        return tags;
    }

    @GetMapping("{id}") //  /tags/{id}
    public Tag getById(@PathVariable("id") Integer id) {
        if (!tagService.existsById(id)) {
            throw new NotFoundException("Tag", id);
        } else {
            Optional<Tag> optional = tagService.getById(id);
            return optional.get();
        }
    }
    @PutMapping("{id}")
    public Tag updateById(@PathVariable("id") Integer id,
                              @RequestBody Tag tag) {
        if (!tagService.existsById(id)) {
            throw new NotFoundException("Tag", id);
        } else
        {   // Faltan las demas validaciones
            return tagService.update(tag);
        }
    }

    @PostMapping
    public ResponseEntity<?> createTag(@RequestBody Tag tag) {
        Tag tagResponse = tagService.create(tag);
        return new ResponseEntity<>(tagResponse, HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")

    public ResponseEntity<?> deleteById(@PathVariable("id") Integer id) {
        if (!tagService.existsById(id)) {
            throw new NotFoundException("Tag", id);
        } else
        {   // Faltan las demas validaciones
            tagService.deleteById(id);
            //return new ResponseEntity<>(HttpStatus.ACCEPTED);
            return ResponseEntity.accepted().build();   // Lambda
        }
    }
}
