/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eis;

import domain.Tag;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author abraham
 */
@Local
public interface TagFacadeLocal {

    void create(Tag tag);

    void edit(Tag tag);

    void remove(Tag tag);

    Tag find(Object id);

    List<Tag> findAll();

    List<Tag> findRange(int[] range);

    int count();
    
}
