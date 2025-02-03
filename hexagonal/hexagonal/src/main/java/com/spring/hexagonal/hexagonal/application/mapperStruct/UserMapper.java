package com.spring.hexagonal.hexagonal.application.mapperStruct;

import com.spring.hexagonal.hexagonal.application.UserDto;
import com.spring.hexagonal.hexagonal.domain.UserEntity;

public class UserMapper {
    public static UserEntity toUserEntity(UserDto userDto) {
        if (userDto == null) {
            return null;  // Si el DTO es nulo, retornamos nulo
        }

        UserEntity userEntity = new UserEntity();
        userEntity.setId(userDto.getId());
        userEntity.setFirstName(userDto.getFirstName());
        userEntity.setSecondName(userDto.getSecondName());
        userEntity.setNumberPhone(userDto.getNumberPhone());
        userEntity.setAddress(userDto.getAddress());
        userEntity.setCity(userDto.getCity());
        userEntity.setNumberDocument(userDto.getNumberDocument());
        userEntity.setDocumentType(userDto.getDocumentType());

        return userEntity;
    }

    // Convierte UserEntity a UserDto
    public static UserDto toUserDto(UserEntity userEntity) {
        if (userEntity == null) {
            return null;  // Si el Entity es nulo, retornamos nulo
        }

        UserDto userDto = new UserDto();
        userDto.setId(userEntity.getId());
        userDto.setFirstName(userEntity.getFirstName());
        userDto.setSecondName(userEntity.getSecondName());
        userDto.setNumberPhone(userEntity.getNumberPhone());
        userDto.setAddress(userEntity.getAddress());
        userDto.setCity(userEntity.getCity());
        userDto.setNumberDocument(userEntity.getNumberDocument());
        userDto.setDocumentType(userEntity.getDocumentType());

        return userDto;
    }
}
