package com.demater.infrastructure.database.repository;

import com.demater.core.domain.user.ERole;
import com.demater.infrastructure.database.entity.folder.FolderEntity;
import com.demater.infrastructure.database.entity.user.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface JpaFolderRepository extends JpaRepository<FolderEntity, Long> {

}
