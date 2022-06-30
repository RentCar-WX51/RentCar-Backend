package rentcar.rentcarbackend.mapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import rentcar.rentcarbackend.domain.model.entity.Performance;
import rentcar.rentcarbackend.resource.CreatePerformanceResource;
import rentcar.rentcarbackend.resource.PerformanceResource;
import rentcar.rentcarbackend.resource.UpdatePerformanceResource;
import shared.EnhanceModelMapper;

import java.io.Serializable;
import java.util.List;

public class PerformanceMapper implements Serializable {
    @Autowired
    EnhanceModelMapper mapper;

    public PerformanceResource toResource(Performance model){
        return mapper.map(model, PerformanceResource.class);
    }
    public Page<PerformanceResource> modelListToPage(List<Performance> modeList, Pageable pageable){
        return new PageImpl<>(mapper.mapList(modeList,PerformanceResource.class), pageable, modeList.size());
    }
    public Performance toModel(CreatePerformanceResource resource){
        return mapper.map(resource, Performance.class);
    }
    public Performance toModel(UpdatePerformanceResource resource){
        return mapper.map(resource, Performance.class);
    }
}
