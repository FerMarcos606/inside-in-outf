package dev.fer.mappers;


import dev.fer.dtos.MomentDto;
import dev.fer.model.Moment;

public class MomentMapper {
    public static MomentDto toDTO(Moment moment) {
        if (moment == null) {
            return null;
        }
        
        MomentDto dto = new MomentDto();
        dto.setTitle(moment.getTitle());
        dto.setDescription(moment.getDescription());
        dto.setEmotion(moment.getEmotion());
        dto.setDate(moment.getDate());

        return dto;
    }
}

