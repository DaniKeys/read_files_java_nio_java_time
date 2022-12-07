package com.modusoftware.test.persistent.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.modusoftware.test.bussines.IArrayService;
import com.modusoftware.test.persistent.entity.ArrayEntity;

/**
 * <h2>ArrayRepository</h2>
 * <p>
 * Este Bean que pertenece a la capa de persistencia lo usamos para hacer la consulta por ID, hereda de la
 * {@code @Interface} {@link CrudRepository}  
 * @see JpaRepository 
 *              
 * @author danielcamacho
 * @version 1.0
 * @since 2022
 * 
 */

@Repository
public interface ArrayRepository extends CrudRepository<ArrayEntity, Integer> {


	
}
