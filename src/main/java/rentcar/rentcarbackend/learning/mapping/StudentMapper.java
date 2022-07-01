package rentcar.rentcarbackend.learning.mapping;


import rentcar.rentcarbackend.learning.domain.model.entity.Student;
import rentcar.rentcarbackend.learning.resource.CreateStudentResource;
import rentcar.rentcarbackend.learning.resource.StudentResource;
import rentcar.rentcarbackend.learning.resource.UpdateStudentResource;
import rentcar.rentcarbackend.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public class StudentMapper implements Serializable {

    @Autowired
    EnhancedModelMapper mapper;

    // Object Mapping
    public StudentResource toResource(Student model) {
        return mapper.map(model, StudentResource.class);
    }

    public Page<StudentResource> modelListPage(List<Student> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, StudentResource.class), pageable, modelList.size());
    }

    public Student toModel(CreateStudentResource resource) {
        return mapper.map(resource, Student.class);
    }

    public Student toModel(UpdateStudentResource resource) {
        return mapper.map(resource, Student.class);
    }

}
