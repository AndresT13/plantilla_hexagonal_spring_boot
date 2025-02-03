package com.spring.hexagonal.hexagonal.application.service;


import com.spring.hexagonal.hexagonal.application.UserDto;

import com.spring.hexagonal.hexagonal.application.mapperStruct.UserMapper;
import com.spring.hexagonal.hexagonal.application.port.UserService;
import com.spring.hexagonal.hexagonal.domain.UserEntity;
import com.spring.hexagonal.hexagonal.domain.exception.UserNotFoundException;
import com.spring.hexagonal.hexagonal.infraestructure.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;


    @Override
    public UserDto createUser(UserDto userDTO) {
        if (userDTO == null) {
            throw new IllegalArgumentException("El cliente no puede ser nulo");
        }


        if (userRepository.existsByNumberDocument(userDTO.getNumberDocument())) {
            throw new IllegalArgumentException("Ya existe un cliente con este número de documento");
        }


        UserEntity userEntity = UserMapper.toUserEntity(userDTO);

        userEntity.setFirstName(userDTO.getFirstName());
        userEntity.setSecondName(userDTO.getSecondName());
        userEntity.setCity(userDTO.getCity());
        userEntity.setAddress(userDTO.getAddress());
        userEntity.setNumberDocument(userDTO.getNumberDocument());
        userEntity.setDocumentType(userDTO.getDocumentType());
        userEntity.setNumberPhone(userDTO.getNumberPhone());

        userEntity = userRepository.save(userEntity);

        UserDto savedUserDto = UserMapper.toUserDto(userEntity);

        return savedUserDto;
    }



    /*
    @Override
    public UserDto createUser(UserDto userDTO) {
        if (userDTO == null) {
            throw new IllegalArgumentException("El cliente no puede ser nulo");
        }

        // Verificar si ya existe un usuario con el mismo número de documento
      //  if (userRepository.existsByNumberDocument(userDTO.getNumberDocument())) {
        //    throw new IllegalArgumentException("Ya existe un cliente con este número de documento");
      //  }

        // Convertir DTO a entidad usando MapStruct
        UserEntity userEntity = UserMapper.toUserEntity(userDTO);

        // Guardar la entidad en la base de datos
        userEntity = userRepository.save(userEntity);

        // Convertir la entidad guardada de nuevo a DTO
        UserDto savedUserDto = UserMapper.toUserDto(userEntity);

        // Retornar el DTO con los datos del usuario guardado
        return savedUserDto;
    }

     */

    @Override
    public Optional<UserDto> getUser(Long id) {
        // Buscamos al usuario en el repositorio
        Optional<UserEntity> userEntityOptional = userRepository.findById(id);

        // Si no se encuentra el usuario, lanzamos una excepción
        if (userEntityOptional.isEmpty()) {
            throw new UserNotFoundException("Cliente con ID " + id + " no encontrado");
        }

        // Convertimos el UserEntity a UserDto usando MapStruct
        UserDto userDto = UserMapper.toUserDto(userEntityOptional.get());

        // Devolvemos el UserDto envuelto en un Optional
        return Optional.of(userDto);
    }

    @Override
    public List<UserDto> getAllUsers() {
        // Obtenemos la lista de UserEntities desde el repositorio
        List<UserEntity> userEntities = userRepository.findAll();

        // Convertimos la lista de UserEntities a UserDtos usando MapStruct
        List<UserDto> userDtos = userEntities.stream()
                .map(UserMapper::toUserDto)  // Convertir cada UserEntity a UserDto
                .collect(Collectors.toList());  // Recoger los resultados en una lista

        // Retornamos la lista de UserDtos
        return userDtos;
    }

    @Override
    public UserDto updateUser(Long id, UserDto clientDto) {
        // Buscar el cliente por ID
        Optional<UserEntity> clientOptional = userRepository.findById(id);

        if (clientOptional.isEmpty()) {
            throw new RuntimeException("Cliente no encontrado para actualizar");
        }

        // Obtener cliente existente
        UserEntity existingClient = clientOptional.get();

        // Actualizar los campos con los nuevos valores desde clientDto
        existingClient.setFirstName(clientDto.getFirstName());
        existingClient.setSecondName(clientDto.getSecondName());
        existingClient.setCity(clientDto.getCity());
        existingClient.setAddress(clientDto.getAddress());
        existingClient.setNumberDocument(clientDto.getNumberDocument());
        existingClient.setDocumentType(clientDto.getDocumentType());
        existingClient.setNumberPhone(clientDto.getNumberPhone());

        // Guardar el cliente actualizado
        UserEntity updatedClient = userRepository.save(existingClient);

        // Convertir el cliente actualizado a un DTO antes de devolverlo
        return UserMapper.toUserDto(updatedClient);
    }

    @Override
    public void deleteUser(Long id) {
        Optional<UserEntity> clientOptional = userRepository.findById(id);
        if (clientOptional.isPresent()) {
            userRepository.deleteById(id);
        } else {
            throw new RuntimeException("Cliente no encontrado");
        }
    }

    @Override
    public Optional<UserDto> findByNumberDocument(Integer numberDocument) {
        Optional<UserEntity> clientOptional = userRepository.findByNumberDocument(numberDocument);

        if (clientOptional.isEmpty()) {
            throw new UserNotFoundException("Cliente con número de documento " + numberDocument + " no encontrado");
        }

        // Convertir la entidad a DTO
        UserDto clientDto = UserMapper.toUserDto(clientOptional.get());

        // Retornar el Optional de ClientDto
        return Optional.of(clientDto);
    }

}
