package com.nibodha.lgaas.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nibodha.lgaas.entity.Device;
import com.nibodha.lgaas.entity.Light;

public interface LightDao  extends JpaRepository<Light, Long>  {

}
