/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eis;

import domain.Vote;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author abraham
 */
@Local
public interface VoteFacadeLocal {

    void create(Vote vote);

    void edit(Vote vote);

    void remove(Vote vote);

    Vote find(Object id);

    List<Vote> findAll();

    List<Vote> findRange(int[] range);

    int count();
    
}
