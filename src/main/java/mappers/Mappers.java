/*
 * Copyright (c) 2023, BRODY GAUDEL MOUNANGA BOUKA
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */

package mappers;

import mappers.exceptions.MappersException;

import java.lang.reflect.Field;

/**
 * The {@code Mappers} class provides methods for mapping entities to Data Transfer Objects (DTOs) and vice versa.
 * It includes functionality to copy properties between objects of different classes based on field compatibility.
 *
 * @param <E> The type of the entity class.
 * @param <D> The type of the DTO class.
 * @author BRODY GAUDEL MOUNANGA BOUKA
 */
public class Mappers<E, D> {

    /**
     * Constructs a new instance of the {@code Mappers} class.
     */
    public Mappers() {
        super();
    }



    /**
     * Converts an entity object to a DTO object, copying properties based on field compatibility.
     *
     * @param entity    The entity object to be converted.
     * @param dtoClass  The class of the DTO to be created.
     * @return          The resulting DTO object.
     * @throws MappersException If an error occurs during the conversion process.
     */
    public D fromEntity(E entity, Class<D> dtoClass) {
        try {
            D dto = dtoClass.getDeclaredConstructor().newInstance();
            copyProperties(entity, dto);
            return dto;
        } catch (Exception e) {
            String message = "Error when creating DTO\n" + e.getMessage() + "\n" + e.getLocalizedMessage();
            throw new MappersException(message);
        }
    }

    /**
     * Converts a DTO object to an entity object, copying properties based on field compatibility.
     *
     * @param dto           The DTO object to be converted.
     * @param entityClass   The class of the entity to be created.
     * @return              The resulting entity object.
     * @throws MappersException If an error occurs during the conversion process.
     */
    public E fromDTO(D dto, Class<E> entityClass) {
        try {
            E entity = entityClass.getDeclaredConstructor().newInstance();
            copyProperties(dto, entity);
            return entity;
        } catch (Exception e) {
            String message = "Error when creating Entity\n" + e.getMessage() + "\n" + e.getLocalizedMessage();
            throw new MappersException(message);
        }
    }

    /**
     * Copies properties from the source object to the destination object based on field compatibility.
     *
     * @param source        The source object.
     * @param destination   The destination object.
     */
    private void copyProperties(Object source, Object destination) {
        if (source == null || destination == null) {
            return;
        }
        Field[] sourceFields = source.getClass().getDeclaredFields();
        Field[] destinationFields = destination.getClass().getDeclaredFields();

        for (Field sourceField : sourceFields) {
            copyField(sourceField, destinationFields, source, destination);
        }
    }

    /**
     * Copies the value of a field from the source object to the corresponding field in the destination object.
     *
     * @param sourceField       The field in the source object.
     * @param destinationFields The array of fields in the destination object.
     * @param source            The source object.
     * @param destination       The destination object.
     */
    private void copyField(Field sourceField, Field[] destinationFields, Object source, Object destination) {
        for (Field destinationField : destinationFields) {
            if (areFieldsCompatible(sourceField, destinationField)) {
                copyFieldValues(sourceField, destinationField, source, destination);
            }
        }
    }

    /**
     * Checks whether two fields are compatible for copying values based on name and type.
     *
     * @param sourceField       The field in the source object.
     * @param destinationField  The field in the destination object.
     * @return                  {@code true} if the fields are compatible, {@code false} otherwise.
     */
    private boolean areFieldsCompatible(Field sourceField, Field destinationField) {
        return sourceField.getName().equals(destinationField.getName())
                && sourceField.getType().equals(destinationField.getType());
    }

    /**
     * Copies the value of a field from the source object to the corresponding field in the destination object.
     *
     * @param sourceField       The field in the source object.
     * @param destinationField  The field in the destination object.
     * @param source            The source object.
     * @param destination       The destination object.
     * @throws MappersException If an error occurs during the field value copying process.
     */
    private void copyFieldValues(Field sourceField, Field destinationField, Object source, Object destination) {
        try {
            sourceField.setAccessible(true);
            destinationField.setAccessible(true);
            destinationField.set(destination, sourceField.get(source));
        } catch (IllegalAccessException e) {
            String message = "Error copying properties\n" + e.getMessage() + "\n" + e.getLocalizedMessage();
            throw new MappersException(message);
        }
    }
}
