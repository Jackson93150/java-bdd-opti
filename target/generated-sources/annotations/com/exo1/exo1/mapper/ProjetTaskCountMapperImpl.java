package com.exo1.exo1.mapper;

import com.exo1.exo1.dto.ProjetTaskCountDto;
import com.exo1.exo1.entity.ProjetTaskCount;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-19T16:19:11+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 23.0.1 (Oracle Corporation)"
)
@Component
public class ProjetTaskCountMapperImpl implements ProjetTaskCountMapper {

    @Override
    public ProjetTaskCountDto toDto(ProjetTaskCount projetTaskCount) {
        if ( projetTaskCount == null ) {
            return null;
        }

        ProjetTaskCountDto projetTaskCountDto = new ProjetTaskCountDto();

        projetTaskCountDto.setTaskCount( projetTaskCount.getTaskCount() );

        return projetTaskCountDto;
    }

    @Override
    public List<ProjetTaskCountDto> toDtos(List<ProjetTaskCount> projetTaskCounts) {
        if ( projetTaskCounts == null ) {
            return null;
        }

        List<ProjetTaskCountDto> list = new ArrayList<ProjetTaskCountDto>( projetTaskCounts.size() );
        for ( ProjetTaskCount projetTaskCount : projetTaskCounts ) {
            list.add( toDto( projetTaskCount ) );
        }

        return list;
    }
}
