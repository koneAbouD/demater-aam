package africa.box.dm.db;

import africa.box.dm.db.entities.NoteTypes;
import africa.box.dm.db.entities.Notes;
import org.hibernate.annotations.OrderBy;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotesDao extends CrudRepository<Notes,Integer> {
    @OrderBy(clause = "id desc")
    public List<Notes> findByBusinessKey(String bk);
    @OrderBy(clause = "date desc")
    public List<Notes> findByBusinessKeyAndType(String bk, NoteTypes type);
    @OrderBy(clause = "date desc")
    public List<Notes> findByBusinessKeyAndDecision(String bk, String decision);
    @OrderBy(clause = "date desc")
    public List<Notes> findByBusinessKeyAndDecisionAndCreatedby(String bk, String decision, String createdby);
    public void deleteByBusinessKey(String bk);
}


/*
package io.saworks.loaninitiate.db.dataAccess;

import io.saworks.loaninitiate.db.entities.Dossier;
import io.saworks.loaninitiate.db.entities.LoanFileStatus;
import io.saworks.loaninitiate.db.entities.NoteTypes;
import io.saworks.loaninitiate.db.entities.Notes;
import org.hibernate.annotations.OrderBy;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface NotesDao extends CrudRepository<Notes,Integer> {
    @OrderBy(clause = "date desc")
    public List<Notes> findByBusinessKey(String bk);
    @OrderBy(clause = "date desc")
    public List<Notes> findByBusinessKeyAndType(String bk, NoteTypes type);
    public void deleteByBusinessKey(String bk);

}
*/