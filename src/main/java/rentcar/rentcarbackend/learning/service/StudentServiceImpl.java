package rentcar.rentcarbackend.learning.service;

import rentcar.rentcarbackend.learning.domain.model.entity.Student;
import rentcar.rentcarbackend.learning.domain.persistence.StudentRepository;
import rentcar.rentcarbackend.learning.domain.service.StudentService;
import rentcar.rentcarbackend.shared.exception.ResourceNotFoundException;
import rentcar.rentcarbackend.shared.exception.ResourceValidationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
public class StudentServiceImpl implements StudentService {

    private static final String ENTITY = "Student";

    private final StudentRepository studentRepository;

    private final Validator validator;

    public StudentServiceImpl(StudentRepository studentRepository, Validator validator) {
        this.studentRepository = studentRepository;
        this.validator = validator;
    }

    @Override
    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    @Override
    public Page<Student> getAll(Pageable pageable) {
        return studentRepository.findAll(pageable);
    }

    @Override
    public Student getById(Long studentId) {
        return studentRepository.findById(studentId).orElseThrow(() -> new ResourceNotFoundException(ENTITY, studentId));
    }

    @Override
    public Student create(Student student) {

        Set<ConstraintViolation<Student>> violations = validator.validate(student);

        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        // Name Uniqueness validation

        Student studentWithName = studentRepository.findByName(student.getName());

        if (studentWithName != null)
            throw new ResourceValidationException(ENTITY,
                    "An student with the same name already exists.");

        return studentRepository.save(student);
    }

    @Override
    public Student update(Long studentId, Student request) {
        Set<ConstraintViolation<Student>> violations = validator.validate(request);

        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        // Name Uniqueness validation

        Student studentWithName = studentRepository.findByName(request.getName());

        if (studentWithName != null && !studentWithName.getId().equals(studentId))
            throw new ResourceValidationException(ENTITY,
                    "An student with the same name already exists.");

        return studentRepository.findById(studentId).map(student ->
                        studentRepository.save(student.withName(request.getName())
                                .withAge(request.getAge())
                                .withAddress(request.getAddress())))
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, studentId));
    }

    @Override
    public ResponseEntity<?> delete(Long studentId) {
        return studentRepository.findById(studentId).map(student -> {
            studentRepository.delete(student);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, studentId));
    }
}

















