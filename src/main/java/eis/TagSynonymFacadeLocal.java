/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eis;

import domain.TagSynonym;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author abraham
 */
@Local
public interface TagSynonymFacadeLocal {

    void create(TagSynonym tagSynonym);

    void edit(TagSynonym tagSynonym);

    void remove(TagSynonym tagSynonym);

    TagSynonym find(Object id);

    List<TagSynonym> findAll();

    List<TagSynonym> findRange(int[] range);

    int count();
    
}
